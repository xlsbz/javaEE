<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
    <h1>角色列表</h1>
    <c:if test="${empty roles}">
    	<h2>没有任何记录</h2>
    </c:if>
    <c:if test="${!empty roles}">
    	<table border="1" width="638">
    		<tr>
    			<th>序号</th>
    			<th>角色名称</th>
    			<th>角色描述</th>
    			<th>操作</th>
    		</tr>
    		<c:forEach items="${roles}" var="r" varStatus="vs">
    			<tr>
	    			<td>${vs.count}&nbsp;</td>
	    			<td>${r.name}&nbsp;</td>
	    			<td>${r.description}&nbsp;</td>
	    			<td>
	    				<a href="javascript:alert('略')">修改</a>
	    				<a href="javascript:alert('略')">删除</a>
	    				<a href="${pageContext.request.contextPath}/manage/PrivilegeServlet?op=grantRole&roleId=${r.id}">功能分配</a>
	    			</td>
	    		</tr>
    		</c:forEach>
    	</table>
    </c:if>
    <a href="${pageContext.request.contextPath}/manage/addRole.jsp">添加</a>
  </body>
</html>
