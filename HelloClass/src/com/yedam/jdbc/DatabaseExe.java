package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseExe {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String id = "scott";
        String pass = "tiger";

        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;

        // ✅ 올바른 DELETE 문
        String sql = "DELETE FROM product WHERE p_code = 201 AND p_name = '치토스' AND p_price = 1000";

        try {
            // 1. 드라이버 로딩
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 2. DB 연결
            conn = DriverManager.getConnection(url, id, pass);
            conn.setAutoCommit(false);
            System.out.println("DB 연결 성공");

            // 3. DELETE 실행
            stmt = conn.createStatement();
            int r = stmt.executeUpdate(sql);
            if (r > 0) {
                conn.commit(); // 커밋
                System.out.println(r + "건 삭제되었습니다.");
            } else {
                conn.rollback(); // 롤백
                System.out.println("삭제 대상 없음, 롤백되었습니다.");
            }

            // 4. SELECT 실행
            rs = stmt.executeQuery("SELECT * FROM product");
            System.out.println("상품코드\t상품이름\t가격");
            System.out.println("---------------------------");
            while (rs.next()) {
                System.out.println(rs.getInt("p_code") + "\t" + rs.getString("p_name") + "\t" + rs.getInt("p_price"));
            }

        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL 실행 오류");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
