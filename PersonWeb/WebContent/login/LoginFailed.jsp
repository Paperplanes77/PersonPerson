<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		response.setHeader("refresh","4;URL=../LoginTest.jsp");
		/* 要先退出这个包面然后再改变 */
	%>
	<h3>很遗憾没有登录成功,两秒后跳转回登录页面!</h3>
	<h3>如果没有跳转，请按<a href="../LoginTest.jsp">这里</a></h3>
</body>
</html>