<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="Js/jquery.min.js"  type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/my.css"></link>
<title>登录界面</title>
</head>
<body style="background-image: url('image/bb.jpg');    background-size:100%; background-repeat:no-repeat;">
	<center>
		<form action="<%=request.getContextPath() %>/servlet/PersonWeb" method="get" >
				<div class="login_putin">
					<span>账户名:</span>
					<input type="text" name="username" size="12" title="输入账户名"/><br/>
					<span>密码名:</span>
					<input type="password" name="password" size="12" title="输入密码"/><br/>
				</div>
				<div class="login_btn">
					<input type="submit" value="登录"/>&nbsp; &nbsp;&nbsp;
					<input type="reset" value="重登"/>
				</div>
		</form>
	</center>
</body>
</html> 