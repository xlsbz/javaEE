<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import ="controller.ApplyinformationS"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="../public/css/apply.css">
	<base href="<%=basePath%>"/>
		<title>报名信息</title>
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
	
</head>
<body>
		<div class="zjxxbox">
			<div class="zjtxtbox">
			<form action=ApplyinformationS method="post"> 
				<h1 align="center">填写报名信息</h1>
				<div class="list">
					<p class="type">您的学号</p>
					<input type="text" placeholder="请输入您的姓名" name="contId"/>
				</div>
				<div class="list">
					<p class="type">您的姓名</p>
					<input type="text" placeholder="请输入您的电话" name="contName"/>
				</div>
				<div class="list">
					<p class="type">您的性别</p>
					<input type="text" placeholder="请输入您的企业姓名" name="contSex"/>
				</div>
				<div class="list">
					<p class="type">您的编号</p>
					<input type="text" placeholder="请输入您的企业姓名" name="contNumber"/>
				</div>
				<div class="list">
					<p class="type">您的学校</p>
					<input type="text" placeholder="请输入您的企业姓名" name="contCard"/>
				</div>
				<div class="list">
					<p class="type">您的密码</p>
					<input type="text" placeholder="请输入您的企业姓名" name="contSchool"/>
				</div>
				<div class="list">
					<p class="type">您的班级</p>
					<input type="text" placeholder="请输入您的企业姓名" name="contClass"/>
				</div>
				<div class="list">
					<p class="type">你的电话</p>
					<input type="text" placeholder="请输入您的企业姓名" name="contPhone"/>
				</div>
			
				<div class="list">
					<p class="type">备注内容</p>
					<input type="text" placeholder="请输入您的备注内容" name="contBeizhu"/>
				</div>
					<div class="list">
					<p class="type">参加赛事</p>
					<input type="text" placeholder="请输入您的企业姓名" name="applyId"/>
				</div>
				<div class="list">
					<p class="info">活动开始前7个工作日内可以修改或取消报名。</p>
				</div>
				<div class="btns">
				<input type="submit" name="option"  value="addApplyinformation" class="ui-btn"></input>
				</div>
	
			</form>
					
			</div>
		</div>	
	</body>
</html>