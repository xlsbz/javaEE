<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>个人信息</title>
<style type="text/css">
a {
	text-decoration: none;
}
</style>
</head>
<body>
	<div style="width: 1400px; margin: 0 auto">
		<h3>
			<font color="red">个人信息</font> <span style="margin-left: 200px"><a
				href="index.jsp">首页</a></span> <span style="margin-left: 200px"><a
				href="add_studentjob.jsp">发布求职信</a></span> <span style="margin-left: 200px"><a
				href="query_studentjob.jsp">查看求职信</a></span>
		</h3>
		<hr>
		<div style="width: 1400px; margin: 0 auto">
			<table border="1" cellpadding="30px">
				<tr>
					<td>用户名</td>
					<td>${query_success.sname }</td>
				</tr>
				<tr>
					<td>姓名</td>
					<td>${query_success.name }</td>
				</tr>
				<tr>
					<td>年龄</td>
					<td>${query_success.age }</td>
				</tr>
				<tr>
					<td>性别</td>
					<td>${query_success.sex }</td>
				</tr>
				<tr>
					<td>生日</td>
					<td>${query_success.birthday }</td>
				</tr>
				<tr>
					<td>学校</td>
					<td>${query_success.school }</td>
				</tr>
				<tr>
					<td>专业</td>
					<td>${query_success.specialty }</td>
				</tr>
				<tr>
					<td>学历</td>
					<td>${query_success.knowledge }</td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td>${query_success.email }</td>
				</tr>
				<tr>
					<td>简介</td>
					<td>${query_success.resume }</td>
				</tr>
			</table>
			<input type="button" value="修改个人信息"
				onclick="location.href='StudentS?option=to_update'">
		</div>
	</div>
</body>
</html>