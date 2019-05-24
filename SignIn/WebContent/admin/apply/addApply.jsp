<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import ="controller.ApplyS"%>
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

<title>Insert title here</title>
<link rel="stylesheet" href="/SignIn/admin/public/admin.css" />
    

</head>
<body>

<div class="container">
		<div class="public-nav" style="margin-top:1%">您当前的位置：<a href="">管理首页</a>><a href="">录入会议信息</a></div>
		<div class="public-content">
			<div class="public-content-header">
				<h3 style="display: inline-block;">录入员工信息</h3>
				<div class="public-content-right fr">
					<a href="admin/apply/addApply.jsp?suboption=nopage" style="height: 24px; width: 60px;border: 1px solid #ccc;font-size: 12px;text-align:center">新增</a>
				</div>
			</div>
			<div class="clearfix"></div>
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
<div style="margin-left:30%">
<fieldset>
<legend style="font-size:36px;margin-left:20%">录入信息</legend>
 <form action="ApplyS" method="post"> 
  <div><span class="titlespan">赛事编号:</span><input type="text" name="applyId" class=" form-control formText" id="firstname"" placeholder="请输入会议名称"></div>
  <div><span class="titlespan">比赛名称:</span><input type="text" name="applyName" class="form-control formText" placeholder="请录入一个为整形的管理员编号"></div>
  <div><span class="titlespan">报名时间:</span><input type="text" name="applyTimestart" class="form-control formText" placeholder="请录入不低于六位的管理员密码"></div>
  <div><span class="titlespan">截止时间:</span><input type="text" name="applyTimeend" class="form-control formText" placeholder="请录入管理员开启或关闭状态"></div>
  <div><span class="titlespan">赛事类型:</span><input type="text" name="applyType" class="form-control formText" placeholder="请录入管理员权限"></div>
  <div><span class="titlespan">赛事状态:</span><input type="text" name="applyState" class="form-control formText" placeholder="请录入管理员电话"></div>
  <div><span class="titlespan">赛事简介:</span><input type="text" name="applyInformation" class=" form-control formText" id="firstname"" placeholder="请录入管理员Id"></div>
  <div><span class="titlespan">比赛地点:</span><input type="text" name="applyAdress" class="form-control formText" placeholder="请录入一个为整形的管理员编号"></div>
  <div><span class="titlespan">赛事奖项:</span><input type="password" name="applyWin" class="form-control formText" placeholder="请录入不低于六位的管理员密码"></div>
  <div><span class="titlespan">联系电话:</span><input type="text" name="applyPhone" class="form-control formText" placeholder="请录入管理员开启或关闭状态"></div>
  <div><span class="titlespan">备注:</span><input type="text" name="applyBeizhu" class="form-control formText" placeholder="请录入管理员权限"></div>
  <div><span class="titlespan">发布人:</span><input type="text" name="admId" class="form-control formText" placeholder="请录入管理员电话"></div>
  <div><span class="titlespan"></span><input type="hidden" name="option" class="formText" value="addApplyInfo"></div>
  <div style="margin-left:-17%"><span class="submitspan"></span><input type="submit" name="option" class="formSubmit" value="addApplyInfo"></div> 
  <div style="margin-left:7%;margin-top:-6%"><span class="submitspan"></span><input type="reset" name="option" class="formSubmit" value="reset"></div>
 </form>
 </fieldset>

 </div>
 <div class="public-content-cont two-col" style="float:right;margin-top:-31%">
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
</div>
</body>
</html>