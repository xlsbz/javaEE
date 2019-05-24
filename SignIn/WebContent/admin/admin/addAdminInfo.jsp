<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import ="controller.AdminS"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="/SignIn/admin/public/admin.css" />
  <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<link rel="stylesheet" href="/SignIn/admin/public/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/SignIn/admin/public/jquery/jquery.min.js" />
<link rel="stylesheet" href="/SignIn/admin/public/bootstrap/js/bootstrap.min.js" />
<title>添加管理员信息</title>
</head>
<body>

	<div class="public-nav" style="margin-top:1%">您当前的位置：<a href="">管理首页</a><a href="">录入信息</a></div>
		<div class="public-content">
			<div class="public-content-header">
				<div class="public-content-right fr">
					<a href="admin/addAdminInfo.jsp?suboption=nopage" style="height: 24px; width: 60px;border: 1px solid #ccc;font-size: 12px;text-align:center">新增</a>
				</div>
			</div>
		
			<div class="public-content-cont two-col">
				<div class="public-cont-left col-1">
					<div class="public-cont-title">
						<h3>信息分类</h3>
					</div>
					<ul class="public-cate-list">
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
			    <li class="public-cate-item"><a href="#">+录入须知</a></li>
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
					</ul>
				</div>
			</div>
<div style="margin-left:20%">
<fieldset>
<legend style="font-size:36px;margin-left:20%">录入信息</legend>
 <form action="AdminS" method="post"> 
  <div><span class="text-primary">管理员ID:</span><input type="text" name="admId" class="form-control" id="focusedInput" placeholder="请录入管理员Id"></div>
  <div><span class="text-primary">管理员编号:</span><input type="text" name="admNumber" class="form-control formText" placeholder="请录入一个为整形的管理员编号"></div>
  <div><span class="text-primary">管理员密码:</span><input type="password" name="admPsd" class="form-control formText" placeholder="请录入不低于六位的管理员密码"></div>
  <div><span class="text-primary">管理员状态:</span><input type="text" name="admState" class="form-control formText" placeholder="请录入管理员开启或关闭状态"></div>
  <div><span class="text-primary">管理员权限:</span><input type="text" name="admPower" class="form-control formText" placeholder="请录入管理员权限"></div>
  <div><span class="text-primary">管理员电话:</span><input type="text" name="admPhone" class="form-control formText" placeholder="请录入管理员电话"></div>
  <div><span class="text-primary"></span><input type="hidden" name="option" class="formText" value="add"></div>
  <div style="margin-left:-17%"><span class="submitspan"></span><input type="submit" name="option" class="formSubmit" value="add"></div> 
  <div style="margin-left:7%;margin-top:-6%"><span class="submitspan"></span><input type="reset" name="option" class="formSubmit" value="reset"></div>
 </form>
 </fieldset>

 </div>

</div>
</body>
</html>