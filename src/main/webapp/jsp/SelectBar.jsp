<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Header Start -->
<header class="header">
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
									<li class="header-toolbar__item mini-cart-item my-auto"><a
										href="#miniCart"
										class="header-toolbar__btn toolbar-btn mini-cart-btn"> <i
											class="flaticon flaticon-shopping-cart"></i> <sup
											class="mini-cart-count">2</sup>
									</a></li>
									<li class="header-toolbar__item my-auto"><a
										href="#searchForm" class="header-toolbar__btn toolbar-btn">
											<i class="flaticon flaticon-search"></i>
									</a></li>
									<li class="header-toolbar__item user-info"><a href=""
										class="header-toolbar__btn"> <!--                                         <i class="flaticon flaticon-user"></i> -->
											<img src="<c:url value="img/logo/user.webp"/>"
											style="width: 100%; height: 100%" />
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
	<div class="header-inner fixed-header"
		style="background-color: #deefed;">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-xl-10 col-lg-9 col-3">
					<nav class="main-navigation">
						<div class="mainmenu-nav d-none d-lg-block">
							<ul class="mainmenu">
								<li class="mainmenu__item menu-item-has-children"><a
									href="<c:url value="/ShopServlet?type=AllProduct"/>"
									class="mainmenu__link"> <span class="mm-text">所有商品</span>
								</a></li>

								<li class="mainmenu__item menu-item-has-children"><a
									href="<c:url value="/ShopServlet?type=Women"/>"
									class="mainmenu__link"> <span class="mm-text">女裝</span>
								</a>
									<ul class="sub-menu"">
										<li><a href="<c:url value="/ShopServlet?type=WomenTop"/>">
												<span class="mm-text">上衣 Top</span>
										</a></li>
										<li><a
											href="<c:url value="/ShopServlet?type=WomenBottom"/>"> <span
												class="mm-text">下身 Bottom</span>
										</a></li>
									</ul></li>

								<li class="mainmenu__item menu-item-has-children"><a
									href="<c:url value="/ShopServlet?type=Men"/>"
									class="mainmenu__link"> <span class="mm-text">男裝</span>
								</a>
									<ul class="sub-menu">
										<li><a href="<c:url value="/ShopServlet?type=MenTop"/>">
												<span class="mm-text">上衣 Top</span>
										</a></li>
										<li><a
											href="<c:url value="/ShopServlet?type=MenBottom"/>"> <span
												class="mm-text">下身 Bottom</span>
										</a></li>
									</ul></li>


								<li class="mainmenu__item menu-item-has-children"><a
									href="<c:url value="/ShopServlet?type=Shoes"/>"
									class="mainmenu__link"> <span class="mm-text">鞋子</span>
								</a>
									<ul class="sub-menu">
										<li><a
											href="<c:url value="/ShopServlet?type=WomenShoes"/>"> <span
												class="mm-text">女鞋 women's shoes</span>
										</a></li>
										<li><a href="<c:url value="/ShopServlet?type=MenShoes"/>">
												<span class="mm-text">男鞋 Men's shoes</span>
										</a></li>
									</ul></li>
								<li class="mainmenu__item menu-item-has-children"><a
									href="<c:url value="/ShopServlet?type=Accessories"/>"
									class="mainmenu__link"> <span class="mm-text">飾品</span>
								</a></li>
								<li class="mainmenu__item menu-item-has-children"><a
									href="<c:url value="/ShopServlet?type=Others"/>"
									class="mainmenu__link"> <span class="mm-text">其他周邊</span>
								</a></li>

								<div class="errMsg" style="display: inline-block">
									<ul class="breadcrumb">
									
									
										<li><a href="<c:url value="/MainShopServlet"/>">Home</a></li>
										<li class="current"><span>Ocean</span></li>
										
										
										
									</ul>
								</div>
							</ul>
						</div>
					</nav>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="mobile-menu"></div>
				</div>
			</div>
		</div>
	</div>
</header>
<!-- Header End -->


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