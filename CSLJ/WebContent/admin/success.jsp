<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>提示页</title>
</head>
<body>
	<% 
		if(request.getAttribute("login_success")!=null){
		response.setHeader("Refresh", "1,url=index.jsp");
	%>
	<h3>${login_success}两秒回到主页,还没有?点击<a href="index.jsp">这里</a>
	</h3>
	<%
		} 
	%>
	<% 
		if(request.getAttribute("logon_success")!=null){
		response.setHeader("Refresh", "1,url=login.jsp");
	%>
	<h3>${logon_success}两秒回到主页,还没有?点击<a href="login.jsp">这里</a>
	</h3>
	<%
		} 
	%>
</body>
</html>