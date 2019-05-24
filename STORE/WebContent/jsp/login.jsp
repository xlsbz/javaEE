<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员登录</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" />
</head>
<body>
	<div class="container">
		<!-- 头部 -->
		<%@ include file="/jsp/header.jsp" %>
		<!-- 主体 -->
		<div class="container-fluid" style="width:100%;height:460px;background:#FF2C4C url('${pageContext.request.contextPath}/images/loginbg.jpg') no-repeat;">
			<div class="row">
				<div class="col-md-7">
				</div>
				<div class="col-md-5">
					<div
						style="width: 440px; border: 1px solid #E7E7E7; padding: 20px 0 20px 30px; border-radius: 5px; margin-top: 60px; background: #fff;">
						<font>会员登录</font>USER LOGIN 
						<h4 style="color:red">${msg }</h4>
						<div>&nbsp;</div>
						<form class="form-horizontal" action="${pageContext.request.contextPath }/user?method=loginUser" method="post">
							<input type="hidden" name="method" value="login">

							<div class="form-group">
								<label for="username" class="col-sm-2 control-label">用户名</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="username"
										placeholder="请输入用户名" name="username">
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
								<label for="inputPassword3" class="col-sm-2 control-label">验证码</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="" name="code"
										placeholder="请输入验证码">
								</div>
								<div class="col-sm-1">
									<a  href="javascript:changeCode()">
										<img id="code" src="${pageContext.request.contextPath}/code?method=code" />
									</a>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<div class="checkbox">
										<label> <input type="checkbox"> 自动登录
										</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label> <input
											type="checkbox" name="savename" value="ok" checked> 记住用户名
										</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<input type="submit" width="100" value="登录" name="submit" border="0"
										style="background: url('${pageContext.request.contextPath}/images/login.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
    height:35px;width:100px;color:white;">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 商品展示：为你推选 -->
				<div class="container-fluid">
					<div class="col-md-10">
						<h2>为你推选&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/img/title2.jpg"/></h2>
					</div>
					<div class="col-md-2">
						<div style="height:53px;">
							<h4 style="height:33px;line-height:53px">
								<a href="${pageContext.request.contextPath }/user?method=loginUI">
									换一批
									<span class="glyphicon glyphicon-refresh"></span>
								</a>
								
							</h4>
						</div>
					</div>
					<div class="col-md-12">
						<c:forEach items="${cList}" var="cl">
							<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
								<a href="${pageContext.request.contextPath}/product?method=getProductById&pid=${cl.pid}">
									<img src="${pageContext.request.contextPath}/${cl.pimage}" width="130" height="130" style="display: inline-block;">
								</a>
								<p><a href="${pageContext.request.contextPath }/product?method=getProductById&pid=${cl.pid}" style='color:#666'>${cl.pname }</a></p>
								<p><font color="#E4393C" style="font-size:16px">&yen;${cl.shop_price }</font></p>
							</div>
						</c:forEach>
					</div>
			</div>	
		<!-- 页脚 -->
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
<script type="text/javascript">
	//获取cookie里面保存的用户名
	var val = "${cookie.saveName.value}";
	document.getElementById("username").value = decodeURI(val);
	
	//刷新验证码
	function changeCode(){
		var code = document.getElementById("code");
		code.src = "${pageContext.request.contextPath}/code?method=code&time="+new Date().getTime()+"";
	}
	
</script>
</html>