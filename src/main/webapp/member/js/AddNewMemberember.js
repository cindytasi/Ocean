$(document).ready(function() {
	// 綁定按鈕的click事件

	const memberName = document.querySelector('#memberName');
	const memberPassword = document.querySelector('#memberPassword');
	const profilePicture = document.querySelector("#upload_btn");//圖片檔
	const uploadBtn = $('#upload_btn'); // 上傳按鈕
	const previewImage = $('#preview_image'); // 預覽圖片



	let childMember_value = false;
	$('#childMember').on('change', function() {
		console.log(this.checked);
		if (this.checked) {
			childMember_value = true;
		} else {
			childMember_value = false;
		}
	});

	$("#btn_new_member").click(function() {

		console.log('aaaaa');
		// 在這裡執行fetch請求
		// 綁定change事件

		// console.log(childMember_value);
		// fetch('/Ocean/web/controller/AddNewMemberController', {
		// 	method: 'POST', // 或者 'GET'，'PUT'等，取決於你的API需求
		// 	headers: {
		// 		'Content-Type': 'application/json', // 根據你的API需求設置合適的Content-Type
		// 	},
		// 	body: JSON.stringify({
		// 		// 請根據你的需求提供需要傳遞的數據
		// 		memberName: memberName.value,
		// 		childMember: childMember_value,
		// 		memberPassword: memberPassword.value,
		// 		userId: sessionStorage.getItem('userId')
		// 		// profilePicture:

		// 	}),
		// })
		// 	.then(response => response.json())
		// 	.then(data => {
		// 		const { successful, message } = data
		// 		// 在這裡處理fetch請求的回應
		// 		console.log(successful);
		// 		console.log(message);
		// 	})
		// 	.catch(error => {
		// 		// 處理錯誤
		// 		console.error('Fetch錯誤:', error);
		// 	});


		const formData = new FormData();
		formData.append("memberName", memberName.value);
		formData.append("memberPassword", memberPassword.value);
		formData.append("userId", sessionStorage.getItem('userId'));
		formData.append("childMember", childMember_value);
		formData.append("profilePicture", profilePicture.files[0]);

		console.log(formData);
		fetch('/Ocean/web/controller/MemberImageController', {
			method: 'POST',
			body: formData
		}).then(response => response.json())
			.then(body => {
				const { successful, message } = body;
				console.log(successful);
				if (successful) {
					
//					msg.textContent = message;
					location.href = 'http://localhost:8080/Ocean/member/member.html';

				} else {
//					msg.textContent = message;
				}
			});
	});
	// });


	// $(document).ready(function () {
	// 選取相關的元素

	// 當選擇文件時的處理
	uploadBtn.on('change', function(e) {
		console.log("aaaaa");
		const file = e.target.files[0]; // 獲取選擇的文件
		uploadFile(file); // 執行上傳文件的函式
	});

	// 上傳文件的函式
	function uploadFile(file) {
		const reader = new FileReader(); // 創建一個 FileReader 物件來讀取文件

		reader.onload = function() {
			previewImage.attr('src', reader.result); // 設定預覽圖片的來源
		}

		reader.readAsDataURL(file); // 開始讀取文件並轉換為 Data URL
	}
});
