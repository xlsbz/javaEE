<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
	
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>乐淘——分类页</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
	<div class="container">
			<!-- 头部 -->
			<%@ include file="/jsp/header.jsp" %>
			<!-- 主体 -->
			<c:forEach items="${pagebean.data }" var="pb">
					<div class="col-md-2">
						<a href="${pageContext.request.contextPath }/product?method=getProductById&pid=${pb.pid}">
							<img src="${pageContext.request.contextPath}/${pb.pimage}" width="170" height="170" style="display: inline-block;">
						</a>
						<p><a href="${pageContext.request.contextPath }/product?method=getProductById&pid=${pb.pid}" style='color:green'>${fn:substring(pb.pname,0,10) }..</a></p>
						<p><font color="#FF0000">商城价：&yen;${pb.shop_price }</font></p>
					</div>
			</c:forEach>
	</div>
			<!-- 分页 -->
	<div class="container">
		<div style="position:relative;margin-left: 450px;">
			<nav aria-label="Page navigation">	
				 <ul class="pagination">
				<!-- 判断是第一页 -->
				<c:if test="${pagebean.pageNumber == 1 }">
					<li class="disabled">
						<a href="javascript:void(0)" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
				</c:if>
				
				<!-- 不是第一页 -->
				<c:if test="${pagebean.pageNumber != 1 }">
					<li>
						<a href="${pageContext.request.contextPath }/product?method=findByPage&pageNumber=${pagebean.pageNumber-1}&cid=${param.cid}" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
				</c:if>
				
				<!-- 展示所有页码 -->
				<c:forEach begin="1" end="${pagebean.totalPage }" var = "tp">
					<!-- 判断是否是当前页 -->
					<c:if test="${pagebean.pageNumber == tp }">
						<li class="active"><a href="javascript:void(0)">${tp }</a></li>
					</c:if>
					<c:if test="${pagebean.pageNumber != tp }">
						<li><a href="${pageContext.request.contextPath }/product?method=findByPage&cid=${param.cid}&pageNumber=${tp}">${tp }</a></li>
					</c:if>
				</c:forEach>
				
				<!-- 判断是最后一页 -->
				<c:if test="${pagebean.pageNumber == pagebean.totalPage }">
					<li class="disabled">
						<a href="javascript:void(0)" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>
				<!-- 判断不是最后一页 -->
				<c:if test="${pagebean.pageNumber != pagebean.totalPage}">
					<li>
						<a href="${pageContext.request.contextPath }/product?method=findByPage&cid=${param.cid}&pageNumber=${pagebean.pageNumber+1}" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>
			</ul>
		</nav>
	</div>
			<!-- 页脚 -->
			<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>