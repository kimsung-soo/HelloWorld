package dogDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dogvalue.Dogs;


public class DogDAO extends DAO {

    // 강아지 정보를 DB에 삽입하는 메서드
    public int insertDog(Dogs dog) {
        // 강아지 정보를 삽입하는 SQL 문 (tbl_dogs 테이블에 id, name, breed, age 컬럼에 값 추가)
        String sql = "insert into tbl_dogs (id, name, breed, age) "
        		+ "values (?, ?, ?, ?)";
        
        // 접속
        getConnect();
        
        try {
            // PreparedStatement 객체 생성 (SQL 실행 준비)
            psmt = conn.prepareStatement(sql);
            
            // SQL 물음표(?)에 값 세팅
            psmt.setInt(1, dog.getId());        // 첫 번째 물음표에 id (int)
            psmt.setString(2, dog.getName());   // 두 번째 물음표에 이름 (String)
            psmt.setString(3, dog.getBreed());  // 세 번째 물음표에 견종 (String)
            psmt.setInt(4, dog.getAge());        // 네 번째 물음표에 나이 (int)
            
            // SQL 실행 (INSERT 수행)
            int r = psmt.executeUpdate();
            
            // 영향 받은 행(row) 수 반환 (1 이상이면 성공)
            return r;
            
        } catch (SQLException e) {
            e.printStackTrace();  // 예외 발생 시 에러 로그 출력
        } finally {
            disconnect();  // DB 자원 반납
        }
        
        // 실패 시 0 반환
        return 0;
    }

    // tbl_dogs 테이블의 모든 강아지 정보를 조회하는 메서드
    public List<Dogs> getDogList() {
        String sql = "SELECT * FROM tbl_dogs ORDER BY id ASC";  // 전체 조회 SQL
        getConnect();  // DB 연결
        
        List<Dogs> list = new ArrayList<>();  // 결과를 저장할 리스트
        
        try {
            psmt = conn.prepareStatement(sql); // SQL 실행 준비
            rs = psmt.executeQuery();          // SQL 실행 후 결과 받아오기
            
            // 결과 집합을 반복하면서 Dogs 객체로 만들고 리스트에 추가
            while (rs.next()) {
                Dogs dog = new Dogs(
                        rs.getInt("id"),       // id 컬럼 (int)
                        rs.getString("name"),  // name 컬럼 (String)
                        rs.getString("breed"), // breed 컬럼 (String)
                        rs.getInt("age")       // age 컬럼 (int)
                );
                list.add(dog);  // 리스트에 추가
            }
        } catch (SQLException e) {
            e.printStackTrace();  // 에러 로그 출력
        } finally {
            disconnect();  // 자원 반납
        }
        
        return list;  // 강아지 목록 반환
    }

    // 특정 id가 tbl_dogs 테이블에 존재하는지 확인하는 메서드
    public boolean Exist(int id) {
        getConnect();  // DB 연결
        
        String sql = "SELECT COUNT(*) FROM tbl_dogs WHERE id = ?";
        
        try {
            psmt = conn.prepareStatement(sql);  // SQL 준비
            psmt.setInt(1, id);                  // id 값 설정
            rs = psmt.executeQuery();            // 실행 후 결과 받기
            
            // 결과가 있으면(첫번째 컬럼의 count) 0보다 크면 존재(true)
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();  // 에러 로그 출력
        } finally {
            disconnect();  // 자원 반납
        }
        
        return false;  // 없으면 false 반환
    }

 // 강아지 삭제 메서드
    public int deleteDog(int id) {
        getConnect();
        String sql = "DELETE FROM tbl_dogs WHERE id = ?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, id);
            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return 0;
    }

	
}