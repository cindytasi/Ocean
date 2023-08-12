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
		var productId = $productInfo.attr('productId');  // 使用 attr('productId') 获取属性值
		var productcomId = $productInfo.attr('comid');   // 使用 attr('comid') 获取属性值
		var inStock = $productInfo.attr('inStock');      // 使用 attr('inStock') 获取属性值
		var productImgId = $productInfo.attr('productImgId');  // 使用 attr('productImgId') 获取属性值
		var prodName = $productInfo.attr('prodName');    // 使用 attr('prodName') 获取属性值
		var selectedColor = $productInfo.find('.selectedColor').attr('data-value');  // 找到子元素
		var selectedSize = $productInfo.find('.selectedSize').attr('data-value');      // 找到子元素
		var price = parseFloat($productInfo.find('.price').attr('data-value'));        // 找到子元素
		var type = $button.attr("type");
		var quantityValue = newVal; // 更新数量值

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
						var unitPrice = parseFloat($row.find('.price').attr('data-value'));  // 找到子元素
						var newSubtotal = unitPrice * newVal;
						$row.find('.total').text(newSubtotal.toFixed(1));  // 找到子元素
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
	$(".toDoAction").on("click", function() {
		var $row = $(this).closest(".productInfo");
		var $comRow = $row.prevAll(".comIdOne").first(); // 查找前面最近的兄弟元素

		var type = $(this).attr("type");
		var productId = $row.attr('productId'); // 使用 attr('productId') 获取属性值
		var productcomId = $row.attr('comid'); // 使用 attr('comid') 获取属性值
		var inStock = $row.attr('inStock'); // 使用 attr('inStock') 获取属性值
		var productImgId = $row.attr('productImgId'); // 使用 attr('productImgId') 获取属性值
		var prodName = $row.attr('prodName'); // 使用 attr('prodName') 获取属性值
		var selectedColor = $row.find('.selectedColor').attr('data-value'); // 找到子元素
		var selectedSize = $row.find('.selectedSize').attr('data-value'); // 找到子元素
		var quantityValue = $row.find('.quantityValue').val();
		var price = parseFloat($row.find('.price').attr('data-value')); // 找到子元素

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
					// 要是點擊增加或減少按鈕則執行
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
				price: 0,
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
				console.error("沒有收到回應:" + error);
			}
		});

	});



	//------------------------------------------更新購物車function(讓別的地方調用)------------------------------------------------------------------------//

	function updateCartTotals() {
		var totalItems = 0; // 初始商品件数为零
		var totalPrice = 0; // 初始总金额为零
		var shippingCost = 0; // 初始运费为零

		// 用 forEach 遍历所有商品列，且计算加总后的商品件数和总金额
		$(".productInfo").each(function() {
			var $row = $(this);
			var unitPrice = parseFloat($row.find(".money.price").text().replace("NT.", "").trim()); // 获取商品单价
			var oldValue = parseFloat($row.find(".quantityValue").val()); // 获取动态生成的商品件数

			totalItems += oldValue; // 加总商品件数
			totalPrice += unitPrice * oldValue; // 加总总金额
		});

		// 根据总金额计算运费
		if (totalPrice < 1000) {
			shippingCost = 60;
		}

		// 更新商品件数和总金额
		$(".cart-calculator__item--value span:eq(0)").text(totalItems + " 件");
		$(".cart-calculator__item--value span:eq(1)").text("NT." + totalPrice.toFixed(0));

		// 更新运费
		$(".shipping-cost").text("NT." + shippingCost);

		// 更新运费描述
		var shippingText = (shippingCost === 0) ? "(滿千免運)" : "(宅配運費：NT." + shippingCost + ")";
		$(".shipping-text").text(shippingText);

		// 更新应付金额
		var totalAmount = totalPrice + shippingCost;
		$(".order-total .money").text("NT." + totalAmount.toFixed(0));
	}





	//------------------------------------------將資料送到CheckoutServlet------------------------------------------------------------------------//   
	//做一個自己的submit發送，讓程式執行完後再發送
	$("#submitBtn").click(function() {
		//將productInfo標籤裡的參數全部取出，要用迴圈跑，因為是list
		var productArray = [];//用一個陣列將物件裝起來
		$(".productInfo").each(function(index, item) {
			let comid = $(item).attr("comid");
			let productId = $(item).attr("productId");
			let productImgId = $(item).attr("productImgId");
			let selectedSize = $(item).attr("selectedSize");
			let selectedColor = $(item).attr("selectedColor");
			let price = $(item).attr("price");
			let quantityValue = $(item).attr("quantityValue");
			let inStock = $(item).attr("inStock");

			let product = {
				comid: comid,
				productId: productId,
				productImgId: productImgId,
				prodname: prodname,
				selectedSize: selectedSize,
				selectedColor: selectedColor,
				price: price,
				quantityValue: quantityValue,
				inStock: inStock
			}

			productArray.push(product);
		});
		//將list轉成json，並將json存入隱藏的input標籤中
		var productJson = JSON.stringify(productArray)
		$("#productJson").val(productJson);


		var checkoutArray = [];//用一個陣列將物件裝起來
		//將checkout方框裡的參數全部取出
		let itemCount = $(".cart-calculator__item--value:eq(0) span").text().trim();
		let totalAmount = $(".cart-calculator__item--value:eq(1) span").text().trim();
		let shippingCost = $(".shipping-cost").text().trim();
		let payableAmount = $(".cart-calculator__item--value:eq(3) span.money").text().trim();

		let checkout = {
			itemCount: itemCount,
			totalAmount: totalAmount,
			shippingCost: shippingCost,
			payableAmount: payableAmount
		}
		checkoutArray.push(checkout);
		var checkoutJson = JSON.stringify(checkoutArray)
		$("#checkoutJson").val(checkoutArray);


		if (productArray.length === 0) {
			alert("你的購物車沒有東西喔~");
		} else {
			// 執行提交
			$("#mainForm").submit();
		}
	});

		
});


