<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>招才网--发布求职信息</title>
<style type="text/css">
a {
	text-decoration: none;
}
</style>
</head>
<body>
	<div style="width: 1400px; margin: 0 auto">
		<h3>
			个人信息 <span style="margin-left: 200px"><a href="index.jsp">首页</a></span>
			<span style="margin-left: 200px"><a href="add_studentjob.jsp"><font
					color="red">发布求职信</font></a></span> <span style="margin-left: 200px"><a
				href="query_studentjob.jsp">查看求职信</a></span>
		</h3>
		<hr>
		<div style="width: 1400px; margin: 0 auto">
			<form method="post" action="StudentJobS">
				<h1>填写求职信息</h1>
				<input type="hidden" name="sname"
					value="<%=session.getAttribute("sname")%>"><br>
				<p>
					期望&nbsp;&nbsp;工作：<input type="text" name="specialty"><br>
				<p>
					期望&nbsp;&nbsp;岗位：<input type="text" name="job"><br>
				<p>
					薪水&nbsp;&nbsp;范围：<input type="text" name="emolument"><br>
				<p>
					开始&nbsp;&nbsp;时间：<input type="text" name="ptime"><br>
				<p>
					有效&nbsp;&nbsp;时间：<input type="text" name="atime"><br>
				<p>
					个人&nbsp;&nbsp;说明：<input type="text" name="other"><br>
				<p>
					<input type="submit" name="" value="发布招聘"> <input
						type="hidden" name="option" value="add_sjob"> <input
						type="reset" value="重置信息">
			</form>
		</div>
	</div>
</body>
</html>