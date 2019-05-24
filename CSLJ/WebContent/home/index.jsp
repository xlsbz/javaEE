<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生用户主页</title>
<style type="text/css">
a {
	text-decoration: none;
}

#sjob, #cjob {
	width: 600px;
	border: 1px solid green;
	margin-top: 50px;
}

#cjob {
	float: right;
	margin-right: 20px;
}

#sjob {
	float: left;
	margin-left: 20px;
}
</style>

</head>
<body>
	
	<%
		String sname = (String) session.getAttribute("sname");
		if (sname != null) {
	%>
	<div style="width: 1400px; margin: 0 auto">
		<h2>
			欢迎<%=sname%>光临本系统
			<hr>
		</h2>
		<h3>
			<font color="red"><a href="index.jsp">首页</a></font> <span
				style="margin-left: 200px"> <input
				style="padding: 10px; background: white; color: black;"
				type="button" value="个人中心"
				onclick="location.href='StudentS?option=query_student'">
			</span> <span style="margin-left: 200px"> <input
				style="padding: 10px; background: white; color: black;"
				type="button" value="发布求职信"
				onclick="location.href='add_studentjob.jsp'">
			</span> <span style="margin-left: 200px"> <input
				style="padding: 10px; background: white; color: black;"
				type="button" value="查看求职信"
				onclick="location.href='StudentJobS?option=getAll_jobs'">
			</span> <span style="margin-left: 400px"> <input
				style="padding: 10px; background: white; color: red;" type="button"
				value="注销" onclick="location.href='StudentS?option=logon'">
			</span>
		</h3>
		<hr size="9">
		<div
			style="width: 1400px; margin: 0 auto; border: 1px solid red; height: 1500px; background: #ccc">
			<div id="sjob">
				<h4>今日求职</h4>
				<!-- 采用iterator遍历集合，el表达式输出 -->
				<%
					if (session.getAttribute("all_sjob") != null) {
				%>
				<table border="1">
					<tr>
						<td>求职人</td>
						<td>专业</td>
						<td>求职工作</td>
						<td>期望薪资</td>
						<td>发布时间</td>
						<td>有效时间</td>
						<td>简历</td>
						<td>操作</td>
					</tr>
					<%
						List all = (List) session.getAttribute("all_sjob");
								Iterator iterator = all.iterator();
								while (iterator.hasNext()) {
									request.setAttribute("sjob", iterator.next());
					%>
					<tr>
						<td>${sjob.jobid }</td>
						<td>${sjob.sname }</td>
						<td>${sjob.specialty }</td>
						<td>${sjob.job }</td>
						<td>${sjob.emolument }</td>
						<td>${sjob.ptime }</td>
						<td>${sjob.atime }</td>
						<td>${sjob.other }</td>
						<td><input type="button" value="查看详情"
							onclick="location.href='../admin/AdminS?jobid=${sjob.jobid}&option=to_find_sxq'"></td>
					</tr>
					<%
						}
					%>
				</table>
				<%
					}
				%>
			</div>
			<div id="cjob">
				<h4>今日招聘</h4>
				<!-- 采用jstl  foreach输出 -->
				<%
					if (session.getAttribute("all_cjob") != null) {
				%>
				<table border="1">
					<tr>
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

					<c:forEach items="${all_cjob }" var="cjob">
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
								onclick="location.href='../admin/AdminS?jobid=${cjob.jobid}&option=to_find_cxq'"></td>
						</tr>
					</c:forEach>
				</table>
				<%
					}
				%>
			</div>
			<%
				} else {
			%>
			<h1>
				点击<a href="login_student.jsp">这里</a>登录
			</h1>
			<h2>
				还没账号?点击<a href="register_student.jsp">这里</a>注册
			</h2>
			<%
				}
			%>
			<!-- 表达式语言输出 -->
			<h3>${job_success}</h3>
			<h3>${job_error}</h3>
		</div>
	</div>
</body>
</html>