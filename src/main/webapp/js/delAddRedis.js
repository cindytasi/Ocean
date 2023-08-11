$(document).ready(function() {
	updateCartTotals();

	
	$(".quantity").append('<div class="dec qtybutton" type="minus">-</div><div class="inc qtybutton" type="add">+</div>');
	

	
	
//--------------------------------------點擊新增或減少按鈕並發送ajax----------------------------------------------------------------------------//

$(".qtybutton").on("click", function() {
    var $button = $(this);
    var $quantityInput = $button.parent().find(".quantity-input");
    var oldValue = parseFloat($quantityInput.val());

    var newVal;
    if ($button.hasClass("inc")) {
        newVal = oldValue + 1;
    } else {
        newVal = oldValue > 1 ? oldValue - 1 : 1;
    }

    var $productInfo = $button.closest('.productInfo');
    var productId = $productInfo.find('.productId').val();
    var productcomId = $productInfo.find('.productcomId').val();
    var inStock = $productInfo.find('.inStock').val();
    var productImgId = $productInfo.find('.productImgId').attr('value');
    var prodName = $productInfo.find('.prodName').attr('value');
    var selectedColor = $productInfo.find('.color.selectedColor').attr('data-value');
    var selectedSize = $productInfo.find('.size.selectedSize').attr('data-value');
    var price = parseFloat($productInfo.find('.money.price').attr('data-value'));
    var type = $button.attr("type");
    var quantityValue = newVal; // Update quantity value

    $.ajax({
        url: "/Ocean/DelAddRedisServlet",
        method: "POST",
        data: {
            productId: productId,
            productcomId: productcomId,
            inStock: inStock,
            productImgId: productImgId,
            prodName: prodName,
            selectedColor: selectedColor,
            selectedSize: selectedSize,
            quantityValue: quantityValue,
            price: price,
            type: type
        },
        success: function(response) {
            console.log("有成功進來add或minus");
            if (response.status === 1) {
                if (response.data.type === "add" || response.data.type === "minus") {
                    $quantityInput.val(newVal);
                    var $row = $button.closest(".productInfo");
                    var unitPrice = parseFloat($row.find('.money.price').attr('data-value'));
                    var newSubtotal = unitPrice * newVal;
                    $row.find('.money.total').text(newSubtotal.toFixed(1));
                    updateCartTotals();
                }
            } else {
               alert("刪除操作失敗：" + response.description);
            }
        },
        error: function(xhr, status, error) {
            console.error("沒有收到回應:" + error);
        }
    });
});
	
	
//------------------------------------------刪除單筆資料------------------------------------------------------------------------//	
	
	
	//刪除資料
	
$(".toDoAction").on("click", function() {
   	var $row = $(this).closest(".productInfo");
    var $comRow = $row.prevAll(".comIdOne").first(); // 查找前面最近的兄弟元素

    var type = $(this).attr("type");
    var productId = $row.find('.productId').val();
    var productcomId = $row.find('.productcomId').val();
    var inStock = $row.find('.inStock').val();
    var productImgId = $row.find('.productImgId').attr('value');
    var prodName = $row.find('.prodName').attr('value');
    var selectedColor = $row.find('.color.selectedColor').attr('data-value');
    var selectedSize = $row.find('.size.selectedSize').attr('data-value');	 
    var quantityValue = $row.find('.quantityValue').val();
    var price = parseFloat($row.find('.money.price').attr('data-value'));

//  $row.remove();
//
//	if ($comRow.nextUntil(".comIdOne", ".productInfo").length === 0) {
//		var comId = $comRow.data("comid");
//		if (comId !== undefined) {
//			$("tr.comIdOne[data-comid='" + comId + "']").remove();
//		}
//	}
//	updateCartTotals();


	$.ajax({
		url: "/Ocean/DelAddRedisServlet",
		method: "POST",
		data: {

			productId: productId,
			productcomId: productcomId,
			inStock: inStock,
			productImgId: productImgId,
			prodName: prodName,
			selectedColor: selectedColor,
			selectedSize: selectedSize,
			quantityValue: quantityValue,
			price: price,
			type: type
		},
		success: function(response) {
			console.log("有成功進來delete");
			if (response.status === 1) {
				//要是點擊增加或減少按鈕則執行
				if (response.data.type === "delete") {
					$row.remove();

					if ($comRow.nextUntil(".comIdOne", ".productInfo").length === 0) {
						var comId = $comRow.data("comid");
						if (comId !== undefined) {
							$("tr.comIdOne[data-comid='" + comId + "']").remove();
						}
					}
					
				var cartSize = response.data.shopcartSize;
					console.log('Cart Size: ' + cartSize);
				$(".mini-cart-count")[0].innerText = cartSize;
					
				var cartSize = response.data.shopcartSize;

				// 檢查數字是否小於1，如果是，隱藏綠色圖案
				if (cartSize < 1) {
					$(".mini-cart-count").css("display", "none");
				}
					
				
					updateCartTotals();
				}

			} else {
				alert("刪除操作失敗：" + response.description);
			}

		},
		error: function(xhr, status, error) {
			console.error("沒有收到回應:" + error);
		}
	});
});


//------------------------------------------刪除整個購物車資料------------------------------------------------------------------------//	    

//
//	$(".cart-form__btn").on("click", function() {
//    // 弹出询问窗口
//    var confirmed = confirm("確定要清空購物車嗎?");
//
//		// 如果用户确认清空购物车
//		if (confirmed) {
//			// 获取所有商品行
//			var $productRows = $("tbody.productAll").find(".productInfo");
//			var type = $(".cart-form__btn").data("type")
//			// 遍历每个商品行
//			$productRows.each(function() {
//				var $row = $(this);
//				var productId = $row.find('.productId').val();
//				var productcomId = $row.find('.productcomId').val();
//				var inStock = $row.find('.inStock').val();
//				var productImgId = $row.find('.productImgId').attr('value');
//				var prodName = $row.find('.prodName').attr('value');
//				var selectedColor = $row.find('.color.selectedColor').attr('data-value');
//				var selectedSize = $row.find('.size.selectedSize').attr('data-value');
//				var quantityValue = $row.find('.quantityValue').val();
//				var price = parseFloat($row.find('.money.price').attr('data-value'));
//
//
//
//				$.ajax({
//					url: "/Ocean/DelAddRedisServlet",
//					method: "POST",
//					data: {
//						productId: productId,
//						productcomId: productcomId,
//						inStock: inStock,
//						productImgId: productImgId,
//						prodName: prodName,
//						selectedColor: selectedColor,
//						selectedSize: selectedSize,
//						quantityValue: quantityValue,
//						price: price,
//						type: type
//					},
//					success: function(response) {
//						if (response.status === 1) {
//							$row.remove();
//
//							if ($comRow.nextUntil(".comIdOne", ".productInfo").length === 0) {
//								var comId = $comRow.data("comid");
//								if (comId !== undefined) {
//									$("tr.comIdOne[data-comid='" + comId + "']").remove();
//								}
//							}
//
//							var cartSize = response.data.shopcartSize;
//							console.log('Cart Size: ' + cartSize);
//							$(".mini-cart-count")[0].innerText = cartSize;
//
//							var cartSize = response.data.shopcartSize;
//
//							// 檢查數字是否小於1，如果是，隱藏綠色圖案
//							if (cartSize < 1) {
//								$(".mini-cart-count").css("display", "none");
//							}
//
//
//							updateCartTotals();
//							//$("tbody.productAll").remove();
//						} else {
//							console.error("删除商品失败：" + response.data.message);
//						}
//						// 更新购物车总计
//						updateCartTotals();
//					},
//					error: function(xhr, status, error) {
//						console.error("沒有收到回應:" + error);
//					}
//				});
//			});
//
//			// 更新页面内容
//			updateCartTotals();
//		}
//	});


	//清空購物車
	$(".cart-form__btn").on("click", function() {
		// 彈出詢問窗口
		var confirmed = confirm("確定要清空購物車嗎?");
		var type = $(".cart-form__btn").data("type");
		// 如果用户確認清空購物車
		if (confirmed) {
			// 刪除所有動態生成的商品列			
			//$("tbody.productAll").remove();
            		
		}
		
		$.ajax({
		url: "/Ocean/DelAddRedisServlet",
		method: "POST",
		data: {
			
			productId: null,
			productcomId: null,
			inStock: 0,
			productImgId: null,
			prodName: null,
			selectedColor: null,
			selectedSize: null,
			quantityValue: 0,
			price:0,
			type: type
		},
			success: function(response) {
				console.log("有成功進來Alldelete");
				if (response.status === 1) {

					if (response.data.type === "Alldelete") {
						$("tbody.productAll").remove();
						console.log("有成功進來並要執行remove()");
					}
					var cartSize = response.data.shopcartSize;
					console.log('Cart Size: ' + cartSize);
					$(".mini-cart-count")[0].innerText = cartSize;

					var cartSize = response.data.shopcartSize;

					// 檢查數字是否小於1，如果是，隱藏綠色圖案
					if (cartSize < 1) {
						$(".mini-cart-count").css("display", "none");
					}


					updateCartTotals();

			} else {
				alert("刪除操作失敗：" + response.description);
			}
			
		},
		error: function(xhr, status, error) {
			console.error("沒有收到回應:"+ error);
		}
	});
		
});    

    
    
    
 // 生成一个随机参数
 
  
//function updateRedisFunction($row, productId, productcomId, inStock, productImgId, prodName, selectedColor, selectedSize, quantityValue,price, type) {
//	
//	$.ajax({
//		url: "/Ocean/DelAddRedisServlet",
//		method: "POST",
//		data: {
//			
//			productId: productId,
//			productcomId: productcomId,
//			inStock: inStock,
//			productImgId: productImgId,
//			prodName: prodName,
//			selectedColor: selectedColor,
//			selectedSize: selectedSize,
//			quantityValue: quantityValue,
//			price:price,
//			type: type
//		},
//		success: function(response) {
//			console.log("有成功執行");
//			if(response.status === 1){
//				//要是點擊增加或減少按鈕則執行
//				if(response.data.type === "add" || response.data.type === "minus"){
//					$quantityInput.val(newVal);
//					var $row = $button.closest(".productInfo");
//					var unitPrice = parseFloat($row.find('.money.price').attr('data-value'));
//					var newSubtotal = unitPrice * newVal;
//					$row.find('.money.total').text(newSubtotal.toFixed(1));
//					updateCartTotals();
//					//刪除單筆資料包含，如是單筆則包含廠商
//				} else if(response.data.typetype === "delete"){
//			        $row.remove();
//					if ($comRow.nextUntil(".comIdOne", ".productInfo").length === 0) {
//						var comId = $comRow.data("comid");
//							if (comId !== undefined) {
//								$("tr.comIdOne[data-comid='" + comId + "']").remove();
//							}
//					}
//					updateCartTotals();
//					// 清空購物車
//				}	else if(type === "Alldelete"){	
//                    $("tbody.productAll").remove();
//                    updateCartTotals();
//				}
//			
//			} else {
//				console.error("操作失敗：" + response.data.message);
//			}
//			
//		},
//		error: function(xhr, status, error) {
//			console.error("沒有收到回應:"+ error);
//		}
//	});
//} 




	

	function updateCartTotals() {
        var totalItems = 0; // 初始商品件數為零
        var totalPrice = 0; // 初始總金額為零

        // 用forEach遍歷所有商品列，並計算加總後的商品件數和總金額
        $(".productInfo").each(function() {
            var $row = $(this);
            var unitPrice = parseFloat($row.find(".money.price").text().replace("NT.", "").trim()); // 獲取商品單價
            var oldValue = parseFloat($row.find(".quantityValue").val()); // 獲取動態生成的商品件數

            totalItems += oldValue; // 加總商品件數
            totalPrice += unitPrice * oldValue; // 加總總金額
        });

        // 更新商品件數和總金額
        $(".cart-calculator__item--value span:eq(0)").text(totalItems + " 件");
        $(".cart-calculator__item--value span:eq(1)").text("NT." + totalPrice.toFixed(0));

        // 更新應付金額
        $(".order-total .money").text("NT." + totalPrice.toFixed(0));
    }

		
});


