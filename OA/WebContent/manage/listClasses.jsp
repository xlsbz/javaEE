<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
    <h1>开班信息列表</h1>
    <form action="${pageContext.request.contextPath}/manage/ConfigServlet?op=listClasses" method="post">
	    课程类型：
	    <select name="classTypeId">
	    	<option value="">全部班级</option>
	    	<c:forEach items="${classTypes}" var="type">
	    		<option ${classTypeId==type.id?'selected="selected"':"" } value="${type.id}">${type.name}</option>
	    	</c:forEach>
	    </select>
	    <input type="submit" value="查询"/>
    </form>
    <c:if test="${empty page.records}">
    	<h2>没有任何记录</h2>
    </c:if>
    <c:if test="${!empty page.records}">
    	<table border="1" width="638">
    		<tr>
    			<th>班级名称</th>
    			<th>开班日期</th>
    			<th>招生截止日期</th>
    			<th>计划招生人数</th>
    			<th>已录取人数</th>
    			<th>班级状态</th>
    			<th>操作</th>
    		</tr>
    		<c:forEach items="${page.records}" var="c" varStatus="vs">
    			<tr>
	    			<td>${c.name}&nbsp;</td>
	    			<td>${c.startDate}&nbsp;</td>
	    			<td>${c.endDate}&nbsp;</td>
	    			<td>${c.planNumber }&nbsp;</td>
	    			<td>${c.number }&nbsp;</td>
	    			<td>${c.status }&nbsp;</td>
	    			<td>
	    				<a href="">修改</a>
	    				<a href="">删除</a>
	    			</td>
	    		</tr>
    		</c:forEach>
    	</table>
    	<!-- 分页显示 -->
    	<%@include file="/commons/page.jsp"%>
    </c:if>
    <br/>
    <a href="${pageContext.request.contextPath}/manage/ConfigServlet?op=addClassesUI">添加</a>
  </body>
</html>
