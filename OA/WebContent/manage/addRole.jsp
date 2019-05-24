<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
    <h1>添加角色</h1>
    <form action="${pageContext.request.contextPath}/manage/PrivilegeServlet?op=addRole" method="post">
    	<table border="1" width="438">
    		<tr>
    			<td>名称：</td>
    			<td>
    				<input type="text" name="name"/>
    			</td>
    		</tr>
    		<tr>
    			<td>描述：</td>
    			<td>
    				<textarea rows="3" cols="38" name="description"></textarea>
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
