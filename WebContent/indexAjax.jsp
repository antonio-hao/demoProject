<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("button").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/mv/myAjax.do",
				data:{
					name:"张三",
					age:"23"
				},
				success:function(data){
					var json = JSON.parse(data);
					alert(json.pname + "   " + json.page);
				}
			});
		});
	});
</script>
	<body>
		<button>提交Ajax请求</button>
	</body>
</html>