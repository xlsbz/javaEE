<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>后台-学生信息</title>
<style type="text/css">
a {
	text-decoration: none;
}

.tb {
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
			<!-- 采用jstl  foreach输出 -->
			<table class="tb">
				<tr class="tr">
					<td>工作编号</td>
					<td>发布人</td>
					<td>招聘工作</td>
					<td>招聘岗位</td>
					<td>工资薪水</td>
					<td>发布时间</td>
					<td>有效时间</td>
					<td>招聘要求</td>
					<td>操作</td>
				</tr>

				<c:forEach items="${allcjob }" var="cjob">
					<tr>
						<td>${cjob.jobid }</td>
						<td>${cjob.cname }</td>
						<td>${cjob.specialty }</td>
						<td>${cjob.job }</td>
						<td>${cjob.emolument }</td>
						<td>${cjob.ptime }</td>
						<td>${cjob.atime }</td>
						<td>${cjob.other }</td>
						<td><input type="button" value="查看详情"
							onclick="location.href='AdminS?jobid=${cjob.jobid}&option=to_find_cxq'"></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>