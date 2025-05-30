package yedam;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO 클래스를 상속받아 산책 일정 관련 DB 작업을 처리하는 클래스
public class SchedulesDAO extends DAO {

	// 산책 일정 정보를 DB에 삽입하는 메서드
	public int insert(WalkSchedules ws) {
		// tbl_walk_schedules 테이블에 산책 일정 삽입 SQL 문
		String sql = "INSERT INTO tbl_walk_schedules " + "(dogId, dateTime, location, walkTime) VALUES (?, ?, ?, ?)";

		getConnect(); // DB 연결

		try {
			psmt = conn.prepareStatement(sql); // SQL 실행 준비

			// SQL 물음표(?)에 값 세팅
			psmt.setInt(1, ws.getDogId()); // 산책 강아지 ID (int)
			psmt.setString(2, ws.getDateTime()); // 산책 날짜와 시간 (String)
			psmt.setString(3, ws.getLocation()); // 산책 장소 (String)
			psmt.setInt(4, ws.getWalkTime()); // 산책 시간 (분, int)

			// SQL 실행 (INSERT 수행), 영향받은 행 수 반환
			return psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // 에러 출력
		} finally {
			disconnect(); // DB 자원 반납
		}

		return 0; // 실패 시 0 반환
	}

	// tbl_walk_schedules 테이블의 모든 산책 일정을 조회하는 메서드
	public List<WalkSchedules> getWalkSchedules() {
		String sql = "SELECT * FROM tbl_walk_schedules ORDER BY dogid ASC"; // 전체 조회 SQL
		getConnect(); // DB 연결

		List<WalkSchedules> list = new ArrayList<>(); // 결과를 저장할 리스트

		try {
			psmt = conn.prepareStatement(sql); // SQL 준비
			rs = psmt.executeQuery(); // 실행 후 결과 받기

			// 결과 집합을 반복하면서 WalkSchedules 객체 생성 후 리스트에 추가
			while (rs.next()) {
				WalkSchedules ws = new WalkSchedules(rs.getInt("dogId"), // dogId 컬럼 (int)
						rs.getString("dateTime"), // dateTime 컬럼 (String)
						rs.getString("location"), // location 컬럼 (String)
						rs.getInt("walkTime") // walkTime 컬럼 (int)
				);
				list.add(ws); // 리스트에 추가
			}
		} catch (SQLException e) {
			e.printStackTrace(); // 에러 로그 출력
		} finally {
			disconnect(); // 자원 반납
		}

		return list; // 산책 일정 목록 반환
	}

	// 특정 산책 일정(강아지 ID와 산책 일시)이 존재하는지 삭제하는 메서드
	public int deleteSchedule(int dogId, String dateTime) {
		// 조건에 맞는 산책 일정 삭제 SQL
		String sql = "DELETE FROM tbl_walk_schedules WHERE dogId = ? AND dateTime = ?";
		getConnect(); // DB 연결

		try {
			psmt = conn.prepareStatement(sql); // SQL 준비
			psmt.setInt(1, dogId); // dogId 조건 설정
			psmt.setString(2, dateTime); // dateTime 조건 설정

			// 삭제 실행, 영향 받은 행 수 반환
			return psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // 에러 출력
		} finally {
			disconnect(); // 자원 반납
		}

		return 0; // 실패 시 0 반환
	}

	public List<String> getSchedulesByDogId(int dogId) {
		List<String> schedules = new ArrayList<>();
		String sql = """
				    SELECT
				        d.name AS dog_name,
				        TO_CHAR(TO_DATE(w.dateTime, 'YYYY-MM-DD HH24:MI:SS'), 'MM"월" DD"일" HH24"시" MI"분"') AS walk_schedule,
				        w.location
				    FROM tbl_dogs d
				    JOIN tbl_walk_schedules w ON d.id = w.dogId
				    WHERE d.id = ?
				    ORDER BY TO_DATE(w.dateTime, 'YYYY-MM-DD HH24:MI:SS')
				""";

		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dogId);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String dogName = rs.getString("dog_name");
				String dateTime = rs.getString("walk_schedule");
				String location = rs.getString("location");
				schedules.add(dogName + "는 " + dateTime + "에 " + location + "에서 산책을 합니다");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return schedules;
	}

}
