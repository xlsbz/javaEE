<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title></title>
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/public.css">
</head>
<body>
<div class="public-header-warrp">
	<div class="public-header">
		<div class="content">
			<div class="public-header-logo"><a href=""><i>LOGO</i><h3>校友帮</h3></a></div>
			<div class="public-header-admin fr">
				<p class="admin-name">管理员 您好！</p>
				<div class="public-header-fun fr">
					<a href="" class="public-header-man">管理</a>
					<a href="../index/login.html" class="public-header-loginout">安全退出</a>	
				</div>
			</div>
		</div>
	</div>
</div>
<div class="clearfix"></div>
<!-- 内容展示 -->
<div class="public-ifame mt20">
	<div class="content">
	<!-- 内容模块头 -->
		<div class="public-ifame-header">
			<ul>
				<li class="ifame-item logo">
					<div class="item-warrp">
						<a href="#"><i>LOGO</i>
							<h3 class="logo-title">校友帮</h3>
							<p class="logo-des">创建于 2017/4/22 22:22:47</p>
						</a>
					</div>
				</li>
				<li class="ifame-item"><div class="item-warrp"><span>注册时间：2017/11/21 21:14:01<br>VIP有效期：</span></div></li>
				<li class="ifame-item"><div class="item-warrp" style="border:none"><span>网站浏览量：15451</span></div></li>
				<div class="clearfix"></div>
			</ul>
		</div>
		<div class="clearfix"></div>
		<!-- 左侧导航栏 -->
		<div class="public-ifame-leftnav">
			<div class="public-title-warrp">
				<div class="public-ifame-title ">
					<a href="">首页</a>
				</div>
			</div>
			<ul class="left-nav-list">
			<!-- 后台管理 -->
				<li class="public-ifame-item">
					<a href="javascript:;">后台管理</a>
					<div class="ifame-item-sub">
						<ul>
							<li class="active"><a href="../system/config.html" target="content">网站配置</a></li>
							<li><a href="../system/admin_music.html" target="content">背景音乐管理</a></li>
							<li><a href="../system/admin_cardTemplate.html" target="content">名片模板管理</a></li>
							<li><a href="../system/index_tj.html" target="content">首页推荐导航</a></li>
						</ul>
					</div>
				</li>
			<!-- 前台管理 -->
				<li class="public-ifame-item">
					<a href="javascript:;">前台管理</a>
					<div class="ifame-item-sub">
						<ul>
							<li><a href="#" target="content">首页轮播图管理</a></li>
							<li><a href="#" target="content">登录页轮播图管理</a></li>
							<li><a href="#" target="content">注册轮播图管理</a></li>
						</ul>
					</div>
				</li>
			<!-- 管理员管理 -->
				<li class="public-ifame-item">
					<a href="javascript:;">管理员管理</a>
					<div class="ifame-item-sub">
						<ul>
							<li><a href="../admin/list.jsp" target="content">管理员信息</a></li>
							<li><a href="../admin/addAdminInfo.jsp" target="content">添加管理员信息</a></li>
							<li><a href="../admin/updateInfo.jsp" target="content">修改管理员信息</a></li>
							<li><a href="../admin/deleteAdminInfo.jsp" target="content">批量添加管理员</a></li>
							
						</ul>
					</div>
				</li>
			<!-- 用户管理 -->
				<li class="public-ifame-item">
					<a href="javascript:;">用户管理</a>
					<div class="ifame-item-sub">
						<ul>
						<li><a href="../user/worklist.jsp" target="content">用户信息（已认证）</a></li>
							<li><a href="../user/worklist.jsp" target="content">用户信息（未认证）</a></li>
							<li><a href="../user/addWorkerInfo.jsp" target="content">添加用户信息</a></li>
							<li><a href="../user/updatework.jsp" target="content">修改用户信息</a></li>
								<li><a href="../admin/updateInfo.jsp" target="content">删除用户信息</a></li>
							<li><a href="../admin/deleteAdminInfo.jsp" target="content">批量添加用户</a></li>
						</ul>
					</div>
				</li>
			<!-- 会议管理 -->
				<li class="public-ifame-item">
					<a href="javascript:;">会议管理</a>
					<div class="ifame-item-sub">
						<ul>
							<li><a href="../meet/meetlist.jsp" target="content">会议查看</a>|</li>
							<li><a href="../meet/addmeet.jsp" target="content">会议添加</a></li>
							<li><a href="../meet/meetupdate.jsp" target="content">会议修改</a></li>
							<li><a href="../meet/cate_manage.html" target="content">分类管理</a></li>
						</ul>
					</div>
				</li>
			<!-- 签到管理 -->
				<li class="public-ifame-item">
					<a href="javascript:;">签到管理</a>
					<div class="ifame-item-sub">
						<ul>
							<li><a href="../sign/signlist.jsp" target="content">查看签到列表</a></li>
							<li><a href="../sign/signadd.jsp" target="content">添加签到列表</a></li>
							<li><a href="../sign/signupdate.jsp" target="content">修改签到列表</a></li>
							<li><a href="../sign/signdelete.jsp" target="content">删除签到列表</a></li>
							
						</ul>
					</div>
				</li>
			<!-- 报名管理 -->
				<li class="public-ifame-item">
					<a href="javascript:;">报名管理</a>
					<div class="ifame-item-sub">
						<ul>
							<li><a href="../apply/listApply.jsp" target="content">报名信息</a></li>
							<li><a href="../apply/addApply.jsp" target="content">添加赛事</a></li>
							<li><a href="../apply/updateApply.jsp" target="content">修改赛事</a></li>
							<li><a href="../apply/deleteApply.jsp" target="content">取消赛事</a></li>
							<li><a href="#" target="content">统计分析</a></li>
						</ul>
					</div>
				</li>
			<!-- 信息查看-->
				<li class="public-ifame-item">
					<a href="javascript:;">信息查看</a>
					<div class="ifame-item-sub">
						<ul>
							<li><a href="../userinformation/listuserinformation.jsp" target="content">查看已报名</a></li>
							<li><a href="../userinformation/listusersign.jsp" target="content">查看已签到</a></li>
							<li><a href="../admin/check.jsp" target="content">统计报名</a></li>
							<li><a href="../apply/deleteApply.jsp" target="content">统计签到</a></li>
							<li><a href="#" target="content">统计分析</a></li>
						</ul>
					</div>
				</li>
				
				

			<!-- 帮助管理 -->
				<li class="public-ifame-item">
					<a href="javascript:;">帮助管理</a>
					<div class="ifame-item-sub">
						<ul>
							<li><a href="#" target="content">管理员帮助</a></li>
							<li><a href="#" target="content">用户管理</a></li>
							<li><a href="#" target="content">关于我们</a></li>
						</ul>
					</div>
				</li>
			</ul>
		</div>
		<!-- 右侧内容展示部分 -->
		<div class="public-ifame-content">
		<iframe name="content" src="main.html" frameborder="0" id="mainframe" scrolling="yes" marginheight="0" marginwidth="0" width="100%" style="height:500px;"></iframe>
		</div>
	</div>
</div>
<script src="js/jquery.min.js"></script>
<script>
$().ready(function(){
	var item = $(".public-ifame-item");

	for(var i=0; i < item.length; i++){
		$(item[i]).on('click',function(){
			$(".ifame-item-sub").hide();
			if($(this.lastElementChild).css('display') == 'block'){
				$(this.lastElementChild).hide()
				$(".ifame-item-sub li").removeClass("active");
			}else{
				$(this.lastElementChild).show();
				$(".ifame-item-sub li").on('click',function(){
					$(".ifame-item-sub li").removeClass("active");
					$(this).addClass("active");
				});
			}
		});
	}
});
</script>
</body>
</html>