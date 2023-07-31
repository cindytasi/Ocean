<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!doctype html>
<html class="no-js" lang="zxx">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Zakas - Fashion eCommerce Bootstrap 4 Template</title>
<meta name="description" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicons -->
<link rel="shortcut icon" href="<c:url value="/img/favicon.ico"/>"
	type="image/x-icon">
<link rel="apple-touch-icon" href="<c:url value="/img/icon.png"/>">

<!-- ************************* CSS Files ************************* -->
<link href='https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css' rel='stylesheet'></link>	
<!-- Vendor CSS -->
<link rel="stylesheet" href="<c:url value="/css/vendor.css"/>">

<!-- style css -->
<link rel="stylesheet" href="<c:url value="/css/main.css"/>">


<style>
.global-search{
    margin: 0;
    flex-grow: 1;
}

.global-search input  {
    margin: 20PX 0 0 80%;
    width: 200px;
    padding: 9px 21px;
    border: 1px solid #dcdcdc;
    color: #656565;
    -webkit-border-radius: 30px;
    border-radius: 30px;
    background: #f5f5f5;
    font-size: 15px;
    line-height: 14px;
    height: 34px;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    background-color: #fff;   
}

.submit-search{
  visibility: hidden;
}


.fa-search::before{

  visibility:visible;
  font-weight: Thin; 
  font-size: 25px;
  display: flex;
  position:absolute;
  top: 82px;
  color:#656565;
  right: 10%;
}


</style>




</head>

<body>

	<!-- Preloader Start -->
	<div class="zakas-preloader active">
		<div
			class="zakas-preloader-inner h-100 d-flex align-items-center justify-content-center">
			<div class="zakas-child zakas-bounce1"></div>
			<div class="zakas-child zakas-bounce2"></div>
			<div class="zakas-child zuka-bounce3"></div>
		</div>
	</div>
	<!-- Preloader End -->
	
	
	<!-- Main Wrapper Start -->
	<div class="wrapper">
		<!-- Header Start -->
		<header class="header">
			<div class="header-inner fixed-header">
				<div class="container">
					<div class="row align-items-center">
						<div class="col-xl-10 col-lg-9 col-3">
							<nav class="main-navigation">
								<div class="site-branding">
									
								</div>


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
												<li><a
													href="<c:url value="/ShopServlet?type=WomenTop"/>"> <span
														class="mm-text">上衣 Top</span>
												</a></li>
												<li><a
													href="<c:url value="/ShopServlet?type=WomenBottom"/>">
														<span class="mm-text">下身 Bottom</span>
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
												<li><a
													href="<c:url value="/ShopServlet?type=MenShoes"/>"> <span
														class="mm-text">男鞋 Men's shoes</span>
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
									</ul>
								</div>



							</nav>
						</div>
						<div class="col-xl-2 col-lg-3 col-9 text-right">
							<ul class="header-toolbar">
								<li class="header-toolbar__item"><a href="wishlist.html"
									class="header-toolbar__btn"> <i
										class="flaticon flaticon-like"></i>
								</a></li>
								<li class="header-toolbar__item mini-cart-item"><a
									href="#miniCart"
									class="header-toolbar__btn toolbar-btn mini-cart-btn"> <i
										class="flaticon flaticon-shopping-cart"></i> <sup
										class="mini-cart-count">2</sup>
								</a></li>
								<li class="header-toolbar__item user-info"><a href=""
									class="header-toolbar__btn"> <i
										class="flaticon flaticon-user"></i>
								</a>
									<ul class="user-info-menu">
										<li><a href="my-account.html">My Account</a></li>
										<li><a href="cart.html">Shopping Cart</a></li>
										<li><a href="checkout.html">Check Out</a></li>
										<li><a href="wishlist.html">Wishlist</a></li>
										<li><a href="order-tracking.html">Order tracking</a></li>
										<li><a href="compare.html">compare</a></li>
									</ul></li>
								<li class="header-toolbar__item"><a href="#searchForm"
									class="header-toolbar__btn toolbar-btn"> <i
										class="flaticon flaticon-search"></i>
								</a></li>
								<li class="header-toolbar__item d-lg-none"><a href="#"
									class="header-toolbar__btn menu-btn"> <i class="fa fa-bars"></i>
								</a></li>
								
								
	<div class="global-search">
      <form id="search-Form" action="#">
        <input placeholder="輸入關鍵字" type="text" class="hot-input">
        <button class="submit-search">
          <i class="fa fa-search"></i>
        </button>
      </form>
    </div>
    
    
							</ul>
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

		<!-- Breadcrumb area Start -->
		<div class="breadcrumb-area bg-color ptb--90" data-bg-color="#f6f6f6">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<div
							class="d-flex justify-content-between align-items-center flex-sm-row flex-column">
							<h1 class="page-title">Shop</h1>
							<ul class="breadcrumb"> 							
								<li><a href="<c:url value="/MainShopServlet"/>">Home</a></li>
								<li class="current"><span>Shop</span></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Breadcrumb area End -->

		<!-- Main Content Wrapper Start -->
		<div class="main-content-wrapper">
			<div class="shop-page-wrapper ptb--80">
				<div class="container">
					<div class="row">
						<div class="col-12">
							<div class="shop-toolbar mb--50">
								
							</div>
							<div class="shop-products">
								<div class="row">


								<c:forEach var="brand" items="${product}">
									<div class="col-xl-3 col-lg-4 col-sm-6 mb--50">
										<div class="zakas-product">
											<div class="product-inner">
												<figure class="product-image">
													<a href="<c:url value="/ShopDetailServlet?productName=${brand.productName}&color=${brand.colorType}"/>"> <img
														src="<c:url value="/ImageSevlet?id=${brand.productImgId}&photo_data=1"/>"
														alt="Products">
													</a>
													
												</figure>
												<div class="product-info">
													<h3 class="product-title mb--15">
													
														<a
															href="<c:url value="/ShopDetailServlet?productName=${brand.productName}&color=${brand.colorType}"/>">${brand.productName}</a>
													</h3>
													<div class="product-price-wrapper mb--30">
														<span class="money">NT.${brand.price}</span>
													</div>
													
												</div>
											</div>
										</div>
									</div>
								</c:forEach>





								</div>
							</div>
							<nav class="pagination-wrap">
								<ul class="pagination">
									<li><a href="#" class="prev page-number"><i
											class="fa fa-angle-double-left"></i></a></li>
									<li><span class="current page-number">1</span></li>
									<li><a href="#" class="page-number">2</a></li>
									<li><a href="#" class="page-number">3</a></li>
									<li><a href="#" class="next page-number"><i
											class="fa fa-angle-double-right"></i></a></li>
								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Main Content Wrapper Start -->

		<!-- Footer Start-->
		<footer class="footer">
			<div class="footer-top bg-color ptb--50" data-bg-color="#f6f6f6">
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-9 text-center">
							<div class="footer-widget mb--50">
								<div class="textwidget">
									<img src="<c:url value="/img/logo/logo.png"/>" alt="Logo">
								</div>
							</div>
							<div class="footer-widget mb--50 pb--1">
								<ul class="footer-menu">
									<li><a href="">About Us</a></li>
									<li><a href="">Terms &amp; Conditions</a></li>
									<li><a href="">Policy</a></li>
									<li><a href="">Help</a></li>
									<li><a href="">Contact Us</a></li>
								</ul>
							</div>
							<div class="footer-widget">
								<!-- Social Icons Start Here -->
								<ul class="social">
									<li class="social__item"><a
										href="https://plus.google.com/"
										class="social__link google-plus"> <span>Google Plus</span>
											<i class="fa fa-google-plus"></i>
									</a></li>
									<li class="social__item"><a href="https://facebook.com/"
										class="social__link facebook"> <span>facebook</span> <i
											class="fa fa-facebook"></i>
									</a></li>
									<li class="social__item"><a href="https://pinterest.com"
										class="social__link pinterest"> <span>pinterest</span> <i
											class="fa fa-pinterest-p"></i>
									</a></li>
									<li class="social__item"><a href="youtube.com"
										class="social__link twitter"> <span>twitter</span> <i
											class="fa fa-twitter"></i>
									</a></li>
								</ul>
								<!-- Social Icons End Here -->
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="footer-bottom bg-color ptb--25" data-bg-color="#e7e7e7">
				<div class="container">
					<div class="row align-items-center">
						<div class="col-sm-6 text-sm-left text-center mb-xs--10">
							<p class="copyright-text">
								<a href="index.html">Zakas</a> &copy; 2019 all rights reserved
							</p>
						</div>
						<div class="col-sm-6 text-sm-right text-center">
							<figure>
								<img src="<c:url value="/img/others/payment.png"/>"
									alt="payment">
							</figure>
						</div>
					</div>
				</div>
			</div>
		</footer>
		<!-- Footer End-->

		<!-- Searchform Popup Start -->
		<div class="searchform__popup" id="searchForm">
			<a href="#" class="btn-close"><i class="flaticon flaticon-cross"></i></a>
			<div class="searchform__body">
				<p>Start typing and press Enter to search</p>
				<form class="searchform">
					<input type="text" name="popup-search" id="popup-search"
						class="searchform__input" placeholder="Search Entire Store...">
					<button type="submit" class="searchform__submit">
						<i class="flaticon flaticon-magnifying-glass-icon"></i>
					</button>
				</form>
			</div>
		</div>
		<!-- Searchform Popup End -->

		<!-- Mini Cart Start -->
		<aside class="mini-cart" id="miniCart">
			<div class="mini-cart-wrapper">
				<a href="" class="btn-close"><i class="flaticon flaticon-cross"></i></a>
				<div class="mini-cart-inner">
					<h3 class="mini-cart__heading mb--40 mb-lg--30">Shopping Cart</h3>
					<div class="mini-cart__content">
						<ul class="mini-cart__list">
							<li class="mini-cart__product"><a href="#"
								class="remove-from-cart remove"> <i
									class="flaticon flaticon-cross"></i>
							</a>
								<div class="mini-cart__product__image">
									<img src="<c:url value="/img/products/prod-1-100x100.jpg"/>"
										alt="products">
								</div>
								<div class="mini-cart__product__content">
									<a class="mini-cart__product__title"
										href="product-details.html">Chain print bermuda shorts </a> <span
										class="mini-cart__product__quantity">1 x $49.00</span>
								</div></li>
							<li class="mini-cart__product"><a href="#"
								class="remove-from-cart remove"> <i
									class="flaticon flaticon-cross"></i>
							</a>
								<div class="mini-cart__product__image">
									<img src="<c:url value="/img/products/prod-2-100x100.jpg"/>"
										alt="products">
								</div>
								<div class="mini-cart__product__content">
									<a class="mini-cart__product__title"
										href="product-details.html">Waxed-effect pleated skirt</a> <span
										class="mini-cart__product__quantity">1 x $49.00</span>
								</div></li>
							<li class="mini-cart__product"><a href="#"
								class="remove-from-cart remove"> <i
									class="flaticon flaticon-cross"></i>
							</a>
								<div class="mini-cart__product__image">
									<img src="<c:url value="/img/products/prod-5-100x100.jpg"/>"
										alt="products">
								</div>
								<div class="mini-cart__product__content">
									<a class="mini-cart__product__title"
										href="product-details.html">Waxed-effect pleated skirt</a> <span
										class="mini-cart__product__quantity">1 x $49.00</span>
								</div></li>
						</ul>
						<div class="mini-cart__total">
							<span>Subtotal</span> <span class="ammount">$98.00</span>
						</div>
						<div class="mini-cart__buttons">
							<a href="cart.html" class="btn btn-fullwidth btn-bg-sand mb--20">View
								Cart</a> <a href="checkout.html"
								class="btn btn-fullwidth btn-bg-sand">Checkout</a>
						</div>
					</div>
				</div>
			</div>
		</aside>
		<!-- Mini Cart End -->

		<!-- Global Overlay Start -->
		<div class="zakas-global-overlay"></div>
		<!-- Global Overlay End -->

		<!-- Qicuk View Modal Start -->
		<div class="modal fade product-modal" id="productModal" tabindex="-1"
			role="dialog" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-body">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true"><i
								class="flaticon flaticon-cross"></i></span>
						</button>
						<div class="row">
							<div class="col-lg-6">
								<div class="zakas-element-carousel nav-vertical-center"
									data-slick-options='{
                            "slidesToShow": 1,
                            "slidesToScroll": 1,
                            "arrows": true,
                            "prevArrow": {"buttonClass": "slick-btn slick-prev", "iconClass": "fa fa-angle-double-left" },
                            "nextArrow": {"buttonClass": "slick-btn slick-next", "iconClass": "fa fa-angle-double-right" }
                        }'>
									<div class="product-image">
										<div class="product-image--holder">
											<a href="product-details.html"> <img
												src="<c:url value="/img/products/prod-9-1.jpg"/>"
												alt="Product Image" class="primary-image">
											</a>
										</div>
										<span class="product-badge sale">sale</span>
									</div>
									<div class="product-image">
										<div class="product-image--holder">
											<a href="product-details.html"> <img
												src="<c:url value="/img/products/prod-9-1.jpg"/>"
												alt="Product Image" class="primary-image">
											</a>
										</div>
										<span class="product-badge sale">sale</span>
									</div>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="modal-box product-summary">
									<div class="product-navigation text-right mb--20">
										<a href="#" class="prev"><i
											class="fa fa-angle-double-left"></i></a> <a href="#" class="next"><i
											class="fa fa-angle-double-right"></i></a>
									</div>
									<div class="product-rating d-flex mb--20">
										<div class="star-rating star-three">
											<span>Rated <strong class="rating">5.00</strong> out
												of 5
											</span>
										</div>
									</div>
									<h3 class="product-title mb--20">Black Blazer</h3>
									<p class="product-short-description mb--25">Donec accumsan
										auctor iaculis. Sed suscipit arcu ligula, at egestas magna
										molestie a. Proin ac ex maximus, ultrices justo eget, sodales
										orci. Aliquam egestas libero ac turpis pharetra, in vehicula
										lacus scelerisque. Vestibulum ut sem laoreet, feugiat tellus
										at, hendrerit arcu.</p>
									<div class="product-price-wrapper mb--25">
										<span class="money">$200.00</span> <span
											class="price-separator">-</span> <span class="money">$400.00</span>
									</div>
									<form action="#" class="variation-form mb--30">
										<div
											class="product-color-variations d-flex align-items-center mb--20">
											<p class="variation-label">Color:</p>
											<div class="product-color-variation variation-wrapper">
												<div class="variation">
													<a class="product-color-variation-btn red selected"
														data-toggle="tooltip" data-placement="top" title="Red">
														<span class="product-color-variation-label">Red</span>
													</a>
												</div>
												<div class="variation">
													<a class="product-color-variation-btn black"
														data-toggle="tooltip" data-placement="top" title="Black">
														<span class="product-color-variation-label">Black</span>
													</a>
												</div>
												<div class="variation">
													<a class="product-color-variation-btn pink"
														data-toggle="tooltip" data-placement="top" title="Pink">
														<span class="product-color-variation-label">Pink</span>
													</a>
												</div>
												<div class="variation">
													<a class="product-color-variation-btn blue"
														data-toggle="tooltip" data-placement="top" title="Blue">
														<span class="product-color-variation-label">Blue</span>
													</a>
												</div>
											</div>
										</div>
										<div
											class="product-size-variations d-flex align-items-center mb--15">
											<p class="variation-label">Size:</p>
											<div class="product-size-variation variation-wrapper">
												<div class="variation">
													<a class="product-size-variation-btn selected"
														data-toggle="tooltip" data-placement="top" title="S">
														<span class="product-size-variation-label">S</span>
													</a>
												</div>
												<div class="variation">
													<a class="product-size-variation-btn" data-toggle="tooltip"
														data-placement="top" title="M"> <span
														class="product-size-variation-label">M</span>
													</a>
												</div>
												<div class="variation">
													<a class="product-size-variation-btn" data-toggle="tooltip"
														data-placement="top" title="L"> <span
														class="product-size-variation-label">L</span>
													</a>
												</div>
												<div class="variation">
													<a class="product-size-variation-btn" data-toggle="tooltip"
														data-placement="top" title="XL"> <span
														class="product-size-variation-label">XL</span>
													</a>
												</div>
											</div>
										</div>
										<a href="" class="reset_variations">Clear</a>
									</form>
									<div
										class="product-action d-flex flex-sm-row flex-column align-items-sm-center align-items-start mb--30">
										<div
											class="quantity-wrapper d-flex align-items-center mr--30 mr-xs--0 mb-xs--30">
											<label class="quantity-label" for="quick-qty">Quantity:</label>
											<div class="quantity">
												<input type="number" class="quantity-input" name="qty"
													id="quick-qty" value="1" min="1">
											</div>
										</div>
										<button type="button"
											class="btn btn-small btn-bg-red btn-color-white btn-hover-2"
											onclick="window.location.href='cart.html'">Add To
											Cart</button>
									</div>
									<div class="product-footer-meta">
										<p>
											<span>Category:</span> <a href="shop.html">Full Sweater</a>,
											<a href="shop.html">SweatShirt</a>, <a href="shop.html">Jacket</a>,
											<a href="shop.html">Blazer</a>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Qicuk View Modal End -->
	</div>
	<!-- Main Wrapper End -->


	<!-- ************************* JS Files ************************* -->

	<!-- jQuery JS -->
	<script src="<c:url value="/js/vendor.js"/>"></script>

	<!-- Main JS -->
	<script src="<c:url value="/js/main.js"/>"></script>

</body>

</html>