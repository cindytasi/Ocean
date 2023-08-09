$(document).ready(function() {

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

				// 檢查數字是否小於1，如果是，隱藏綠色圖案
				if (cartSize < 1) {
					$(".mini-cart-count").css("display", "none");
				}
					
				},
				error: function(xhr, status, error) {
					// 请求失败的回调函数，如果后端返回错误，会执行这里的代码
					console.error(error); // 打印错误信息，方便调试
				}

			})
		



		
	});


});




