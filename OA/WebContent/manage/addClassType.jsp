<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
    <h1>添加课程类型</h1>
    <form action="${pageContext.request.contextPath}/manage/ConfigServlet?op=addClassType" method="post">
    	<table border="1" width="438">
    		<tr>
    			<td>
    			<span style="color: red;" >*</span>
    			名称：</td>
    			<td>
    				<input type="text" id="name" name="name"/>
    			</td>
    		</tr>
    		<tr>
    			<td>描述：</td>
    			<td>
    				<textarea rows="3" cols="38" name="description"></textarea>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<input type="button" value="保存" onclick="toSubmit()"/>
    			</td>
    		</tr>
    	</table>
    </form>
    <script type="text/javascript">
    	function toSubmit(){
    		var nameObj = document.getElementById("name");
    		if(nameObj.value.trim()==""){
    			alert("请输入名称");
    			return;
    		}
    		//提交表单
    		document.forms[0].submit();
    	}
    </script>
  </body>
</html>
