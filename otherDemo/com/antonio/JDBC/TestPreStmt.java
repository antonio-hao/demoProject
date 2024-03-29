package com.antonio.JDBC;
import java.sql.*;


public class TestPreStmt {

	public static void main(String[] args) {
		
		if(args.length !=3){
			System.out.println("Parameter Error! Please Input Again!");
			System.exit(-1);
		}
		
		int deptno = 0;
		
		try{
		deptno = Integer.parseInt(args[0]);
		}catch(NumberFormatException e){
			System.out.println("Parameter Error! Deptno should be Number Format!");
			System.exit(-1);
		}
		
		String dname = args[1];
		String loc = args[2];
		Connection conn = null;
		PreparedStatement pstmt = null;
		

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// new oracle.jdbc.driver.OracleDriver();
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##quhao", "quhao");
			pstmt = conn.prepareStatement("insert into dept values(?,?,?)");
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
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
