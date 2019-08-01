package com.antonio.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionInfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession mySession = request.getSession(true);
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Session Info Servlet</title></head>"
				+ "<body><h3>Session Information</h3>"
				+ "New Session: " + mySession.isNew()
				+ "<br>Session ID: " + mySession.getId() + "</br>"
				+ "<br>Session Creation Time: " + new java.util.Date(mySession.getCreationTime())
				+ "</br>"
				+ "<br>Session Last Accessed Time: " + new java.util.Date(mySession.getLastAccessedTime())
				+ "<h3>Request Information</h3>"
				+ "Session ID from requset: " + request.getRequestedSessionId()
				+ "<br>Session ID via Cookie: " + request.isRequestedSessionIdFromCookie() 
				+ "</br>"
				+ "<br>Session ID via rewritten URL: " + request.isRequestedSessionIdFromURL()
				+ "</br>"
				+ "<br>Valid Session ID: " + request.isRequestedSessionIdValid()
				+ "</br>"
				+ "<br><a href=" + response.encodeRedirectURL("SessionInfoServlet")
				+ ">refresh</a>"
				+ "</body></html>"
				
				);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
