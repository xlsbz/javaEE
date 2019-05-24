<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>公司信息</title>
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
				href="add_companyjob.jsp">发布招聘信</a></span> <span style="margin-left: 200px"><a
				href="query_companyjob.jsp">查看招聘信</a></span>
		</h3>
		<hr>
		<div style="width: 1400px; margin: 0 auto">
			<table border="1" cellpadding="30px">
				<tr>
					<td>用户名</td>
					<td>${query_success.cname }</td>
				</tr>
				<tr>
					<td>姓名</td>
					<td>${query_success.name }</td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td>${query_success.email }</td>
				</tr>
				<tr>
					<td>电话</td>
					<td>${query_success.tel }</td>
				</tr>
				<tr>
					<td>行业</td>
					<td>${query_success.manage }</td>
				</tr>
				<tr>
					<td>地址</td>
					<td>${query_success.address }</td>
				</tr>
				<tr>
					<td>简介</td>
					<td>${query_success.resume }</td>
				</tr>
			</table>
			<input type="button" value="修改个人信息"
				onclick="location.href='CompanyS?option=to_update'">
		</div>
	</div>
</body>
</html>