<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!doctype html>
<html class="no-js" lang="zxx">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<!-- 把jQurey統一匯進來 -->
<jsp:include page="/jsp/pluginsJs.jsp"></jsp:include>
<title>Ocean</title>
<meta name="description" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicons -->
<link rel="shortcut icon" href="<c:url value="/img/favicon.ico"/>"
	type="image/x-icon">
<link rel="apple-touch-icon" href="<c:url value="/img/icon.png"/>">


<script type="text/javascript" src="<c:url value="/js/checkoutToOrder.js"/>"></script>
<!-- ************************* CSS Files ************************* -->

<!-- Vendor CSS -->
<link rel="stylesheet" href="<c:url value="/css/vendor.css"/>">

<!-- style css -->
<link rel="stylesheet" href="<c:url value="/css/main.css"/>">

<style>
.cart-section {
	padding: 64px 0 40px
}

select {
	margin: 0;
	padding: 0 8px 0 3px;
	height: 30px;
	border: 1px solid #c5c5c5;
	color: #656565;
	background-color: #fff;
	vertical-align: top;
	text-align: center;
	box-sizing: border-box;
}

.selection {
	position: relative;
	display: inline-block;
	vertical-align: top;
}

.form__label {
	color: #707070;
	font-size: 16px;
	font-weight: 500;
}

.table thead th, .table th {
	text-transform: uppercase;
	padding: 13px 13px;
	letter-spacing: 1px;
	font-weight: 400;
	font-size: 16px;
	border: 0px solid #eeeeee;
	vertical-align: middle;
}

.order-table thead th {
	color: #111111;
	padding: 0;
}

.order-table thead th {
	font-weight: bold;
	font-size: 18px;
}

.order-table {
	border-collapse: separate;
	border-spacing: 0;
	width: 100%;
}

.order-table th, .order-table td {
	padding: 1px;
	border: none;
	position: relative;
}

.order-table .comIdOne td {
	padding-top: 0;
}

.order-table tfoot th, .order-table tfoot td {
	padding: 5px;
	border-top: none;
	background-color: #f2f2f2;
}
</style>

</head>

<body>
	<!-- Header Start -->
	<header class="header">
		<input type="hidden" value='${productJson}' />
		<jsp:include page="/jsp/SelectBar.jsp"></jsp:include>
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
											<li><a
												href="<c:url value="/ShopServlet?type=WomenTop"/>"> <span
													class="mm-text">上衣 Top</span>
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




		<!-- Breadcrumb area Start -->

		<!-- Breadcrumb area End -->

		<!-- Main Content Wrapper Start -->
		<div class="main-content-wrapper">
			<div class="page-content-inner">
				<div class="container">
					<div class="row pt--50 pt-md--40 pt-sm--20">
						<div class="col-12"></div>
					</div>
					<div class="row pb--80 pb-md--60 pb-sm--40">
						<!-- Checkout Area Start -->
						<div class="col mt-md--40">
							<div class="order-details">
								<div class="checkout-title mt--10">
									<h2>訂單明細</h2>
								</div>
								<div class="table-content table-responsive mb--30">
									<table class="table order-table order-table-2">
										<thead>
											<tr>
												<th><strong>商品資訊</strong></th>
												<th><strong>顏色</strong></th>
												<th><strong>尺寸</strong></th>
												<th><strong>數量</strong></th>
												<th class="text-right"><strong>金額</strong></th>
											</tr>
											<tr class="comIdOne">
												<td colspan="8"><hr></td>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="productList" items="${productList}">
											<tr>
												<th>${productList.prodName}</th>
												<th>${productList.selectedColor}</th>
												<th>${productList.selectedSize}</th>
												<th>${productList.quantityValue}</th>
												<td class="text-right">NT.${productList.price}</td>
											</tr>
										</c:forEach>	
											<tr class="comIdOne">
												<td colspan="8"><hr></td>
											</tr>

										</tbody>
										<tfoot>

											<tr class="Items">
												<th>商品件數</th>
												<th></th>
												<th></th>
												<th></th>
												<td class="text-right"><span class="Items-ammount">${checkoutVo.itemCountText}</span></td>
											</tr>
											<tr class="order-total">
												<th>總金額</th>
												<th></th>
												<th></th>
												<th></th>
												<td class="text-right"><span class="Items-ammount">${checkoutVo.totalAmountText}</span></td>
											</tr>
											<tr class="shipping">
												<th>運費</th>
												<th></th>
												<th></th>
												<th></th>
												<td class="text-right"><span class="shipping-ammount">${checkoutVo.shippingCostText}</span></td>
											</tr>
											<tr class="Payable">
												<th>應付金額</th>
												<th></th>
												<th></th>
												<th></th>
												<td class="text-right"><span class="Payable-ammount">${checkoutVo.payableAmountText}</span></td>
											</tr>
										</tfoot>
									</table>
								</div>
							</div>
						</div>
						<div class="col-lg-12">
							<div class="order-details">
								<div class="checkout-title mt--10">
									<h2>填寫運送資料</h2>
								</div>
								<div class="checkout-form">
								
									<form id="mainForm" action="<c:url value="/OrdersServlet"/>" method="post">
									<input type="hidden" name="productJson" value='${productJson}' />
									<input type="hidden" name="checkoutJson" value='${checkoutJson}' />
									<input id="transportInfoJson" type="hidden" name="transportInfoJson">								
										<div class="form-row mb--20">
											<div class="form__group col-md-6 mb-sm--30">
												<label for="billing_fname"
													class="form__label form__label--2">姓名<span
													class="required">*</span></label> <input type="text"
													name="billing_fname" id="billing_fname"
													class="form__input form__input--2">
											</div>
										</div>
										<div class="form-row mb--20">
											<div class="form__group col-12">
												<label for="billing_phone"
													class="form__label form__label--2">手機<span
													class="required">*</span></label> <input type="text"
													name="billing_phone" id="billing_phone"
													class="form__input form__input--2">
											</div>
										</div>
										<li style="list-style-type: none;"><label
											for="billing_phone" class="form__label form__label--2">地址<span
												class="required">*</span></label>
											<div>
												<div class="clearfix">
													<div class="float-left mb-2 mr-2">
														<div class="controls-float">
															<select name="city" aria-invalid="false"
																style="color: #707070"
																class="floatLabel text select-icon valid form__input form__input--2">
																<option value="臺北市">臺北市</option>
																<option value="基隆市">基隆市</option>
																<option value="新北市">新北市</option>
																<option value="宜蘭縣">宜蘭縣</option>
																<option value="新竹市">新竹市</option>
																<option value="新竹縣">新竹縣</option>
																<option value="桃園市">桃園市</option>
																<option value="苗栗縣">苗栗縣</option>
																<option value="臺中市">臺中市</option>
																<option value="彰化縣">彰化縣</option>
																<option value="南投縣">南投縣</option>
																<option value="嘉義市">嘉義市</option>
																<option value="嘉義縣">嘉義縣</option>
																<option value="雲林縣">雲林縣</option>
																<option value="臺南市">臺南市</option>
																<option value="高雄市">高雄市</option>
																<option value="澎湖縣">澎湖縣</option>
																<option value="屏東縣">屏東縣</option>
																<option value="臺東縣">臺東縣</option>
																<option value="花蓮縣">花蓮縣</option>
																<option value="金門縣">金門縣</option>
																<option value="連江縣">連江縣</option>
															</select>
														</div>
													</div>
													<div class="float-left mb-2">
														<div class="controls-float">
															<select name="district" aria-invalid="false"
																style="color: #707070"
																class="floatLabel text select-icon valid  form__input form__input--2"><option
																	value="萬里區">207 萬里區</option>
																<option value="金山區">208 金山區</option>
																<option value="板橋區">220 板橋區</option>
																<option value="汐止區">221 汐止區</option>
																<option value="深坑區">222 深坑區</option>
																<option value="石碇區">223 石碇區</option>
																<option value="瑞芳區">224 瑞芳區</option>
																<option value="平溪區">226 平溪區</option>
																<option value="雙溪區">227 雙溪區</option>
																<option value="貢寮區">228 貢寮區</option>
																<option value="新店區">231 新店區</option>
																<option value="坪林區">232 坪林區</option>
																<option value="烏來區">233 烏來區</option>
																<option value="永和區">234 永和區</option>
																<option value="中和區">235 中和區</option>
																<option value="土城區">236 土城區</option>
																<option value="三峽區">237 三峽區</option>
																<option value="樹林區">238 樹林區</option>
																<option value="鶯歌區">239 鶯歌區</option>
																<option value="三重區">241 三重區</option>
																<option value="新莊區">242 新莊區</option>
																<option value="泰山區">243 泰山區</option>
																<option value="林口區">244 林口區</option>
																<option value="蘆洲區">247 蘆洲區</option>
																<option value="五股區">248 五股區</option>
																<option value="八里區">249 八里區</option>
																<option value="淡水區">251 淡水區</option>
																<option value="三芝區">252 三芝區</option>
																<option value="石門區">253 石門區</option></select>
														</div>
														<input name="zipcode" placeholder="郵遞區號" type="hidden"
															value="221">
													</div>
												</div>
												<div class="clearfix">
													<div>
														<div class="controls-float">
															<input type="text" name="address" placeholder="請輸入地址"
																required="required" class="form__input form__input--2">
															<label for="address"></label>
														</div>
													</div>
												</div>
											</div></li>
										<div class="form-row mb--20">
											<div class="form__group col-12">
												<label for="billing_email"
													class="form__label form__label--2">Email</label> <input
													type="email" name="billing_email" id="billing_email"
													class="form__input form__input--2">
											</div>
										</div>
										<div class="checkout-payment">
											<div class="payment-group mb--10">
												<div class="payment-radio">
													<input type="radio" value="fax" name="delivery-method" checked > <label>宅配</label>
												</div>
											</div>
											<div class="payment-group mb--10">
												<div class="payment-radio">
													<input type="radio" value="cheque" name="payment-method"
														id="cheque"> <label class="payment-label"
														for="cheque"> 貨到付款 </label>
												</div>
											</div>
											<div class="payment-group mb--10">
												<div class="payment-radio">
													<input type="radio" value="cash" name="payment-method"
														id="cash"> <label class="payment-label" for="cash">
														線上刷卡 </label>
												</div>
											</div>
											<div class="payment-group mt--20">
												<p class="mb--15"
													style="font-size: 20px; font-weight: bold;">Notice</p>
												<p>※下單前請再次確認您的購買明細及配送資訊，訂單成立後無法異動訂單內容</p>
												<input id="submitBtn" type="button" value="Place Order"
													class="btn btn-fullwidth btn-bg-red btn-color-white btn-hover-2"></input>
											</div>
										</div>
									</form>
								</div>
							</div>
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
												src=" <c:url value="/img/products/prod-9-1.jpg"/>"
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