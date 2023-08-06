//$(document).ready(function() {
//    // 给删除图标添加点击事件处理程序
//    $("#delete").click(function() {
//        // 获取要删除的内容信息，可以根据需要从DOM中获取其他信息
////        const productName = $(this).closest('tr').find('.product-name h3 a').text();
////        const color = $(this).closest('tr').find('.color').text();
////        const size = $(this).closest('tr').find('.size').text();
////
////        // 发送 AJAX 请求
////        $.ajax({
////            url: 'your_server_url_here', // 替换为你的服务器端处理请求的URL
////            method: 'POST', // 或者使用 'GET'，根据你的需求
////            data: {
////                productName: productName,
////                color: color,
////                size: size
////            },
////            success: function(response) {
////                // 请求成功的回调函数，你可以在这里处理服务器返回的响应
////                console.log(response);
////            },
////            error: function(xhr, status, error) {
////                // 请求失败的回调函数，你可以在这里处理请求失败的情况
////                console.error(error);
////            }
////        });
////
////        // 删除行(tr)
////        $(this).closest('tr').remove();
//    });
//    
//    
//    
//    
//    
//});