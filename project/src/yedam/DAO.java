package yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DAO {
    //  데이터베이스 접속을 위한 정보 설정 (Oracle DB 기준) 
    String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle DB에 접속하기 위한 주소
    String id = "scott";    // DB 접속 ID (사용자 계정)
    String pass = "tiger";  // DB 접속 비밀번호

    //  데이터베이스 작업에 사용될 객체들 
    Connection conn;          // DB와 연결을 담당하는 객체
    Statement stmt;           // 정적 SQL(쿼리) 실행 시 사용 (값이 고정된 쿼리)
    PreparedStatement psmt;   // 동적 SQL 실행 시 사용 (변수가 포함된 쿼리)
    ResultSet rs;             // SELECT 쿼리 실행 결과를 저장하는 객체

    // DB 연결을 수행하는 메서드 
    public void getConnect() {
        try {
            // 1. Oracle JDBC 드라이버를 메모리에 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 2. DriverManager를 통해 DB 연결 시도 (url, id, password 사용)
            conn = DriverManager.getConnection(url, id, pass);

            // 연결 성공 시 conn 객체를 통해 SQL 작업 가능
        } catch (Exception e) {
            // 예외 발생 시 에러 내용을 콘솔에 출력
            e.printStackTrace();
        }
    }

    //  사용한 DB 관련 자원을 해제하는 메서드 
    public void disconnect() {
        try {
            // 자원을 역순으로 닫아주는 것이 원칙
            if (rs != null) rs.close();       // 결과셋 닫기
            if (psmt != null) psmt.close();   // PreparedStatement 닫기
            if (stmt != null) stmt.close();   // Statement 닫기
            if (conn != null) conn.close();   // 연결 닫기 (DB 접속 종료)
        } catch (SQLException e) {
            // 자원 해제 중 예외가 발생하면 콘솔에 출력
            e.printStackTrace();
        }
    }


}
