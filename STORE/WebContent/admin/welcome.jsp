<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet" />
<style type="text/css">
<!--
body {
	background-color: #FFFFFF;
	margin-left: 0px;
	margin-top: 10%;
	margin-right: 0px;
	margin-bottom: 0px;
}
body,td,th {
	color: #000000;
	font-size:28px;
}
-->
    </style>
<style>
BODY {SCROLLBAR-FACE-COLOR: #cccccc; SCROLLBAR-HIGHLIGHT-COLOR: #ffffFF; SCROLLBAR-SHADOW-COLOR: #ffffff; SCROLLBAR-3DLIGHT-COLOR: #cccccc; SCROLLBAR-ARROW-COLOR:  #ffffff; SCROLLBAR-TRACK-COLOR: #ffffFF; SCROLLBAR-DARKSHADOW-COLOR: #cccccc; }
</style>
</head>

<body>

	<table width="100%">
		<tr>
			<td width="100%" height="200px" align="center" >
				<c:if test="${admin!=null }">
					<h1><span class="Style1">登录成功！欢迎您${admin }</span></h1>
				</c:if>
			</td>
		</tr>
		<tr><td height=2></td></tr>
	
	</table>
</body>

</html>