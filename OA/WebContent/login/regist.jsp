<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<form action="${pageContext.request.contextPath}/login/LoginServlet?op=regist" method="post">
		<table border="1" width="438">
			<tr>
				<td>姓名：</td>
				<td>
					<input name="name"/>
				</td>
			</tr>
			<tr>
				<td>手机号：</td>
				<td><input name="phoneNumber"/></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td>
					<input type="radio" name="gender" value="男" checked="checked"/>男
					<input type="radio" name="gender" value="女"/>女
				</td>
			</tr>
			<tr>
				<td>QQ号码：</td>
				<td><input name="qq"/></td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td><input name="email"/></td>
			</tr>
			<tr>
				<td>所在省市：</td>
				<td><input name="address"/></td>
			</tr>
			<tr>
				<td>目前状态：</td>
				<td>
					<select name="status">
						<c:forEach items="${customerStatus}" var="v">
							<option value="${v.name}">${v.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>意向课程：</td>
				<td>
					<select name="classType">
						<c:forEach items="${classTypes}" var="v">
							<option value="${v.name}">${v.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>信息来源：</td>
				<td>
					<select name="infoSource">
						<c:forEach items="${infoSources}" var="v">
							<option value="${v.name}">${v.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>留言：</td>
				<td>
					<textarea rows="3" cols="38" name="message"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="注册"/>
				</td>
			</tr>
		</table>
	</form>
  </body>
</html>
