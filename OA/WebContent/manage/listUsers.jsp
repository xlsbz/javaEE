<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
    <h1>用户列表</h1>
    <c:if test="${empty users}">
    	<h2>没有任何记录</h2>
    </c:if>
    <c:if test="${!empty users}">
    	<table border="1" width="638">
    		<tr>
    			<th>序号</th>
    			<th>用户名</th>
    			<th>昵称</th>
    			<th>操作</th>
    		</tr>
    		<c:forEach items="${users}" var="u" varStatus="vs">
    			<tr>
	    			<td>${vs.count}&nbsp;</td>
	    			<td>${u.username}&nbsp;</td>
	    			<td>${u.nickname}&nbsp;</td>
	    			<td>
	    				<a href="javascript:alert('略')">修改</a>
	    				<a href="javascript:alert('略')">删除</a>
	    				<a href="${pageContext.request.contextPath}/manage/PrivilegeServlet?op=grantUser&userId=${u.id}">权限分配</a>
	    			</td>
	    		</tr>
    		</c:forEach>
    	</table>
    </c:if>
    <a href="${pageContext.request.contextPath}/manage/addUser.jsp">添加</a>
  </body>
</html>
