$(document).ready(function() {
	updateCartTotals();

	
	$(".quantity").append('<div class="dec qtybutton" type="minus">-</div><div class="inc qtybutton" type="add">+</div>');
	
	//新增或減少商品數量(因為動態生成，所以用foreach來跑)
	$(".quantity").each(function() {
		//先獲取畫面進入時商品數量和金額
		var $quantityContainer = $(this);
		var $quantityInput = $quantityContainer.find(".quantity-input");
		var $priceElement = $quantityContainer.closest("tr").find('.money.price'); //拿到商品的金額
		var money = parseFloat($priceElement.attr('data-value'));//拿到商品的金額		
		var oldValue = parseFloat($quantityInput.val());//拿到商品數量

		// 計算初始總金額
		var total = money * oldValue;
		$quantityContainer.closest("tr").find('.money.total').text(total);

		// 給加減按鈕綁定點擊事件
		$quantityContainer.find(".qtybutton").on("click", function() {
			var $button = $(this);
			var oldValue = parseFloat($button.parent().find(".quantity-input").val());

			if ($button.hasClass("inc")) {
				var newVal = oldValue + 1;
			} else {
				
				if (oldValue > 1) {
					var newVal = oldValue - 1;
				} else {
					// 不允許數字降到0
					newVal = 1;
				}
			}

			// 更新數量輸入框的值
			$button.parent().find(".quantity-input").val(newVal);

			// 計算更新後的新總價
			var total = money * newVal;
			$quantityContainer.closest("tr").find('.money.total').text(total);
			// 獲取要傳送ajax的參數
			const productId = $quantityContainer.closest('tr.productInfo').find('input.productId').val();
			const productcomId = $quantityContainer.closest('tr.productInfo').find('input.productcomId').val();
			const inStock = $quantityContainer.closest('tr.productInfo').find('input.inStock').val();
			const productImgId = $quantityContainer.closest('tr.productInfo').find('.productImgId').attr('value');
			const prodName = $quantityContainer.closest('tr.productInfo').find('.prodName').attr('value');
			const selectedColor = $quantityContainer.closest('tr.productInfo').find('.color.selectedColor').attr('data-value');
			const selectedSize = $quantityContainer.closest('tr.productInfo').find('.size.selectedSize').attr('data-value');
			const quantityValue = $quantityInput.val();
			var type = $button.attr("type"); // 獲取type值
			//alert(type);
			updateCartTotals();
			updateRedisFunction(productId, productcomId, inStock, productImgId, prodName, selectedColor, selectedSize, newVal, type);
		});
	});
	
	
	
	
	//刪除資料
	 $(".toDoAction").on("click", function() {
        var $row = $(this).closest("tr.productInfo");
        var type = $(this).attr("type");
		alert(type);
        var productId = $row.find('.productId').val();
        var productcomId = $row.find('.productcomId').val();
        var inStock = $row.find('.inStock').val();
        var productImgId = $row.find('.productImgId').attr('value');
        var prodName = $row.find('.prodName').attr('value');
        var selectedColor = $row.find('.color.selectedColor').attr('data-value');
        var selectedSize = $row.find('.size.selectedSize').attr('data-value');
        var quantityValue = $row.find('.quantityValue').val();

        // 調用 testFunction 函数
        updateRedisFunction(productId, productcomId, inStock, productImgId, prodName, selectedColor, selectedSize, quantityValue, type);

        // 删除整个 <tr> 元素 
        $row.remove();
        updateCartTotals();
    });
    
    
    
    
  
function updateRedisFunction(productId, productcomId, inStock, productImgId, prodName, selectedColor, selectedSize, quantityValue, type) {
	$.ajax({
		url: 'your_server_url_here',
		method: 'POST',
		data: {
			productId: productId,
			productcomId: productcomId,
			inStock: inStock,
			productImgId: productImgId,
			prodName: prodName,
			selectedColor: selectedColor,
			selectedSize: selectedSize,
			quantityValue: quantityValue,
			type: type
		},
		success: function(response) {
			console.log(response);
		},
		error: function(xhr, status, error) {
			console.error(error);
		}
	});
} 


	//清空購物車
	$(".cart-form__btn").on("click", function() {
		// 弹出询问窗口
		var confirmed = confirm("確定要清空購物車嗎?");

		// 如果用户确认清空购物车
		if (confirmed) {
			// 删除所有动态生成的商品行
			$(".productInfo").remove();
		}
		updateCartTotals();
	});


	

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
        $(".cart-calculator__item--value span:eq(1)").text("NT." + totalPrice.toFixed(2));

        // 更新應付金額
        $(".order-total .money").text("NT." + totalPrice.toFixed(2));
    }









  
		
});


