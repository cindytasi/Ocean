<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
    
<!doctype html>
<html class="no-js" lang="zxx">

<script type="text/javascript">
	var mappingJson = '${mappingJson}';
</script>

<head>
    <meta charset="utf-8">
	<jsp:include page="/jsp/pluginsJs.jsp"></jsp:include>
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Zakas - Fashion eCommerce Bootstrap 4 Template</title>
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
	<script type="text/javascript" src="<c:url value="/js/keyword.js"/>"></script>
	
	<style type="text/css">
		.checked {
      		background-color:gainsboro;
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
        .navbar-dark .navbar-nav .nav-link:focus,
        .navbar-dark .navbar-nav .nav-link:hover {
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
    <jsp:include page="/jsp/SelectBar.jsp"></jsp:include>
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
                                                <a href="https://www.youtube.com/watch?v=Rp19QD2XIGM" class="action-btn video-popup"><i class="fa fa-play"></i></a>
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
                                        	<c:forEach var="size" items="${detail.sizeSet}">
                                        	
												<div class="variation">
	                                                <a class="product-size-variation-btn selected sizeBtn" data-toggle="tooltip" data-placement="top">
	                                                    <span class="product-size-variation-label">${size}</span>
	                                                </a>
	                                            </div>
                                        	</c:forEach>

                                          
                                        </div>                                 
                                    </div>
                                    <div class="product-size-variations d-flex align-items-center mb--15">
                                        <p class="variation-label">顏色:</p>   
                                        <div class="product-size-variation variation-wrapper">
                                        	<c:forEach var="color" items="${detail.colorSet}">
                                        	
                                        		
												<div id="btn1" class="variation colorCheck <c:if test="${defaultColorType.equals(color)}">checked</c:if>">
	                                                <a class="product-size-variation-btn selected colorBtn" data-toggle="tooltip" data-placement="top" color="${color}">
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
                                        <label class="quantity-label" for="qty">件數:</label>
                                        <div class="quantity">
                                            <input type="number" class="quantity-input" name="qty" id="qty" value="1" min="1">
                                        </div>
                                    </div>
                                    
                                </div>  
                             <div>
                                    <button type="button" class="btn btn-small btn-bg-red btn-color-white btn-hover-2" onclick="window.location.href='cart.html'">
                                        WIST LIST
                                    </button>
                                    <button type="button" class="btn btn-small btn-bg-red btn-color-white btn-hover-2" onclick="window.location.href='cart.html'">
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
                                        <span>Description</span>
                                    </a>
                                    <a class="product-data-tab__link nav-link" id="nav-info-tab" data-toggle="tab" href="#nav-info" role="tab" aria-selected="true">
                                        <span>Additional Information</span>
                                    </a>
                                    <a class="product-data-tab__link nav-link" id="nav-reviews-tab" data-toggle="tab" href="#nav-reviews" role="tab" aria-selected="true">
                                        <span>Reviews(1)</span>
                                    </a>
                                </div>
                                <div class="tab-content product-data-tab__content" id="product-tabContent">
                                    <div class="tab-pane fade show active" id="nav-description" role="tabpanel" aria-labelledby="nav-description-tab">
                                        <div class="product-description">
                                            <p>Lorem ipsum dolor sit amet, consec do eiusmod tincididunt ut labore et dolore magna aliqua. Ut enim ad minim veniaLo ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla paExcepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. iatis unde omnis iste natus error sit voluptatem accusantium </p>

                                            <p>Lorem ipsum dolor sit amet, consec do eiusmod tincididunt ut labore et dolore magna aliqua. Ut enim ad minim veniaLo ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
                                            
                                            <h5 class="product-description__heading">Characteristics :</h5>
                                            <ul>
                                                <li><i class="ti-arrow-right"></i><span>Rsit amet, consectetur adipisicing elit, sed do eiusmod tempor inc.</span></li>
                                                <li><i class="ti-arrow-right"></i><span>sunt in culpa qui officia deserunt mollit anim id est laborum. </span></li>
                                                <li><i class="ti-arrow-right"></i><span>Lorem ipsum dolor sit amet, consec do eiusmod tincididu. </span></li>
                                            </ul>
                                            
                                        </div>
                                    </div>
                                    <div class="tab-pane" id="nav-info" role="tabpanel" aria-labelledby="nav-info-tab">
                                        <div class="table-content table-responsive">
                                            <table class="table shop_attributes">
                                                <tbody>
                                                    <tr>
                                                        <th>Weight</th>
                                                        <td>57 kg</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Dimensions</th>
                                                        <td>160 × 152 × 110 cm</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Color</th>
                                                        <td>
                                                            <a href="shop-sidebar.html">Black</a>,
                                                            <a href="shop-sidebar.html">Gray</a>,
                                                            <a href="shop-sidebar.html">Red</a>,
                                                            <a href="shop-sidebar.html">Violet</a>,
                                                            <a href="shop-sidebar.html">Yellow</a>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <div class="tab-pane fade" id="nav-reviews" role="tabpanel" aria-labelledby="nav-reviews-tab">
                                        <div class="product-reviews">
                                            <h3 class="review__title">1 review for Black Blazer</h3>
                                            <ul class="review__list">
                                                <li class="review__item">
                                                    <div class="review__container">                                                   
                                                        <img src="<c:url value="/img/others/comment-1.jpg"/>" alt="Review Avatar" class="review__avatar">
                                                        <div class="review__text">
                                                            <div class="d-flex flex-sm-row flex-column justify-content-between">
                                                                <div class="review__meta">
                                                                    <strong class="review__author">John Snow </strong>
                                                                    <span class="review__dash">-</span>
                                                                    <span class="review__published-date">November 20, 2018</span>
                                                                </div>
                                                                <div class="product-rating">
                                                                    <div class="star-rating star-five">
                                                                        <span>Rated <strong class="rating">5.00</strong> out of 5</span>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <p class="review__description">Aliquam egestas libero ac turpis pharetra, in vehicula lacus scelerisque. Vestibulum ut sem laoreet, feugiat tellus at, hendrerit arcu.</p>
                                                        </div>
                                                    </div>
                                                </li>
                                            </ul>
                                            <div class="review-form-wrapper">
                                                <div class="row">
                                                    <div class="col-lg-8">
                                                        <span class="reply-title">Add a review</span>
                                                        <form action="#" class="form pr--30">
                                                            <div class="form-notes mb--20">
                                                                <p>Your email address will not be published. Required fields are marked <span class="required">*</span></p>
                                                            </div>
                                                            <div class="form__group mb--10 pb--1">
                                                                <label class="form__label d-block" >Your Ratings</label>
                                                                <div class="rating">
                                                                    <span><i class="fa fa-star"></i></span>
                                                                    <span><i class="fa fa-star"></i></span>
                                                                    <span><i class="fa fa-star"></i></span>
                                                                    <span><i class="fa fa-star"></i></span>
                                                                    <span><i class="fa fa-star"></i></span>
                                                                </div>
                                                            </div>
                                                            <div class="form__group mb--10">
                                                                <label class="form__label d-block" for="email">Your Review<span class="required">*</span></label>
                                                                <textarea name="review" id="review" class="form__input form__input--textarea"></textarea>
                                                            </div>
                                                            <div class="form__group mb--20">
                                                                <label class="form__label d-block" for="name">Name<span class="required">*</span></label>
                                                                <input type="text" name="name" id="name" class="form__input">
                                                            </div>
                                                            <div class="form__group mb--20">
                                                                <label class="form__label d-block" for="email">Email<span class="required">*</span></label>
                                                                <input type="email" name="email" id="email" class="form__input">
                                                            </div>
                                                            <div class="form__group">
                                                                <div class="form-row">
                                                                    <div class="col-12">
                                                                        <input type="submit" value="Submit Now" class="btn-submit">
                                                                    </div>
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
                                <div class="item">
                                    <div class="zakas-product">
                                        <div class="product-inner">
                                            <figure class="product-image">
                                                <a href="product-details.html">                                                
                                                    <img src="<c:url value="/img/products/prod-9.jpg"/>" alt="Products">
                                                </a>
                                                <div class="zakas-product-action">
                                                    <div class="product-action d-flex">
                                                        <div class="product-size">
                                                            <a href="" class="action-btn">
                                                                <span class="current">XL</span>
                                                            </a>
                                                            <div class="product-size-swatch">
                                                                <span class="product-size-swatch-btn variation-btn">
                                                                    L
                                                                </span>
                                                                <span class="product-size-swatch-btn variation-btn">
                                                                    M
                                                                </span>
                                                                <span class="product-size-swatch-btn variation-btn">
                                                                    S
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="product-color">
                                                            <a href="" class="action-btn">
                                                                <span class="current abbey">Abbey</span>
                                                            </a>
                                                            <div class="product-color-swatch">
                                                                <span class="product-color-swatch-btn blue variation-btn">
                                                                    Blue
                                                                </span>
                                                                <span class="product-color-swatch-btn copper variation-btn">
                                                                    Copper
                                                                </span>
                                                                <span class="product-color-swatch-btn old-rose variation-btn">
                                                                    Old Rose
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <a href="wishlist.html" class="action-btn">
                                                            <i class="flaticon flaticon-like"></i>
                                                        </a>
                                                        <a data-toggle="modal" data-target="#productModal" class="action-btn quick-view">
                                                            <i class="flaticon flaticon-eye"></i>
                                                        </a>
                                                    </div>
                                                </div>
                                                <span class="product-badge">New</span>
                                            </figure>
                                            <div class="product-info">
                                                <h3 class="product-title mb--15">
                                                    <a href="product-details.html">Long Cartigen</a>
                                                </h3>
                                                <div class="product-price-wrapper mb--30">
                                                    <span class="money">$80</span>
                                                    <span class="money-separator">-</span>
                                                    <span class="money">$200</span>
                                                </div>
                                                <a href="cart.html" class="btn btn-small btn-bg-sand btn-color-dark">Add To Cart</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="item">
                                    <div class="zakas-product">
                                        <div class="product-inner">
                                            <figure class="product-image">
                                                <a href="product-details.html">                                                
                                                    <img src="<c:url value="/img/products/prod-10.jpg"/>" alt="Products">
                                                </a>
                                                <div class="zakas-product-action">
                                                    <div class="product-action d-flex">
                                                        <div class="product-size">
                                                            <a href="" class="action-btn">
                                                                <span class="current">XL</span>
                                                            </a>
                                                            <div class="product-size-swatch">
                                                                <span class="product-size-swatch-btn variation-btn">
                                                                    L
                                                                </span>
                                                                <span class="product-size-swatch-btn variation-btn">
                                                                    M
                                                                </span>
                                                                <span class="product-size-swatch-btn variation-btn">
                                                                    S
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="product-color">
                                                            <a href="" class="action-btn">
                                                                <span class="current abbey">Abbey</span>
                                                            </a>
                                                            <div class="product-color-swatch">
                                                                <span class="product-color-swatch-btn blue variation-btn">
                                                                    Blue
                                                                </span>
                                                                <span class="product-color-swatch-btn copper variation-btn">
                                                                    Copper
                                                                </span>
                                                                <span class="product-color-swatch-btn old-rose variation-btn">
                                                                    Old Rose
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <a href="wishlist.html" class="action-btn">
                                                            <i class="flaticon flaticon-like"></i>
                                                        </a>
                                                        <a data-toggle="modal" data-target="#productModal" class="action-btn quick-view">
                                                            <i class="flaticon flaticon-eye"></i>
                                                        </a>
                                                    </div>
                                                </div>
                                            </figure>
                                            <div class="product-info">
                                                <h3 class="product-title mb--15">
                                                    <a href="product-details.html">Long Cartigen</a>
                                                </h3>
                                                <div class="product-price-wrapper mb--30">
                                                    <span class="money">$80</span>
                                                    <span class="money-separator">-</span>
                                                    <span class="money">$200</span>
                                                </div>
                                                <a href="cart.html" class="btn btn-small btn-bg-sand btn-color-dark">Add To Cart</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="item">
                                    <div class="zakas-product">
                                        <div class="product-inner">
                                            <figure class="product-image">
                                                <a href="product-details.html">                                                
                                                    <img src="<c:url value="/img/products/prod-11.jpg"/>" alt="Products">
                                                </a>
                                                <div class="zakas-product-action">
                                                    <div class="product-action d-flex">
                                                        <div class="product-size">
                                                            <a href="" class="action-btn">
                                                                <span class="current">XL</span>
                                                            </a>
                                                            <div class="product-size-swatch">
                                                                <span class="product-size-swatch-btn variation-btn">
                                                                    L
                                                                </span>
                                                                <span class="product-size-swatch-btn variation-btn">
                                                                    M
                                                                </span>
                                                                <span class="product-size-swatch-btn variation-btn">
                                                                    S
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="product-color">
                                                            <a href="" class="action-btn">
                                                                <span class="current abbey">Abbey</span>
                                                            </a>
                                                            <div class="product-color-swatch">
                                                                <span class="product-color-swatch-btn blue variation-btn">
                                                                    Blue
                                                                </span>
                                                                <span class="product-color-swatch-btn copper variation-btn">
                                                                    Copper
                                                                </span>
                                                                <span class="product-color-swatch-btn old-rose variation-btn">
                                                                    Old Rose
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <a href="wishlist.html" class="action-btn">
                                                            <i class="flaticon flaticon-like"></i>
                                                        </a>
                                                        <a data-toggle="modal" data-target="#productModal" class="action-btn quick-view">
                                                            <i class="flaticon flaticon-eye"></i>
                                                        </a>
                                                    </div>
                                                </div>
                                                <span class="product-badge">New</span>
                                            </figure>
                                            <div class="product-info">
                                                <h3 class="product-title mb--15">
                                                    <a href="product-details.html">Long Cartigen</a>
                                                </h3>
                                                <div class="product-price-wrapper mb--30">
                                                    <span class="money">$80</span>
                                                    <span class="money-separator">-</span>
                                                    <span class="money">$200</span>
                                                </div>
                                                <a href="cart.html" class="btn btn-small btn-bg-sand btn-color-dark">Add To Cart</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="item">
                                    <div class="zakas-product">
                                        <div class="product-inner">
                                            <figure class="product-image">
                                                <a href="product-details.html">                                                
                                                    <img src="<c:url value="/img/products/prod-12.jpg"/>" alt="Products">
                                                </a>
                                                <div class="zakas-product-action">
                                                    <div class="product-action d-flex">
                                                        <div class="product-size">
                                                            <a href="" class="action-btn">
                                                                <span class="current">XL</span>
                                                            </a>
                                                            <div class="product-size-swatch">
                                                                <span class="product-size-swatch-btn variation-btn">
                                                                    L
                                                                </span>
                                                                <span class="product-size-swatch-btn variation-btn">
                                                                    M
                                                                </span>
                                                                <span class="product-size-swatch-btn variation-btn">
                                                                    S
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="product-color">
                                                            <a href="" class="action-btn">
                                                                <span class="current abbey">Abbey</span>
                                                            </a>
                                                            <div class="product-color-swatch">
                                                                <span class="product-color-swatch-btn blue variation-btn">
                                                                    Blue
                                                                </span>
                                                                <span class="product-color-swatch-btn copper variation-btn">
                                                                    Copper
                                                                </span>
                                                                <span class="product-color-swatch-btn old-rose variation-btn">
                                                                    Old Rose
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <a href="wishlist.html" class="action-btn">
                                                            <i class="flaticon flaticon-like"></i>
                                                        </a>
                                                        <a data-toggle="modal" data-target="#productModal" class="action-btn quick-view">
                                                            <i class="flaticon flaticon-eye"></i>
                                                        </a>
                                                    </div>
                                                </div>
                                                <span class="product-badge">New</span>
                                            </figure>
                                            <div class="product-info">
                                                <h3 class="product-title mb--15">
                                                    <a href="product-details.html">Long Cartigen</a>
                                                </h3>
                                                <div class="product-price-wrapper mb--30">
                                                    <span class="money">$80</span>
                                                    <span class="money-separator">-</span>
                                                    <span class="money">$200</span>
                                                </div>
                                                <a href="cart.html" class="btn btn-small btn-bg-sand btn-color-dark">Add To Cart</a>
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
        <!-- Main Content Wrapper End -->


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
                                <img src="<c:url value="/img/others/payment.png"/>" alt="payment">
                            </figure>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Footer End-->

        

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
                                    <img src="<c:url value="/img/products/prod-1-100x100.jpg"/>" alt="products">
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
                                    <img src=" <c:url value="/img/products/prod-5-100x100.jpg"/>" alt="products">
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
        <script src="<c:url value="/js/vendor.js"/>"></script>

    <!-- Main JS -->
    <script src="<c:url value="/js/main.js"/>"></script>

</body>

</html>