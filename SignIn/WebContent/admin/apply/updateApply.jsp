<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="controller.*"%>
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
<style type="text/css">

 input{
 
 }
 a:hover{
 color:red;
 background:#ff0000;}
 .main  div{margin-top:5px;}
 input{
 margin:10px;
 }
 h1{
 color:red;
 }
  .titlespan{width:120px;display: inline-block;}
  
  .formText{height:26px;width:400px;border-radius:2px;}
  .submitspan{width:260px;height:26px;display: inline-block;}
    .formSubmit{height:56px;width:120px;border-radius:5px;}
    
    .public-content .public-content-cont .public-cont-table{
	width:100%;
}
.public-content .two-col .public-cont-table{
	width:71%;
	font-size: 12px;
	line-height: 38px;
}
.public-content .public-content-cont tr{
	height: 38px;
	text-align: center;
	border: 1px solid #ccc;
}
.public-content .public-content-cont th{
	background: #dedede;
	padding: 5px;
}
.public-content .public-content-cont td{
	height:38px;
	border-right: 1px solid #ccc;
}
.public-content .public-content-cont .table-fun a{
	display: inline-block;
	width:40px;
	height: 24px;
	line-height: 24px;
	padding: 3px;
	border: 1px solid #ddd;
	border-radius: 5px;
}
.public-content .public-content-cont .thumb{
	width: 150px;
	height: 50px;
	margin:10px;
}
.public-content .page{
	text-align: center;
	height: 34px;
	line-height: 34px;
	margin-top: 10px;
}
.public-content .page a{
	display: inline-block;
}
.public-content .page .page-input{
	width:40px;
	height: 20px;
	line-height: 20px;
	padding-left: 5px;
	border-radius: 5px;
	border:1px solid #ccc;
	outline: none;
}
.public-content .page .page-btn{
	width:40px;
	height: 28px;
	line-height: 20px;
	padding-left: 5px;
	border-radius: 5px;
	border: none;
	color:#fff;
	background: #6CB98F;
}
.public-content .public-cont-left{
	width:260px;
	border:1px solid #ccc;
	padding: 5px;
	float: left;
	margin-right: 10px;
}
.public-content .two-col .col-1{
	width:170px;
}
.public-content .two-col .col-2{
	width:79%;
}
.public-content .public-cont-left .public-cont-title{
	height: 28px;
	line-height: 28px;
	border-bottom: 1px dashed #ccc;
}
.public-content .public-cate-list{
	padding: 5px;
}
.public-content .public-cate-list .public-cate-item{
	height:24px;
	line-height: 24px;
}
.public-content .public-cate-list .public-cate-item a:hover{
	color:#6CB98F;
}
body{background: #fff;}
.container{
	width: 100%;
    overflow: hidden;
    background: #FFFFFF;
}
.public-nav{
	height: 28px;
	line-height: 28px;
	border-bottom: 1px solid #ddd;
    padding-left: 8px;
}
.public-nav a{
	display: inline-block;
	margin-left: 15px;
	margin-right: 15px;
	position: relative;
}
.public-content{
	margin-top: 15px;
}
.public-content .public-content-header{
	height: 28px;
	line-height: 28px;
	font-weight: 600;
	padding-left: 10px;
	border-bottom: 1px solid #dedede;
}
.public-content .public-content-cont{
	padding:15px;
	position: relative;
}


html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, embed, 
figure, figcaption, footer, header, hgroup, 
menu, nav, output, ruby, section, summary,
time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
}
article, aside, details, figcaption, figure, 
footer, header, hgroup, menu, nav, section {
	display: block;
}
body {
	line-height: 1;
}
ol, ul,li {
	list-style: none;
}
blockquote, q {
	quotes: none;
}
blockquote:before, blockquote:after,
q:before, q:after {
	content: '';
	content: none;
}
table {
	border-collapse: collapse;
	border-spacing: 0;
}
a{
	text-decoration: none;
	color: #333;
	display: block;
}
body{
	background: url("images/bg.jpg");
    font-size: 14px;
}
.clearfix{
	zoom:1;
}
.clearfix:after{
	content:".";
	display:block;
	visibility:hidden;
	height:0;
	clear:both;
}
.fl,.l{
	float: left;
}
.fr,.r{
	float: right;
}
/*margin-top*/
.mt10{
	margin-top: 10px;
}
.mt15{
	margin-top: 15px;
}
.mt20{
	margin-top: 20px;
}
.mt5{
	margin-top: 5px;
}
.mt0{
	margin-top: 0px;
}
/*padding-left*/
.pl15{
	padding-left: 15px;
}
.ac{
border:1px solid rgb(222,222,222);
padding:7px;
border-radius:5px;
font-size:16px;
font-weight:bold;
}
a:hover{
background:#ff0000;
color:white;
}
</style>
</head>
<body>
<div class="main">
<div class="container">
		<div class="public-nav" style="margin-top:1%">您当前的位置：<a href="">管理首页</a>><a href="">录入信息</a></div>
		<div class="public-content">
			<div class="public-content-header">
				<h3 style="display: inline-block;">录入员工信息</h3>
				<div class="public-content-right fr">
					<a href="admin/admin/addAdminInfo.jsp?suboption=nopage" style="height: 24px; width: 60px;border: 1px solid #ccc;font-size: 12px;text-align:center">新增</a>
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="public-content-cont two-col">
					 <div class="public-content-cont two-col" >
				<div class="public-cont-left">
					<div class="public-cont-title">
						<h3>添加修改分类</h3>
					</div>
					<div class="form-group">
						<label for="">分类名称</label>
						<select name="" id="" class="form-select">
							<option value="1">一级分类</option>
						</select>
					</div>
					<div class="form-group mt0">
						<label for="">分类名称</label>
						<input type="text" class="form-input-small">
					</div>
					<div class="form-group mt0">
						<label for="">排序编号</label>
						<input type="text" class="form-input-small">
					</div>
					<div class="form-group mt0">
						<label for="">外链</label>
						<input type="text" class="form-input-small">
					</div>
					<div class="form-group">
						<label for="">缩略图</label>
						<input type="text" class="form-input-small">
						<div class="file"><input type="file" class="form-input-file" />选择文件</div>
						<div class="file"><input type="submit" class="form-input-file"/>上传</div>
					</div>
					<div class="clearfix"></div>
					<div class="form-group">
						<label for="">导航显示</label>
						<input type="checkbox" />显示
					</div>
					<div class="form-group mt0">
						<label for="">查看权限</label>
						<input type="checkbox" />会员
					</div>
					<div class="form-group mt0">
						<label for="">新栏目</label>
						<input type="checkbox" />显示
					</div>
					<div class="form-group mt0" style="text-align:center;margin-top:15px;">
						<input type="submit" class="sub-btn" value="提   交">
					</div>
					
				</div>
			</div>
<div style="margin-left:30%">
 <form action="ApplyS" method="post">
 <legend style="font-size:36px;margin-left:20%">修改信息</legend>
  <div><span class="titlespan">赛事编号:</span><input type="text" name="applyId" class=" form-control formText" id="firstname"" placeholder="请录入管理员Id"></div>
  <div><span class="titlespan">赛事名称:</span><input type="text" name="applyName" class="form-control formText" placeholder="请录入一个为整形的管理员编号"></div>
  <div><span class="titlespan">报名时间:</span><input type="text" name="applyTimestart" class="form-control formText" placeholder="请录入不低于六位的管理员密码"></div>
  <div><span class="titlespan">截止时间:</span><input type="text" name="applyTimeend" class="form-control formText" placeholder="请录入管理员开启或关闭状态"></div>
  <div><span class="titlespan">赛事类型:</span><input type="text" name="applyType" class="form-control formText" placeholder="请录入管理员权限"></div>
  <div><span class="titlespan">赛事状态:</span><input type="text" name="applyState" class="form-control formText" placeholder="请录入管理员电话"></div>
  <div><span class="titlespan">赛事简介:</span><input type="text" name="applyInformation" class=" form-control formText" id="firstname"" placeholder="请录入管理员Id"></div>
  <div><span class="titlespan">比赛地点:</span><input type="text" name="applyAdress" class="form-control formText" placeholder="请录入一个为整形的管理员编号"></div>
  <div><span class="titlespan">比赛奖项:</span><input type="password" name="applyWin" class="form-control formText" placeholder="请录入不低于六位的管理员密码"></div>
  <div><span class="titlespan">联系电话:</span><input type="text" name="applyPhone" class="form-control formText" placeholder="请录入管理员开启或关闭状态"></div>
  <div><span class="titlespan">备注:</span><input type="text" name="applyBeizhu" class="form-control formText" placeholder="请录入管理员权限"></div>
  <div><span class="titlespan">发布人:</span><input type="text" name="admId" class="form-control formText" placeholder="请录入管理员电话"></div>
  <div><span class="titlespan"></span><input type="hidden" name="option" class="formText" value="updateApplyInfo"></div>
  <div><span class="submitspan"></span><input type="submit" class="formSubmit" value="updateApplyInfo"></div>
 </form>
 </div>
 <div class="public-content-cont two-col" style="float:right;margin-top:-28%">
				<div class="public-cont-left">
					<div class="public-cont-title">
						<h3>删除修改分类</h3>
					</div>
					<div class="form-group">
						<label for="">分类名称</label>
						<select name="" id="" class="form-select">
							<option value="1">一级分类</option>
						</select>
					</div>
					<div class="form-group mt0">
						<label for="">分类名称</label>
						<input type="text" class="form-input-small">
					</div>
					<div class="form-group mt0">
						<label for="">排序编号</label>
						<input type="text" class="form-input-small">
					</div>
					<div class="form-group mt0">
						<label for="">外链</label>
						<input type="text" class="form-input-small">
					</div>
					<div class="form-group">
						<label for="">缩略图</label>
						<input type="text" class="form-input-small">
						<div class="file"><input type="file" class="form-input-file" />选择文件</div>
						<div class="file"><input type="submit" class="form-input-file"/>上传</div>
					</div>
					<div class="clearfix"></div>
					<div class="form-group">
						<label for="">导航显示</label>
						<input type="checkbox" />显示
					</div>
					<div class="form-group mt0">
						<label for="">查看权限</label>
						<input type="checkbox" />会员
					</div>
					<div class="form-group mt0">
						<label for="">新栏目</label>
						<input type="checkbox" />显示
					</div>
					<div class="form-group mt0" style="text-align:center;margin-top:15px;">
						<input type="submit" class="sub-btn" value="提   交">
					</div>
				</div>
 
</div>
</body>
</html>