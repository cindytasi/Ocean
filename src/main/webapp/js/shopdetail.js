$(document).ready(function() {
	
	$(".colorBtn").click(function(){
		let color = $(this).attr("color");
		var mappingJsonList = JSON.parse(mappingJson);
		
		let colorMapping = mappingJsonList.filter(function(item){
			return item.colorType === color;
		})[0];
		
		let productImgId = colorMapping.productImgId;
		
		$("#imageDiv img").each(function(index, item){
			$(item).attr("src", "/Ocean/ImageSevlet?id="+productImgId+"&photo_data="+(index+1));
		});

	});
	
	
	
  // 添加点击事件处理程序
  $('.variation.colorCheck').click(function() {
    // 切换 'checked' 类名
      
   
    // 取消前一个选中的 div 的 'checked' 类名
    $('.variation.colorCheck.checked').removeClass('checked');

    // 给当前点击的 div 添加 'checked' 类名
    $(this).addClass('checked');
    
  });
  
  
  
  
  
    // 给所有具有 'variation' 类名的 div 元素下的 'a' 元素添加点击事件处理程序
    $('.variation a.product-size-variation-btn').click(function() {
        // 移除之前选中的标签的选中类名，并移除之前选中的标签的颜色样式
        $('.variation a.product-size-variation-btn.selected').removeClass('selected').removeClass('selected-color');

        // 给当前点击的标签添加选中类名，并设置当前选中的标签的颜色样式
        $(this).addClass('selected').addClass('selected-color');
    });


	
});




