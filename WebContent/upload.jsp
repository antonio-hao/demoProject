<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/up/upload.do" method="POST" enctype="multipart/form-data">
		文件：<input type="file" name="img"><br>
		<input type="submit" value="上传">
	</form>


	<form action="${pageContext.request.contextPath}/up/upload2.do" method="POST" enctype="multipart/form-data">
		文件1：<input type="file" name="imgs"><br>
		文件2：<input type="file" name="imgs"><br>
		文件3：<input type="file" name="imgs"><br>
		<input type="submit" value="上传">
	</form>
</body>
</html>