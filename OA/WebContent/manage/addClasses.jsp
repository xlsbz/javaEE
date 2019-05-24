<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
    <h1>添加开班信息</h1>
    <form action="${pageContext.request.contextPath}/manage/ConfigServlet?op=addClasses" method="post">
    	<table border="1" width="438">
    		<tr>
    			<td>
    			班级类型：</td>
    			<td>
    				<select name="classTypeId">
    					<c:forEach items="${classTypes}" var="type">
    						<option value="${type.id}">${type.name}</option>
    					</c:forEach>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td>期数：</td>
    			<td>
    				<input type="text" name="count"/>
    			</td>
    		</tr>
    		<tr>
    			<td>开班日期：</td>
    			<td>
    				<input type="text" id="startDate" name="startDate" readonly="readonly" onclick="return showCalendar('startDate', 'y-mm-dd');"/>yyyy-MM-dd
    			</td>
    		</tr>
    		<tr>
    			<td>招生截止日期：</td>
    			<td>
    				<input type="text" id="endDate" name="endDate" readonly="readonly"  onclick="return showCalendar('endDate', 'y-mm-dd');"/>yyyy-MM-dd
    			</td>
    		</tr>
    		<tr>
    			<td>计划招收人数：</td>
    			<td>
    				<input type="text" name="planNumber"/>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<input type="submit" value="保存"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
