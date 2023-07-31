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
	
});

