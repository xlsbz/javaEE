<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head></head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员登录</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
	type="text/javascript"></script>
</head>
<body>
	<div class="container">
		<!-- 头部 -->
		<%@include file="/jsp/header.jsp" %>
		<!-- 主体 -->
		<div class="container"	style="width:100%;background:url('${pageContext.request.contextPath}/image/regist_bg.jpg');">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8" style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
					<font>会员注册</font>USER REGISTER
					<form class="form-horizontal" style="margin-top: 5px;" method="post" action="${pageContext.request.contextPath }/user?method=registerUser" onsubmit="return enabled()">
						<input type="hidden" name="method" value="regist">
						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="username" 
									placeholder="请输入用户名" name="username" onblur="regCheck(this.value)" >
								<span id="msg"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-6">
								<input type="password" class="form-control" id="inputPassword3"
									placeholder="请输入密码" name="password">
							</div>
						</div>
						<div class="form-group">
							<label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
							<div class="col-sm-6">
								<input type="password" class="form-control" id="confirmpwd"
									placeholder="请输入确认密码">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
							<div class="col-sm-6">
								<input type="email" class="form-control" id="inputEmail3"
									placeholder="Email" name="email">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail4" class="col-sm-2 control-label">电话</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id=""
									placeholder="电话" name="telephone">
							</div>
						</div>
						<div class="form-group">
							<label for="usercaption" class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="usercaption"
									placeholder="请输入姓名" name="name">
							</div>
						</div>
						<div class="form-group opt">
							<label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
							<div class="col-sm-6">
								<label class="radio-inline"> <input type="radio"
									name="sex" id="inlineRadio1" value="1"> 男
								</label> <label class="radio-inline"> <input type="radio"
									name="sex" id="inlineRadio2" value="0"> 女
								</label>
							</div>
						</div>
						<div class="form-group">
							<label for="date" class="col-sm-2 control-label">出生日期</label>
							<div class="col-sm-6">
								<input type="date" class="form-control" name="birthday">
							</div>
						</div>

						<div class="form-group">
							<label for="date" class="col-sm-2 control-label">验证码</label>
							<div class="col-sm-3">
								<input type="text" class="form-control">

							</div>
							<div class="col-sm-2">
								<img
									src="${pageContext.request.contextPath}/image/captcha.jhtml" />
							</div>

						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="submit" width="100" value="注册" name="submit"
									border="0"
									style="background: url('${pageContext.request.contextPath}/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
				    height:35px;width:100px;color:white;">
							</div>
						</div>
					</form>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
	<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
<!-- 注册验证 -->
<script type="text/javascript">
	var regAjax;
	var flag = true;
	function create(){
		if(window.XMLHttpRequest){
			regAjax = new XMLHttpRequest();
		}else{
			regAjax = new ActiveXObject("Mircrosoft XMLHTTP");
		}
	}
	function regCheck(username){
		create();
		regAjax.open("POST","user?method=registerCheck&username="+username);
		regAjax.onreadystatechange = callBack;
		regAjax.send(null);
	}
	function callBack(){
		if(regAjax.status==200&&regAjax.readyState==4){
			var text = regAjax.responseText;
			if (text == "true") {
				flag = true;
				document.getElementById("msg").innerHTML = "该用户名可以注册!";
			} else {
				flag = false;
				document.getElementById("msg").innerHTML = "该用户名已被注册，请更换!";
			}
		}
	}
	function enabled(){
		return flag;
	}
</script>
</html>




