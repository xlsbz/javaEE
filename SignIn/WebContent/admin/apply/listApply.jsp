<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="controller.ApplyS"%>
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
<title>Insert title here</title>
<link rel="stylesheet" href="css/reset.css" />
<link rel="stylesheet" href="css/content.css" />
<link rel="stylesheet" type="text/css" href="css/font.css">
<link rel="stylesheet" type="text/css" href="public/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="public/bootstrap/css/bootstrap.min.css">
<script src="public/bootstrap/js/bootstrap.js"></script>
<script src="public/jquery/jquery.min.js"></script>
<script src="public/jquery/jquery.js"></script>
<script src="public/bootstrap/js/bootstrap.min.js"></script>
<style type="text/css">
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
.a1{
background:#ff0000;
}
</style>
</head>
<body marginwidth="0" marginheight="0">
 <%ApplyS applys = new ApplyS();
 
 applys.getAllApply(request);
 %>
 <c:if test="${result >= 1}">
   <script>
     alert("${apply.applyId}" + "${msg}");
   </script>
 </c:if>
 <c:if test="${result < 1}">
   <script>
   alert("${apply.applyId}" + "${msg}");
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
				
 <table class="public-cont-table col-2">
 <!-- items是对应调用了Servlet对应方法中 保存到request中的集合对象的名称 -->
  <caption style="font-size:36px;padding-bottom:2%">管理员信息</caption>
  <tr style="background:rgb(222,222,222)">
  <td style="width:10%">赛事编号</td>
  <td style="width:10%">赛事名称</td>
  <td style="width:10%">报名开始</td>
  <td style="width:10%">报名截止</td>
  <td style="width:10%">赛事类型</td>
  <td style="width:10%">赛事状态</td>
   <td style="width:10%">赛事简介</td>
  <td style="width:10%">比赛地点</td>
  <td style="width:10%">赛事奖励</td>
  <td style="width:10%">联系方式</td>
  <td style="width:10%">备注</td>
  <td style="width:10%">发布人</td>
  <td colspan=2  style="width:10%">操作</td>
  </tr>
  <c:forEach items="${applys}" var="applys">
    <tr>	
 
      <td>${applys.applyId}</td>
      <td>${applys.applyName}</td>
      <td>${applys.applyTimestart}</td>
      <td>${applys.applyTimeend}</td>
      <td>${applys.applyType}</td>
      <td>${applys.applyState}</td>
      <td>${applys.applyInformation}</td>
      <td>${applys.applyAdress}</td>
      <td>${applys.applyWin}</td>
      <td>${applys.applyPhone}</td>
      <td>${applys.applyBeizhu}</td>
      <td>${applys.admId}</td>
      <div  class="table-fun">
      <td class="ac"><a href="admin/admin/updateInfo.jsp?suboption=nopage"> 修改</a></td>
      <td class="ac"><a href="admin/admin/deleteAdminInfo.jsp?suboption=nopage">删除</a></td>
      <div>
    </tr>
  </c:forEach>
   </table>

  <div style="margin-left:80%;margin-top:1%;">
  <paging:paging 
  href="admin/apply/list.jsp" 
  maxResults="${pageInfo.maxResults}" 
  firstResult="${pageInfo.firstResult}" 
  itemCount="${pageInfo.itemCount}"/>
  </div>

</div>
 </div>
</body>
</html>