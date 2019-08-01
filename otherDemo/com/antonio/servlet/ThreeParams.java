package com.antonio.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreeParams extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respones) throws ServletException, IOException {

		respones.setContentType("text/html");		
		PrintWriter pw = respones.getWriter();
		pw.println(request.getParameter("param11"));
		pw.println("<br/>");
		pw.println(request.getParameter("param22"));
		pw.println("<br/>");
		pw.println(request.getParameter("param33"));
		pw.println("<br/>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse respones) throws ServletException, IOException {

		doGet(request,respones);
	}

}
