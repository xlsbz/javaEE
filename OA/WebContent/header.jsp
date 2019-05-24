<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>欢迎</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div style="text-align: right;">
    	欢迎您：${sessionScope['com.dhr.logined'].name}&nbsp;&nbsp;
    	<c:if test="${!sessionScope['com.dhr.logined'].actived}">
    		<a href="${pageContext.request.contextPath}/login/LoginServlet?op=validateEmail">验证</a>
    	</c:if>
    	<c:if test="${sessionScope['com.dhr.logined'].actived}">
    		已验证
    	</c:if>
    	&nbsp;&nbsp;
    	<a href="${pageContext.request.contextPath}/login/LoginServlet?op=logout">安全退出</a>
    </div>
    <hr/>
    <a href="${pageContext.request.contextPath}/index.jsp">查看报名流程</a>
    <a href="${pageContext.request.contextPath}/apply/ApplyServlet?op=showApplyUI">发出入学申请</a>
    <a href="${pageContext.request.contextPath}/apply/ApplyServlet?op=processApplyUI">处理入学申请</a>
    <a href="">查看我的申请</a>
    <a href="${pageContext.request.contextPath}/apply/ApplyServlet?op=editCustomerUI">修改个人信息</a>
    <hr/>
  
