<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>报名登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    	<form action="${pageContext.request.contextPath}/login/LoginServlet?op=login" method="post">
    		<table border="1" width="438">
    			<tr>
    				<td>邮箱：</td>
    				<td>
    					<input type="text" name="email"/>
    				</td>
    			</tr>
    			<tr>
    				<td>手机号：</td>
    				<td>
    					<input type="text" name="phoneNumber"/>
    				</td>
    			</tr>
    			<tr>
    				<td>验证码：</td>
    				<td>
    					<input type="text" name="captcha" size="4"/>
    					<img id="captcha" src="${pageContext.request.contextPath}/login/LoginServlet?op=captcha"/>
    					<a href="javascript:changeCaptcha()">看不清换一张</a>
    				</td>
    			</tr>
    			<tr>
    				<td colspan="2">
    					<input type="submit" value="登陆"/>
    				</td>
    			</tr>
    		</table>
    	</form>
    	还没有注册？请猛戳<a href="${pageContext.request.contextPath}/login/LoginServlet?op=registUI">这里</a>
    	<script type="text/javascript">
    		function changeCaptcha(){
    			var imgObj = document.getElementById("captcha");
    			imgObj.src="${pageContext.request.contextPath}/login/LoginServlet?op=captcha&time="+new Date().getTime();
    		}
    	</script>
  </body>
</html>
