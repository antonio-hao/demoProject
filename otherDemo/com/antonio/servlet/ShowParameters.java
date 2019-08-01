package com.antonio.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowParameters extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		String title="Reading All Request Parameters";
		out.println("<html><head><title>��ȡ���в���</title></head>"
				+ "<BODY BGCOLOR='#FDF5E6'>\n" + "<H1 ALIGN='CENTER'>" + title
				+ "</H1>\n" + "<TABLE BORDER=1 ALIGN='CENTER'>\n"
				+ "<TR BGCOLOR=\"#FFAD0O\">\n"
				+ "<TH>Parameter Name</TH><TH>Parameter Value(s)</TH></TR>");
		Enumeration paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()){
			String paramName = (String)paramNames.nextElement();
			out.print("<TR><TD>" + paramName +"</TD>\n<TD>");
			String[] paramValues = request.getParameterValues(paramName);
			if(paramValues.length == 1){
				String paramValue = paramValues[0];
				if(paramValue.length() == 0)
					out.println("<I>No Value</I></TD></TR>");
				else 
					out.println(paramValue + "</TD></TR>");
					
			}else{
				out.println("<UL>");
				for (int i=0; i<paramValues.length; i++){
					out.println("<LI>" + paramValues[i] + "</LI>");
				}
				out.println("</UL></TD></TR>");
			}
		}
		out.println("</TABLE>\n</BODY></HTML>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
