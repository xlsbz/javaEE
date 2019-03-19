<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		.active{
			backgound:blue;
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
			<h1>我的订单<span></span></h1>
			<!-- 订单列表-->
			<div class="container">
			<div class="row">
				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<strong>我的订单</strong>
					<table class="table table-bordered">
					<c:forEach items="${pageBean.data }" var="pb">
						<tbody>
							<tr class="success">
								<th colspan="2">订单编号:${pb.oid }</th>
								<th colspan="1">订单状态
									<c:if test="${pb.state==0 }">
										<a href="${pageContext.request.contextPath }/order?method=gotoOrder&oid=${pb.oid}">去付款</a>
									</c:if>
									<c:if test="${pb.state==1 }">待发货</c:if>
									<c:if test="${pb.state==2 }">
										<a href="${pageContext.request.contextPath }/order?method=sureOrder&oid=${pb.oid}">确认收货</a>
									</c:if>
									<c:if test="${pb.state==3 }">已完成</c:if>
								</th>
								<th colspan="1">订单金额:${pb.total }</th>
								<c:if test="${pb.state==0 }">
									<th colspan="1"><a href="${pageContext.request.contextPath }/order?method=deleteOrder&oid=${pb.oid}">取消订单</a></th>								
								</c:if>
								<c:if test="${pb.state==1 }">
									<th colspan="1">配货中...退款</th>								
								</c:if>
								<c:if test="${pb.state==2 }">
									<th colspan="1">发货中...不能取消</th>								
								</c:if>
								<c:if test="${pb.state==3 }">
									<th colspan="1">售后服务</th>								
								</c:if>
							</tr>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
							</tr>
							<!-- 遍历订单 -->
							<c:forEach items="${pb.orderItems}" var="pi">
								<tr class="active">
									<td width="60" width="50%">
										<input type="hidden" name="id" value="22">
										<img src="${pageContext.request.contextPath}/${pi.product.image}" width="70" height="60">
									</td>
									<td width="20%">
										<a target="_blank"> ${pi.product.bname }</a>
									</td>
									<td width="20%">
										${pi.product.price }
									</td>
									<td width="15%">
										${pi.ordercount }
									</td>
									<td width="15%">
										<span class="subtotal">${pi.subtotal }</span>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</c:forEach>
					</table>
				</div>
			</div>
			<!-- 分页 -->
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
									<a href="${pageContext.request.contextPath }/order?method=pageOrderlist&pageNumber=${pageBean.pageNumber-1}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
								</li>
							</c:if>
							
							<!-- 计算begin，end -->
								<c:choose>
									<%--页面不足7页--%>
									<c:when test="${pageBean.pageNumberTotal<=7 }">
										<c:set var="begin" value="1"></c:set>
										<c:set var="end" value="${pageBean.pageNumberTotal }"></c:set>
									</c:when>
									
									<%-- 页面足够7页，计算公式 ->保证当前页的位置在第四个   。。。当前页。。。  begin=当前页-3；end=当前页+3--%>
									<c:otherwise>
										<c:set var="begin" value="${pageBean.pageNumber-3 }"></c:set>
										<c:set var="end" value="${pageBean.pageNumber+3 }"></c:set>
										<%-- 如果头溢出，不足三页 --%>
										<c:if test="${begin<1 }">
											<c:set var="begin" value="1"></c:set>
											<c:set var="end" value="7"></c:set>
										</c:if>
										<%-- 尾溢出，已经是最后一页 --%>
										<c:if test="${end>pageBean.pageNumberTotal }">
											<c:set var="begin" value="${pageBean.pageNumberTotal-6 }"></c:set>
											<c:set var="end" value="${pageBean.pageNumberTotal }"></c:set>
										</c:if>
									</c:otherwise>
								</c:choose>
							<!-- 遍历中间页 -->
							<c:forEach begin="${begin }" end="${end }" var="n">
								<!-- 判断是否是当前页 -->
								<c:if test="${pageBean.pageNumber == n }">
									<li class="active"><a href="javascript:void(0)">${n }</a></li>
								</c:if>
								<c:if test="${pageBean.pageNumber != n }">
									<li><a href="${pageContext.request.contextPath }/order?method=pageOrderlist&pageNumber=${n}">${n }</a></li>
								</c:if>
							</c:forEach>
							<!-- 判断是否是最后一页 -->
							<c:if test="${pageBean.pageNumber==pageBean.pageNumberTotal }">
								<li class="disabled">
									<a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
								</li>
							</c:if>
							<c:if test="${pageBean.pageNumber!=pageBean.pageNumberTotal }">
								<li class="">
									<a href="${pageContext.request.contextPath }/order?method=pageOrderlist&pageNumber=${pageBean.pageNumber+1}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
								</li>
							</c:if>
						</ul>
					</nav>
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