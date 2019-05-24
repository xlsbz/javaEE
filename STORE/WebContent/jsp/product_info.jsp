<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${productBean.pname }</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
	type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" type="text/css" />
</head>

<body>
	<div class="container">
		<%@include file="/jsp/header.jsp"%>
		<div class="container">
			<div class="row">
				<div
					style="border: 1px solid #e4e4e4; width: 930px; margin-bottom: 10px; margin: 0 auto; padding: 10px; margin-bottom: 10px;">
					<a href="./index.htm">首页&nbsp;&nbsp;&gt;</a> <a href="./蔬菜分类.htm">蔬菜&nbsp;&nbsp;&gt;</a>
					<a>无公害蔬菜</a>
				</div>

				<div style="margin: 0 auto; width: 950px;">
					<div class="col-md-6">
						<img style="opacity: 1; width: 400px; height: 350px;" title=""
							class="medium"
							src="${pageContext.request.contextPath}/${productBean.pimage}">
					</div>
					<div class="col-md-6">
						<div>
							<strong>${productBean.pname }</strong>
						</div>
						<div style="border-bottom: 1px dotted #dddddd; width: 350px; margin: 10px 0 10px 0;">
							<div>编号：${productBean.pid }</div>
						</div>
						<div style="margin: 10px 0 10px 0;">
							商城价: <strong style="color: #ef0101;">￥：${productBean.shop_price }元</strong>
							市场 价：
							<del>￥${productBean.market_price }元</del>
						</div>
						<div style="margin: 10px 0 10px 0;">
							促销: <a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)"	style="background-color: #f07373;">限时抢购</a>
						</div>
						<div style="padding: 10px; border: 1px solid #e7dbb1; width: 330px; margin: 15px 0 10px 0;; background-color: #fffee6;">
							<div style="margin: 5px 0 10px 0;">白色</div>
							<form action="${pageContext.request.contextPath}/cart" id="formcart" method="get">
								<input type="hidden" name="method" value="add2Cart">
								<input type="hidden" name="pid" value="${productBean.pid }">
								<div style="border-bottom: 1px solid #faeac7; margin-top: 20px; padding-left: 10px;">
									购买数量: <input id="quantity" name="count" value="1"
										maxlength="4" size="10" type="text">
								</div>
								<div style="margin: 20px 0 10px 0;; text-align: center;">
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
				<div class="clear"></div>
				<div style="width: 950px; margin: 0 auto;">
					<div
						style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
						<strong>商品介绍</strong>
					</div>

					<div>
						<img src="${pageContext.request.contextPath}/${productBean.pimage}">
					</div>

					<div
						style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
						<strong>${productBean.pdesc }</strong>
					</div>
				</div>
			</div>
			
			<!-- 最近浏览 -->
			<div style="width:1210px;margin:0 auto; padding: 0 9px;border-top: 2px solid #999;height: auto;">
				<h4 style="width: 50%;float: left;font: 14px/30px " 微软雅黑 ";">浏览记录</h4>
				<div style="width: 50%;float: right;text-align: right;"><a href="">more</a></div>
				<div style="clear: both;"></div>
				<c:forEach items="${proList }" var="pl">
					<div class="col-md-2">
						<a href="${pageContext.request.contextPath }/product?method=getProductById&pid=${pl.pid}">
							<img src="${pageContext.request.contextPath}/${pl.pimage}" width="170" height="170" style="display: inline-block;">
						</a>
						<p><a href="${pageContext.request.contextPath }/product?method=getProductById&pid=${pl.pid}" style='color:green'>${fn:substring(pl.pname,0,10) }..</a></p>
						<p><font color="#FF0000">商城价：&yen;${pl.shop_price }</font></p>
					</div>
				</c:forEach>
			</div>
			
			<!-- 脚注 -->
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
</body>
<script type="text/javascript">
function subForm(){
	document.getElementById("formcart").submit();
}
</script>
</html>