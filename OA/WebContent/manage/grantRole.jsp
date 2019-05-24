<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
    <h1>角色功能分配</h1>
    <form action="${pageContext.request.contextPath}/manage/PrivilegeServlet?op=saveGrantRole" method="post">
    	<input type="hidden" name="roleId" value="${role.id}"/>
	 	<table width="438">
	 		<tr>
	 			<td>
	 				已分配功能：<br/>
	 				<div style="border: 1px solid">
	 					<c:if test="${empty role.functions}">没有分配任何功能</c:if>
	 					<c:if test="${!empty role.functions}">
	 						<c:forEach items="${role.functions}" var="f">
	 							${f.name}<br/>
	 						</c:forEach>
	 					</c:if>
	 				</div>
	 			</td>
	 			<td>
	 				<div style="border: 1px solid">
	 					<c:forEach items="${functions}" var="f">
	 						<input type="checkbox" name="functionId" value="${f.id}"/>${f.name}<br/>
	 					</c:forEach>
	 				</div>
	 			</td>
	 		</tr>
	 	</table>
	    <input type="submit" value="保存"/>
    </form>
  </body>
</html>
