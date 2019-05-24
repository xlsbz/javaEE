<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="controller.SignInS"%>
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
 .nodisplay{display: block;}
 .main{
  width:400px;margin-left:auto;margin-right:auto;margin-top:20px;
 }
 .main  div{margin-top:5px;}
 
 
  .titlespan{width:120px;display: inline-block;}
  
  .formText{height:26px;width:160px;border-radius:2px;}
  .submitspan{width:260px;height:26px;display: inline-block;}
    .formSubmit{height:26px;width:80px;border-radius:5px;}
    
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


    
<script>
$(function() {
	$('.popupDatepicker').datepick();
	 //$('#inlineDatepicker').datepick({onSelect: showDate});
   });
function showDate(date) {
	alert('The date chosen is ' + date);
}
</script>
</head>
<body>
 <%SignInS sign = new SignInS();
sign.deleteSignInInfo(request);//request是jsp的内置对象，由服务器生成，服务器启动new request对象
 //StudentS studentS = new StudentS();
 //studentS.getStudentBySno(request);//request是jsp的内置对象，由服务器生成，服务器启动new request对象
 %>
<div >
<div class="container">
		<div class="public-nav" style="margin-top:1%">您当前的位置：<a href="">管理首页</a>><a href="">删除信息</a></div>
		<div class="public-content">
			<div class="public-content-header">
				<h3 style="display: inline-block;">删除员工信息</h3>
				<div class="public-content-right fr">
					<a href="back/admin/index/addAdminInfo.jsp?suboption=nopage" style="height: 24px; width: 60px;border: 1px solid #ccc;font-size: 12px;text-align:center">新增</a>
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
					<li class="public-cate-item"><a href="#">+录入须知</a></li>
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
				<li class="public-cate-item"><a href="#">+录入须知</a></li>
		
					</ul>
				</div>
			</div>
	<div style="margin-left:30%">
 <form action="SignInS" method="get">
 <legend style="font-size:30px;margin-left:20%">按签到ID删除</legend>

  <div><span class="titlespan">签到ID:</span><input type="text" name="signId" class="formText" value="" placeholder=${admin.admID}></div>
     <div><span class="titlespan"></span><input type="hidden" name="option" class="formText" value="deleteSignInInfo"></div>
   <div><span class="submitspan"></span><input type="submit" class="formSubmit" value="deleteSignInInfo"></div>
  
</form>
</div>
</div>
</body>
</html>