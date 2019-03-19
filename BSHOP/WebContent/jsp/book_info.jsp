<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/swiper3.07.min.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/myfocus-2.0.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	
	<style>
		.swiper-container {
			width: 1200px;
			height: 500px;
			margin: 0 auto;
		}
		.swiper-wrapper{
			margin-left:40px;
		}
		.findPageNumber{
			margin-left: 40%;
		}
	</style>
	<script type="text/javascript">
		function subForm(){
			document.getElementById("formcart").submit();
		}
	</script>
		<title>书淘——首页</title>
</head>
<body>
<!-- 顶部 通栏-->
<%@ include file="/jsp/header.jsp" %>

<div class="mian container">
	<!-- 书籍区 -->
		<div class="jiaocai clearfix" id="item2">
			<h1>商品详情<span></span></h1>
			<!-- 展示商品详情 -->
			<div class="swiper-container">
				<div class="swiper-wrapper">
					<div class="row">
						<div
							style="border: 1px solid #e4e4e4; width: 930px; margin-bottom: 10px; margin: 0 auto; padding: 10px; margin-bottom: 10px;">
							<a href="${pageContext.request.contextPath }">首页&nbsp;&nbsp;&gt;</a> <a href="#">书籍&nbsp;&nbsp;&gt;</a>
							<a>教材书籍</a>
						</div>

						<div style="margin: 0 auto; width: 950px;">
							<div class="col-md-6">
								<img style="opacity: 1; width: 400px; height: 350px;" title=""
									class="medium"
									src="${pageContext.request.contextPath}/${product.image}">
							</div>
							<div class="col-md-6">
								<div>
									<strong>${product.bname }</strong>
								</div>
								<div style="border-bottom: 1px dotted #dddddd; width: 350px; margin: 10px 0 10px 0;">
									<div>编号：${product.bid }</div>
								</div>
								<div style="margin: 10px 0 10px 0;">
									商城价: <strong style="color: #ef0101;">￥：${product.price }元</strong>
									市场 价：
									<del>￥${product.price_old }元</del>
								</div>
								<div style="margin: 10px 0 10px 0;">
									作者: <strong style="color: #ef0101;">￥：${product.author }</strong>
								</div>
								<div style="margin: 10px 0 10px 0;">
									促销: <a target="_blank" title="限时抢购 (2018-07-30 ~ 2018-11-01)"	style="background-color: #f07373;">限时抢购</a>
								</div>
								<div style="padding: 10px; border: 1px solid #e7dbb1; width: 330px; margin: 15px 0 10px 0;; background-color: #fffee6;">
									<div style="margin: 5px 0 10px 0;">剩余库存:<strong>${product.count }</strong></div>
									<form action="${pageContext.request.contextPath}/cart" id="formcart" method="get">
										<input type="hidden" name="method" value="add2Cart">
										<input type="hidden" name="bid" value="${product.bid }">
										<div style="border-bottom: 1px solid #faeac7; margin-top: 20px; padding-left: 10px;">
											购买数量: <input id="quantity" name="count" value="1"
												maxlength="4" size="10" type="text">
										</div>
									</form>
											<a href="javascript:void(0)" onclick="subForm()">
												<input type="button" value="加入购物车">
											</a>
											<span class="glyphicon glyphicon-shopping-cart"></span>
											&nbsp;&nbsp;&nbsp;&nbsp;收藏商品
										</div>
									</div>
								</div>
							</div>
				</div>
			</div>
		</div>
</div>
<div class="foot">
	<div class="container">

		<div class="zhinan">
			<ul class="clearfix">
				<li class="item-li">购书指南
					<ul>
						<li><a href="#">支付宝担保安全！</a></li>
						<li><a href="#">如何退换货呢？</a></li>
						<li><a href="#">会员有哪些优惠？</a></li>
						<li><a href="#">多长时间可以送达？</a></li>
					</ul>
				</li>
				<li class="item-li">配送与支持
					<ul>
						<li><a href="#">我们的配送方式。</a></li>
						<li><a href="#">配送费说明</a></li>
						<li><a href="#">我们的配送范围。</a></li>
						<li><a href="#">发货方式有哪些？</a></li>
					</ul>
				</li>
				<li class="item-li">支付方式
					<ul>
						<li><a href="#">支付方式有哪些？</a></li>
						<li><a href="#">购书如何支付</a></li>
						<li><a href="#">支付步骤</a></li>
					</ul>
				</li>
				<li class="item-li">售后服务
					<ul>
						<li><a href="#">退换货注意事项</a></li>
						<li><a href="#">不退换货说明</a></li>
						<li><a href="#">售后服务流程</a></li>
					</ul>
				</li>
				<li class="item-li" style="margin: 0">帮助信息
					<ul>
						<li><a href="#">二手书说明</a></li>
						<li><a href="#">隐私安全</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<div class="line"></div>

		<div class="bottom">
			<p>友情链接：<a href="#">安工在线</a>&nbsp;&nbsp;<a href="#">万林强-前端在线简历</a></p>
			<p>本站所有信息均为用户自由发布，本站不对信息的真实性负任何责任，交易时请注意识别信息的真假如有网站内容侵害了您的权益请联系我们删除，举报电话：15068718875</p>
			<p>技术支持：万林强 &nbsp;&nbsp;商务QQ:584845663 &nbsp;&nbsp;邮箱：584845663@qq.com</p>
		</div>
	</div>
</div>
<div class="fixnav">
	<ul>
		<li><a href="#" title="4">返回顶部</a></li>
	</ul>
</div>
</body>

</html>