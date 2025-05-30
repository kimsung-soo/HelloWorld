package yedam;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//  SchedulesDAO 클래스 

// DAO 클래스를 상속받아, 산책 일정(tbl_walk_schedules) 테이블을 다루는 DB 접근 클래스
public class SchedulesDAO extends DAO {

	/// ---------------------------- 1. 산책 일정 등록 ---------------------------
	// WalkSchedules 객체를 받아 DB에 새 산책 일정을 INSERT하는 메서드
	public int insert(WalkSchedules ws) {

		// 삽입할 SQL 문 (물음표 ?는 나중에 실제 값으로 대체됨)
		String sql = "INSERT INTO tbl_walk_schedules (dogId, dateTime, location, walkTime) VALUES (?, ?, ?, ?)";

		getConnect(); // DB 연결

		try {
			psmt = conn.prepareStatement(sql); // SQL 실행 준비

			// 각 물음표에 값 세팅
			psmt.setInt(1, ws.getDogId()); // 강아지 ID
			psmt.setString(2, ws.getDateTime()); // 산책 날짜 및 시간 (문자열 형식)
			psmt.setString(3, ws.getLocation()); // 산책 장소
			psmt.setInt(4, ws.getWalkTime()); // 산책 시간 (분)

			// SQL 실행 후, 영향받은 행 수 반환
			return psmt.executeUpdate();

		} catch (SQLException e) {
			// 예외 발생 시 에러 로그 출력
			e.printStackTrace();
		} finally {
			// 무조건 DB 연결 해제
			disconnect();
		}

		return 0; // 실패 시 0 반환
	}

	/// -----------------2. 전체 산책 일정 조회--------------------------

	// tbl_walk_schedules 테이블의 모든 데이터를 조회하여 리스트로 반환
	public List<WalkSchedules> getWalkSchedules() {
		String sql = "SELECT * FROM tbl_walk_schedules ORDER BY dogId ASC"; // 조회 SQL
		getConnect(); // DB 연결

		List<WalkSchedules> list = new ArrayList<>(); // 결과 담을 리스트

		try {
			psmt = conn.prepareStatement(sql); // SQL 준비
			rs = psmt.executeQuery(); // 쿼리 실행 및 결과 수신

			// 결과 집합을 한 줄씩 읽어 객체 생성 후 리스트에 추가
			while (rs.next()) {
				WalkSchedules ws = new WalkSchedules(rs.getInt("dogId"), // 강아지 ID
						rs.getString("dateTime"), // 산책 날짜 및 시간
						rs.getString("location"), // 장소
						rs.getInt("walkTime") // 산책 시간
				);
				list.add(ws);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();// 무조건 DB 연결 해제
		}

		return list; // 전체 산책 일정 리스트 반환
	}

	/// ------------------------------- 3. 특정 산책 일정 삭제
	/// -----------------------------------------------
	///
	// dogId와 dateTime을 기준으로 특정 일정을 삭제하는 메서드
	public int deleteSchedule(int dogId, String dateTime) {
		String sql = "DELETE FROM tbl_walk_schedules WHERE dogId = ? AND dateTime = ?";
		getConnect(); // DB 연결

		try {
			psmt = conn.prepareStatement(sql); // SQL 준비
			psmt.setInt(1, dogId); // 강아지 ID
			psmt.setString(2, dateTime); // 산책 시간

			return psmt.executeUpdate(); // 삭제 실행 및 결과 반환

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(); // 연결 해제
		}

		return 0; // 실패 시 0 반환
	}

	/// ---------------------------- 4. 강아지 ID로 산책 일정 조회
	/// --------------------------------------------

	// 특정 강아지 ID에 해당하는 모든 산책 일정을 포맷팅된 문자열로 반환
	public List<String> getSchedulesByDogId(int dogId) {
		List<String> schedules = new ArrayList<>();

		// SQL: JOIN을 통해 강아지 이름과 함께 산책 일정 조회
		// 날짜/시간은 "MM월 DD일 HH시 MM분" 형태로 포맷 변경
		String sql = 
			  
			    "SELECT d.name AS dog_name, " +   // 강아지 이름을 dog_name 별칭으로 조회			    
			    "TO_CHAR(s.dateTime, 'MM\"월\" DD\"일\" HH24\"시\" MI\"분\"') AS walk_schedule, " + 
			 // 산책 시간(dateTime)을 'MM월 DD일 HH24시 MI분' 포맷 문자열로 변환하여 walk_schedule 별칭으로 조회			    
			    // 산책 장소 조회
			    "s.location " +
			    // tbl_dogs 테이블 별칭 d에서
			    "FROM tbl_dogs d " +
			    // tbl_walk_schedules 테이블 별칭 s와 d.id = s.dogId 조건으로 INNER JOIN
			    "JOIN tbl_walk_schedules s ON d.id = s.dogId " +			    
			    "WHERE d.id = ? " +
			    // 산책 시간 기준으로 오름차순 정렬
			    "ORDER BY s.dateTime";

		
		getConnect(); // DB 연결

		try {
			psmt = conn.prepareStatement(sql); // SQL 준비
			psmt.setInt(1, dogId); // 검색할 강아지 ID 설정
			rs = psmt.executeQuery(); // 쿼리 실행

			// 결과를 읽어 사용자에게 보여줄 메시지 형태로 변환하여 리스트에 저장
			while (rs.next()) {
				String dogName = rs.getString("dog_name"); // 강아지 이름
				String dateTime = rs.getString("walk_schedule"); // 포맷된 산책 시간
				String location = rs.getString("location"); // 산책 장소
				
				schedules.add(dogName + "는 " + dateTime + "에 " + location + "에서 산책을 합니다");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(); // 연결 해제
		}

		return schedules; // 결과 리스트 반환
	}
}
