<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>后台登录</title>
<!-- ajax -->
<script type="text/javascript" >
	var ajax = null;
	function create(){
		if(window.XMLHttpRequest){
			ajax = new XMLHttpRequest();
		}else{
			ajax = new ActiveXObject("Mricosoft XMLHTTP");
		}
	}
	function job() {
		create();
		ajax.open("POST","IndexS");
		ajax.onreadystatechange = callback;
		ajax.send(null);
	}
	function callback(){
		if(ajax.status==200&&ajax.readyState==4){
			var success = ajax.responseText;
		}
	}
	window.onload = function() {
		job();
	}
</script>
</head>
<body>
<div style="width: 1400px; margin: 0 auto">
		<h3>
			<font color="red">个人信息</font> <span style="margin-left: 200px"><a
				href="index.jsp">首页</a></span> 
		</h3>
		<hr>
		<div style="width: 1400px; margin: 0 auto">
	<%
		String sname = (String) session.getAttribute("sname");
		if (sname == null) {
	%>
	<form action="StudentS" method="post">
		用户账户：<input type="text" name="name"><br>
		用户密码：<input type="password" name="password"><br>
		<input type="hidden" name="option" value="login_student">
		<input type="submit" value="登录">
		<input type="reset" value="重置">
	</form>
	<%
		}else{
	%>
		<h2>您已经登陆过了，正在跳往主页...
		<% response.setHeader("Refresh", "2,url=index.jsp"); %>
		</h2>
	<%
		}
	%>
	<h3>${error }</h3>
	</div>
</div>
</body>
</html>