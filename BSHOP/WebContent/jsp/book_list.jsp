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
		<title>书淘——首页</title>
</head>
<body>
<!-- 顶部 通栏-->
<%@ include file="/jsp/header.jsp" %>

<div class="mian container">
	<!-- 书籍区 -->
		<div class="jiaocai clearfix" id="item2">
			<h1>工具书区<span></span></h1>
	
			<div class="swiper-container">
				<div class="swiper-wrapper">
					<div class="swiper-slide">
						<c:forEach items="${pageBean.data }" var="pg">
							<dl>
								<dt><a href="${pageContext.request.contextPath }/product?method=productInfo&bid=${pg.bid}"><img src="${pageContext.request.contextPath }/${pg.image}" alt=""/></a></dt>
								<dd>
									<p><a href="${pageContext.request.contextPath }/product?method=productInfo&bid=${p.bid}">${pg.bname}</a></p>
									<p>数量：${pg.count }</p>
									<p><s>价格：￥${pg.price_old }</s> ￥${pg.price }</p>
								</dd>
							</dl>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<div class="findPageNumber">
			<nav aria-label="Page navigation">
				<ul class="pagination">
					<!-- 判断是否是第一页 -->
					<c:if test="${pageBean.pageNumber==1 }">
						<li class="disabled">
							<a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
						</li>
					</c:if>
					<c:if test="${pageBean.pageNumber!=1 }">
						<li class="">
							<a href="${pageContext.request.contextPath }/product?method=findPageNumber&pageNumber=${pageBean.pageNumber-1}&cid=${param.cid}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
						</li>
					</c:if>
					<!-- 遍历中间页 -->
					
					<c:forEach begin="1" end="${pageBean.pageNumberTotal }" var="n">
						<li>
							<a href="${pageContext.request.contextPath }/product?method=findPageNumber&pageNumber=${n}&cid=${param.cid}">${n}</a>
						</li>
					</c:forEach>
					<!-- 判断是否是最后一页 -->
					<c:if test="${pageBean.pageNumber==pageBean.pageNumberTotal }">
						<li class="disabled">
							<a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
						</li>
					</c:if>
					<c:if test="${pageBean.pageNumber!=pageBean.pageNumberTotal }">
						<li class="">
							<a href="${pageContext.request.contextPath }/product?method=findPageNumber&pageNumber=${pageBean.pageNumber+1}&cid=${param.cid}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
						</li>
					</c:if>
				</ul>
			</nav>
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