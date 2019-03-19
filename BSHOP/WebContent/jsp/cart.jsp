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
		<title>购物车</title>
</head>
<body>
<!-- 顶部 通栏-->
<%@ include file="/jsp/header.jsp" %>

<div class="mian container">
		<div class="jiaocai clearfix" id="item2">
			<h1>我的购物车<span></span></h1>
			<div class="container">
		        <div class="row">
		            <div style="margin: 0 auto; margin-top: 10px; width: 950px;">
		                <strong style="font-size: 16px; margin: 5px 0;">订单详情</strong>
		                <c:if test="${empty cart.cartItems }">
		                    <h3>购物车什么也没有，先去逛逛吧！</h3>
		                </c:if>
		                <c:if test="${not empty cart.cartItems }">
		                    <table class="table table-bordered">
		                        <tbody>
		                        <tr class="warning">
		                            <th>图片</th>
		                            <th>商品</th>
		                            <th>价格</th>
		                            <th>数量</th>
		                            <th>小计</th>
		                            <th>操作</th>
		                        </tr>
		                        <c:forEach items="${cart.cartItems }" var="ci">
		                            <tr class="active">
		                                <td width="60" width="40%">
		                                    <img src="${pageContext.request.contextPath}/${ci.product.image }"
		                                         width="70" height="60"></td>
		                                <td width="30%"><a target="_blank"> ${ci.product.bname }</a></td>
		                                <td width="20%">${ci.product.price }</td>
		                                <td width="10%"><input readonly="readonly" type="text" name="quanity"
		                                                       value="${ci.count }"
		                                                       maxlength="4" size="10"></td>
		                                <td width="15%"><span class="subtotal">${ci.subTotal }</span></td>
		                                <td><a href="javascript:void(0);" onclick="removeCart('${ci.product.bid}')" class="delete">删除</a></td>
		                            </tr>
		                        </c:forEach>
		                        </tbody>
		                    </table>
		                </c:if>
		            </div>
		        </div>
		
		        <div style="margin-right: 130px;">
		            <div style="text-align: right;">
		                <em style="color: #ff6600;"> 登录后确认是否享有优惠&nbsp;&nbsp; </em> 赠送积分: <em
		                    style="color: #ff6600;">666</em>&nbsp; 商品金额: <strong
		                    style="color: #ff6600;">${cart.total }</strong>
		            </div>
		            <div
		                    style="text-align: right; margin-top: 10px; margin-bottom: 10px;">
		                <a href="${pageContext.request.contextPath }/cart?method=clear2Cart" id="clear" class="clear">清空购物车</a>
		                <a href="${pageContext.request.contextPath }/order?method=saveOrder"> <input type="submit" width="100"
		                                                                                             value="提交订单" name="submit"
		                                                                                             style="background: url('${pageContext.request.contextPath}/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
								height:35px;width:100px;color:white;">
		                </a>
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
<script type="text/javascript">
	function removeCart(bid){
		if(confirm("确定要删除我吗?")){
			location.href="${pageContext.request.contextPath}/cart?method=delete2Cart&bid="+bid;
		}
	}
</script>
</html>