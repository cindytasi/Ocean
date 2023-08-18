$(document).ready(function() {


	$.ajax({
		url: "/Ocean/SelectOrdersServlet",
		type: "POST",
		dataType: "json",
		data: {
		},
		success: function(response) {



			var orderContent = $("#orderContent");
			orderContent.empty();//用來清空標籤裡的所有東西，以防載入時還有其他不要的標籤
			response.forEach(function(item, index) {
				var payFlowType = "";
				if (item.payFlowType === 1) {
					payFlowType = "付款成功";
				} else {
					payFlowType = "付款失敗";
				}

				orderContent.append(
					"<tr>"+
						"<td>"+item.formattedOrderDate+"</td>"+
						"<td class='wide-column'>"+item.HODateOrderDetailId +"</td>"+
						"<td>"+payFlowType+"</td>"+
						"<td class='wide-column'>NT."+ item.orderTotal +"</td>"+
		                "<td><a href='/Ocean/html/order-detail.html?orderId="+ item.orderId +"'"+"class='btn btn-small btn-bg-red btn-color-white btn-hover-2'>View</a></td>"+
           			"</tr>"
				);

			});
		


		},
		error: function(xhr, status, error) {
			// 请求失败的回调函数，如果后端返回错误，会执行这里的代码
			console.error("訂單頁面拉不到資料"); // 打印错误信息，方便调试
		}
	})
	

	
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});





	
	
	
	
