<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="controller.UserS" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<link rel="apple-touch-icon" href="apple-touch-icon.png">
	<base href="<%=basePath%>"/>
	<link rel="stylesheet" type="text/css" href="home/public/css/common.css" media="all">
	<link rel="stylesheet" type="text/css" href="home/public/css/style.css" media="all">
	
	<title>校友帮-易签到</title>
	<meta name="description" content="签到，报名，互联网，会议，服务">

	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
	<meta content="yes" name="apple-mobile-web-app-capable">
	<meta content="black" name="apple-mobile-web-app-status-bar-style">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta content="telephone=no" name="format-detection">
	
	
</head>
<body>
  <%UserS users = new UserS(); 
 users.getbyId(request);
 %>

	<div class="wapdoc">
		<!-- 顶部logo + 搜索 -->
		<header class="hd">
			<h1 class="logo"><a href="index.html">91易签到</a></h1>
			<div class="search">
				<div class="search_text" id="search_text">
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
		<nav class="site region">
			<div class="nav"><a href="home/index.jsp"  class="cura" >首页</a>
			<i></i><a href="home/list.html">校赛</a>
			<i></i><a href="home/list.html">省赛</a>
			<i></i><a href="home/meet/indexmeet.jsp">会议</a>
			<i></i><a href="home/apply/myapply.jsp">比赛</a>
			<i></i><a href="home/user/indexuser.jsp">个人中心</a></div>   
		</nav>
		<!-- 分类 -->

		<section class="region">
		<form action="UserS" method="post">
 <p>请输入您的管理编号</p>
  <div>编号:<input type="text" name="wiId" class="formText" }></div>
     <div><input type="hidden" name="option" class="formText" value="getbyId">
     <input type="submit" class="formSubmit" value="getbyId">
     </div>
  
</form>
		
			<div class="mod_box">
				<div class="m_tit">
					<h2 class="long"><a href="#">我的信息</a></h2>
				
				</div>
				<div class="m_cont">
					<ul class="mc_text">	
					<c:forEach items="${users}" var="users">	
      				<li><a href="">${users.wiName}</a></li>
      				<li><a href="">${users.wiSex}</a></li>
      				<li><a href="">${users.wiName}</a></li>
      				<li><a href="">${users.wiGrade}</a></li>
      				<li><a href="">${users.wiPsd}</a></li>
      				<li><a href="">${users.wiAddress}</a></li>
      				<li><a href="">${users.wiPhone}</a></li>
      				<li><a href="">${users.wiBorthday}</a></li>
       				 </c:forEach>
				</ul>
				<h2  align="right"><a href="home/user/updateuser.jsp">点击修改</a></h2>
				</div>
			</div>
		</section>
	
		

		

	</div>	
	<!-- 分类 -->
	<!-- 导航栏 -->
	<nav class="site f_site region mTop">
		<div class="nav">
		<a href="#">首页</a><i></i>
		<a href="#">会议</a><i></i>
		<a href="#">报名</a><i></i>
		<a href="#">签到</a><i></i>
		<a href="#">排行</a><i></i>
		<a href="#">推荐</a></div>
	</nav>
	<!-- 导航栏 -->
	<!-- footer -->
	<footer class="ft region">
	<div class="version" style="width:184px;"><a href="#" class="curr">简版</a><i></i><a href="#">触屏版</a></div>
	<p class="record"><a href="#">关于2958.cn</a><i>|</i><a href="#">浏览记录</a></p>
	<p class="copyright">91校友帮 Copyright &copy; wap.91xiaoyoubang.com</p>
	<i class="reTop"><a href="javascript:scroll(0, 0);"><img src="images/ionc4.png" width="19" height="25" alt=""></a></i>	</footer>
	<!-- footer -->	
</body>
</html>