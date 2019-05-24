<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>公司信息</title>
</head>
<body>
	<div style="width: 1400px; margin: 0 auto">
		<h3>
			个人信息 <span style="margin-left: 200px"><a href="index.jsp">首页</a></span>
			<span style="margin-left: 200px"><a href="add_studentjob.jsp"><font
					color="red">发布招聘信</font></a></span> <span style="margin-left: 200px"><a
				href="query_studentjob.jsp">查看招聘信</a></span>
		</h3>
		<hr>
		<div style="width: 1400px; margin: 0 auto">
			<table border="1">
				<%
					List all = (ArrayList) request.getAttribute("query_success");
					if (all != null) {
				%>

				<tr>
					<td>选择</td>
					<td>工作编号</td>
					<td>发布人</td>
					<td>招聘工作</td>
					<td>招聘岗位</td>
					<td>工资薪水</td>
					<td>发布时间</td>
					<td>有效时间</td>
					<td>招聘要求</td>
					<td>操作</td>
				</tr>
				<%
					Iterator iterator = all.iterator();
						while (iterator.hasNext()) {
							pageContext.setAttribute("list", iterator.next());
				%>
				<tr>

					<td><input type="radio" name="deljobId" value="${list.jobid}"></td>
					<td>${list.jobid}</td>
					<td>${list.cname}</td>
					<td>${list.specialty}</td>
					<td>${list.job}</td>
					<td>${list.emolument}</td>
					<td>${list.ptime}</td>
					<td>${list.atime}</td>
					<td>${list.other}</td>
					<td><input type="button" value="删除"
						onclick="location.href='CompanyJobS?option=delete_companyjob&jobid=${list.jobid}'">
						<input type="button" value="修改"
						onclick="location.href='CompanyJobS?option=to_update&jobid=${list.jobid}'">
					</td>
				</tr>
				<%
		}
	%>
				<%
		}
	%>
			</table>
		</div>
	</div>
</body>
</html>