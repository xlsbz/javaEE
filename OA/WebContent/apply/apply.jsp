<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
    <h1>请选择您的意向班级：</h1>
    <form action="${pageContext.request.contextPath}/apply/ApplyServlet?op=genApply" method="post">
    <c:forEach items="${classes}" var="c">
    	<input type="radio" name="classesId" value="${c.id}"/>${c.name}
    </c:forEach>
    <br/>
    <input type="submit" value="提交申请"/>
    </form>
    提示：<br/>
    	如果想更改课程类型，请修改个人信息。
    	<br/>
    	一旦提交了申请，将不能修改。
  </body>
</html>
