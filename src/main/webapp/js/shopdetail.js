$(document).ready(function() {

	$(".quantity").append('<div class="dec qtybutton" type="minus">-</div><div class="inc qtybutton" type="add">+</div>');


	//-------------------------點選不同顏色就會換圖片--------------------------------------	

	//綁定color按鈕
	$(".colorBtn").click(function() {
		let color = $(this).attr("color"); //抓color按鈕裡面color的value Ex:粉
		var mappingJsonList = JSON.parse(PageConfig.mappingJson);

		let colorMapping = mappingJsonList.filter(function(item) {
			return item.colorType === color;
		})[0];

		let productImgId = colorMapping.productImgId;

		$("#imageDiv img").each(function(index, item) {
			$(item).attr("src", "/Ocean/ImageSevlet?id=" + productImgId + "&photo_data=" + (index + 1));
		});

		$(".colorBtn").removeClass("checked");
		$(this).addClass("checked");


	});

	//	讓size選擇的時候可以更換顏色
	$(".sizeBtn").first().addClass("checked");

	$(".sizeBtn").on("click", function() {
		$(".sizeBtn").removeClass("checked");
		$(this).addClass("checked");
	});





	//-----------------------購物車icon的顯示長度------------------------

	$("#shopCartbtn").on("click", function() {


		//拿到選取的尺寸和顏色標籤
		const selectedSizeTag = $(".sizeBtn.checked");
		const selectedColorTag = $(".colorBtn.checked");



		//拿到選取的尺寸、顏色、數量、產品名稱、價格、產品id...數據
		const selectedSize = selectedSizeTag.find(".product-size-variation-label").text();
		const selectedColor = selectedColorTag.find(".product-color-variation-label").text();
		const quantityValue = parseInt($('#qty').val());


		var prodName = PageConfig.prodName;
		var price = PageConfig.price;

		var mappingJsonList = JSON.parse(PageConfig.mappingJson);
		let prodIdComIdMapping = mappingJsonList.filter(function(item) { //用filter過濾 值為true則加入prodIdComIdMapping
			return (item.colorType === selectedColor && item.sizeType === selectedSize);
		})[0];

		let productId = prodIdComIdMapping.productId;
		let productcomId = prodIdComIdMapping.comId;
		let productImgId = prodIdComIdMapping.productImgId;
		let inStock = prodIdComIdMapping.inStock;

		if (inStock <= 0) {
			// 库存不足，弹出提示或者其他操作
			alert("該商品庫存不足，無法加入購物車。");
			return; // 阻止继续执行
		}



		$.ajax({
			url: "/Ocean/AddToCartServlet",
			type: "POST",
			dataType: "json",
			data: {
				selectedSize: selectedSize,  //要放入購物車的尺寸
				selectedColor: selectedColor, //要放入購物車的顏色
				quantityValue: quantityValue, //要放入購物車的數量
				prodName: prodName, //要放入購物車的產品名稱
				productId: productId, //要放入購物車的產品id
				productcomId: productcomId, //要放入購物車的廠商
				inStock: inStock, //要放入購物車的庫存
				price: price, //要放入購物車的價格
				productImgId: productImgId //要放入購物車的照片id
			},
			success: function(response) {
				console.log(response);
				var cartSize = response.data.shopcartSize;
				console.log('Cart Size: ' + cartSize);
				$(".mini-cart-count")[0].innerText = cartSize;

				var cartSize = response.data.shopcartSize;

				// 檢查數字是否小於1，如果是，隱藏綠色圖案，相反則顯示
				if (cartSize < 1) {
					$(".mini-cart-count").css("display", "none");
				} else {
					$(".mini-cart-count").css("display", "block");
				}

			},
			error: function(xhr, status, error) {
				// 请求失败的回调函数，如果后端返回错误，会执行这里的代码
				console.error(error); // 打印错误信息，方便调试
			}
		})
	});


	//----------------讓加號 減號可以正常發揮-----------	
	$(".qtybutton").click(function() {
		var inputElement = $("#qty");
		var currentValue = parseInt(inputElement.val());
		var min = parseInt(inputElement.attr("min")) || 1;
		var pickColor = $(".checked.pickColor span").text();
		var pickSize = $(".checked.pickSize span").text();

		var mappingJsonList = JSON.parse(PageConfig.mappingJson);

		let inStockMapping = mappingJsonList.filter(function(item) {
			return (item.colorType === pickColor && item.sizeType === pickSize);
		})[0];

		if ($(this).hasClass("dec")) {
			// 點擊 "-" 按鈕
			if (currentValue > min) {
				inputElement.val(currentValue - 1);
			}
		} else if ($(this).hasClass("inc")) {
			// 點擊 "+" 按鈕
			if (currentValue < inStockMapping.inStock) {
				inputElement.val(currentValue + 1);
			}
		}

		// 更新按钮状态
		updateButtonStatus(inputElement, inStockMapping);
	});

	$(".product-size-variation-btn").click(function() {
		resetQuantityAndButtons();
	});

	$(".product-color-variation-btn").click(function() {
		resetQuantityAndButtons();
	});

	function resetQuantityAndButtons() {
		var inputElement = $("#qty");
		var pickColor = $(".checked.pickColor span").text();
		var pickSize = $(".checked.pickSize span").text();

		var mappingJsonList = JSON.parse(PageConfig.mappingJson);

		let inStockMapping = mappingJsonList.filter(function(item) {
			return (item.colorType === pickColor && item.sizeType === pickSize);
		})[0];

		// 重製數量為1
		if (inStockMapping.inStock <= 0) {
			inputElement.val("缺貨");
		} else {
			inputElement.val(1);
		}

		// 更新按鈕狀態
		updateButtonStatus(inputElement, inStockMapping);
	}

	function updateButtonStatus(inputElement, inStockMapping) {
		var currentValue = parseInt(inputElement.val());

		// 獲取加號或減號按鈕
		var incButton = $(".inc.qtybutton");
		var decButton = $(".dec.qtybutton");

		// 根据庫存情况禁用或启用按钮
		incButton.prop("disabled", currentValue >= inStockMapping.inStock);
		decButton.prop("disabled", currentValue <= 1 || inStockMapping.inStock <= 0);
	}


	//----------------加入購物車-----------	
	$("#wishlistbtn").click(function() {
		// 獲取選取的顏色
		
		var prodName = PageConfig.prodName;
		var price = PageConfig.price;
		var selectedColorTag = $(".colorBtn.checked");
		var selectedColor = selectedColorTag.find(".product-color-variation-label").text();
		
		var mappingJsonList = JSON.parse(PageConfig.mappingJson);		
		let colorMapping = mappingJsonList.filter(function(item) { //用filter過濾 值為true則加入prodIdComIdMapping
			return item.colorType === selectedColor;
		})[0];

//		let colorMapping = mappingJsonList.find(function(item) {
//			return item.colorType === selectedColor;
//		});

		let productImgId = colorMapping.productImgId;
		let colorType = colorMapping.colorType;
		

		$.ajax({
			url: "/Ocean/WishListServlet",
			type: "POST",
			dataType: "json",
			data: {
				colorType: colorType, //要放入願望清單的顏色		
				prodName: prodName, //要放入願望清單的產品名稱	
				price: price, //要放入願望清單的價格
				productImgId: productImgId //要放入願望清單的照片id
			},
			success: function(response) {
				if (response.status === "success") {
					// 商品已加入願望清單
					alert(response.message);
				} else if (response.status === "error") {
					// 願望清單已經有此商品囉~
					alert(response.message);
				}
			},
			error: function(xhr, status, error) {
				// 请求失败的回调函数，如果后端返回错误，会执行这里的代码
				console.error(error); // 打印错误信息，方便调试
			}
		})
	});


	// 顯示商品已加入購物車的彈窗
	showAddedToCartPopup(selectedColor, productName, imageId);
});

// 定義顯示彈窗的函數
function showAddedToCartPopup(color, productName, imageId) {
	// 在這裡寫你的彈窗代碼，可以使用 Bootstrap 的 Modal 或其他彈窗庫
	// 將 color、productName 和 imageId 插入到彈窗內容中
	// 顯示彈窗
}





	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	
	
	
	
	







