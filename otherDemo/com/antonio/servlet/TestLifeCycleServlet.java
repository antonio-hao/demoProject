package com.antonio.servlet;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestLifeCycleServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("init");
	}


	@Override
	public void destroy() {
System.out.println("destroy");
	}


	public TestLifeCycleServlet(){
		System.out.println("constructor!");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("doGet");
	}

}
