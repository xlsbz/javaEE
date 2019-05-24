<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>用户列表</strong>
						</TD>
					</tr>
					<tr>
						
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="19%">
										序号
									</td>
									<td align="center" width="13%">
										用户名称
									</td>
									<td align="center" width="13%">
										真实姓名
									</td>
									<td align="center" width="13%">
										邮箱
									</td>
									<td align="center" width="13%">
										电话
									</td>
									<td align="center" width="13%">
										生日
									</td>
									<td align="center" width="13%">
										性别
									</td>
								</tr>
									<c:forEach items="${allUserBean.data }" var="ab" varStatus="vs">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="19%">
												${vs.count }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="13%">
												${ab.username }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="13%">
												${ab.name }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="13%">
												${ab.email }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="13%">
												${ab.telephone }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="13%">
												${ab.birthday }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="13%">
												${ab.sex }
											</td>
										</tr>
									</c:forEach>
							</table>
						</td>
					</tr>
					<tr align="center">
							<!-- 分页 -->
						<h1><font color="red">${msg }</font></h1>
						<div style="text-align: center;">
							<ul class="pagination">
								<!-- 判断是否为第一页 -->
									<c:if test="${allUserBean.pageNumber==1 }">
										<li class="disabled">
											<a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
										</li>
									</c:if>
									<c:if test="${allUserBean.pageNumber!=1 }">
										<li class="">
											<a href="${pageContext.request.contextPath }/admin?method=findAllUser&pageNumber=${allUserBean.pageNumber-1}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
										</li>
									</c:if>
								<c:forEach begin="1" end="${allUserBean.totalPage }" var="n">
									<c:if test="${allUserBean.pageNumber==n}">
										<li class="active"><a href="${pageContext.request.contextPath }/admin?method=findAllUser&pageNumber=${n}">${n }</a></li>
									</c:if>
									<c:if test="${allUserBean.pageNumber!=n}">
										<li><a href="${pageContext.request.contextPath }/admin?method=findAllUser&pageNumber=${n}">${n }</a></li>
									</c:if>
								</c:forEach>
								<!-- 判断是否为最后一页 -->
									<c:if test="${allUserBean.pageNumber==allUserBean.totalPage }">
										<li class="disabled">
											<a href="#" aria-label="Previous"><span aria-hidden="true">&raquo;</span></a>
										</li>
									</c:if>
									<c:if test="${allUserBean.pageNumber!=allUserBean.totalPage }">
										<li class="">
											<a href="${pageContext.request.contextPath }/admin?method=findAllUser&pageNumber=${allUserBean.pageNumber+1}" aria-label="Next">
											<span aria-hidden="true">&raquo;</span>
											</a>
										</li>
									</c:if>
							</ul>
						</div>
					</tr>
				</TBODY>
			</table>
		</form>
	</body>
</HTML>

