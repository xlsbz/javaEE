<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
    <h1>功能菜单列表</h1>
    <c:if test="${empty functions}">
    	<h2>没有任何记录</h2>
    </c:if>
    <c:if test="${!empty functions}">
    	<table border="1" width="638">
    		<tr>
    			<th>序号</th>
    			<th>功能名称</th>
    			<th>uri</th>
    			<th>操作</th>
    		</tr>
    		<c:forEach items="${functions}" var="f" varStatus="vs">
    			<tr>
	    			<td>${vs.count}&nbsp;</td>
	    			<td>${f.name}&nbsp;</td>
	    			<td>${f.uri}&nbsp;</td>
	    			<td>
	    				<a href="javascript:alert('略')">修改</a>
	    				<a href="javascript:alert('略')">删除</a>
	    			</td>
	    		</tr>
    		</c:forEach>
    	</table>
    </c:if>
    <a href="${pageContext.request.contextPath}/manage/addFunction.jsp">添加</a>
  </body>
</html>
