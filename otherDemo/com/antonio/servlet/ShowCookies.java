package com.antonio.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowCookies extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=gb2312");
	PrintWriter out = response.getWriter();
	String title = "Active Cookies";
	out.println("<html><head><title>��ȡ�ͻ���Cookie</title></head>"
			+ "<body bgcolor=\"FDF5E6\">\n"
			+ "<h1 align=\"center\">" + title + "</h1>\n"
			+ "<table border=1 align=\"center\">\n" 
			+ "<tr bgcolor=\"FFAD0O\">\n"
			+ "<th>Cookie Name</th>\n"
			+ "<th>Cookie Value</th></tr>\n"
			);
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		Cookie cookie;
		for(int i=0; i<cookies.length; i++){
			cookie = cookies[i];
			out.println("<tr>\n" +
			"<td>" + cookie.getName() + "</td>\n" +
			"<td>"+ cookie.getValue() + "</td></tr>\n"
					);
		}
	}
	out.println("</table></body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
	}

}
