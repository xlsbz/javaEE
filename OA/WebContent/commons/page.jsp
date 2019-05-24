<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
第${page.pageNum}页/共${page.totalPageNumber}页&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}${page.uri}&num=${page.prePageNum}">上一页</a>&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}${page.uri}&num=${page.nextPageNum}">下一页</a>