<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="controller.ApplyS"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../public/css/common.css" media="all">
	<link rel="stylesheet" type="text/css" href="../public/css/style.css" media="all">
	<base href="<%=basePath%>"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
	<meta content="yes" name="apple-mobile-web-app-capable">
	<meta content="black" name="apple-mobile-web-app-status-bar-style">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta content="telephone=no" name="format-detection">
<title>赛事详情</title>
</head>
<body>
  <%ApplyS apply = new ApplyS();
 apply.getApplyByID(request);
 %>
<div class="wapdoc">
	<!-- 顶部logo + 搜索 -->
	<header class="hd">
		<h1 class="logo"><a href="index.html">赛事详情</a></h1>
		<div class="search">
			<div class="search_text">
				<form action="#" method="get" name="wapSearchForm">
				<input type="search" value="" name="keyword">
				<input type=hidden name=sid value="1">
				<input type=hidden name=para value="&amp;Sid=1&amp;uuid=06dcHVMymR5JFBOoGl1lAgE=">
				</form>
			</div>
		</div>
	</header>
	<!-- 顶部logo + 搜索 -->
	<!-- 顶部导航栏 -->
	<!-- 顶部导航栏 -->
	<nav class="site region">
			<div class="nav"><a href="home/index.jsp"  class="cura" >首页</a>
			<i></i><a href="home/list.html">校赛</a>
			<i></i><a href="home/list.html">省赛</a>
			<i></i><a href="home/meet/indexmeet.jsp">会议</a>
			<i></i><a href="home/apply/myapply.jsp">比赛</a>
			<i></i><a href="home/user/indexuser.jsp">个人中心</a></div>   
		</nav>

	<!-- 顶部导航栏 -->
    <div class="content">
        <section class="region">
            <div class="cPic"><img src="../public/images/20140324151114_2.jpg" width="283" height="175" alt=""></div>
            <h2 class="cTit">
            <items="${applyId}" var="applyId">	
			<dd>${applyId.applyName}</dd>
			</items>
			</h2>
            <ul class="cUl">
                <li class="oRa">投资额度：<b>5千以下</b></li>
                <li>公司名称：<b>广州启泰企业管理有限公司</b></li>
            </ul>
        </section>
        <!-- 文字内容区域 -->
        <div class="round2">
            <div class="rTit"><h2>赛事简介</h2><span class="zxIcon"><a href="#guestbook">咨询</a></span></div>
           <div class="text indent">
             <items="${applyId}" var="applyId">	
			<dd>${applyId.applyInformation}</dd>
			</items>
           </div>
        </div>
        <div class="round2">
            <div class="rTit"><h2>赛事奖项</h2><span class="zxIcon"><a href="#guestbook">咨询</a></span></div>
           <div class="text">
            <items="${applyId}" var="applyId">	
			<dd>${applyId.applyAdress}</dd>
			</items>
           </div>
        </div>
        <div class="round2">
            <div class="rTit"><h2>备注说明</h2><span class="zxIcon"><a href="#guestbook">咨询</a></span></div>
           <div class="text">
           <items="${applyId}" var="applyId">	
			<dd>${applyId.applyBeizhu}</dd></br>
			</items>
           </div>
        </div>
        
            <div class="round2">
                
              
               <div class="msg mT16">
				
                    <p class="button"><a href="home/apply/addapply.jsp"><input name="" type="submit" value="点击报名"></a></p>
					
               </div>
            </div>
         
            
    </div>
	<!-- footer -->
</div>


</body>
</html>