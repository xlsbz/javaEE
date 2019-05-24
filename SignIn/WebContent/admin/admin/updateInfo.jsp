<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="controller.*"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/SignIn/admin/public/admin.css" />
</head>
<body>
<div class="main">
<div class="container">
		<div class="public-nav" style="margin-top:1%">您当前的位置：<a href="">管理首页</a>><a href="">录入信息</a></div>
		<div class="public-content">
			<div class="public-content-header">
				<h3 style="display: inline-block;">录入员工信息</h3>
				<div class="public-content-right fr">
					<a href="admin/admin/addAdminInfo.jsp?suboption=nopage" style="height: 24px; width: 60px;border: 1px solid #ccc;font-size: 12px;text-align:center">新增</a>
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="public-content-cont two-col">
					 <div class="public-content-cont two-col" >
				<div class="public-cont-left">
					<div class="public-cont-title">
						<h3>添加修改分类</h3>
					</div>
					<div class="form-group">
						<label for="">分类名称</label>
						<select name="" id="" class="form-select">
							<option value="1">一级分类</option>
						</select>
					</div>
					<div class="form-group mt0">
						<label for="">分类名称</label>
						<input type="text" class="form-input-small">
					</div>
					<div class="form-group mt0">
						<label for="">排序编号</label>
						<input type="text" class="form-input-small">
					</div>
					<div class="form-group mt0">
						<label for="">外链</label>
						<input type="text" class="form-input-small">
					</div>
					<div class="form-group">
						<label for="">缩略图</label>
						<input type="text" class="form-input-small">
						<div class="file"><input type="file" class="form-input-file" />选择文件</div>
						<div class="file"><input type="submit" class="form-input-file"/>上传</div>
					</div>
					<div class="clearfix"></div>
					<div class="form-group">
						<label for="">导航显示</label>
						<input type="checkbox" />显示
					</div>
					<div class="form-group mt0">
						<label for="">查看权限</label>
						<input type="checkbox" />会员
					</div>
					<div class="form-group mt0">
						<label for="">新栏目</label>
						<input type="checkbox" />显示
					</div>
					<div class="form-group mt0" style="text-align:center;margin-top:15px;">
						<input type="submit" class="sub-btn" value="提   交">
					</div>
					
				</div>
			</div>
<div style="margin-left:30%">
 <form action="AdminS" method="post">
 <legend style="font-size:36px;margin-left:20%">修改信息</legend>
   <div><span class="titlespan">管理员ID:</span><input type="text" name="admId" class="formText" value="${adminInfomation.adm_Id}" placeholder="禁止修改管理员Id" ></div>
  <div><span class="titlespan">管理员编号:</span><input type="text" name="admNumber" class="formText" value="${adminInfomation.adm_Number}"></div>
  <div><span class="titlespan">管理员密码:</span><input type="password" name="admPsd" class="formText"  value="${adminInfomation.admPsd}"></div>
  <div><span class="titlespan">管理员状态:</span>
  正常<input type="radio" name="admState" value="正常">
  异常<input type="radio" name="admState" value="异常">
  </div>
  <div><span class="titlespan">管理员权限:</span><input type="text" name="admPower" class="formText"  value="${adminInfomation.admPower}"></div>
  <div><span class="titlespan">管理员电话:</span><input type="text" name="admPhone" class="formText"  value="${adminInfomation.admPhone}"></div>
  <div><span class="titlespan"></span><input type="hidden" name="option" class="formText" value="updateInfo"></div>
  <div><span class="submitspan"></span><input type="submit" class="formSubmit" value="updateInfo"></div>
 </form>
 </div>
 <div class="public-content-cont two-col" style="float:right;margin-top:-28%">
				<div class="public-cont-left">
					<div class="public-cont-title">
						<h3>删除修改分类</h3>
					</div>
					<div class="form-group">
						<label for="">分类名称</label>
						<select name="" id="" class="form-select">
							<option value="1">一级分类</option>
						</select>
					</div>
					<div class="form-group mt0">
						<label for="">分类名称</label>
						<input type="text" class="form-input-small">
					</div>
					<div class="form-group mt0">
						<label for="">排序编号</label>
						<input type="text" class="form-input-small">
					</div>
					<div class="form-group mt0">
						<label for="">外链</label>
						<input type="text" class="form-input-small">
					</div>
					<div class="form-group">
						<label for="">缩略图</label>
						<input type="text" class="form-input-small">
						<div class="file"><input type="file" class="form-input-file" />选择文件</div>
						<div class="file"><input type="submit" class="form-input-file"/>上传</div>
					</div>
					<div class="clearfix"></div>
					<div class="form-group">
						<label for="">导航显示</label>
						<input type="checkbox" />显示
					</div>
					<div class="form-group mt0">
						<label for="">查看权限</label>
						<input type="checkbox" />会员
					</div>
					<div class="form-group mt0">
						<label for="">新栏目</label>
						<input type="checkbox" />显示
					</div>
					<div class="form-group mt0" style="text-align:center;margin-top:15px;">
						<input type="submit" class="sub-btn" value="提   交">
					</div>
				</div>
 
</div>
</body>
</html>