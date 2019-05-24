<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>申请审批管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/calendar.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/util.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/calendar.js"></script>
  </head>
  <body>
    欢迎您：${sessionScope.user.nickname}
    <hr/>
           业务处理：
    <a href="${pageContext.request.contextPath}/manage/ProcessServlet?op=listApplys">查询申请</a>
    <a href="">自荐信审批</a>
    <a href="">基础测试审批</a>
    <a href="">分配入学名额</a>
    &nbsp;&nbsp;
	系统配置：
    <a href="${pageContext.request.contextPath}/manage/ConfigServlet?op=listAllInfoSources">信息来源设置</a>
    <a href="${pageContext.request.contextPath}/manage/ConfigServlet?op=listAllCustomerStatus">客户状态设置</a>
    <a href="${pageContext.request.contextPath}/manage/ConfigServlet?op=listAllClassTypes">课程类型设置</a>
    <a href="${pageContext.request.contextPath}/manage/ConfigServlet?op=listClasses">开班设置</a>
    <br/>
    权限管理：
    <a href="${pageContext.request.contextPath}/manage/PrivilegeServlet?op=listFunctions">功能管理</a>
    <a href="${pageContext.request.contextPath}/manage/PrivilegeServlet?op=listRoles">角色管理</a>
    <a href="${pageContext.request.contextPath}/manage/PrivilegeServlet?op=listUsers">用户管理</a>
<hr/>