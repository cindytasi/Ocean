// // $('.add-profile').on('click', function () {
// //     // 使用 prompt 函式彈出對話框，請使用者輸入新使用者的名稱
// // 	console.log("aaaa");
// //     const newUserName = prompt('請輸入新使用者的名稱：');
// //     if (newUserName) { // 如果使用者輸入了名稱
// //         // 使用 prompt 函式再彈出對話框，請使用者輸入新使用者的圖片路徑
// //         const newUserImagePath = prompt('請輸入新使用者的圖片路徑：');
// //         // 新增一個 li 元素，並將使用者名稱和圖片顯示在其中
// //         const newLi = `
// //             <li class="profile">
// //                 <div>
// //                     <img src="${newUserImagePath}" alt="Member image" class="member_image">
// //                 </div>
// //                 <span>${newUserName}</span>
// //             </li>
// //         `;
// //         // 將新的 li 元素新增到 ul 元素的末尾
// //         $('ul').append(newLi);
// //     }
// // });

$(document).ready(function () {
	// 使用jQuery的.on()方法來綁定reset事件
	$("#the_form").on("reset", function () {
		// console.log("aaa");
		p_count_el.html("1");
		// 當reset事件發生時，p_count_el的值會回復成1
		navigator_geolocatio();
		check_fullscreen_enabled();
		preview_el.html('<span class="text">預覽圖</span>');
		sessionStorage.clear();
	});
});


var drop_zone_e1 = document.getElementById("drop_zone");

// 當dragover事件發生時，刪除瀏覽器的預設行為，預設行為為開新頁顯示圖片
drop_zone_e1.addEventListener("dragover", function (e) {
	e.preventDefault();
});

// 當dragenter事件發生時，將class屬性的"-on"加上
drop_zone_e1.addEventListener("dragenter", function (e) {
	e.target.classList.add("-on");
});

// 當dragleave事件發生時，將class屬性的"-on"刪除
drop_zone_e1.addEventListener("dragleave", function (e) {
	e.target.classList.remove("-on");
});

// drop 事件發生時
drop_zone_e1.addEventListener("drop", function (e) {
	e.preventDefault(); // 如果是從電腦檔案拖曳過來，就停掉預設行為
	e.target.classList.remove("-on");

	preview_img(e.dataTransfer.files[0]);
	p_file_el.vaule = "";
});

$(document).ready(function () {
	// 綁定拖放事件
	$("#drop_zone").on("dragover", function (e) {
		e.preventDefault(); // 防止預設行為（打開文件）
		$(this).addClass("dragover");
	});

	$("#drop_zone").on("dragleave", function () {
		$(this).removeClass("dragover");
	});

	$("#drop_zone").on("drop", function (e) {
		e.preventDefault();
		$(this).removeClass("dragover");

		// 獲取拖放的文件
		var file = e.originalEvent.dataTransfer.files[0];

		// 判斷是否是圖片
		if (file.type.match("image.*")) {
			// 創建FileReader物件來讀取文件
			var reader = new FileReader();

			// 當讀取完成時執行
			reader.onload = function (event) {
				// 將讀取的圖片數據設置為預覽圖片
				$("#drop_zone").html('<img src="' + event.target.result + '" alt="Preview" class="preview_image">');
			};

			// 開始讀取文件
			reader.readAsDataURL(file);
		}
	});
});




$(document).ready(function () {
	// 綁定按鈕的click事件
	var childMember_value = '';
	$('#childMember').on('change', function () {
		if (this.checked) {
			childMember_value = true;
		} else {
			childMember_value = false;
		}
	});

	$("#btn_new_member").click(function () {
		// 在這裡執行fetch請求
		// 綁定change事件

		// console.log(childMember_value);
		fetch('/Ocean/web/controller/AddNewMemberController', {
			method: 'POST', // 或者 'GET'，'PUT'等，取決於你的API需求
			headers: {
				'Content-Type': 'application/json', // 根據你的API需求設置合適的Content-Type
			},
			body: JSON.stringify({
				// 請根據你的需求提供需要傳遞的數據
				memberName: memberName.value,
				childMember: childMember_value,
				memberPassword: memberPassword.value,
				userId: sessionStorage.getItem('userId')
				// profilePicture:

			}),
		})
			.then(response => response.json())
			.then(data => {
				// 在這裡處理fetch請求的回應
				console.log(data);
			})
			.catch(error => {
				// 處理錯誤
				console.error('Fetch錯誤:', error);
			});
	});
});