<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>会员登录</title>
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- 引入自定义css文件 style.css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>
    <style>
        body {
            margin-top: 20px;
            margin: 0 auto;
        }

        .carousel-inner .item img {
            width: 100%;
            height: 300px;
        }

        .container .row div {
            /* position:relative;
             float:left; */

        }

        font {
            color: #3164af;
            font-size: 18px;
            font-weight: normal;
            padding: 0 10px;
        }
    </style>
</head>

<body>
<div class="container">
    <!-- 头部 -->
    <%@ include file="header.jsp"%>
    <div class="container">
        <div class="row">
            <div style="margin: 0 auto; margin-top: 10px; width: 950px;">
                <strong style="font-size: 16px; margin: 5px 0;">订单详情</strong>
                <c:if test="${empty cart.cartItems }">
                    <h3>购物车什么也没有，先去逛逛吧！</h3>
                </c:if>
                <c:if test="${not empty cart.cartItems }">
                    <table class="table table-bordered">
                        <tbody>
                        <tr class="warning">
                            <th>图片</th>
                            <th>商品</th>
                            <th>价格</th>
                            <th>数量</th>
                            <th>小计</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${cart.cartItems }" var="ci">
                            <tr class="active">
                                <td width="60" width="40%">
                                    <img src="${pageContext.request.contextPath}/${ci.product.pimage}"
                                         width="70" height="60"></td>
                                <td width="30%"><a target="_blank"> ${ci.product.pname }</a></td>
                                <td width="20%">${ci.product.shop_price }</td>
                                <td width="10%"><input readonly="readonly" type="text" name="quanity"
                                                       value="${ci.count}"
                                                       maxlength="4" size="10"></td>
                                <td width="15%"><span class="subtotal">${ci.subtotal }</span></td>
                                <td><a href="javascript:void(0);" onclick="removeCart('${ci.product.pid}')"
                                       class="delete">删除</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>
        </div>

        <div style="margin-right: 130px;">
            <div style="text-align: right;">
                <em style="color: #ff6600;"> 登录后确认是否享有优惠&nbsp;&nbsp; </em> 赠送积分: <em
                    style="color: #ff6600;">666</em>&nbsp; 商品金额: <strong
                    style="color: #ff6600;">${cart.total }</strong>
            </div>
            <div
                    style="text-align: right; margin-top: 10px; margin-bottom: 10px;">
                <a href="${pageContext.request.contextPath }/cart?method=clearCart" id="clear" class="clear">清空购物车</a>
                <a href="${pageContext.request.contextPath }/order?method=saveOrder"> <input type="submit" width="100"
                                                                                             value="提交订单" name="submit"
                                                                                             style="background: url('${pageContext.request.contextPath}/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
						height:35px;width:100px;color:white;">
                </a>
            </div>
        </div>
    </div>
    <!-- 尾注 -->
    <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
<script type="text/javascript">
    function removeCart(pid) {
        if (confirm("确定要删除我吗?")) {
            location.href = "${pageContext.request.contextPath}/cart?method=removeProduct&pid=" + pid;
        }
    }
</script>
</html>