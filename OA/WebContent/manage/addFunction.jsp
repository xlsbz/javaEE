<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
    <h1>添加功能</h1>
    <form action="${pageContext.request.contextPath}/manage/PrivilegeServlet?op=addFunction" method="post">
    	<table border="1" width="438">
    		<tr>
    			<td>名称：</td>
    			<td>
    				<input type="text" name="name"/>
    			</td>
    		</tr>
    		<tr>
    			<td>URI：</td>
    			<td>
    				<input type="text" name="uri"/>
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
