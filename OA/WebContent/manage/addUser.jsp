<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
    <h1>添加用户</h1>
    <form action="${pageContext.request.contextPath}/manage/PrivilegeServlet?op=addUser" method="post">
    	<table border="1" width="438">
    		<tr>
    			<td>用户名：</td>
    			<td>
    				<input type="text" name="username"/>
    			</td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td>
    				<input type="password" name="password"/>
    			</td>
    		</tr>
    		<tr>
    			<td>昵称：</td>
    			<td>
    				<input type="text" name="nickname"/>
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
