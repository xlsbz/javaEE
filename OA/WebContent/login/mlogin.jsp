<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    	<form action="${pageContext.request.contextPath}/login/LoginServlet?op=mlogin" method="post">
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
    					<input type="text" name="password"/>
    				</td>
    			</tr>
    			<tr>
    				<td colspan="2">
    					<input type="submit" value="登陆"/>
    				</td>
    			</tr>
    		</table>
    	</form>
  </body>
</html>
