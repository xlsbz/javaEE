<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>会员登录</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" />
		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
			}
			
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
		</style>
	</head>
<body>
<div class="container">
		<!-- 头部 -->
		<%@ include file="header.jsp" %>
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
									<th colspan="1">配货中...退货</th>								
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
							<c:forEach items="${pb.items}" var="pi">
								<tr class="active">
									<td width="60" width="50%">
										<input type="hidden" name="id" value="22">
										<img src="${pageContext.request.contextPath}/${pi.product.pimage}" width="70" height="60">
									</td>
									<td width="20%">
										<a target="_blank"> ${pi.product.pname }</a>
									</td>
									<td width="20%">
										${pi.product.shop_price }
									</td>
									<td width="15%">
										${pi.count }
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
				
			<div style="text-align: center;">
				<ul class="pagination">
					<!-- 判断是否为第一页 -->
						<c:if test="${pageBean.pageNumber==1 }">
							<li class="disabled">
								<a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
							</li>
						</c:if>
						<c:if test="${pageBean.pageNumber!=1 }">
							<li class="">
								<a href="${pageContext.request.contextPath }/order?method=findOrderByPage&pageNumber=${pageBean.pageNumber-1}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
							</li>
						</c:if>
					<c:forEach begin="1" end="${pageBean.totalPage }" var="n">
						<c:if test="${pageBean.pageNumber==n}">
							<li class="active"><a href="${pageContext.request.contextPath }/order?method=findOrderByPage&pageNumber=${n}">${n }</a></li>
						</c:if>
						<c:if test="${pageBean.pageNumber!=n}">
							<li><a href="${pageContext.request.contextPath }/order?method=findOrderByPage&pageNumber=${n}">${n }</a></li>
						</c:if>
					</c:forEach>
					<!-- 判断是否为最后一页 -->
						<c:if test="${pageBean.pageNumber==pageBean.totalPage }">
							<li class="disabled">
								<a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
							</li>
						</c:if>
						<c:if test="${pageBean.pageNumber!=pageBean.totalPage }">
							<li class="">
								<a href="${pageContext.request.contextPath }/order?method=findOrderByPage&pageNumber=${pageBean.pageNumber+1}" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
								</a>
							</li>
						</c:if>
				</ul>
			</div>
		</div>
		<!-- footer -->
		<jsp:include page="footer.jsp"></jsp:include>
	</div>		
</body>
</html>