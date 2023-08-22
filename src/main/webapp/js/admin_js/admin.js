const xhr = new XMLHttpRequest();
xhr.onreadystatechange = function () {
	if (xhr.readyState === 4 && xhr.status === 200) {
		const adminName = xhr.responseText;
		console.log(adminName);
		// document.querySelector("#adminName").innerHTML += adminName;
	}
};
// fetch("/Ocean/GetAdminName", {
// 	method: 'GET',
// 	credentials: 'include' // 包括Cookie以保持會話
// })
// .then(response => response.text())
// .then(adminName => {
// 	document.getElementById("adminName").textContent = adminName;
// })
// .catch(error => console.error('發生錯誤:', error));



//取得頁籤
const tabLinks = document.querySelectorAll('.tab-link');
//取得頁籤DIV用於顯示或隱藏
const tabContents = document.querySelectorAll('.tab-content');

//預設第一個頁籤，隱藏其他頁籤
window.addEventListener("load", function () {
	tabContents.forEach(content => {
		content.style.display = 'none';

	});
	document.querySelector("#tab1").style.display = 'block';
	document.querySelector("#m_upload").classList.add("active");
})

//顯示點擊頁籤的畫面
tabLinks.forEach(link => {
	link.addEventListener('click', (e) => {
		e.preventDefault();

		const selectedTab = link.getAttribute('data-tab');

		// 移除所有 li 元素的 active 
		tabLinks.forEach(link => {
			link.parentNode.classList.remove('bordered');
		});

		// 添加當前點擊的li區域的css
		link.parentNode.classList.add('bordered');

		// 隱藏所有內容區域
		tabContents.forEach(content => {
			content.style.display = 'none';

		});

		// 顯示選到的內容區域
		document.getElementById(selectedTab).style.display = 'block';

		//預設第一個按鈕click
		switch (selectedTab) {
			case 'tab1':
				document.querySelector("#m_upload").click();
				break;
			case 'tab3':
				document.querySelector("#review_pr").click();
				break;
			case 'tab4':
				break;
			case 'tab5':
				userNosubscribeCount();
				userAllSubscribe();
				// selectAllMembers();
				SubscribersAndExpiresThisMonth();
				break;
			case 'tab6':
				Achievement_selectAll();
				break;
			case 'tab7':
				manufacturers_selectAll();
				break;
			case 'tab8':
				admin_selectAll();
				break;
			default:
				document.querySelector("#m_upload").click();
				break;
		}
	});
});
