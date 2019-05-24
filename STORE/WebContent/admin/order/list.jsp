<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>订单列表</strong>
						</TD>
					</tr>
					
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="10%">
										序号
									</td>
									<td align="center" width="10%">
										订单编号
									</td>
									<td align="center" width="10%">
										订单金额
									</td>
									<td align="center" width="10%">
										收货人
									</td>
									<td align="center" width="10%">
										订单状态
									</td>
									<td align="center" width="50%">
										订单详情
									</td>
								</tr>
									<c:forEach items="${pageBean.data }" var="pd" varStatus="vs">
										<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">
												${vs.count }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${pd.oid }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${pd.total }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${pd.name }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<c:if test="${pd.state==0 }">未付款</c:if>
												<c:if test="${pd.state==1 }">
													<a href="${pageContext.request.contextPath }/adminorder?method=updateState&oid=${pd.oid}">去发货</a>
												</c:if>
												<c:if test="${pd.state==2 }">待收货</c:if>
												<c:if test="${pd.state==3 }">已完成</c:if>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<input type="button" value="订单详情" onclick="showOrder('${pd.oid}')"/>
											</td>
										</tr>
									</c:forEach>
							</table>
						</td>
					</tr>
							<!-- 分页 -->
						<h1><font color="red">${msg }</font></h1>
						<div style="text-align: center;">
							<ul class="pagination">
								<!-- 判断是否为第一页 -->
									<c:if test="${pageBean.pageNumber==1 }">
										<li class="disabled">
											<a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
										</li>
									</c:if>
									
									<c:forEach items="${pageBean.data }" var="pb">
										<c:if test="${pageBean.pageNumber!=1 }">
											<li class="">
												<a href="${pageContext.request.contextPath }/adminorder?method=findAllOrder&state=${pb.state }&pageNumber=${pageBean.pageNumber-1}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
											</li>
										</c:if>
									</c:forEach>
									<c:forEach begin="1" end="${pageBean.totalPage }" var="n">
										<c:if test="${pageBean.pageNumber==n}">
											<li class="active"><a href="#">${n }</a></li>
										</c:if>
										<c:if test="${pageBean.pageNumber!=n}">
											<li><a href="#">${n }</a></li>
										</c:if>
									</c:forEach>
									
								<!-- 判断是否为最后一页 -->
									<c:if test="${pageBean.pageNumber==pageBean.totalPage }">
										<li class="disabled">
											<a href="#" aria-label="Previous"><span aria-hidden="true">&raquo;</span></a>
										</li>
									</c:if>
								
									<c:forEach items="${pageBean.data }" var="pb">
										<c:if test="${pageBean.pageNumber!=pageBean.totalPage }">
											<li class="">
												<a href="${pageContext.request.contextPath }/adminorder?method=findAllOrder&state=${pb.state }&pageNumber=${pageBean.pageNumber+1}" aria-label="Previous">
													<span aria-hidden="true">&raquo;</span>
												</a>
											</li>
										</c:if>
									</c:forEach>
							</ul>
						</div>
				</TBODY>
			</table>
		</form>
	</body>
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/layer/layer.js" type="text/javascript"></script>
	<script type="text/javascript">
			function showOrder(oid){
						//发送异步请求ajax
						$.post("${pageContext.request.contextPath}/adminorder",{"method":"showOrder","oid":oid},function(obj){
							var s = "<table border='1' width='99%'>";
							s+="<tr><td>商品名称</td><td>购买数量</td></tr>";
							//遍历返回的集合
							$(obj).each(function(){
								s+="<tr><td height='50px'>"+this.product.pname+"</td><td>"+this.count+"</td></tr>"
							})
							s+="</table>";
							layer.open({
								  type: 1,//0:信息框; 1:页面; 2:iframe层;	3:加载层;	4:tip层
							      title:"订单号"+oid,//标题
							      area: ['550px', '320px'],//大小
							      shadeClose: true, //点击弹层外区域 遮罩关闭
							      content: s//内容
								 });
						},"json");   
				}
		</script>
</HTML>

