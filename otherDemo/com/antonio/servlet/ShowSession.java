package com.antonio.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowSession extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		String title= "Session Tracking Example";
		HttpSession session = request.getSession(true);
		String heading;
		Integer accessCount = (Integer)session.getAttribute("accessCount");
		if(accessCount == null){
			accessCount = new Integer(0);
			heading = "Welcome , Newcomer";
		}else{
			heading = "Welcome Back";
			accessCount = new Integer(accessCount.intValue() + 1);
		}
		session.setAttribute("accessCount", accessCount);
		out.println("<html><head><title>Session׷��</title></head>"
				+ "<body bgcolor=\"#FDF5E6\">\n"
				+ "<h1 align=\"center\">"
				+ heading + "</h1>\n"
				+ "<h2>Information on Your Session:</h2>\n"
				+ "<table border=1 align=\"center\">\n"
				+ "<tr bgcolor=\"#FFAD00\">\n" + "<th>Info Type</th><th>Value</th><tr>"
				+ "<tr>\n" + "<td>ID\n</td>" + "<td>" + session.getId() + "</td></tr>\n"
				+ "<tr>\n" + "<td>Creation Time</td>\n" 
				+ "<td>" + new Date(session.getCreationTime()) + "</td></tr>\n" 
				+ "<tr>\n" + "<td>Time of Last Access</td>\n" 
				+ "<td>" + new Date(session.getLastAccessedTime()) + "</td></tr>\n" 
				+ "<tr>\n" + "<td>Number of Previous Accesses</td>\n" 
				+ "<td>" + accessCount + "</td></tr>\n" 
				+ "</table></body></html>"
				);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
