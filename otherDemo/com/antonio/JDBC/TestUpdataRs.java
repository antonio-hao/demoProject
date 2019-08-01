package com.antonio.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdataRs {

	public static void main(String[] args) {

		try {
			new oracle.jdbc.driver.OracleDriver();
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			Connection conn = DriverManager.getConnection(url, "c##quhao", "quhao");
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("select * from emp");
			rs.next();
			rs.updateString("ename", "AAAA"); // ����һ������
			rs.updateRow();
			//��������
			rs.moveToInsertRow();
			rs.updateInt(1, 9999);
			rs.updateString("ename", "BBBB");
			rs.updateInt("mgr", 7839);
			rs.updateDouble("sal", 99.99);
			rs.insertRow();
			//������ƶ����½�����
			rs.moveToCurrentRow();
			//ɾ����
			rs.absolute(5);
			rs.deleteRow();
			//ȡ������
			//rs.cancelRowUpdates();
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
