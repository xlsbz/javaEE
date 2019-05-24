<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>操作提示</title>
</head>
<body>
	<%--删除求职信息失败事件 --%>
	<%
		if (request.getAttribute("register_success") != null) {
	%>
	<%
		response.setHeader("Refresh", "2,URL=index.jsp");
	%>
	<h3>${register_success},两秒后跳转，还没有跳转点击<a href="index.jsp">这里</a>
	</h3>
	<%
		}
	%>
	<%--更新求职信成功事件 --%>
	<%
		if (request.getAttribute("updatejob_success") != null) {
	%>
	<%
		response.setHeader("Refresh", "2,URL=index.jsp");
	%>
	<h3>${updatejob_success},两秒后跳转，还没有跳转点击<a href="index.jsp">这里</a>
	</h3>
	<%
		}
	%>
	<%--更新个人信息成功事件 --%>
	<%
		if (request.getAttribute("update_success") != null) {
	%>
	<%
		response.setHeader("Refresh", "1,URL=login_student.jsp");
	%>
	<h3>${update_success},两秒后跳转，还没有跳转点击<a href="login_student.jsp">这里</a>
	</h3>
	<%
		}
	%>
	<%--更新失败事件 --%>
	<%
		if (request.getAttribute("updatejob_error") != null) {
	%>
	<%
		response.setHeader("Refresh", "2,URL=index.jsp");
	%>
	<h3>${updatejob_error},两秒后跳转，还没有跳转点击<a href="index.jsp">这里</a>
	</h3>
	<%
		}
	%>
	<%--删除求职信息成功事件 --%>
	<%
		if (request.getAttribute("deljob_success") != null) {
	%>
	<%
		response.setHeader("Refresh", "2,URL=index.jsp");
	%>
	<h3>${deljob_success},两秒后跳转，还没有跳转点击<a href="index.jsp">这里</a>
	</h3>
	<%
		}
	%>
	<%--删除求职信息失败事件 --%>
	<%
		if (request.getAttribute("deljob_error") != null) {
	%>
	<%
		response.setHeader("Refresh", "2,URL=index.jsp");
	%>
	<h3>${deljob_error},两秒后跳转，还没有跳转点击<a href="index.jsp">这里</a>
	</h3>
	<%
		}
	%>
</body>
</html>