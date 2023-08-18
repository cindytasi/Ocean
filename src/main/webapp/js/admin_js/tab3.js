//取得商品審核、商品置入、景點審核按鈕
let btn_review = document.querySelectorAll(".btn_review");

//取得頁籤
let review = document.querySelectorAll(".review");

btn_review.forEach((e1, index) => {
	e1.addEventListener("click", (e2) => {
		e2.preventDefault();

		//移除其他按鈕的css
		btn_review.forEach(e1 => {
			e1.classList.remove("active");
		});
		//加入當前按鈕的css
		e1.classList.add("active");

		//隱藏其他頁籤的內容
		review.forEach(divv => {
			divv.style.display = 'none';
		});
		//顯示當前頁籤的內容
		review[index].style.display = 'block';
	});
});