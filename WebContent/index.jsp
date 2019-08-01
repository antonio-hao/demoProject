<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/rg/register2.do" method="POST">
		姓名：<!-- <input type="text" name="pname"> -->
		<input type="text" name="name"><br>
		年龄:<input type="text" name="age"><br>
		学校：<input type="text" name="school.sname"><br>
		校址：<input type="text" name="school.address"><br>
		<input type="submit" value="注册2">
	</form>
	---------------------<br>
	<form action="${pageContext.request.contextPath}/rg/register4.do" method="POST">
		姓名：<input type="text" name="name">
		年龄:<input type="text" name="age"><br>
		<input type="submit" value="注册4">
	</form>
		---------------------<br>
	<form action="${pageContext.request.contextPath}/rg/register5.do" method="POST">
		姓名：<input type="text" name="name">
		年龄:<input type="text" name="age"><br>
		<input type="submit" value="注册5">
	</form>
	---------------------<br>
		<form action="${pageContext.request.contextPath}/rg/register6.do" method="POST">
		姓名：<input type="text" name="pname">
		年龄:<input type="text" name="age"><br>
		<input type="submit" value="注册6">
	</form>
		---------------------<br>

		<form action="${pageContext.request.contextPath}/rg/register7.do" method="POST">
		年龄：<input type="text" name="age" value="${age}">${ageErrors }<br>
		生日:<input type="text" name="birthday" value="${birthday}">${birthdayErrors }<br>
		<input type="submit" value="注册7">
	</form>
			---------------------<br>

		<form action="${pageContext.request.contextPath}/rg/register8.do" method="POST">
		姓名：<input type="text" name="name" value="${people.name}">${nameErrorMSG}<br>
		成绩:<input type="text" name="score" value="${people.score}">${scoreErrorMSG}<br>
		电话:<input type="text" name="mobile" value="${people.mobile}">${mobileErrorMSG}<br>
		<input type="submit" value="注册8">
	</form>
	
			---------------------<br>

	<form action="${pageContext.request.contextPath}/test/permission.do" method="POST">
		用户：<input id="user" type="text" name="user"><br>
		
		<input  type="submit" value="权限拦截">
		<%
			session.setAttribute("user","beijing");
		%>
	</form>
</body>
</html>