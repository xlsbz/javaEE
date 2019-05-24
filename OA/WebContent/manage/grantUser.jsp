<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
    <h1>权限分配</h1>
    <form action="${pageContext.request.contextPath}/manage/PrivilegeServlet?op=saveGrantUser" method="post">
    	<input type="hidden" name="userId" value="${user.id}"/>
	 	<table width="438">
	 		<tr>
	 			<td>
	 				已分配角色：<br/>
	 				<div style="border: 1px solid">
	 					<c:if test="${empty user.roles}">没有分配任何角色</c:if>
	 					<c:if test="${!empty user.roles}">
	 						<c:forEach items="${user.roles}" var="r">
	 							${r.name}<br/>
	 						</c:forEach>
	 					</c:if>
	 				</div>
	 			</td>
	 			<td>
	 				<div style="border: 1px solid">
	 					<c:forEach items="${roles}" var="r">
	 						<input type="checkbox" name="roleId" value="${r.id}"/>${r.name}<br/>
	 					</c:forEach>
	 				</div>
	 			</td>
	 		</tr>
	 	</table>
	    <input type="submit" value="保存"/>
    </form>
  </body>
</html>
