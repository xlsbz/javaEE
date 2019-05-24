<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>后台-学生信息</title>
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
	width: 60px;
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
			<!-- 采用iterator遍历集合，el表达式输出 -->
			<table class="tb">
				<tr class="tr">
					<td>用户名</td>
					<td>姓名</td>
					<td>性别</td>
					<td>年龄</td>
					<td>生日</td>
					<td>学校</td>
					<td>学历</td>
					<td>专业</td>
					<td>邮箱</td>
					<td>简历</td>
				</tr>
				<%
					List all = (List) request.getAttribute("all_student");
					Iterator iterator = all.iterator();
					while (iterator.hasNext()) {
						request.setAttribute("all", iterator.next());
				%>
				<tr>
					<td>${all.sname}</td>
					<td>${all.name}</td>
					<td>${all.sex}</td>
					<td>${all.age}</td>
					<td>${all.birthday}</td>
					<td>${all.school}</td>
					<td>${all.specialty}</td>
					<td>${all.knowledge}</td>
					<td>${all.email}</td>
					<td>${all.resume}</td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
	</div>
</body>
</html>