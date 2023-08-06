<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/jsp/pluginsJs.jsp"></jsp:include>
<script type="text/javascript" src="<c:url value="/js/shopdetail.js"/>"></script>
<!-- Header Start -->

<style>
.mini-cart-count {
	color: white;
	background-color: #3f9891;
}

.checked {
	background-color: gainsboro;
}

.selected-color {
	background-color: gainsboro; /* 设置选中标签的背景颜色为红色，你可以根据需要更改颜色 */
	color: #FFFFFF; /* 设置选中标签的文本颜色为白色，你可以根据需要更改颜色 */
}

:root {
	--bs-blue: #81D8D0;
}

/* 頁面背景色 */
.list {
	background: #000;
}

/* 清單 */
.navbar-dark .navbar-nav .nav-link:focus, .navbar-dark .navbar-nav .nav-link:hover
	{
	color: var(--bs-blue)
}

.navbar {
	background: #000;
}

/* search */
.bi {
	color: #fff;
	font-size: 25px;
}

.bi:hover {
	color: #81D8D0;
}

/* 下拉選單 */
.dropdown-item:hover {
	font-size: 20px;
	color: rgb(9, 163, 130);
}

.dropdown-menu.show {
	opacity: 65%;
}

.errMsg {
	position: absolute;
	right: 0;
	/* 使用 absolute 定位，並設定 right 為 0 */
	transform: translateX(100%);
	/* 將元素右偏移自身寬度的 100%，這將將元素移到最右邊 */
}
</style>


	<div class="navAndMovie sticky-top">
		<!-- navbar -->
		<nav class="navbar navbar-expand-lg navbar-dark">
			<div class="container-fluid">
				<div class="collapse navbar-collapse justify-content-between"
					id="navbarNavDropdown">
					<!-- logo -->
					<div class="logo d-flex">
						<a class="navbar-brand" href="/oceanIndex.html"> <img
							src="<c:url value="/img/logo/logo_-_.png"/>" alt="Ocean Logo"
							style="width: 50px; height: 50px;">
						</a>
					</div>
					<!-- 導覽列 -->
					<div class="list">
						<ul class="navbar-nav align-items-center justify-content-end">
							<!-- 首頁 -->
							<li class="nav-item"><a class="nav-link active"
								href="/oceanIndex.html">首頁</a></li>
							<!-- 電影 -->
							<li class="nav-item"><a class="nav-link"
								href="/movieIndex.html">電影</a></li>
							<!-- 影集 -->
							<li class="nav-item"><a class="nav-link"
								href="/seriesIndex.html">影集</a></li>
							<!-- 藝人商品 -->
							<li class="nav-item"><a class="nav-link active"
								style="color: #81D8D0;" href="/productIndex.html">藝人商品</a></li>
							<!-- 收藏地圖 -->
							<li class="nav-item"><a class="nav-link"
								href="/favoriteMapIndex.html">收藏地圖</a></li>
							<!--user  -->
							<div class="col-xl-2 col-lg-3 col-9 text-right align-item-center">
								<ul class="header-toolbar d-flex">
									<li class="header-toolbar__item my-auto"><a
										href="wishlist.html" class="header-toolbar__btn"> <i
											class="flaticon flaticon-like"></i>
									</a></li>

									<li class="header-toolbar__item my-auto"><a
										href="<c:url value="/ShopCartDetailServlet"/>" class="header-toolbar__btn mini-cart-btn"> <i
											class="flaticon flaticon-shopping-cart"></i><sup
											class="mini-cart-count">${cartSize}</sup>
									</a></li>
	
									<li class="header-toolbar__item my-auto"><a
										href="#searchForm" class="header-toolbar__btn toolbar-btn">
											<i class="flaticon flaticon-search"></i>
									</a></li>
									<li class="header-toolbar__item user-info"><a href=""
										class="header-toolbar__btn"> <!--<i class="flaticon flaticon-user"></i> -->
											<img src="<c:url value="img/logo/user.webp"/>"
											style="width: 85%; height: 100%;"/>
									</a>
										<ul class="user-info-menu">
											<li><a href="my-account.html">My Account</a></li>
											<li><a href="cart.html">Shopping Cart</a></li>
											<li><a href="checkout.html">Check Out</a></li>
											<li><a href="wishlist.html">Wishlist</a></li>
											<li><a href="order-tracking.html">Order tracking</a></li>
											<li><a href="compare.html">compare</a></li>
										</ul></li>

									<li class="header-toolbar__item d-lg-none"><a href="#"
										class="header-toolbar__btn menu-btn"> <i
											class="fa fa-bars"></i>
									</a></li>
								</ul>
							</div>
						</ul>
					</div>
				</div>
			</div>
		</nav>
	</div>
	

<Style>
.mini-cart-count:not(:empty) {
  display: inline-block; /* 顯示圖案 */
}

.mini-cart-count:empty {
  display: none; /* 數字小於1時隱藏圖案 */
}
</Style>

<!-- Searchform Popup Start -->
<div class="searchform__popup" id="searchForm">
	<a href="#" class="btn-close"><i class="flaticon flaticon-cross"></i></a>
	<form action="/Ocean/SelectBarServlet" method="post"
		class="searchform__body">
		<div class="searchform">
			<input type="text" name="msg" id="popup-search"
				class="searchform__input" placeholder="請輸入商品或影片關鍵字搜尋">
			<button type="submit" class="searchform__submit">
				<i class="flaticon flaticon-magnifying-glass-icon"></i>
			</button>
		</div>
	</form>
</div>
<!-- Searchform Popup End -->