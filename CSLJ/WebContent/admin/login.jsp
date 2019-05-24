<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>后台登录</title>
</head>
<body>
	<form action="AdminS" method="post">
		管理员账户：<input type="text" name="username"><br> 管理员密码：<input
			type="password" name="password"><br> <input
			type="hidden" name="option" value="login"> <input
			type="submit" value="登录"> <input type="reset" value="重置">
	</form>
	<h3>${login_error }</h3>
</body>
</html>