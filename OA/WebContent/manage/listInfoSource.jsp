<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
    <h2>信息来源列表</h2>
    <form action="${pageContext.request.contextPath}/manage/ConfigServlet?op=delMultiInfoSource" method="post">
	    <table border="1" width="438">
	    	<tr>
	    		<th><input type="checkbox" id="selectAll" onclick="selectDeSelect(this)"/>全选</th>
	    		<th>名称</th>
	    		<th>描述</th>
	    		<th>操作</th>
	    	</tr>
	    	<!-- 
	    	varStatus:取值为一个String。该字符串是一个变量名称，引用了一个对象。放到页面范围
	    		该对象记录着当前遍历的元素的信息。
	    		int getIndex():索引。从0开始
	    		int getCount():计数。从1开始
	    		boolean isFirst():是否是第一个元素
	    		boolean isLast():是否是最后一个元素
	    	
	    	-->
	    	<c:forEach items="${infoSources}" var="info" varStatus="vs">
		    	<tr class="${vs.index%2==0?'even':'odd'}">
		    		<td>
		    			<input type="checkbox" name="infoSourceIds" value="${info.id}"/>
		    		</td>
		    		<td>${info.name}</td>
		    		<td>${info.description}</td>
		    		<td>
		    			<a href="${pageContext.request.contextPath}/manage/ConfigServlet?op=editInfoSourceUI&id=${info.id}">修改</a>
		    			<a href="javascript:del('${info.id}')">删除</a>
		    		</td>
		    	</tr>
	    	</c:forEach>
	    </table>
    </form>
    <a href="${pageContext.request.contextPath}/manage/addInfoSource.jsp">添加</a>
    <a href="javascript:delMulti()">删除</a>
    <script type="text/javascript">
    	function del(infoSourceId){
    		var sure = window.confirm("确定要删除吗？");
    		if(sure){
    			window.location.href="${pageContext.request.contextPath}/manage/ConfigServlet?op=delInfoSource&id="+infoSourceId;
    		}
    	}
    	
    	function delMulti(){
    		//判断用户有没有选择
    		var selected = false;//选择标记
    		var infoSourceIdsObj = document.getElementsByName("infoSourceIds");
    		for(var i=0;i<infoSourceIdsObj.length;i++){
    			if(infoSourceIdsObj[i].checked){
    				selected = true;
    				break;
    			}
    		}
    		
    		if(!selected){
    			alert("请先选择要删除的记录");
    			return;
    		}
    		//如果选择了至少一个：二次提示
    		var sure = window.confirm("确定要删除所选记录吗？");
    		if(sure){
    			//如果用户确定要删除：提交表单
    			document.forms[0].submit();
    		}
    		
    	}
    	
    	function selectDeSelect(checkboxObj){
    		var status = checkboxObj.checked;
    		var infoSourceIdsObj = document.getElementsByName("infoSourceIds");
    		for(var i=0;i<infoSourceIdsObj.length;i++){
    			infoSourceIdsObj[i].checked=status;
    		}
    	}
    </script>
  </body>
</html>
