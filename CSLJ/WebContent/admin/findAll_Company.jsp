<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>后台-公司信息</title>
<style type="text/css">
a {
	text-decoration: none;
}

table {
	align: "center";
}

.tr {
	height: 85px;
	width: 70px;
}

.tr td {
	width: 120px;
	padding-left: 20px;
	color: red;
}
</style>
</head>
<body>
	<div style="width: 1400px; margin: 0 auto">
		<h3>
			<font color="red"><a href="index.jsp">首页</a></font> <span
				style="margin-left: 100px"> <input
				style="padding: 10px; background: white; color: black;"
				type="button" value="个人中心"
				onclick="location.href='StudentS?option=query_student'">
			</span> <span style="margin-left: 100px"> <input
				style="padding: 10px; background: white; color: black;"
				type="button" value="查询所有公司信息"
				onclick="location.href='AdminS?option=findAll_Company'">
			</span> <span style="margin-left: 100px"> <input
				style="padding: 10px; background: white; color: black;"
				type="button" value="查询所有学生信息"
				onclick="location.href='AdminS?option=findAll_Student'">
			</span> <span style="margin-left: 100px"> <input
				style="padding: 10px; background: white; color: black;"
				type="button" value="查看所有求职信"
				onclick="location.href='AdminS?option=findAll_Sjob'">
			</span> <span style="margin-left: 100px"> <input
				style="padding: 10px; background: white; color: black;"
				type="button" value="查看所有招聘信"
				onclick="location.href='AdminS?option=findAll_Cjob'">
			</span> <span style="margin-left: 200px"> <input
				style="padding: 10px; background: white; color: red;" type="button"
				value="注销" onclick="location.href='AdminS?option=logon'">
			</span>
		</h3>
		<hr>
		<div style="width: 1400px; margin: 0 auto">
			<!-- foreach实现遍历 -->
			<table class="tb">
				<tr class="tr">
					<td>用户名</td>
					<td>公司名</td>
					<td>邮箱</td>
					<td>电话</td>
					<td>行业</td>
					<td>地址</td>
					<td>简介</td>
				</tr>
				<c:forEach items="${all_company}" var="company">
					<tr>
						<td>${company.cname }</td>
						<td>${company.name }</td>
						<td>${company.email }</td>
						<td>${company.tel }</td>
						<td>${company.manage }</td>
						<td>${company.address }</td>
						<td>${company.resume }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>