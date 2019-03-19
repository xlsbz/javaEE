<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>书淘——登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
 	<style type="text/css">
 		body{
			background:url('${pageContext.request.contextPath}/images/regist_bg.jpg');
		}
 		.content{
 			margin-left:20%;
 		}
 		
 	</style>
  </head>
  <body>

		
		<!-- 顶部通栏 -->
		<%@ include file="/jsp/header.jsp" %>
				<!-- 主体 -->
				<div class="content">
					<div class="row">
						<div class="col-md-2"></div>
						<div class="col-md-8" style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
							<font>会员登录</font>USER LOGIN
							<form class="form-horizontal" style="margin-top: 5px;" method="post" action="${pageContext.request.contextPath }/user?method=loginUser">
								<div class="form-group">
									<label for="username" class="col-sm-2 control-label">用户名</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="username" 
											placeholder="请输入用户名" name="username" >
										<h3><font color="red">${msg }</font></h3>
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
									<label for="date" class="col-sm-2 control-label">验证码</label>
									<div class="col-sm-3">
										<input type="text" name="code" class="form-control">
									</div>
									<div class="col-sm-2">
										<a href="javascript:changeCode();">
											<img id="Changecode" src="${pageContext.request.contextPath}/code?method=code" />
										</a>
									</div>
								</div>
								
								 <div class="form-group">
								    <div class="col-sm-offset-2 col-sm-10">
								      <div class="checkbox">
								        <label>
								          <input type="checkbox" name="savename" value="ok" checked> 记住我
								        </label>
								      </div>
								    </div>
								  </div>
								
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<input type="submit" width="100" value="登录" name="submit"
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
  </body>
  	<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">

	//显示cookie存的用户名
	var savename = "${cookie.savename.value}";
	document.getElementById("username").value = decodeURI(savename);
	//换一张验证码
	function changeCode(){
		var code = document.getElementById("Changecode");
		code.src = "${pageContext.request.contextPath}/code?method=code&time="+new Date().getTime()+"";
	}
		
</script>
</html>
