<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="vo.SjobVo"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我的求职信</title>
</head>
<body>
	<div style="width: 1400px; margin: 0 auto">
		<h3>
			个人信息 <span style="margin-left: 200px"><a href="index.jsp">首页</a></span>
			<span style="margin-left: 200px"> <a href="add_studentjob.jsp">
					发布求职信</a>
			</span> <span style="margin-left: 200px"> <a
				href="query_studentjob.jsp"><font color="red">查看求职信</font></a>
			</span>
		</h3>
		<hr>
		<div style="width: 1400px; margin: 0 auto">
			<table border="1">
				<tr>
					<td>选择</td>
					<td>求职编号</td>
					<td>求职人</td>
					<td>专业</td>
					<td>求职工作</td>
					<td>期望薪资</td>
					<td>发布时间</td>
					<td>有效时间</td>
					<td>简历</td>
					<td>操作</td>
				</tr>
				<%
						List<SjobVo> all = (List) request.getAttribute("getAllJobs");
						Iterator<SjobVo> iterator = all.iterator();
						while (iterator.hasNext()) {
							SjobVo vo = iterator.next();
					%>
				<tr>
					<td><input type="radio" name="delId"
						value="<%=vo.getJobid()%>"></td>
					<td><%=vo.getJobid()%></td>
					<td><%=vo.getSname()%></td>
					<td><%=vo.getSpecialty()%></td>
					<td><%=vo.getJob()%></td>
					<td><%=vo.getEmolument()%></td>
					<td><%=vo.getPtime()%></td>
					<td><%=vo.getAtime()%></td>
					<td><%=vo.getOther()%></td>
					<td><input type="button" value="删除"
						onclick="location.href='StudentJobS?option=delete_jobs&jobid=<%=vo.getJobid() %>'">
						<input type="button" value="修改"
						onclick="location.href='StudentJobS?option=to_update&jobid=<%=vo.getJobid() %>'">
					</td>
				</tr>
				<%
						}
					%>
			</table>
		</div>
	</div>
</body>
</html>