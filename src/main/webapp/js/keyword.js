$(document).ready(function() {
    // 在表單提交時，獲取關鍵字並進行處理
//    $('.searchform__submit').on('click', function(event) {
//      	event.preventDefault(); // 阻止表單的預設提交行為
//	
//      	// 獲取關鍵字
//     	const keyword = $('#popup-search').val();
//
//      	// 在這裡你可以使用獲得的 keyword 進行搜索或其他操作
//     	 console.log('使用者輸入的關鍵字：', keyword);
//      
//      
//      	const data = {
//        	msg: keyword
//      	};
//      
//        
//      
//        $.ajax({
//            url:"/Ocean/SelectBarServlet",
//            type:"POST",
//            dataType:"json",
//            data:{
//                msg:keyword,
//            },
//            success : function(data){
//                console.log(data);
//            }
//            
//        })
//		
//         
//      
////      	fetch('Ocean/shop.controller/ShopServlet',{
////			method:'post',
////			headers:{'Content-Type':'applocation/json'},
////			body: JSON.stringify({
////			  msg: "keyword"
////		  	})
////		  });	
//     
//    });
});
