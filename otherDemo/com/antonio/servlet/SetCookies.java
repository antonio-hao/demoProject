package com.antonio.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetCookies extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		for(int i=0; i<3; i++){
			Cookie cookie = new Cookie("Session-Cookie" + i,"Cookie-Value-S" + i);
			response.addCookie(cookie);
			cookie = new Cookie("Persisten-Cookie-" + i,"Cookie-Value-p" + i);
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
		}
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		String title = "Setting Cookies";
		out.println("<html><head><title>����Cookie</title><head>"
				+ "<body bgcolor=\"#FDF5E6\">\n" + "<h1 align=\"center\">"
				+ title + "</h1>\n"
				+ "There are six cookies associated with this page.\n"
				+ "Tosee them, visit the\n" + "<a href=\"ShowCookies\">\n"
				+ "<code>ShowCookies</code> servlet</a>.\n" + "<p>\n"
				+ "current session,while three are persistent.\n"
				+ "Quit the browser,restart, and return to the\n"
				+ "<code>ShowCookies</code> servlet to verify that\n"
				+ "the three long-lived ones persist across sessions.\n"
				+ "</body></html>"
				);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
	}
	

}
