$(document).ready(function() {
	
	
	//如何拿到url後面的參數			
			var url_string = window.location.href; //window.location.href
			var url = new URL(url_string);
			var orderId = url.searchParams.get("orderId");	
	
	
	$.ajax({
		url: "/Ocean/SelectOrderDetailServlet",
		type: "POST",
		dataType: "json",
		data: {
			orderId: orderId
		},
		success: function(response) {
			console.log(response);
			

			var prodBuyWhat = $("#prodBuyWhat");
			prodBuyWhat.empty();
			response.forEach(function(item, index){

				prodBuyWhat.append(
					"<tr>"+
                       "<th>"+item.productName+"</th>"+
                       "<th>"+item.productColor+"</th>"+
                       "<th>"+item.productSize+"</th>"+
                       "<th>"+item.productQuantity+"</th>"+
                       "<th>"+item.productPrice+"</th>"+
                       "<td class='text-right'>NT."+item.Subtotal+"</td>"+
                    "</tr>"

				);
			});
			const uniqueItem = response[0];
			var OrderInfo=$("#OrderInfo");
			OrderInfo.empty();//先清空裡面的所有元素
			var payFlowType = "";
			if (uniqueItem.payFlowType === 1) {
				payFlowType = "付款成功";
			} else {
				payFlowType = "付款失敗";
			}
				
			OrderInfo.append(
				"<tr>"+
			        "<th>"+uniqueItem.formattedOrderDate+"</th>"+
			        "<th>"+uniqueItem.HODateOrderDetailId+"</th>"+
			        "<th>"+payFlowType+"</th>"+
			        "<th>NT."+uniqueItem.orderTotal+"</th>"+
			        "<td class='text-right'>"+uniqueItem.paymentMethod+"</td>"+
			     "</tr>"

				);
			
			
			var numberOfItems = $("#numberOfItems");
			numberOfItems.empty();
			numberOfItems.append(
                  "<th>商品件數</th>"+
                  "<th></th>"+
                  "<th></th>"+
                  "<th></th>"+
                  "<td class='text-right'><span class='Items-ammount'>"+uniqueItem.ItemsQuantity+"件</span></td>"
			);
			
			var numberOftotal = $("#numberOftotal");
			numberOftotal.empty();
			numberOftotal.append(
                  "<th>總金額</th>"+
                  "<th></th>"+
                  "<th></th>"+
                  "<th></th>"+
                  "<td class='text-right'><span class='Items-ammount'>NT."+uniqueItem.orderTotal+"</span></td>"
			);
			
			var numberOfshipping = $("#numberOfshipping");
			numberOfshipping.empty();
			numberOfshipping.append(
                  "<th>運費</th>"+
                  "<th></th>"+
                  "<th></th>"+
                  "<th></th>"+
                  "<td class='text-right'><span class='shipping-ammount'>NT."+uniqueItem.shipping+"</span></td>"
			);
			
			var numberOfPayable = $("#numberOfPayable");
			numberOfPayable.empty();
			numberOfPayable.append(
                  "<th>應付金額</th>"+
                  "<th></th>"+
                  "<th></th>"+
                  "<th></th>"+
                  "<td class='text-right'><span class='Payable-ammount'>NT."+uniqueItem.Payable+"</span></td>"
			);
			
			var OrderfullName = $("#OrderfullName");
			OrderfullName.empty();
			OrderfullName.append(
                  "<th>收件者</th>"+
                  "<th></th>"+
                  "<th></th>"+
                  "<th></th>"+
                  "<td class='text-right'><span class='fullName-ammount'>"+uniqueItem.fullName+"</span></td>"
			);
			
			var Orderphone = $("#Orderphone");
			Orderphone.empty();
			Orderphone.append(
                  "<th>電話</th>"+
                  "<th></th>"+
                  "<th></th>"+
                  "<th></th>"+
                  "<td class='text-right'><span class='phone-ammount'>"+uniqueItem.phone+"</span></td>"
			);
			
			var Orderaddress = $("#Orderaddress");
			Orderaddress.empty();
			Orderaddress.append(
                  "<th>收件地址</th>"+
                  "<th></th>"+
                  "<th></th>"+
                  "<th></th>"+
                  "<td class='text-right'><span class='address-ammount'>"+uniqueItem.address+"</span></td>"
			);
			
			var Orderemail = $("#Orderemail");
			Orderemail.empty();
			Orderemail.append(
                  "<th>Email</th>"+
                  "<th></th>"+
                  "<th></th>"+
                  "<th></th>"+
                  "<td class='text-right'><span class='address-ammount'>"+uniqueItem.email+"</span></td>"
			);
			
			
			
			
			
			
			
			
			

		},
		error: function(xhr, status, error) {
			// 请求失败的回调函数，如果后端返回错误，会执行这里的代码
			console.error("訂單頁面拉不到資料"); // 打印错误信息，方便调试
		}
	})
	

	
HODateOrderDetailId: "HO202308171"
ItemsQuantity: 2
Payable: 2560
address: "新北市萬里區忠三街39巷41弄24號"
comId: 1
deliveryMethod: "宅配"
email: "chad0919@gmail.com"
formattedOrderDate: "2023/8/17"
fullName: "黃建瑋"
orderDetailId: 15
orderId: 14
orderTotal: 2560
payFlowType: 1
paymentMethod: "線上刷卡"
phone: "0988866652"
productColor: "杏"
productId: 71
productName: "舒適仿麻西裝外套"
productPrice: 1280
productQuantity: 1
productSize: "S"
shipping: 0
shippingTextValue: "全館免運"
userId: 1
	
	
	
	
	
	
	
	
	
	
});