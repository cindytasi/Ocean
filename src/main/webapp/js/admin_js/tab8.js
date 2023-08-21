//按新增顯示輸入框
document.querySelector("#add_admin").addEventListener("click", function() {
	document.querySelector(".add_admin_insert").style.display = "block";
});

// 按下管理員帳號標籤載入清單
function admin_selectAll() {
	document.querySelector(".add_admin_insert").style.display = "none";
	const table = document.querySelector("#admin_info");
	table.innerHTML = `
                <tr>
                    <th>管理員編號</th>
                    <th>管理員名稱</th>
                    <th>管理員帳號</th>
                    
                    <th></th>
                    <th></th>
                </tr>
                `;
	ad_mode = 'select';
	//let select = {"adMode":ad_mode};
	fetch('/Ocean/adminController')
		.then(response => response.json())
		.then(data => {

			for (let i = 0; i < data.length; i++) {

				let row = document.createElement('tr');
				row.setAttribute('id', 'tr' + i);

				//編號
				let adminId = document.createElement('td');
				adminId.textContent = data[i]["adminId"];
				row.appendChild(adminId);

				//名稱
				let adminName = document.createElement('td');
				adminName.textContent = data[i]["adminName"];
				row.appendChild(adminName);

				//帳號
				let adminAccount = document.createElement('td');
				adminAccount.textContent = data[i]["adminAccount"];
				row.appendChild(adminAccount);

				//修改按鈕
				let ad_upd_btn = document.createElement('td');
				ad_upd_btn.innerHTML = '<button id="admin_update_btn' + i + '" style="width:auto;" onclick="admin_update_btn(' + `${i}` + ')">修改密碼</button>';
				row.appendChild(ad_upd_btn);

				// 刪除按鈕
				let ad_delete_btn = document.createElement('td');

				// 將btn加上自動編號鎖定欄位
				// 紀錄該欄位tr的ID
				ad_delete_btn.innerHTML = '<button id="admin_delete_btn' + i + '"type="button" onclick="admin_delete_btn(' + `${i}` + ')">刪除</button>';
				row.appendChild(ad_delete_btn);

				table.appendChild(row);
				ad_mode = '';
			}
		})
		.catch(error => {
			console.error('Error:', error);
		});
}

var ad_mode = "";

// 確定新增按鈕
function submit_add_admin() {
	let admin_name = document.querySelector("#admin_name").value.trim();
	let admin_account = document.querySelector("#admin_account").value.trim();
	let admin_password = document.querySelector("#admin_password").value.trim();
	let rows = document.querySelector("#admin_info").rows;
	let msg = '';
	for (let i = 1; i < rows.length; i++) {
		let name_check = rows[i].cells[1].innerHTML;
		let account_check = rows[i].cells[2].innerHTML;

		if (admin_name == name_check || admin_account == account_check) {
			msg = "帳號或名稱重複，請重新輸入";
			break;
		} else if (admin_name == '' || admin_account == '' || admin_password == '') {
			msg = "請輸入完整內容";
			break;
		}
	}
	if (msg == "帳號或名稱重複，請重新輸入" || msg == '請輸入完整內容') {

		return alert(msg);
	} else {
		ad_mode = "insert";
		let InsertData = {
			"adminName": admin_name,
			"adminAccount": admin_account,
			"adminPassword": admin_password,
			"adMode": ad_mode
		};
		fetch("/Ocean/adminController", {
			method: 'POST',
			headers: { 'Content-Type': 'application/json' },
			body: JSON.stringify(InsertData)
		})
			.then(response => response.text())
			.then(resMsg => {
				admin_selectAll();
				msg = '';
				alert(resMsg);
			})
			.catch(error => {
				console.log('Error:', error);
			})
			.finally(
				admin_selectAll()
			);
	}

}

// 修改密碼
function admin_update_btn(tr_id) {
	var newPassword = prompt('請輸入新密碼');
	var firstTd = document.querySelector('#tr' + tr_id).firstChild;
	var adminId = firstTd.textContent;
	ad_mode = 'update';
	if (newPassword == null) {
		admin_selectAll();
	} else {
		var up_data = {
			"adminId": adminId,
			"adminPassword": newPassword,
			"adMode": ad_mode
		}
		fetch('/Ocean/adminController', {
			//mode: 'no-cors',
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify(up_data)
		})
			// function(response){response.text();}
			.then(response => response.text())
			.then(data => {
				admin_selectAll();
				alert(data);
			}).catch(error => {
				console.error('Error:', error);
			})
			.finally(
				admin_selectAll()
			);
	}

}

// 刪除按鈕
function admin_delete_btn(tr_id) {
	let yes = confirm('你確定嗎？');
	if (!yes) {
		admin_selectAll();
	} else {
		var firstTd = document.querySelector('#tr' + tr_id).firstChild;
		var adminId = firstTd.textContent;
		ad_mode = "delete";
		var data = {
			"adminId": adminId,
			"adMode": ad_mode
		};
		fetch('/Ocean/adminController', {
			//mode: 'no-cors',
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify(data)
		}).then(response => response.text())
			.then(data => {
				admin_selectAll();
				alert(data);
			}).catch(error => {
				console.error('Error:', error);
			})
			.finally(
				admin_selectAll()
			);
	}

}

// 取消新增，隱藏並清空欄位
document.querySelector("#cancel_add_admin").addEventListener("click", function() {
	clear();
	document.querySelector(".add_admin_insert").style.display = "none";
});

//清空輸入框
function clear() {
	document.querySelector("#admin_name").value = '';
	document.querySelector("#admin_account").value = '';
	document.querySelector("#admin_password").value = '';
}