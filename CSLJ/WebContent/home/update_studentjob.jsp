<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>招才网--修改求职信息</title>
</head>
<body>
	<div style="width: 1400px; margin: 0 auto">
		<h3>
			个人信息 <span style="margin-left: 200px"><a href="index.jsp">首页</a></span>
			<span style="margin-left: 200px"><a href="add_studentjob.jsp"><font
					color="red">发布求职信</font></a></span> <span style="margin-left: 200px"><a
				href="query_studentjob.jsp">查看求职信</a></span>
		</h3>
		<hr>
		<div style="width: 1400px; margin: 0 auto">
			<form method="post" action="StudentJobS">
				<h1>修改求职信息</h1>
				<%
					if (session.getAttribute("sname") != null) {
				%>
				<input type="hidden" name="sname"
					value="<%=session.getAttribute("sname")%>"><br>
				<p>
					ID:<input type="text" name="jobid" value="${update.jobid }"><br>
				<p>
					行业名称：<input type="text" name="specialty"
						value="${update.specialty }"><br>
				<p>
					应聘工作：<input type="text" name="job" value="${update.job }"><br>
				<p>
					所求薪水：<input type="text" name="emolument"
						value="${update.emolument }"><br>
				<p>
					发布时间<input type="text" name="ptime" value="${update.ptime }"><br>
				<p>
					有效时间：<input type="text" name="atime" value="${update.atime }"><br>
				<p>
					其他说明：<input type="text" name="other" value="${update.other }"><br>
				<p>
					<input type="submit" name="" value="确认修改"> <input
						type="hidden" name="option" value="update_job"> <input
						type="reset" value="重置">
					<%
						} else {
					%>
				
				<h2>
					你还没有登录，请先<a href="login_student.jsp">登录</a>
				</h2>
				<%
			}
		%>
			</form>
		</div>
	</div>
</body>
</html>