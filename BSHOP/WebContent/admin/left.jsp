<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/admincss/left.css" rel="stylesheet" type="text/css"/>
<link rel="StyleSheet" href="${pageContext.request.contextPath}/admincss/dtree.css" type="text/css" />
</head>
<body>

<table width="100%" border="0">
  <tr>
    <td>
	<div class="dtree">
		<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree.js"></script>
			<script type="text/javascript">
				d = new dTree('d');
				d.add('01',-1,'系统菜单树');
				d.add('0101','01','用户管理','','','mainFrame');
				d.add('010101','0101','管理用户','${pageContext.request.contextPath}/admin?method=findAllUser&pageNumber=1','','mainFrame');
				d.add('0102','01','分类管理','','','mainFrame');
				d.add('010201','0102','管理分类','${pageContext.request.contextPath}/admincategory?method=findAll','','mainFrame');
				d.add('0104','01','商品管理');
				d.add('010401','0104','查看上架商品','${pageContext.request.contextPath}/adminproduct?method=findAllProduct&pageNumber=1','','mainFrame');
				d.add('010401','0104','查看下架商品','${pageContext.request.contextPath}/adminproduct?method=findAllOutProduct&pageNumber=1','','mainFrame');
				d.add('010402','0104','添加商品','${pageContext.request.contextPath}/adminproduct?method=addProductUI','','mainFrame');
				d.add('0105','01','订单管理');
				d.add('010501','0105','查看所有订单','${pageContext.request.contextPath}/adminorder?method=findAllOrder&pageNumber=1&state=4','','mainFrame');
				d.add('010502','0105','查看已付款订单','${pageContext.request.contextPath}/adminorder?method=findAllOrder&pageNumber=1&state=1','','mainFrame');
				d.add('010503','0105','查看未付款订单','${pageContext.request.contextPath}/adminorder?method=findAllOrder&pageNumber=1&state=0','','mainFrame');
				d.add('010504','0105','查看待收货订单','${pageContext.request.contextPath}/adminorder?method=findAllOrder&pageNumber=1&state=2','','mainFrame');
				d.add('010505','0105','查看已完成订单','${pageContext.request.contextPath}/adminorder?method=findAllOrder&pageNumber=1&state=3','','mainFrame');
				document.write(d);
			</script>
	</div>	
	</td>
 </tr>
</table>
</body>
</html>
