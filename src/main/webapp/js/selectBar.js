$(document).ready(function() {
	//先讓畫面一載入就判斷購物車icon是否為0，是則隱藏數字
	var zeroCartSize = $(".mini-cart-count")[0].innerText;
	// 檢查數字是否小於1，如果是，隱藏綠色圖案
	if (zeroCartSize == 0 ) {
		$(".mini-cart-count").css("display", "none");
	}
	
	
	  var cartSize = parseInt($(".mini-cart-count")[0].innerText);
	// 检查数量是否小于1，如果是，隐藏绿色图案
	if (cartSize < 1) {
		$(".mini-cart-count").css("display", "none");
	}

});
