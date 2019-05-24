<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>商品结果</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
	</head>

	<body>
		<div class="container">
			<!-- 头部 -->
			<%@include file="/jsp/header.jsp" %>
				<div class="container-fluid">
					<c:forEach items="${sList }" var="sl">
						<div class="col-md-2">
							<a href="${pageContext.request.contextPath }/product?method=getProductById&pid=${sl.pid}">
								<img src="${pageContext.request.contextPath}/${sl.pimage}" width="170" height="170" style="display: inline-block;">
							</a>
							<p><a href="${pageContext.request.contextPath }/product?method=getProductById&pid=${sl.pid}" style='color:green'>${fn:substring(sl.pname,0,10) }..</a></p>
							<p><font color="#FF0000">商城价：&yen;${sl.shop_price }</font></p>
						</div>
					</c:forEach>
				</div>
			<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>

</html>