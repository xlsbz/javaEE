<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>页面提示</title>
</head>
<body>
	<%-- 注册事件 --%>
	<%
		if (request.getAttribute("register_success") != null) {
	%>
	<%
		response.setHeader("Refresh", "2,URL=login_company.jsp");
	%>
	<h3>${register_success },两秒后跳转，还没有跳转点击<a href="login_company.jsp">这里</a>
	</h3>
	<%
		}
	%>
	<%-- 登录事件 --%>
	<%
		if (request.getAttribute("login_success") != null) {
	%>
	<%
		response.setHeader("Refresh", "2,URL=index.jsp");
	%>
	<h3>${login_success},两秒后跳转，还没有跳转点击<a href="index.jsp">这里</a>
	</h3>
	<%
		}
	%>
	<%--更新事件 --%>
	<%
		if (request.getAttribute("update_success") != null) {
	%>
	<%
		response.setHeader("Refresh", "2,URL=index.jsp");
	%>
	<h3>${update_success},两秒后跳转，还没有跳转点击<a href="index.jsp">这里</a>
	</h3>
	<%
		}
	%>
	<%--发布招聘信息事件 --%>
	<%
		if (request.getAttribute("insertjob_success") != null) {
	%>
	<%
		response.setHeader("Refresh", "2,URL=index.jsp");
	%>
	<h3>${insertjob_success},两秒后跳转，还没跳转点击<a href="index.jsp">这里</a>
	</h3>
	<%
		}
	%>
	<%--删除招聘信息事件 --%>
	<%
		if (request.getAttribute("del_success") != null) {
	%>
	<%
		response.setHeader("Refresh", "2,URL=index.jsp");
	%>
	<h3>${del_success},两秒后跳转，还没跳转点击<a href="index.jsp">这里</a>
	</h3>
	<%
		}
	%>
	<%--删除招聘失败事件 --%>
	<%
		if (request.getAttribute("msg_del") != null) {
	%>
	<%
		response.setHeader("Refresh", "2,URL=index.jsp");
	%>
	<h3>${msg_del},两秒后跳转，还没跳转点击<a href="index.jsp">这里</a>
	</h3>
	<%
		}
	%>
</body>
</html>