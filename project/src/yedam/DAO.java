package yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
    // 데이터베이스 접속 정보 (Oracle 기준)
    String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
    String id = "scott";    
    String pass = "tiger";  

    // DB 관련 객체 선언
    Connection conn;          // DB 연결을 위한 객체
    Statement stmt;           // 정적 SQL 실행 시 사용
    PreparedStatement psmt;   // 동적 SQL 실행 시 사용 
    ResultSet rs;             // SQL 실행 결과 저장 (select 문 결과)

    // DB 연결 메서드
    public void getConnect() {
        try {
            // Oracle JDBC 드라이버를 로딩
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // DB와 연결 시도 (url, id, password 이용)
            conn = DriverManager.getConnection(url, id, pass);
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 에러 메시지 출력
        }
    }

    // DB 자원 해제 메서드
    public void disconnect() {
        try {
            // 결과셋, PreparedStatement, Statement, 연결 순서로 자원 해제
            if (rs != null) rs.close();
            if (psmt != null) psmt.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace(); // 자원 해제 도중 에러 발생 시 출력
        }
    }
}
