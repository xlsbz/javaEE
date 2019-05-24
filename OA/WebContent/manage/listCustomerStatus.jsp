<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
    <h2>客户状态列表</h2>
	    <table border="1" width="438">
	    	<tr>
	    		<th><input type="checkbox" id="selectAll" onclick="alert('略')"/>全选</th>
	    		<th>名称</th>
	    		<th>描述</th>
	    		<th>操作</th>
	    	</tr>
	    	<c:forEach items="${customerStatus}" var="info" varStatus="vs">
		    	<tr class="${vs.index%2==0?'even':'odd'}">
		    		<td>
		    			<input type="checkbox" name="customerStatusids" value="${info.id}"/>
		    		</td>
		    		<td>${info.name}</td>
		    		<td>${info.description}</td>
		    		<td>
		    			<a href="javascript:alert('略')">修改</a>
		    			<a href="javascript:alert('略')">删除</a>
		    		</td>
		    	</tr>
	    	</c:forEach>
	    </table>
    <a href="${pageContext.request.contextPath}/manage/addCustomerStatus.jsp">添加</a>
  </body>
</html>
