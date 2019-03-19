<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/swiper3.07.min.css"/>

	<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/myfocus-2.0.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	<script>
		myFocus.set({
			id:'picBOX',//焦点图盒子ID
			pattern:'mF_liquid',//风格应用的名称
			time:3,//切换时间间隔(秒)
			trigger:'click',//触发切换模式:'click'(点击)/'mouseover'(悬停)
			width:750,//设置图片区域宽度(像素)
			height:290,//设置图片区域高度(像素)
			txtHeight:'default'//文字层高度设置(像素),'default'为默认高度，0为隐藏
		});
		
	</script>
	<style>
		.swiper-container {
			width: 1100px;
			height: 300px;
			margin: 0 auto;
		}
	</style>
		<title>书淘——首页</title>
</head>
<body>
<!-- 顶部 通栏-->
<%@ include file="/jsp/header.jsp" %>

<div class="header">
	<div class="container clearfix">
		<div class="logo fl">
			<a href="#"><img src="images/logo4.png" alt=""/></a>
		</div>
		<div class="seacher fl">
			<form action="" method="post">
				<input type="text" placeholder="小伙伴，你想找什么?"/><input type="submit" value="搜 索"/>
			</form>
			<p>热门搜索：<a href="#">自行车</a> <a href="#">笔记本</a> <a href="#">散热器</a> <a href="#">考研资料</a> <a href="#">摩托车</a> <a href="#">手机</a> <a href="#">轮滑鞋</a> <a href="#">显示器</a></p>
		</div>
		<div class="mm fl clearfix">
			<a href="#">我要买</a>
			<a href="#">我要卖</a>
		</div>
	</div>
</div>

<div class="mian container">
	<img src="images/notice.png" alt="" style="width: 1200px;height: auto;"/>
	<div class="clearfix">
		<div class="about fl">
			<h1>易书网</h1>
			<img src="images/logo9.png" alt=""/>
			<p><span>易书网</span>是一个网上书商城。力求打造网上最大的中文图书借换系统二手书交换系统力求打造是是网上最大的中文图书借换系统二手书交换系统。易书网来了,让爱书的你花极小的支出(1到2元)就可以读到你喜欢的书且没有后顾之忧哦！</p>
		</div>
		<div class="focus fl">
			<div id="picBOX"><!--焦点图盒子-->
				<div class="loading"><img src="js/mf-pattern/img/loading.gif" alt="请稍候..." /></div><!--载入画面(可删除)-->
				<div class="pic"><!--内容列表(li数目可随意增减)-->
					<ul>
						<li><a href="#"><img src="images/focus1.jpg" thumb="12" alt="便宜出售一本好书" text="卖书" /></a></li>
						<li><a href="#"><img src="images/focus2.jpg" thumb="12" alt="便宜出售一本好书" text="卖书" /></a></li>
						<li><a href="#"><img src="images/focus3.jpg" thumb="12" alt="便宜出售一本好书" text="卖书" /></a></li>
						<li><a href="#"><img src="images/focus4.jpg" thumb="12" alt="便宜出售一本好书" text="卖书" /></a></li>
						<li><a href="#"><img src="images/focus5.jpg" thumb="12" alt="便宜出售一本好书" text="卖书" /></a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="help fr">
			<h2>最先公告</h2>
			<ul>
				<li><a href="#">这是易书网最新公告1</a></li>
				<li><a href="#">这是易书网最新公告2</a></li>
				<li><a href="#">这是易书网最新公告3</a></li>
				<li><a href="#">这是易书网最新公告4</a></li>
				<li><a href="#">这是易书网最新公告5</a></li>
			</ul>
			<h2>新手帮助</h2>
			<ul>
				<li><a href="#">这是易书网帮助1</a></li>
				<li><a href="#">这是易书网帮助2</a></li>
				<li><a href="#">这是易书网帮助3</a></li>
				<li><a href="#">这是易书网帮助4</a></li>
			</ul>
		</div>
	</div>
	<div class="jiaocai clearfix" id="item1">
		<h1>教材区<span></span><a href="#">查看更多</a></h1>
		<!-- 异步导航 -->
		<div class="list fl">
			<ul class="one" id="category">
			</ul>
		</div>
		<!-- 显示教材区-->
		<div class="book fr">
			<c:forEach items="${products }" var="p">
				<dl>
					<dt><a href="${pageContext.request.contextPath }/product?method=productInfo&bid=${p.bid}"><img src="${pageContext.request.contextPath}/${p.image}" alt=""/></a></dt>
					<dd>
						<p><a href="${pageContext.request.contextPath }/product?method=productInfo&bid=${p.bid}">${p.bname }</a></p>
						<p>数量：${p.count }</p>
						<p><s>价格：￥${p.price_old }</s> ￥${p.price }</p>
					</dd>
				</dl>
			</c:forEach>
		</div>
	</div>
	<div class="jiaocai clearfix" id="item2">
		<h1>工具书区<span></span></h1>
		<!-- 加载分类 -->
		<ul class="tab clearfix" id="tab_category"></ul>
			<div class="swiper-container">
				<div class="swiper-wrapper" id="cateBook">
					<c:forEach items="${cateproducts }" var="cp">
						<dl>
							<dt>
								<a href="${pageContext.request.contextPath }/product?method=productInfo&bid=${cp.bid}">
								<img src="${pageContext.request.contextPath }/${cp.image}">
								</a>
							</dt>
							<dd>
								<p><a href="${pageContext.request.contextPath }/product?method=productInfo&bid=${cp.bid}">${cp.bname }</a></p>
								<p>数量：${cp.count }</p><p><s>价格：￥${cp.price_old }</s> ￥${cp.price }</p>
							</dd>
						</dl>
					</c:forEach>
				</div>
			</div>
		<script src="js/swiper3.07.min.js"></script>
		<script>
			var swiper = new Swiper('.swiper-container', {
				pagination: '.swiper-pagination',
				slidesPerView: 7,
				paginationClickable: true,
				grabCursor: true,
				spaceBetween: 30
			});
		</script>
	</div>
	<div class="jiaocai clearfix" id="item3">
		<h1>分享区<span></span></h1>
		<div class="book clearfix" style="margin: 0 auto;width: 1130px;">
			<c:forEach items="${likeproducts}" var="lp">
				<dl>
					<dt><a href="${pageContext.request.contextPath }/product?method=productInfo&bid=${lp.bid}"><img src="${pageContext.request.contextPath }/${lp.image}" alt=""/></a></dt>
					<dd>
						<p><a href="${pageContext.request.contextPath }/product?method=productInfo&bid=${lp.bid}">${lp.bname }</a></p>
						<p>数量：${lp.count }</p>
						<p><s>价格：￥${lp.price_old }</s> ￥${lp.price }</p>
					</dd>
				</dl>
			</c:forEach>
		</div>
	</div>

</div>
<div class="foot">
	<div class="container">

		<div class="zhinan">
			<ul class="clearfix">
				<li class="item-li">购书指南
					<ul>
						<li><a href="#">支付宝担保安全！</a></li>
						<li><a href="#">如何退换货呢？</a></li>
						<li><a href="#">会员有哪些优惠？</a></li>
						<li><a href="#">多长时间可以送达？</a></li>
					</ul>
				</li>
				<li class="item-li">配送与支持
					<ul>
						<li><a href="#">我们的配送方式。</a></li>
						<li><a href="#">配送费说明</a></li>
						<li><a href="#">我们的配送范围。</a></li>
						<li><a href="#">发货方式有哪些？</a></li>
					</ul>
				</li>
				<li class="item-li">支付方式
					<ul>
						<li><a href="#">支付方式有哪些？</a></li>
						<li><a href="#">购书如何支付</a></li>
						<li><a href="#">支付步骤</a></li>
					</ul>
				</li>
				<li class="item-li">售后服务
					<ul>
						<li><a href="#">退换货注意事项</a></li>
						<li><a href="#">不退换货说明</a></li>
						<li><a href="#">售后服务流程</a></li>
					</ul>
				</li>
				<li class="item-li" style="margin: 0">帮助信息
					<ul>
						<li><a href="#">二手书说明</a></li>
						<li><a href="#">隐私安全</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<div class="line"></div>

		<div class="bottom">
			<p>友情链接：<a href="#">安工在线</a>&nbsp;&nbsp;<a href="#">万林强-前端在线简历</a></p>
			<p>本站所有信息均为用户自由发布，本站不对信息的真实性负任何责任，交易时请注意识别信息的真假如有网站内容侵害了您的权益请联系我们删除，举报电话：15068718875</p>
			<p>技术支持：万林强 &nbsp;&nbsp;商务QQ:584845663 &nbsp;&nbsp;邮箱：584845663@qq.com</p>
		</div>
	</div>
</div>
<div class="fixnav">
	<ul>
		<li><a href="#" title="1">教材区</a></li>
		<li><a href="#" title="2">工具书区</a></li>
		<li><a href="#" title="3">分享区</a></li>
		<li><a href="#" title="4">返回顶部</a></li>
	</ul>
</div>
</body>
<script type="text/javascript">
	//推荐栏显示四条
	var tab = 0;
	/*ajax实现异步加载分类*/
	$(function(){
		$.post("${pageContext.request.contextPath}/category",{"method":"getAllCategory"},function(obj){
			$(obj).each(function(){
				$("#category").append("<li><a href='${pageContext.request.contextPath}/product?method=findPageNumber&pageNumber=1&cid="+this.cid+"'>"+this.cname+"</a></li>")
				if(tab<4){
					$("#tab_category").append("<li class='on'><a href=\"javascript:changeCate('"+this.cid+"')\">"+this.cname+"</a></li>");
					tab++;
				}
			});
		},"json");
	})
	
	/*异步加载商品*/
	function changeCate(cid){
		$.post("${pageContext.request.contextPath}/product",{"method":"findCategory","cid":cid},function(obj){
			$("#cateBook").empty();
			$(obj).each(function(){
					var html = "<dl><dt><a href='${pageContext.request.contextPath }/product?method=productInfo&bid="+this.bid+"'><img src='${pageContext.request.contextPath }/"+this.image+"'/></a></dt><dd><p><a href='#'>"+this.bname+"</a></p><p>数量："+this.count+"</p><p><s>价格：￥"+this.price_old+"</s> ￥"+this.price+"</p></dd></dl>"
					$("#cateBook").append(html);
					
				});
		
		},"json");
	}
</script>
</html>