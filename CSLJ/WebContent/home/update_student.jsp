<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>招才网--修改个人信息</title>
<style type="text/css">	
	a{
	text-decoration: none;
	}
</style>
</head>
<body>
<div style="width:1400px;margin:0 auto">
	<h3><font color="red">个人信息</font>
	<span style="margin-left:200px"><a href="index.jsp">首页</a></span>
	<span style="margin-left:200px"><a href="add_studentjob.jsp">发布求职信</a></span>
	<span style="margin-left:200px"><a href="query_studentjob.jsp">查看求职信</a></span>
	</h3>
	<hr>
	<div style="width:1400px;margin:0 auto">
	<form method="post" action="StudentS" >
		<h1>修改个人信息</h1>
		<%
			if(session.getAttribute("sname")!=null){
		%>
			<input type="hidden" name="sname" value="<%=session.getAttribute("sname") %>"><br><p>
			密&nbsp;&nbsp;码：<input type="password" name="password" value="${update.password }"><br><p>
			姓&nbsp;&nbsp;名：<input type="text" name="name" value="${update.name }"><br><p>
			年&nbsp;&nbsp;龄：<input type="text" name="age" value="${update.age }"><br><p>
			性&nbsp;&nbsp;别：<input type="text" name="sex" value="${update.sex }"><br><p>
			生&nbsp;&nbsp;日：<input type="text" name="birthday" value="${update.birthday }"><br><p>
			学&nbsp;&nbsp;校：<input type="text" name="school" value="${update.school }"><br><p>
			专&nbsp;&nbsp;业：<input type="text" name="specialty" value="${update.specialty }"><br><p>
			学&nbsp;&nbsp;历：<input type="text" name="knowledge" value="${update.knowledge }"><br><p>
			邮&nbsp;&nbsp;箱：<input type="text" name="email" value="${update.email }"><br><p>
			说&nbsp;&nbsp;明：<input type="text" name="resume" value="${update.resume }"><br><p>
			<input type="submit" name="" value="确认修改">
			<input type="hidden" name="option" value="update_student">
			<input type="reset" value="重置">
		<%
				if(request.getAttribute("register_error")!=null){
		%>
				<h2><%=request.getAttribute("update_error") %></h2>
		<%
				}
			}else{
		%>
			<h2>你还没有登录，请先<a href="login_student.jsp">登录</a></h2>
		<%
			}
		%>
		
	</form>
	</div>
</div>
</body>
</html>