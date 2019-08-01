<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome page</title>
</head>
<body>
<!-- 
param.pname的底层执行的是request.getParameter("pname")
requestScope.pname的底层执行的是request.getAttribute("pname")
 -->

name: ${param.pname}<br>
age: ${param.age}<br>
birthday: ${param.birthday}<br>
---------------------------<br>
姓名：${people.name}<br>
成绩：${people.score}<br>
电话：${people.mobile}<br>

</body>
</html>