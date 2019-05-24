<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>招才网--修改公司信息</title>
<style type="text/css">
a {
	text-decoration: none;
}
</style>
</head>
<body>
	<div style="width: 1400px; margin: 0 auto">
		<h3>
			<font color="red">个人信息</font> <span style="margin-left: 200px"><a
				href="index.jsp">首页</a></span> <span style="margin-left: 200px"><a
				href="add_studentjob.jsp">发布招聘信</a></span> <span style="margin-left: 200px"><a
				href="query_studentjob.jsp">查看招聘信</a></span>
		</h3>
		<hr>
		<div style="width: 1400px; margin: 0 auto">
			<form method="post" action="CompanyS">
				<h1>修改个人信息</h1>
				<%
					if (session.getAttribute("cname") != null) {
				%>
				<input type="hidden" name="cname"
					value="<%=session.getAttribute("cname")%>"><br>
				<p>
					密&nbsp;&nbsp;码：<input type="password" name="password"
						value="${update_cjob.password }"><br>
				<p>
					姓&nbsp;&nbsp;名：<input type="text" name="name"
						value="${update_cjob.name }"><br>
				<p>
					邮&nbsp;&nbsp;箱：<input type="text" name="email"
						value="${update_cjob.email }"><br>
				<p>
					电&nbsp;&nbsp;话：<input type="text" name="tel"
						value="${update_cjob.tel }"><br>
				<p>
					行&nbsp;&nbsp;业：<input type="text" name="manage"
						value="${update_cjob.manage }"><br>
				<p>
					地&nbsp;&nbsp;址：<input type="text" name="address"
						value="${update_cjob.address }"><br>
				<p>
					说&nbsp;&nbsp;明：<input type="text" name="resume"
						value="${update_cjob.resume }"><br>
				<p>
					<input type="submit" name="" value="确认修改"> <input
						type="hidden" name="option" value="update_company"> <input
						type="reset" value="重置">
					<%
			}else{
		%>
				
				<h2>
					你还没有登录，请先<a href="login_company.jsp">登录</a>
				</h2>
				<%
			}
		%>

			</form>
		</div>
	</div>
</body>
</html>