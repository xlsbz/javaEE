<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>后台-学生信息</title>
</head>
<body>
	<table border="1">
		<tr>
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
		<tr>
			<td>${find_cjob.jobid }</td>
			<td>${find_cjob.cname }</td>
			<td>${find_cjob.specialty }</td>
			<td>${find_cjob.job }</td>
			<td>${find_cjob.emolument }</td>
			<td>${find_cjob.ptime }</td>
			<td>${find_cjob.atime }</td>
			<td>${find_cjob.other }</td>
		</tr>
	</table>
</body>
</html>