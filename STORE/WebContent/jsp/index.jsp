<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>乐淘——首页</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
	</head>
	
	<body >
		<div class="container">
			<!-- 头部 -->
			<%@ include file="/jsp/header.jsp" %>
			<!--
 				轮播
            -->
			<div class="container-fluid">
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="${pageContext.request.contextPath}/img/1.jpg">
							<div class="carousel-caption">
							</div>
						</div>
						<div class="item">
							<img src="${pageContext.request.contextPath}/img/2.jpg">
							<div class="carousel-caption">
							</div>
						</div>
						<div class="item">
							<img src="${pageContext.request.contextPath}/img/3.jpg">
							<div class="carousel-caption">
							</div>
						</div>
					</div>

					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<!--
            	描述：商品显示
            -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>热门商品&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/img/title2.jpg"/></h2>
				</div>
				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
					<img src="${pageContext.request.contextPath}/products/hao/big01.jpg" width="205" height="404" style="display: inline-block;" class="img-thumbnail"/>
				</div>
				<div class="col-md-10">
					<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
						<a href="product_info.htm">
							<img src="${pageContext.request.contextPath}/products/hao/middle01.jpg" width="400px" height="200px" style="display: inline-block;" >
						</a>
					</div>
				<c:forEach items="${hList }" var="hot">
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product?method=getProductById&pid=${hot.pid }">
							<img src="${pageContext.request.contextPath}/${hot.pimage}" width="130" height="130" style="display: inline-block;" class="img-thumbnail">
						</a>
						<p><a href="product?method=getProductById&pid=${hot.pid }" style='color:#666'>${fn:substring(hot.pname,0,10) }...</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;${hot.shop_price }</font></p>
					</div>
				</c:forEach>
				</div>
			</div>
			<!--
            	描述：广告部分
            -->
            <div class="container-fluid">
				<img src="${pageContext.request.contextPath}/products/hao/ad.jpg" width="100%"/>
			</div>
			<!--
            	描述：商品显示最新
            -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>最新商品&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/img/title2.jpg"/></h2>
				</div>
				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
					<img src="${pageContext.request.contextPath}/products/hao/big01.jpg" width="205" height="600" style="display: inline-block;"/>
				</div>
				<div class="col-md-10">
					<c:forEach items="${nList }" var="isnew">
						<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
							<a href="product?method=getProductById&pid=${isnew.pid }">
								<img src="${pageContext.request.contextPath}/${isnew.pimage}" width="130" height="130" style="display: inline-block;">
							</a>
							<p><a href="product?method=getProductById&pid=${isnew.pid }" style='color:#666'>${fn:substring(isnew.pname,0,10) }...</a></p>
							<p><font color="#E4393C" style="font-size:16px">&yen;${isnew.shop_price }</font></p>
						</div>
					</c:forEach>
					<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
							<a href="product_info.htm">
								<img src="${pageContext.request.contextPath}/products/hao/middle01.jpg" width="400px" height="200px" style="display: inline-block;">
							</a>
					</div>
				</div>
			</div>	
			<!-- 商品展示：猜你喜欢 -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>猜你喜欢&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/img/title2.jpg"/></h2>
				</div>
				<c:forEach items="${lList }" var="like">
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product?method=getProductById&pid=${like.pid }">
							<img src="${pageContext.request.contextPath}/${like.pimage}" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product?method=getProductById&pid=${like.pid }" style='color:#666'>${like.pname }</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;${like.shop_price }</font></p>
					</div>
				</c:forEach>
			</div>
			<!-- 页脚 -->
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</body>
</html>