<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
    <h1>修改个人信息</h1>
    <form action="${pageContext.request.contextPath}/apply/ApplyServlet?op=editCustomer" method="post">
    	<table border="1" width="438">
    		<tr>
    			<td>QQ:</td>
    			<td>
    				<input name="qq" value="${sessionScope['com.dhr.logined'].qq}"/>
    			</td>
    		</tr>
    		<tr>
    			<td>邮箱：</td>
    			<td>
    				<input name="email" value="${sessionScope['com.dhr.logined'].email}"/>
    			</td>
    		</tr>
    		<tr>
    			<td>性别：</td>
    			<td>
    				<input type="radio" name="gender" ${sessionScope['com.dhr.logined'].gender=='男'?'checked="checked"':''} value="男"/>男
    				<input type="radio" name="gender" ${sessionScope['com.dhr.logined'].gender=='女'?'checked="checked"':''} value="女"/>女
    			</td>
    		</tr>
    		<tr>
    			<td>目前状态：</td>
    			<td>
    				<select name="status">
    					<c:forEach items="${customerStatus}" var="cs">
    						<option ${sessionScope['com.dhr.logined'].status==cs.name?'selected="selected"':'' }  value="${cs.name}">${cs.name}</option>
    					</c:forEach>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td>意向课程：</td>
    			<td>
    				<select name="classType">
    					<c:forEach items="${classTypes}" var="ct">
    						<option ${sessionScope['com.dhr.logined'].classType==ct.name?'selected="selected"':'' }  value="${ct.name}">${ct.name}</option>
    					</c:forEach>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td>现所在地：</td>
    			<td>
    				<input name="address" value="${sessionScope['com.dhr.logined'].address}"/>
    			</td>
    		</tr>
    	</table>
    <br/>
    <input type="submit" value="保存"/>
    </form>
  </body>
</html>
