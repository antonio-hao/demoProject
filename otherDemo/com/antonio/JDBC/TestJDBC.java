package com.antonio.JDBC;
import java.sql.*;

public class TestJDBC {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// new oracle.jdbc.driver.OracleDriver();
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##quhao", "quhao");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from dept");
			System.out.println("deptno" + " " + "dname" + " " + "loc");
			while (rs.next()) {
				System.out.println(rs.getInt("deptno") + " " + rs.getString("dname") + " " + rs.getString("loc"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
