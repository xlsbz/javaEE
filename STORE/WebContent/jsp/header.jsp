<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
			<!--
            	描述：菜单栏
            -->
			<div class="container-fluid">
				<div class="col-md-3">
					<img src="${pageContext.request.contextPath }/img/logo.png" height=60/>
				</div>
				<div class="col-md-4">
					<img src="${pageContext.request.contextPath}/img/header.png" />
				</div>
				<div class="col-md-5" style="padding-top:20px">
					<ol class="list-inline">
						<c:if test="${empty user }">
							<li><a href="${pageContext.request.contextPath }/user?method=loginUI">登录<span class="glyphicon glyphicon-user"></span></a></li>
							<li><a href="${pageContext.request.contextPath }/user?method=registerUI">注册<span class="glyphicon glyphicon-eye-open"></span></a></li>
						</c:if>
						<c:if test="${not empty user }">
							${user.username }:你好!
							<li><a href="${pageContext.request.contextPath }/order?method=findOrderByPage&pageNumber=1">我的订单<span class="glyphicon glyphicon-folder-open"></span></a></li>
							<li><a href="${pageContext.request.contextPath }/cart?method=findCart">购物车<span class="glyphicon glyphicon-shopping-cart"></span></a></li>
							<li><a href="${pageContext.request.contextPath }/user?method=updatePasswordUI">修改密码<span class="glyphicon glyphicon-cog"></span></a></li>
							<li><a href="${pageContext.request.contextPath }/user?method=logonUser">注销账号</a></li>
						</c:if>
						
					</ol>
				</div>
			</div>
			<!--
            	描述：导航条
            -->
			<div class="container-fluid">
				<nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">首页</a>
						</div>
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav" id="nav_ajax">
							</ul>
							<form class="navbar-form navbar-right" role="search" action="product" method="post">
								<input type="hidden" name="method" value=searchProduct>
								<div class="form-group">
									<input type="text" name="search" class="form-control" size="40"  placeholder="搜索商品...">
								</div>
								<button type="submit" class="btn btn-primary">
										<span class="glyphicon glyphicon-search"></span>
								</button>
							</form>
						</div>
					</div>
				</nav>
			</div>
			
<script type="text/javascript">
	$(function(){
		//发送ajax 查询所有分类
		$.post("${pageContext.request.contextPath}/category",{"method":"findAll"},function(obj){
			//遍历json列表,获取每一个分类,包装成li标签,插入到ul内部
			//$.each($(obj),function(){});
			$(obj).each(function(){
				//alert(this.cname);
				$("#nav_ajax").append("<li><a href='${pageContext.request.contextPath}/product?method=findByPage&pageNumber=1&cid="+this.cid+"'>"+this.cname+"</a></li>");
			});
		},"json");
	})
</script>