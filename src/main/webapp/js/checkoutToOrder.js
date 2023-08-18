$(document).ready(function() {
	$("#submitBtn").click(function() {



		// 獲取姓名的值
		var fullName = $("#billing_fname").val();

		// 獲取手機的值
		var phone = $("#billing_phone").val();

		// 獲取地址的值
		var city = $("select[name='city']").val();
		var district = $("select[name='district']").val();
		var street = $("input[name='address']").val();
		var address = city + district + street;
		// 獲取Email的值
		var email = $("#billing_email").val();

		// 獲取選中的宅配方式的值
		var deliveryMethod = $("input[name='delivery-method']:checked").val();

		// 獲取選中的付款方式的值
		var paymentMethod = $("input[name='payment-method']:checked").val();

		// 檢查是否選擇了付款方式
		if (!paymentMethod) {
			alert("請選擇付款方式！");
			return;
		}

		// 檢查其他字段是否为空
		if (fullName === "" || phone === "" || address === "" || email === "" || deliveryMethod === undefined) {
			alert("請填寫所有必填欄位！");
			return;
		}

		// 映射對象，將值映射到中文
		var deliveryMethodMap = {
			"fax": "宅配"
			
		};

		var paymentMethodMap = {
			"cash": "線上刷卡",
			"cheque": "貨到付款"
			
		};

		// 傳換為中文
		var translatedDeliveryMethod = deliveryMethodMap[deliveryMethod];
		var translatedPaymentMethod = paymentMethodMap[paymentMethod];


		//把運送訊息包成物件
		var transportInfo = {
			fullName: fullName,
			phone: phone,
			address: address,
			email: email,
			deliveryMethod: translatedDeliveryMethod, //會顯示中文:宅配
			paymentMethod: translatedPaymentMethod //會顯示中文:貨到付款 or 線上刷卡
		};

		var transportInfoJson = JSON.stringify(transportInfo)
		$("#transportInfoJson").val(transportInfoJson);



		$("#mainForm").submit();
	});



});
