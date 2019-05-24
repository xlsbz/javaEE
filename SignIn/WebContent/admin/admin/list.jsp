<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="controller.AdminS"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="paging" uri="../../WEB-INF/paging.tld" %>
 
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reset.css" />
<link rel="stylesheet" href="/SignIn/admin/public/admin.css" />

</head>
<body marginwidth="0" marginheight="0">
 <%AdminS admins = new AdminS();
 
 admins.getAllAdmin(request);
 %>
 <c:if test="${result >= 1}">
   <script>
     alert("${admin.admId}" + "${msg}");
   </script>
 </c:if>
 <c:if test="${result < 1}">
   <script>
   alert("${admin.admId}" + "${msg}");
   </script>
 </c:if>

<div class="main">
<div class="container">
		<div class="public-nav" style="margin-top:1%">您当前的位置：<a href="">管理首页</a>><a href="">信息列表</a></div>
		<div class="public-content">
			<div class="public-content-header">
				<h3 style="display: inline-block;">管理员列表信息</h3>
				<div class="public-content-right fr">
					<a href="admin/admin/addAdminInfo.jsp?suboption=nopage" style="height: 24px; width: 60px;border: 1px solid #ccc;font-size: 12px;text-align:center">新增</a>
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="public-content-cont two-col">
				<div class="public-cont-left col-1">
					<div class="public-cont-title">
						<h3>信息分类</h3>
					</div>
					<ul class="public-cate-list">
						<li class="public-cate-item"><a href="#">+管理员须知</a></li>
					    <li class="public-cate-item"><a href="#">+管理员须知</a></li>
						<li class="public-cate-item"><a href="#">+管理员须知</a></li>
						<li class="public-cate-item"><a href="#">+管理员须知</a></li>
						<li class="public-cate-item"><a href="#">+管理员须知</a></li>
						<li class="public-cate-item"><a href="#">+管理员须知</a></li>
						<li class="public-cate-item"><a href="#">+管理员须知</a></li>
						<li class="public-cate-item"><a href="#">+管理员须知</a></li>
						<li class="public-cate-item"><a href="#">+管理员须知</a></li>
						<li class="public-cate-item"><a href="#">+管理员须知</a></li>
						<li class="public-cate-item"><a href="#">+管理员须知</a></li>
						<li class="public-cate-item"><a href="#">+管理员须知</a></li>
						<li class="public-cate-item"><a href="#">+管理员须知</a></li>
						<li class="public-cate-item"><a href="#">+管理员须知</a></li>
						<li class="public-cate-item"><a href="#">+管理员须知</a></li>
						<li class="public-cate-item"><a href="#">+管理员须知</a></li>
						<li class="public-cate-item"><a href="#">+管理员须知</a></li>
						<li class="public-cate-item"><a href="#">+管理员须知</a></li>
						<li class="public-cate-item"><a href="#">+管理员须知</a></li>
						<li class="public-cate-item"><a href="#">+管理员须知</a></li>
					</ul>
				</div>
 <table class="public-cont-table col-2">
 <!-- items是对应调用了Servlet对应方法中 保存到request中的集合对象的名称 -->
  <caption style="font-size:36px;padding-bottom:2%">管理员信息</caption>
  <tr style="background:rgb(222,222,222)">
  <td style="width:10%">管理员ID</td>
  <td style="width:10%">管理员编号</td>
  <td style="width:10%">管理员密码</td>
  <td style="width:10%">管理员状态</td>
  <td style="width:10%">管理员权限</td>
  <td style="width:10%">管理员电话</td>
  <td colspan=2  style="width:10%">操作</td>
  </tr>
  <c:forEach items="${admins}" var="admin">
    <tr>	
      <td>${admin.admId}</td>
      <td>${admin.admNumber}</td>
      <td>${admin.admPsd}</td>
      <td>${admin.admState}</td>
      <td>${admin.admPower}</td>
      <td>${admin.admPhone}</td>
      <div  class="table-fun">
      <td class="ac"><a href="admin/admin/updateInfo.jsp?suboption=nopage"> 修改</a></td>
      <td class="ac"><a href="admin/admin/deleteAdminInfo.jsp?suboption=nopage">删除</a></td>
      <div>
    </tr>
  </c:forEach>
   </table>

  <div style="margin-left:80%;margin-top:1%;">
  <paging:paging 
  href="admin/admin/list.jsp" 
  maxResults="${pageInfo.maxResults}" 
  firstResult="${pageInfo.firstResult}" 
  itemCount="${pageInfo.itemCount}"/>
  </div>

</div>
 </div>
</body>
</html>