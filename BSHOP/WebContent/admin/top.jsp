<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style type="text/css">
BODY {
	MARGIN: 0px;
	BACKGROUND-COLOR: #ffffff
}

BODY {
	FONT-SIZE: 12px;
	COLOR: #000000
}

TD {
	FONT-SIZE: 12px;
	COLOR: #000000
}

TH {
	FONT-SIZE: 12px;
	COLOR: #000000
}
</style>
		<link href="${pageContext.request.contextPath}/admincss/Style1.css" rel="stylesheet" type="text/css">
	</HEAD>
	<body>
		<table width="100%" height="130px">
			<tr>
				<td>
					<img src="${pageContext.request.contextPath}/images/top_100.jpg" width="100%" />
				</td>
			</tr>
			<tr>
				<td align="right"  background="${pageContext.request.contextPath}/images/mis_05b.jpg">
					`<h2><font color="blue">管理员：${admin.adminname },欢迎你!
						 </font>
					</h2>
				</td>
			</tr>
		</table>
	</body>
</HTML>
