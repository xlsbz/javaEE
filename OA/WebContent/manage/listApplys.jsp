<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
    <h1>入学申请列表</h1>
    <c:if test="${empty page.records}">
    	<h2>没有任何申请记录</h2>
    </c:if>
    <c:if test="${!empty page.records}">
    	<table border="1" width="638">
    		<tr>
    			<th>申请编号</th>
    			<th>申请名称</th>
    			<th>申请日期</th>
    			<th>结束日期</th>
    			<th>是否关闭</th>
    			<th>是否成功</th>
    			<th>总得分</th>
    			<th>操作</th>
    		</tr>
    		<c:forEach items="${page.records}" var="a" varStatus="vs">
    			<tr>
	    			<td>${a.number}&nbsp;</td>
	    			<td>${a.title}&nbsp;</td>
	    			<td>${a.startDate}&nbsp;</td>
	    			<td>${a.endDate }&nbsp;</td>
	    			<td>${a.closed==true?'已关闭':'未关闭'}&nbsp;</td>
	    			<td>${a.successed==true?'成功':''}&nbsp;</td>
	    			<td>${a.totalGrade}&nbsp;</td>
	    			<td>
	    				<a href="${pageContext.request.contextPath}/manage/ProcessServlet?op=passApply&number=${a.number}">通过</a>
	    				<a href="${pageContext.request.contextPath}/manage/ProcessServlet?op=closeApply&number=${a.number}">关闭</a>
	    				<a href="javascript:alert('略')">删除</a>
	    			</td>
	    		</tr>
    		</c:forEach>
    	</table>
    	<!-- 分页显示 -->
    	<%@include file="/commons/page.jsp"%>
    </c:if>
  </body>
</html>
