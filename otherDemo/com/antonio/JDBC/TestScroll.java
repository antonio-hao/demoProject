package com.antonio.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestScroll {

	public static void main(String[] args) {

		try {
			new oracle.jdbc.driver.OracleDriver();
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			Connection conn = DriverManager.getConnection(url, "c##quhao", "quhao");
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery("select * from emp order by sal");
			rs.next();
			System.out.println(rs.getInt(1)); // ��һ���ֶΣ�empname
			rs.last();
			System.out.println(rs.getString(1));
			System.out.println(rs.isLast()); // �Ƿ����һ��
			System.out.println(rs.isAfterLast()); // �Ƿ������һ������һ��
			System.out.println(rs.getRow()); // �ǵڼ���
			rs.previous();
			System.out.println(rs.getString(1));
			rs.absolute(6);
			System.out.println(rs.getString(1));
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
