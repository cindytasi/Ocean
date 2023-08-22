<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
    
<!doctype html>
<html class="no-js" lang="zxx">

<script type="text/javascript">

	var PageConfig = {
		price :	"${detail.price}",
		prodName: "${detail.displayProdName}",
 		mappingJson:'${mappingJson}'
	};
		
</script>

<head>
    <meta charset="utf-8">
	<script type="text/javascript" src="<c:url value="/js/jquery/jquery-3.7.0.min.js"/>"></script>
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Ocean</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Favicons -->
    <link rel="shortcut icon" href="<c:url value="/img/favicon.ico"/>" type="image/x-icon">    
    <link rel="apple-touch-icon" href="<c:url value="/img/icon.png"/>">

    <!-- ************************* CSS Files ************************* -->
	
    <!-- Vendor CSS -->
   
    <link rel="stylesheet" href=" <c:url value="/css/vendor.css"/>">

    <!-- style css -->     
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
  	
		<script type="text/javascript" src="<c:url value="/js/shopdetail.js"/>"></script>
<style>

#footerID {
	background: #000;
	background-image: url("./img/waves_5.jpg");
	color: #81D8D0;
}
.footer_detail li>a {
    color: #fff;
    text-decoration: none;
}

.footer_detail li>a:hover {
    color: var(--bs-blue);
}

.carousel-control-prev,
.carousel-control-next {
    width: 3%;
    background-color: #000;
}

.carousel-control-prev-icon,
.carousel-control-next-icon {
    width: 4rem;
    height: 5rem;
}

.card {
    background: transparent;
}

</style>	

</head>

<body>
	<input id="productName" type="hidden" value="${detail.displayProdName}"/>
	<input id="price" type="hidden" value="${detail.price}"/>
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
									
										<li><a href="<c:url value="/ShopServlet?type=AllProduct"/>">Shop</a></li>
										<li class="current"><span>Product Detail</span></li>
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
        <div class="zakas-preloader-inner h-100 d-flex align-items-center justify-content-center">
            <div class="zakas-child zakas-bounce1"></div>
            <div class="zakas-child zakas-bounce2"></div>
            <div class="zakas-child zuka-bounce3"></div>
        </div>
    </div>
    <!-- Preloader End -->

    <!-- Main Wrapper Start -->
    <div class="wrapper">

        <!-- Main Content Wrapper Start -->
        <div class="main-content-wrapper">
            <div class="page-content-inner ptb--80">
                <div class="container">
                    <div class="row no-gutters mb--70">
                        <div class="col-lg-7 product-main-image">
                            <div class="product-image">
                                <div class="product-gallery">
                                    <div class="product-gallery__large-image">
                                        <div class="product-gallery__wrapper">
                                            <div id="imageDiv" class="row grid-space-10">
                                                <div class="col-12 mb--10">
                                                    <figure class="product-gallery__image">                                             
                                                        <img src="<c:url value="/ImageSevlet?id=${detail.defaultImgId}&photo_data=1"/>" alt="Product">
                                                    </figure>
                                                </div>
                                                <div class="col-6 mb--10">
                                                    <figure class="product-gallery__image">                                                    
                                                        <img src="<c:url value="/ImageSevlet?id=${detail.defaultImgId}&photo_data=2"/>" alt="Product">
                                                    </figure>
                                                </div>
                                                <div class="col-6 mb--10">
                                                    <figure class="product-gallery__image">                                                    
                                                        <img src="<c:url value="/ImageSevlet?id=${detail.defaultImgId}&photo_data=3"/>" alt="Product">
                                                    </figure>
                                                </div>
                                                <div class="col-12 mb--10">
                                                    <figure class="product-gallery__image">                                                    
                                                        <img src="<c:url value="/ImageSevlet?id=${detail.defaultImgId}&photo_data=4"/>" alt="Product">
                                                    </figure>
                                                </div>
                                            </div>
                                            <div class="product-gallery__actions">
                                                <button class="action-btn btn-zoom-popup"><i class="fa fa-eye"></i></button>
<!--                                                 <a href="https://www.youtube.com/watch?v=Rp19QD2XIGM" class="action-btn video-popup"><i class="fa fa-play"></i></a> -->
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
                            </div>
                        </div>
                        <div class="col-xl-4 offset-xl-1 col-lg-5 product-main-details mt-md--40" id="sticky-sidebar">
                            <div class="product-summary pl-lg--30 pl-md--0">
                                <div class="product-navigation text-right mb--20">
                                   
                                </div>
                                <div class="product-rating d-flex mb--20">
                                   
                                </div>
                                <h3 class="product-title mb--20">${detail.displayProdName}</h3>
                                
                                <div class="product-price-wrapper mb--25">
                                    <span class="money">NT.${detail.price}</span>
                                </div>
                                <form action="#" class="variation-form mb--20">
                                    <div class="product-size-variations d-flex align-items-center mb--15">
                                        <p class="variation-label">尺寸:</p>   
                                        <div class="product-size-variation variation-wrapper">
                                        	<c:forEach var="size" items="${detail.sizeList}">
                                        	
												<div class="variation">
	                                                <a class="product-size-variation-btn selected pickSize sizeBtn" data-toggle="tooltip" data-placement="top">
	                                                    <span class="product-size-variation-label">${size}</span>
	                                                </a>
	                                            </div>
                                        	</c:forEach>

                                          
                                        </div>                                 
                                    </div>
                                    <div class="product-size-variations d-flex align-items-center mb--15">
                                        <p class="variation-label">顏色:</p>   
                                        <div id="colorbtnList" class="product-size-variation variation-wrapper">
                                        	<c:forEach var="color" items="${detail.colorSet}">
                                        	
                                        		
												<div class="variation colorCheck colorbtn">
	                                                <a class="product-size-variation-btn selected pickColor colorBtn <c:if test="${defaultColorType.equals(color)}">checked</c:if>" data-toggle="tooltip" data-placement="top" color="${color}">
	                                                    <span class="product-color-variation-label">${color}</span>
	                                                    <c:set var="color" value="${defaultColorType}" />
	                                                </a>
	                                            </div>
                                        	</c:forEach>

                                          
                                        </div>                                 
                                    </div>
                                </form>
                                <div class="product-action d-flex flex-sm-row align-items-sm-center flex-column align-items-start mb--30">
                                    <div class="quantity-wrapper d-flex align-items-center mr--30 mr-xs--0 mb-xs--30">
                                        <label class="quantity-label" for="qty" style="font-size:16px">件數:</label>
                                        <div class="quantity">
                                            <input type="number " class="quantity-input" name="qty" id="qty" value="1" min="1">
                                        </div>
                                    </div>
                                    
                                </div>  
                             <div>
                                    <button id="wishlistbtn" type="button" class="btn btn-small btn-bg-red btn-color-white btn-hover-2">
                                        WIST LIST
                                    </button>
                                    <button id="shopCartbtn" type="button" class="btn btn-small btn-bg-red btn-color-white btn-hover-2">
                                        Add To Cart
                                    </button>
                                    </div>
                                
                            </div>
                        </div>
                    </div>
                    <div class="row justify-content-center mb--80">
                        <div class="col-12">
                            <div class="product-data-tab tab-style-3">
                                <div class="nav nav-tabs product-data-tab__head mb--35 mb-sm--25" id="product-tab" role="tablist">
                                    <a class="product-data-tab__link nav-link active" id="nav-description-tab" data-toggle="tab" href="#nav-description" role="tab" aria-selected="true"> 
                                        <span>商品描述</span>
                                    </a> <a
										class="product-data-tab__link nav-link" id="nav-info-tab"
										data-toggle="tab" href="#nav-info" role="tab"
										aria-selected="true"> <span>洗滌說明 </span>
									</a> <a class="product-data-tab__link nav-link"
										id="nav-reviews-tab" data-toggle="tab" href="#nav-reviews"
										role="tab" aria-selected="true"> <span>尺寸指南</span>
									</a>
								</div>
								<div class="tab-content product-data-tab__content"
									id="product-tabContent">
									<div class="tab-pane fade show active" id="nav-description"
										role="tabpanel" aria-labelledby="nav-description-tab">
										<div class="product-description">
											<div>
												<p>*實品顏色依單品照為主</p>
												<p>聚丙烯腈纖維 75% 尼龍 25%</p>
												<p>素材產地 / 中國</p>
												<p>加工產地 / 中國</p>
												<p>
													造型木紋釦/V領寬鬆版型/涼感針織紗線<br>
													<br>商品長度/適中<br>商品版型/適中<br>商品厚薄/適中<br>商品彈性/佳<br>
													<br>*深色布料因穿著時接觸人體溫度及洗滌後有脫色及染劑移染狀況，第一次下水脫色為正常現象<br>*此款材質特性，不宜使用衣架吊掛，建議平放/避免摩擦<br>*針織材質吸濕性較一般材質大，故洗滌後些微縮水屬正常現象<br>*請避免手錶、飾品或者包包小零件勾住針織網眼
												</p>
											</div>


										</div>
									</div>
									<div class="tab-pane" id="nav-info" role="tabpanel"
										aria-labelledby="nav-info-tab">
										<div class="table-content table-responsive">
											<table class="table shop_attributes">
												<tbody>
													<tr>
														<p>
														<p>1.深淺色請分開洗滌，以避免造成互相移染。</p>
														<p>2.請放入大小適中之細網洗衣袋細中弱速水洗，以保持商品型態。</p>
														<p>3.洗滌時，水溫請低於30℃；請使用中性洗劑；請勿浸泡。</p>
														<p>4.請勿使用漂白劑、螢光增白劑及衣物柔軟劑，以免破壞布料。</p>
														<p>5.不可濕放，以免衣物染色；請弱速輕脫水，不可烘乾，以免衣物縮水。</p>
														<p>6.清洗後請快速調整商品型態並平放陰乾即可，不可擰扭，勿直接曝曬於陽光下</p>
														<p>7.不可熨燙。</p>
														<p>8.穿著時，請留意避免與配件包包等他物接觸摩擦。</p>
														<p>9.毛衣外套/特殊立體針織毛衣/長毛類針織毛衣等商品建議送專業乾洗 。</p>
														</p>
													</tr>

												</tbody>
											</table>
										</div>
									</div>
									<div class="tab-pane fade" id="nav-reviews" role="tabpanel"
										aria-labelledby="nav-reviews-tab">
										<div class="product-reviews">

											<div class="modal-content">
												<div class="modal-header">
													<a href="#" data-dismiss="modal" class="r-lightbox__close"></a>
												</div>
												<div class="modal-body">
													<div>
														<div class="size-guide">

															<div class="size-guide__section sg_sizeChart">
																<h2>SIZE CHART 平鋪尺寸表 (CM)</h2>
																<div class="size-guide__content" style="">
																	<!--尺寸表開始-->
																	<table>
																		<tbody>
																			<tr>
																				<td width="100">SIZE (CM)</td>
																				<td width="80">S</td>
																				<td width="80">M</td>
																				<td width="80">L</td>
																				<td width="80">F</td>
																				<td><br></td>
																			</tr>
																			<tr>
																				<td>肩寬</td>
																				<td>33</td>
																				<td>34.5</td>
																				<td>36</td>
																				<td>-</td>
																				<td class="etc" rowspan="7"><img
																					src="https://image.mercci22.tw/sizereport/top_01.gif"
																					class="fr-fic fr-dii"></td>
																			</tr>
																			<tr>
																				<td>胸寬</td>
																				<td>38</td>
																				<td>40.5</td>
																				<td>43</td>
																				<td>-</td>
																			</tr>
																			<tr>
																				<td>下擺寬(羅紋)</td>
																				<td>33</td>
																				<td>35.5</td>
																				<td>38</td>
																				<td>-</td>
																			</tr>
																			<tr>
																				<td>袖長</td>
																				<td>13.5</td>
																				<td>14.5</td>
																				<td>15.5</td>
																				<td>-</td>
																			</tr>
																			<tr>
																				<td>袖口寬(羅紋)</td>
																				<td>15</td>
																				<td>16</td>
																				<td>17</td>
																				<td>-</td>
																			</tr>
																			<tr>
																				<td>衣長</td>
																				<td>42</td>
																				<td>44</td>
																				<td>46</td>
																				<td>-</td>
																			</tr>
																			<tr>
																				<td>重量g</td>
																				<td>167</td>
																				<td>167</td>
																				<td>167</td>
																				<td>-</td>
																			</tr>
																			<tr>
																				<td class="etc" colspan="6">1肩寬 2胸圍 3下擺寬 4袖長
																					5袖口寬 6衣長 <br> <br>※尺寸表會因布料彈性、水洗處理、測量起訖點等因素，
																					<br>與實際商品尺寸略有誤差，誤差尺寸±2cm， <br>在國際驗貨標準範圍都是屬於可接受範圍，並不屬於瑕疵。
																				</td>
																			</tr>
																		</tbody>
																	</table>
																	<!--尺寸表結束-->
																</div>
															</div>


														</div>
													</div>
												</div>
											</div>

										</div>
									</div>
								</div>
							</div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <div class="zakas-element-carousel nav-vertical-center" data-slick-options='{
                                "spaceBetween": 30,
                                "slidesToShow": 4,
                                "slidesToScroll": 1,
                                "arrows": true,
                                "prevArrow": {"buttonClass": "slick-btn slick-prev", "iconClass": "fa fa-angle-double-left" },
                                "nextArrow": {"buttonClass": "slick-btn slick-next", "iconClass": "fa fa-angle-double-right" }
                            }'
                            data-slick-responsive= '[
                                {"breakpoint":1199, "settings": {
                                    "slidesToShow": 3
                                }},
                                {"breakpoint":991, "settings": {
                                    "slidesToShow": 2
                                }},
                                {"breakpoint":575, "settings": {
                                    "slidesToShow": 1
                                }}
                            ]'>
                            <c:forEach var="randomProductList" items="${randomProductList}">
                                <div class="item">
                                    <div class="zakas-product">
                                        <div class="product-inner">
                                            <figure class="product-image">
                                                <a href="<c:url value="/ShopDetailServlet?productName=${randomProductList.productName}&color=${randomProductList.colorType}"/>">                                                
                                                    <img src="<c:url value="/ImageSevlet?id=${randomProductList.productImgId}&photo_data=1"/>" alt="Product">
                                                </a>
                                            </figure>
                                            <div class="product-info">
                                                <h3 class="product-title mb--15">
                                                
                                                    <a href="<c:url value="/ShopDetailServlet?productName=${randomProductList.productName}&color=${randomProductList.colorType}"/>">${randomProductList.productName}</a>
                                                </h3>
                                                <div class="product-price-wrapper mb--30">
                                                    <span class="money">NT.${randomProductList.price}</span>
                                                </div>
                                                
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                                
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Main Content Wrapper End -->


       <!-- Footer Start-->
		<footer class="footer" id="footerID">
			<div class="footer-bottom bg-color ptb--25">
				<div class="container">
					<div class="row align-items-center">
						<div class="container mt-5">
							<ul
								class="footer_detail d-flex justify-content-center list-unstyled">
								<li class="px-2"><a href="../index/qaIndex.html">常見問題</a></li>
								<li class="px-2"><a href="../index/copyright.html">版權聲明</a></li>
								<li class="px-2"><a href="../index/instruction.html">使用說明</a></li>
								<li class="px-2"><a href="../index/aboutUs.html">關於我們</a></li>
							</ul>
							<span class="d-flex justify-content-center">Copyright©
								2023 Ocean.All rights reserved.</span>
						</div>
					</div>
				</div>
			</div>
		</footer>
		<!-- Footer End-->
        

        

        <!-- Global Overlay Start -->
        <div ></div>
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
                                            <a class="product-size-variation-btn " data-toggle="tooltip" data-placement="top" title="S">
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
        <script src="<c:url value="/js/vendor.js"/>"></script>

    <!-- Main JS -->
    <script src="<c:url value="/js/main.js"/>"></script>

</body>

</html>