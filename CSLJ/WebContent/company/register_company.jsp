<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>招才网--公司用户注册</title>
<script type="text/javascript">
	var regAjax;
	var flag;
	function createXML() {
		if(window.XMLHttpRequest){
			regAjax = new XMLHttpRequest();
		}else{
			regAjax = new ActiveXObject("Mircrosoft XMLHTTP");
		}
	}
	function registerAjax(sname){
		createXML();
		regAjax.open("POST","StudentS?option=registerAjax&sname="+sname);
		regAjax.onreadystatechange = regCallback;
		regAjax.send(null);
	}
	function regCallback(){
		if(regAjax.readyState == 4){
			if(regAjax.status == 200){
				var text = regAjax.responseText;
				if(text=="true"){
					flag = true;
					document.getElementById("msg").innerHTML = "该用户名可以注册!";
				}else{
					flag = false;
					document.getElementById("msg").innerHTML = "该用户名已被注册，请更换!";
				}
			}
		}
	}
	function enabled(){
		return flag;
	}
</script>
</head>
<body>
<div style="width: 1400px; margin: 0 auto">
		<h3>
			<font color="red">个人信息</font> <span style="margin-left: 200px"><a
				href="index.jsp">首页</a></span> <span style="margin-left: 200px"><a
				href="add_companyjob.jsp">发布招聘信</a></span> <span style="margin-left: 200px"><a
				href="query_companyjob.jsp">查看招聘信</a></span>
		</h3>
		<hr>
		<div style="width: 1400px; margin: 0 auto">
	<form method="post" action="StudentS" onsubmit="return enabled()">
	<h1>填写注册信息</h1>
		登录名：<input type="text" name="sname" onblur="registerAjax(this.value)"><span id="msg"></span><br><p>
		密&nbsp;&nbsp;码：<input type="password" name="password"><br><p>
		姓&nbsp;&nbsp;名：<input type="text" name="name"><br><p>
		年&nbsp;&nbsp;龄：<input type="text" name="age"><br><p>
		性&nbsp;&nbsp;别：<input type="text" name="sex"><br><p>
		生&nbsp;&nbsp;日：<input type="text" name="birthday"><br><p>
		学&nbsp;&nbsp;校：<input type="text" name="school"><br><p>
		专&nbsp;&nbsp;业：<input type="text" name="specialty"><br><p>
		学&nbsp;&nbsp;历：<input type="text" name="knowledge"><br><p>
		邮&nbsp;&nbsp;箱：<input type="text" name="email"><br><p>
		说&nbsp;&nbsp;明：<input type="text" name="resume"><br><p>
		<input type="submit" name="" value="注册">
		<input type="hidden" name="option" value="register_student">
		<input type="reset" value="重置">
	</form>
	<%
		if(request.getAttribute("register_error")!=null){
	%>
		<h2><%=request.getAttribute("register_error") %></h2>
	<%
		}
	%>
	</div>
</div>
</body>
</html>