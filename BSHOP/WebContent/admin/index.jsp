<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>乐淘-后台管理</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/admincss/base.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/admincss/index.css" />
</head>
<body>
<div class="page">
	<div class="loginwarrp">
		<div class="logo">管理员登陆</div>
        <div class="login_form">
			<form  method="post" action="${pageContext.request.contextPath }/admin">
				<input type="hidden" name="method" value="loginAdmin">
				<span><font color="red">${msg }</font></span>
				<li class="login-item">
					<span>用户名：</span>
					<input type="text" name="adminName" class="login_input">
				</li>
				<li class="login-item">
					<span>密　码：</span>
					<input type="password" name="password" class="login_input">
				</li>
				<li class="login-item verify">
					<span>验证码：</span>
					<input type="text" name="CheckCode" class="login_input verify_input">
				</li>
				<img src="images/verify.png" border="0" class="verifyimg" />
				<div class="clearfix"></div>
				<li class="login-sub">
					<input type="submit" name="Submit" value="登录" />
				</li>                      
           </form>
		</div>
	</div>
</div>
</body>
</html>
