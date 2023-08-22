<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="<c:url value="/js/jquery/jquery-3.7.0.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/selectBar.js"/>"></script>
<script type="text/javascript" src="<c:url value="./index/js/nav.js"/>"></script>
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



element.style {
}
.header-toolbar__btn.menu-btn i, .user-info-menu, .banner-box .banner-hover-1 .banner-image:after, .blog-info, .home-08-banner-01 .banner-overlay, .home-08-banner-01 .banner-overlay:after, .modal, .searchform__popup, .mini-cart, .offcanvas-menu-wrapper .offcanvas-menu-inner, .product-size-swatch, .product-size-swatch-btn, .product-color-swatch, .product-color-swatch-btn, .zakas-product-list .product-thumbnail-action, .tab-style-1 .nav-link:after, .tab-style-2 .nav-link span:after, .zakas-global-overlay, .instagram-feed .instagram-feed-item a:before {
    visibility: hidden;
    opacity: 0;
}
a, button, .user-info-menu, .banner-box .banner-info, .banner-box .banner-hover-1 .banner-image, .banner-box .banner-hover-1 .banner-image:after, .banner-box .banner-hover-2 .banner-image, .btn, .btn-submit, .slick-btn, .accordion-slider__btn, .accordion-click-slider__btn, .slick-arrow, .product-slide-nav .slick-btn, .product-slide-nav .accordion-slider__btn, .product-slide-nav .accordion-click-slider__btn, .searchform__input, .product-modal .close, .custom-close i, .searchform__body, .offcanvas-menu-wrapper .offcanvas-menu-inner, .offcanvas-navigation .offcanvas-menu li > .menu-expand, .zakas-product-list .product-thumbnail-action, .variation-form .product-color-variations .product-color-variation-btn, .tab-style-1 .nav-link:after, .zakas-global-overlay, .pagination li .page-number, .instagram-feed .instagram-feed-item a:before {
    -webkit-transition: all 250ms ease-out;
    -moz-transition: all 250ms ease-out;
    -ms-transition: all 250ms ease-out;
    -o-transition: all 250ms ease-out;
    transition: all 250ms ease-out;
}
.header-toolbar__btn.mini-cart-btn .mini-cart-count, .user-info-menu, .banner-box .banner-info-over-img .banner-info, .banner-box .banner-overlay, .banner-badge-wrapper.abs-center, .banner-badge, .banner-overlay, .blog-info, .slick-btn-wrapper, .nav-center-bottom .slick-btn, .nav-center-bottom .accordion-slider__btn, .nav-center-bottom .accordion-click-slider__btn, .nav-left-bottom .slick-btn, .nav-left-bottom .accordion-slider__btn, .nav-left-bottom .accordion-click-slider__btn, .nav-right-bottom .slick-btn, .nav-right-bottom .accordion-slider__btn, .nav-right-bottom .accordion-click-slider__btn, .product-slide-nav .slick-btn, .product-slide-nav .accordion-slider__btn, .product-slide-nav .accordion-click-slider__btn, .product-slide-nav.slick-vertical .slick-btn, .product-slide-nav.slick-vertical .accordion-slider__btn, .product-slide-nav.slick-vertical .accordion-click-slider__btn, .comment .reply, .searchform__submit, .cart-form .coupon .cart-form__btn, .product-modal .close, .product-badge, .product-size-swatch, .product-color-swatch, .zakas-product-action, .zakas-product-list .product-thumbnail-action, .accordion-slider__btn-group, .accordion-click-slider__btn-group, .product-gallery__actions, .method-box i, .countdown-2 .single-countdown:not(:last-child):after, .breadcrumb li:not(:last-child):after, .zakas-product.product-style-2 .product-info, .instagram-feed-heading, .instagram-feed-heading:after, .nav-right-center .slick-btn, .nav-right-center .accordion-slider__btn, .nav-right-center .accordion-click-slider__btn, .nav-vertical-center .slick-btn, .nav-vertical-center .accordion-slider__btn, .nav-vertical-center .accordion-click-slider__btn {
    position: absolute;
}
.user-info-menu {
    left: 50%;
    top: 150%;
    min-width: 200px;
    margin-top: 6px;
    background: #fff;
    padding: 15px 0;
    pointer-events: none;
    z-index: 111;
    white-space: -moz-nowrap;
    white-space: nowrap;
    -webkit-transform: translateX(-50%);
    -moz-transform: translateX(-50%);
    -ms-transform: translateX(-50%);
    -o-transform: translateX(-50%);
    transform: translateX(-50%);
    -webkit-box-shadow: 0 2px 12px 2px rgba(0, 0, 0, 0.1);
    -moz-box-shadow: 0 2px 12px 2px rgba(0, 0, 0, 0.1);
    -ms-box-shadow: 0 2px 12px 2px rgba(0, 0, 0, 0.1);
    -o-box-shadow: 0 2px 12px 2px rgba(0, 0, 0, 0.1);
    box-shadow: 0 2px 12px 2px rgba(0, 0, 0, 0.1);
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
						<a class="navbar-brand" href="./index/oceanIndex.html"> <img
							src="<c:url value="/img/logo/logo_-_.png"/>" alt="Ocean Logo"
							style="width: 50px; height: 50px;">
						</a>
					</div>
					<!-- 導覽列 -->
					<div class="list">
						<ul class="navbar-nav align-items-center justify-content-end">
							<!-- 首頁 -->
							
							<li class="nav-item"><a class="nav-link active"
								href="<c:url value="/index/oceanIndex.html"/>">首頁</a></li>
							<!-- 電影 -->
							
							<li class="nav-item"><a class="nav-link"
								href="<c:url value="/index/movieIndex.html"/>">電影</a></li>
							<!-- 影集 -->
							
							<li class="nav-item"><a class="nav-link"
								href="<c:url value="/index/seriesIndex.html"/>">影集</a></li>
							<!-- 藝人商品 -->
							<li class="nav-item">
							
							<a class="nav-link active"
								style="color: #81D8D0;" href="<c:url value="/MainShopServlet"/>">藝人商品</a></li>
								
								
								
							<!-- 收藏地圖 -->
							<li class="nav-item"><a class="nav-link"
								href="<c:url value="/index/favoriteMapIndex.html"/>">收藏地圖</a></li>
							<!--user  -->
							<div class="col-xl-2 col-lg-3 col-9 text-right align-item-center">
								<ul class="header-toolbar d-flex">
									<li class="header-toolbar__item my-auto"><a
										href="<c:url value="/SelectWishListServlet"/>" class="header-toolbar__btn"> <i
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
											<img src="<c:url value="img/user.png"/>"
											style="width: 85%; height: 100%;"/>
									
									</a>
										<ul class="user-info-menu">
											<li><a href="/Ocean/subscription/Ocean_Subscription.html" style="font-size:16px">帳戶</a></li>
											<li><a href="/Ocean/edit/edit.html" style="font-size:16px">基本資料</a></li>
<!-- 											<li><a href="checkout.html" style="font-size:16px">我的成就</a></li> -->
											<li><a href="/Ocean/html/my-account.html" style="font-size:16px">我的訂單</a></li>
											<li><a href="/Ocean/favourites/favourites.html" style="font-size:16px">我的片單</a></li>
											<li><a href="/Ocean/memberwatchduration/MemberWatchDuration.html" style="font-size:16px">觀看紀錄</a></li>
											<li><hr></li>
											<li id="logout"><a href="#" class="dropdown-item">登出</a></li>
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