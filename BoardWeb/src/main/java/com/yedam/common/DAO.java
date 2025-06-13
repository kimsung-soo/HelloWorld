package com.yedam.common;

import java.sql.*;

public class DAO {
    protected Connection conn;
    protected PreparedStatement pstmt;
    protected ResultSet rs;

   
    private String jdbc_driver = "oracle.jdbc.OracleDriver";
    private String jdbc_url    = "jdbc:oracle:thin:@localhost:1521:xe";
    private String db_id       = "jsp";
    private String db_pw       = "jsp";

    protected void conn() {
        try {
            Class.forName(jdbc_driver);
            conn = DriverManager.getConnection(jdbc_url, db_id, db_pw);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void disconn() {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}