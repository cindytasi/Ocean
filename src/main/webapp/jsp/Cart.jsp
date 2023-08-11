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
<title>Zakas - Fashion eCommerce Bootstrap 4 Template</title>
<meta name="description" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicons -->
<link rel="shortcut icon" href="<c:url value="/img/favicon.ico"/>"
	type="image/x-icon">
<link rel="apple-touch-icon" href="/img/icon.png">

<!-- ************************* CSS Files ************************* -->

<!-- Vendor CSS -->

<link rel="stylesheet" href="<c:url value="/css/vendor.css"/>">

<!-- style css -->

<link rel="stylesheet" href="<c:url value="/css/main.css"/>">
<script type="text/javascript" src="<c:url value="/js/delAddRedis.js"/>"></script>
    
    
    <style>   
    .cart-form__btn{
    	border: 1px solid;
    	color: #666666;
    }
    
    .cart-calculator span{
    	font-size:15px;
    	color: #666666;
    }
    
    .prodInfo{
    	font-size:15px;
    }
    .custom-cart-box {
    width: 50%; /* 設置寬度為畫面寬度的一半 */
    margin-left: auto; /* 將左側外邊距設置為auto，使其往右移動 */
     margin-top: 20px; /* 調整上方外邊距，往下移動 20 像素 */
	}
	 
	.product-remove, .product-thumbnail {
    padding-left: 10px; /* 調整左側內邊距，水平向左偏移 10 像素 */
	}

</style>



</head>

<body>

    <!-- Preloader Start -->
    <div class="zakas-preloader active">
        <div class="zakas-preloader-inner h-100 d-flex align-items-center justify-content-center">
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

       

        <!-- Main Content Wrapper Start -->
        <div class="main-content-wrapper">
            <div class="page-content-inner ptb--80">
                <div class="container">
                    <div >
                        <div class="col-lg-8 mb-md--50">
							<div class="row no-gutters">
								<div class="col-12">
									<div class="table-content table-responsive">
										<table class="table text-center">
											<thead>
												<tr>
													<th>&nbsp;</th>
													<th>&nbsp;</th>
													<th style="font-size: 15px" class="prodInfo text-left">商品資訊</th>
													<th style="font-size: 15px">顏色</th>
													<th style="font-size: 15px">尺寸</th>
													<th style="font-size: 15px">單價</th>
													<th style="font-size: 15px">數量</th>
													<th style="font-size: 15px">小計</th>
												</tr>
											</thead>
											<tbody class="productAll">

												<c:forEach var="shopCartGroupByComIdList" items="${prod}">

													<tr class="comIdOne"
														data-comid="${shopCartGroupByComIdList[0].productcomId}">
														<td colspan="8"><hr></td>
													</tr>
													<tr class="comIdOne"
														data-comid="${shopCartGroupByComIdList[0].productcomId}">
														<td colspan="1">
															<div class="seller-box">
																<span class="seller-label">廠商:${shopCartGroupByComIdList[0].productcomId}</span>
															</div>
														</td>
													</tr>

													<c:forEach var="shopCart"
														items="${shopCartGroupByComIdList}">

														<tr class="productInfo" comid="${shopCart.productcomId}">
															<input class="productId" type="hidden"
																value="${shopCart.productId}" />
															<input class="productcomId" type="hidden"
																value="${shopCart.productcomId}" />
															<input class="inStock" type="hidden"
																value="${shopCart.inStock}" />
															<td class="product-remove text-left"><a><i
																	class="flaticon flaticon-cross toDoAction"
																	type="delete"></i></a></td>
															<td class="product-thumbnail text-left"><a
																href="<c:url value="/ShopDetailServlet?productName=${shopCart.prodName}&color=${shopCart.selectedColor}"/>"><img
																	class="productImgId" value="${shopCart.productImgId}"
																	src="<c:url value="/ImageSevlet?id=${shopCart.productImgId}&photo_data=1"/>"
																	alt="Product Thumnail"></a></td>
															<td class="product-name text-left wide-column">
																<h3>
																	<a href="<c:url value="/ShopDetailServlet?productName=${shopCart.prodName}&color=${shopCart.selectedColor}"/>">${shopCart.prodName}</a>
																</h3>
															</td>
															<td class="product-price"><span
																class="product-price-wrapper"> <span
																	class="color selectedColor"
																	data-value="${shopCart.selectedColor}">${shopCart.selectedColor}</span>
															</span></td>
															<td class="product-price"><span
																class="product-price-wrapper"> <span
																	class="size selectedSize"
																	data-value="${shopCart.selectedSize}">${shopCart.selectedSize}</span>
															</span></td>
															<td class="product-price"><span
																class="product-price-wrapper"> <span
																	class="money price" data-value="${shopCart.price}">${shopCart.price}</span>
															</span></td>
															<td class="product-quantity">
																<div class="quantity">
																	<input type="number"
																		class="quantity-input quantityValue" name="qty"
																		value="${shopCart.quantityValue}" min="1">
																</div>
															</td>

															<td class="product-total-price"><span
																class="product-price-wrapper"> <span
																	class="money total"
																	data-value="${shopCart.price*shopCart.quantityValue}">${shopCart.price*shopCart.quantityValue}</span>
															</span></td>
														</tr>

													</c:forEach>
												</c:forEach>

											</tbody>
										</table>
									</div>
								</div>
							</div>
							<div class="row no-gutters border-top pt--20 mt--20">
								<div class="col-sm-6"></div>
								<div class="col-sm-6 text-sm-right">
									<button type="button" class="cart-form__btn"
										data-type="Alldelete">清空購物車</button>
								</div>
							</div>
						</div>
                        <div class="col-lg-4 custom-cart-box">
                            <div class="cart-collaterals">
                                <div class="cart-totals">
                                    
                                    <div class="cart-calculator">
                                        <div class="cart-calculator__item">
                                            <div class="cart-calculator__item--head">
                                                <span>商品件數 :</span>
                                            </div>
                                            
                                            <div class="cart-calculator__item--value">
                                                <span Style="color:gray;text-align: right;">3 件</span>
                                            </div>
                                        </div>
                                        <div class="cart-calculator__item">
                                            <div class="cart-calculator__item--head">
                                                <span >總金額 :</span>
                                            </div>
                                            <div class="cart-calculator__item--value">
                                                <span Style="color:gray;text-align: right;">NT.2000</span>
                                            </div>
                                        </div>
                                        <div class="cart-calculator__item">
                                            <div class="cart-calculator__item--head">
                                                <span>運費 :</span>
                                            </div>
                                            <div class="cart-calculator__item--value">
                                                <span Style="color:gray;text-align: right;">NT.0</span>         
                                            </div>
                                        </div>
                                        <div class="cart-calculator__item order-total">
                                            <div class="cart-calculator__item--head">
                                                <span >應付金額 :</span>
                                            </div>
                                            <div class="cart-calculator__item--value">
                                                <span style="text-align: right;" class="product-price-wrapper">
                                                    <span class="money">NT.2000</span>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <a href="checkout.html" class="btn btn-fullwidth btn-bg-red btn-color-white btn-hover-2">
                                    Proceed To Checkout
                                </a>
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
                                    <li class="social__item">
                                        <a href="https://plus.google.com/" class="social__link google-plus">
                                            <span>Google Plus</span>
                                            <i class="fa fa-google-plus"></i>
                                        </a>
                                    </li>
                                    <li class="social__item">
                                        <a href="https://facebook.com/" class="social__link facebook">
                                            <span>facebook</span>
                                            <i class="fa fa-facebook"></i>
                                        </a>
                                    </li>
                                    <li class="social__item">
                                        <a href="https://pinterest.com" class="social__link pinterest">
                                            <span>pinterest</span>
                                            <i class="fa fa-pinterest-p"></i>
                                        </a>
                                    </li>
                                    <li class="social__item">
                                        <a href="youtube.com" class="social__link twitter">
                                            <span>twitter</span>
                                            <i class="fa fa-twitter"></i>
                                        </a>
                                    </li>
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
                            <p class="copyright-text"><a href="index.html">Zakas</a> &copy; 2019 all rights reserved</p>
                        </div>
                        <div class="col-sm-6 text-sm-right text-center">
                            <figure>
                                <img src=" <c:url value="/img/others/payment.png"/>" alt="payment">                                
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
                    <input type="text" name="popup-search" id="popup-search" class="searchform__input" placeholder="Search Entire Store...">
                    <button type="submit" class="searchform__submit"><i class="flaticon flaticon-magnifying-glass-icon"></i></button>
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
                            <li class="mini-cart__product">
                                <a href="#" class="remove-from-cart remove">
                                    <i class="flaticon flaticon-cross"></i>
                                </a>
                                <div class="mini-cart__product__image">                               
                                    <img src=" <c:url value="/img/products/prod-1-100x100.jpg"/>" alt="products">
                                </div>
                                <div class="mini-cart__product__content">
                                    <a class="mini-cart__product__title" href="product-details.html">Chain print bermuda shorts  </a>
                                    <span class="mini-cart__product__quantity">1 x $49.00</span>
                                </div>
                            </li>
                            <li class="mini-cart__product">
                                <a href="#" class="remove-from-cart remove">
                                    <i class="flaticon flaticon-cross"></i>
                                </a>
                                <div class="mini-cart__product__image">                                 
                                    <img src="<c:url value="/img/products/prod-2-100x100.jpg"/>" alt="products">
                                </div>
                                <div class="mini-cart__product__content">
                                    <a class="mini-cart__product__title" href="product-details.html">Waxed-effect pleated skirt</a>
                                    <span class="mini-cart__product__quantity">1 x $49.00</span>
                                </div>
                            </li>
                            <li class="mini-cart__product">
                                <a href="#" class="remove-from-cart remove">
                                    <i class="flaticon flaticon-cross"></i>
                                </a>
                                <div class="mini-cart__product__image">                                
                                    <img src="<c:url value="/img/products/prod-5-100x100.jpg"/>" alt="products">
                                </div>
                                <div class="mini-cart__product__content">
                                    <a class="mini-cart__product__title" href="product-details.html">Waxed-effect pleated skirt</a>
                                    <span class="mini-cart__product__quantity">1 x $49.00</span>
                                </div>
                            </li>
                        </ul>
                        <div class="mini-cart__total">
                            <span>Subtotal</span>
                            <span class="ammount">$98.00</span>
                        </div>
                        <div class="mini-cart__buttons">
                            <a href="cart.html" class="btn btn-fullwidth btn-bg-sand mb--20">View Cart</a>
                            <a href="checkout.html" class="btn btn-fullwidth btn-bg-sand">Checkout</a>
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
        <div class="modal fade product-modal" id="productModal" tabindex="-1" role="dialog" aria-hidden="true">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true"><i class="flaticon flaticon-cross"></i></span>
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
                        }'
                        >
                            <div class="product-image">
                                <div class="product-image--holder">
                                    <a href="product-details.html">                                    
                                        <img src="<c:url value="/img/products/prod-9-1.jpg"/>" alt="Product Image" class="primary-image">
                                    </a>
                                </div>
                                <span class="product-badge sale">sale</span>
                            </div>
                            <div class="product-image">
                                <div class="product-image--holder">
                                    <a href="product-details.html">                                    
                                        <img src="<c:url value="/img/products/prod-9-1.jpg"/>" alt="Product Image" class="primary-image">
                                    </a>
                                </div>
                                <span class="product-badge sale">sale</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="modal-box product-summary">
                            <div class="product-navigation text-right mb--20">
                                <a href="#" class="prev"><i class="fa fa-angle-double-left"></i></a>
                                <a href="#" class="next"><i class="fa fa-angle-double-right"></i></a>
                            </div>
                            <div class="product-rating d-flex mb--20">
                                <div class="star-rating star-three">
                                    <span>Rated <strong class="rating">5.00</strong> out of 5</span>
                                </div>
                            </div>
                            <h3 class="product-title mb--20">Black Blazer</h3>
                            <p class="product-short-description mb--25">Donec accumsan auctor iaculis. Sed suscipit arcu ligula, at egestas magna molestie a. Proin ac ex maximus, ultrices justo eget, sodales orci. Aliquam egestas libero ac turpis pharetra, in vehicula lacus scelerisque. Vestibulum ut sem laoreet, feugiat tellus at, hendrerit arcu.</p>
                            <div class="product-price-wrapper mb--25">
                                <span class="money">$200.00</span>
                                <span class="price-separator">-</span>
                                <span class="money">$400.00</span>
                            </div>
                            <form action="#" class="variation-form mb--30">
                                <div class="product-color-variations d-flex align-items-center mb--20">
                                    <p class="variation-label">Color:</p>
                                    <div class="product-color-variation variation-wrapper">
                                        <div class="variation">
                                            <a class="product-color-variation-btn red selected" data-toggle="tooltip" data-placement="top" title="Red">
                                                <span class="product-color-variation-label">Red</span>
                                            </a>
                                        </div>
                                        <div class="variation">
                                            <a class="product-color-variation-btn black" data-toggle="tooltip" data-placement="top" title="Black">
                                                <span class="product-color-variation-label">Black</span>
                                            </a>
                                        </div>
                                        <div class="variation">
                                            <a class="product-color-variation-btn pink" data-toggle="tooltip" data-placement="top" title="Pink">
                                                <span class="product-color-variation-label">Pink</span>
                                            </a>
                                        </div>
                                        <div class="variation">
                                            <a class="product-color-variation-btn blue" data-toggle="tooltip" data-placement="top" title="Blue">
                                                <span class="product-color-variation-label">Blue</span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <div class="product-size-variations d-flex align-items-center mb--15">
                                    <p class="variation-label">Size:</p>   
                                    <div class="product-size-variation variation-wrapper">
                                        <div class="variation">
                                            <a class="product-size-variation-btn selected" data-toggle="tooltip" data-placement="top" title="S">
                                                <span class="product-size-variation-label">S</span>
                                            </a>
                                        </div>
                                        <div class="variation">
                                            <a class="product-size-variation-btn" data-toggle="tooltip" data-placement="top" title="M">
                                                <span class="product-size-variation-label">M</span>
                                            </a>
                                        </div>
                                        <div class="variation">
                                            <a class="product-size-variation-btn" data-toggle="tooltip" data-placement="top" title="L">
                                                <span class="product-size-variation-label">L</span>
                                            </a>
                                        </div>
                                        <div class="variation">
                                            <a class="product-size-variation-btn" data-toggle="tooltip" data-placement="top" title="XL">
                                                <span class="product-size-variation-label">XL</span>
                                            </a>
                                        </div>
                                    </div>                                 
                                </div>
                                <a href="" class="reset_variations">Clear</a>
                            </form>
                            <div class="product-action d-flex flex-sm-row flex-column align-items-sm-center align-items-start mb--30">
                                <div class="quantity-wrapper d-flex align-items-center mr--30 mr-xs--0 mb-xs--30">
                                    <label class="quantity-label" for="quick-qty">Quantity:</label>
                                    <div class="quantity">
                                        <input type="number" class="quantity-input" name="qty" id="quick-qty" value="1" min="1">
                                    </div>
                                </div>
                                <button type="button" class="btn btn-small btn-bg-red btn-color-white btn-hover-2" onclick="window.location.href='cart.html'">
                                    Add To Cart
                                </button>
                            </div>  
                            <div class="product-footer-meta">
                                <p><span>Category:</span>
                                    <a href="shop.html">Full Sweater</a>,
                                    <a href="shop.html">SweatShirt</a>,
                                    <a href="shop.html">Jacket</a>,
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
    <script src="<c:url value="/js/vendor.js" />"></script>
    

    <!-- Main JS -->
    <script src="<c:url value="/js/main.js" />"></script>

</body>

</html>