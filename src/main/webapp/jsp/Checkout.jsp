<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!doctype html>
<html class="no-js" lang="zxx">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<jsp:include page="/jsp/pluginsJs.jsp"></jsp:include>
<title>Zakas - Fashion eCommerce Bootstrap 4 Template</title>
<meta name="description" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicons -->
<link rel="shortcut icon" href="<c:url value="/img/favicon.ico"/>"
	type="image/x-icon">
<link rel="apple-touch-icon" href="<c:url value="/img/icon.png"/>">

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


</style>

</head>

<body>
<!-- Header Start -->
	<header class="header">
		<input type="hidden" value='${productJson}'/>
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
										class="mainmenu__link"> <span class="mm-text">�Ҧ��ӫ~</span>
									</a></li>

									<li class="mainmenu__item menu-item-has-children"><a
										href="<c:url value="/ShopServlet?type=Women"/>"
										class="mainmenu__link"> <span class="mm-text">�k��</span>
									</a>
										<ul class="sub-menu"">
											<li><a
												href="<c:url value="/ShopServlet?type=WomenTop"/>"> <span
													class="mm-text">�W�� Top</span>
											</a></li>
											<li><a
												href="<c:url value="/ShopServlet?type=WomenBottom"/>"> <span
													class="mm-text">�U�� Bottom</span>
											</a></li>
										</ul></li>

									<li class="mainmenu__item menu-item-has-children"><a
										href="<c:url value="/ShopServlet?type=Men"/>"
										class="mainmenu__link"> <span class="mm-text">�k��</span>
									</a>
										<ul class="sub-menu">
											<li><a href="<c:url value="/ShopServlet?type=MenTop"/>">
													<span class="mm-text">�W�� Top</span>
											</a></li>
											<li><a
												href="<c:url value="/ShopServlet?type=MenBottom"/>"> <span
													class="mm-text">�U�� Bottom</span>
											</a></li>
										</ul></li>


									<li class="mainmenu__item menu-item-has-children"><a
										href="<c:url value="/ShopServlet?type=Shoes"/>"
										class="mainmenu__link"> <span class="mm-text">�c�l</span>
									</a>
										<ul class="sub-menu">
											<li><a
												href="<c:url value="/ShopServlet?type=WomenShoes"/>"> <span
													class="mm-text">�k�c women's shoes</span>
											</a></li>
											<li><a
												href="<c:url value="/ShopServlet?type=MenShoes"/>"> <span
													class="mm-text">�k�c Men's shoes</span>
											</a></li>
										</ul></li>
									<li class="mainmenu__item menu-item-has-children"><a
										href="<c:url value="/ShopServlet?type=Accessories"/>"
										class="mainmenu__link"> <span class="mm-text">���~</span>
									</a></li>
									<li class="mainmenu__item menu-item-has-children"><a
										href="<c:url value="/ShopServlet?type=Others"/>"
										class="mainmenu__link"> <span class="mm-text">��L�P��</span>
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
		<div class="breadcrumb-area bg-color ptb--90" data-bg-color="#f6f6f6">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<div
							class="d-flex justify-content-between align-items-center flex-sm-row flex-column">
							<h1 class="page-title">Checkout</h1>
							<ul class="breadcrumb">
								<li><a href="index.html">Home</a></li>
								<li class="current"><span>Checkout</span></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Breadcrumb area End -->

		<!-- Main Content Wrapper Start -->
		<div class="main-content-wrapper">
			<div class="page-content-inner">
				<div class="container">
					<div class="row pt--50 pt-md--40 pt-sm--20">
						<div class="col-12">
							
						</div>
					</div>
					<div class="row pb--80 pb-md--60 pb-sm--40">
						<!-- Checkout Area Start -->
						<div class="col-xl-5 offset-xl-1 col-lg-6 mt-md--40">
							<div class="order-details">
								<div class="checkout-title mt--10">
									<h2>�q�����</h2>
								</div>
								<div class="table-content table-responsive mb--30">
									<table class="table order-table order-table-2">
										<thead>
											<tr>
												<th >�ӫ~��T</th>
												<th>�C��</th>
												<th>�ؤo</th>
												<th>�ƶq</th>
												<th class="text-right">���B</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<th>�ξA��¦�˥~�M</th>
												<th>��</th>
												<th>S</th>
												<th>1</th>
												<td class="text-right">NT.1280.0</td>
											</tr>
											<tr>
												<th>�y���e�}Ю�������J�� <strong><span>&#10005;</span>1</strong>
												</th>
												<td class="text-right">NT.1680.0</td>
											</tr>
										</tbody>
										<tfoot>
											<tr class="cart-subtotal">
												<th>Subtotal</th>
												<td class="text-right">$56.00</td>
											</tr>
											<tr class="shipping">
												<th>Shipping</th>
												<td class="text-right"><span>Flat Rate; $20.00</span></td>
											</tr>
											<tr class="order-total">
												<th>Order Total</th>
												<td class="text-right"><span
													class="order-total-ammount">$56.00</span></td>
											</tr>
										</tfoot>
									</table>
								</div>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="checkout-title mt--10">
								<h2>��g�B�e���</h2>
							</div>
							<div class="checkout-form">
								<form action="#" class="form form--checkout">
									<div class="form-row mb--20">
										<div class="form__group col-md-6 mb-sm--30">
											<label for="billing_fname" class="form__label form__label--2">�m�W<span
												class="required">*</span></label> <input type="text"
												name="billing_fname" id="billing_fname"
												class="form__input form__input--2">
										</div>

									</div>
									<div class="form-row mb--20">
										<div class="form__group col-12">
											<label for="billing_phone" class="form__label form__label--2">���<span
												class="required">*</span></label> <input type="text"
												name="billing_phone" id="billing_phone"
												class="form__input form__input--2">
										</div>
									</div>
									<li style="list-style-type: none;"><label
										for="billing_phone" class="form__label form__label--2">�a�}<span
											class="required">*</span></label>
										<div>
											<div class="clearfix">
												<div class="float-left mb-2 mr-2">
													<div class="controls-float">
														<select name="city" aria-invalid="false"
															style="color: #707070"
															class="floatLabel text select-icon valid form__input form__input--2">
															<option value="�O�_��">�O�_��</option>
															<option value="�򶩥�">�򶩥�</option>
															<option value="�s�_��">�s�_��</option>
															<option value="�y����">�y����</option>
															<option value="�s�˥�">�s�˥�</option>
															<option value="�s�˿�">�s�˿�</option>
															<option value="��饫">��饫</option>
															<option value="�]�߿�">�]�߿�</option>
															<option value="�O����">�O����</option>
															<option value="���ƿ�">���ƿ�</option>
															<option value="�n�뿤">�n�뿤</option>
															<option value="�Ÿq��">�Ÿq��</option>
															<option value="�Ÿq��">�Ÿq��</option>
															<option value="���L��">���L��</option>
															<option value="�O�n��">�O�n��</option>
															<option value="������">������</option>
															<option value="���">���</option>
															<option value="�̪F��">�̪F��</option>
															<option value="�O�F��">�O�F��</option>
															<option value="�Ὤ��">�Ὤ��</option>
															<option value="������">������</option>
															<option value="�s����">�s����</option>
														</select>
													</div>
												</div>
												<div class="float-left mb-2">
													<div class="controls-float">
														<select name="district" aria-invalid="false"
															style="color: #707070"
															class="floatLabel text select-icon valid  form__input form__input--2"><option
																value="�U����">207 �U����</option>
															<option value="���s��">208 ���s��</option>
															<option value="�O����">220 �O����</option>
															<option value="�����">221 �����</option>
															<option value="�`�|��">222 �`�|��</option>
															<option value="�����">223 �����</option>
															<option value="��ڰ�">224 ��ڰ�</option>
															<option value="���˰�">226 ���˰�</option>
															<option value="���˰�">227 ���˰�</option>
															<option value="�^�d��">228 �^�d��</option>
															<option value="�s����">231 �s����</option>
															<option value="�W�L��">232 �W�L��</option>
															<option value="�Q�Ӱ�">233 �Q�Ӱ�</option>
															<option value="�éM��">234 �éM��</option>
															<option value="���M��">235 ���M��</option>
															<option value="�g����">236 �g����</option>
															<option value="�T�l��">237 �T�l��</option>
															<option value="��L��">238 ��L��</option>
															<option value="�a�q��">239 �a�q��</option>
															<option value="�T����">241 �T����</option>
															<option value="�s����">242 �s����</option>
															<option value="���s��">243 ���s��</option>
															<option value="�L�f��">244 �L�f��</option>
															<option value="Ī�w��">247 Ī�w��</option>
															<option value="���Ѱ�">248 ���Ѱ�</option>
															<option value="�K����">249 �K����</option>
															<option value="�H����">251 �H����</option>
															<option value="�T�۰�">252 �T�۰�</option>
															<option value="�۪���">253 �۪���</option></select>
													</div>
													<input name="zipcode" placeholder="�l���ϸ�" type="hidden"
														value="221">
												</div>
											</div>
											<div class="clearfix">
												<div>
													<div class="controls-float">
														<input type="text" name="address" placeholder="�п�J�a�}"
															required="required" class="form__input form__input--2">
														<label for="address"></label>
													</div>
												</div>
											</div>
										</div></li>

									<div class="form-row mb--20">
										<div class="form__group col-12">
											<label for="billing_email" class="form__label form__label--2">Email</label>
											<input type="email" name="billing_email" id="billing_email"
												class="form__input form__input--2">
										</div>
									</div>
									
									<div class="checkout-payment">
										<div class="payment-group mb--10">
											<div class="payment-radio">
												<input type="radio" value="fax" checked> <label>�v�t</label>
											</div>
											
										</div>
										<div class="payment-group mb--10">
											<div class="payment-radio">
												<input type="radio" value="cheque" name="payment-method"
													id="cheque"> <label class="payment-label"
													for="cheque"> �f��I�� </label>
											</div>
											
										</div>
										<div class="payment-group mb--10">
											<div class="payment-radio">
												<input type="radio" value="cash" name="payment-method"
													id="cash"> <label class="payment-label" for="cash">
													�u�W��d </label>
											</div>
											
										</div>
										<div class="payment-group mt--20">
											<p class="mb--15" style="font-size:20px; font-weight: bold;" >Notice</p>
											<p>���U��e�ЦA���T�{�z���ʶR���Ӥΰt�e��T�A�q�榨�߫�L�k���ʭq�椺�e</p>
											<button type="submit"
												class="btn btn-fullwidth btn-bg-red btn-color-white btn-hover-2">Place
												Order</button>
										</div>

									</div>
								</form>
							</div>
						</div>
						
						<!-- Checkout Area End -->
						<div class="cart-buttons">
							<a class="btn btn--l" href="/zh-tw/checkout"><span
								class="d-inline-block align-middle">PREV</span></a> <input
								class="btn btn--black btn--l btn-next" id="btn-go-checkoutbtn"
								type="submit" value="NEXT >">
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