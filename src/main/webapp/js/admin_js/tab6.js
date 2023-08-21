//按新增後顯示輸入框
document.querySelector("#ach_add_btn").addEventListener("click", function () {
	document.querySelector("#ach_insert_div").style.display = 'block';
});
//按取消後隱藏並清空輸入框
document.querySelector("#ach_cancel_btn").addEventListener("click", function () {
	document.querySelector("#ach_insert_div").style.display = 'none';
	document.querySelector("#achievementName").value = '';
	document.querySelector("#domainName").value = '請選擇';
	document.querySelector("#achievementThresholdHours").value = '';
});

//查詢全部
function Achievement_selectAll() {
	const Achievement_info = document.querySelector("#Achievement_info");
	Achievement_info.innerHTML = `
		<tr>
			<th>編號</th>
			<th>成就名稱</th>
			<th>領域</th>
			<th>門檻時數</th>
			<th></th>
			<th></th>
		</tr>
	`;
	fetch('/Ocean/AchievementSelectController')
		.then(response => response.json())
		.then(data => {
			for (let i = 0; i < data.length; i++) {
				let row = document.createElement('tr');
				row.setAttribute('id', 'ach_tr' + i);

				//Id
				let achievementId = document.createElement('td');
				achievementId.textContent = data[i]["achievementId"];
				row.appendChild(achievementId);

				//成就名稱
				let achievementName = document.createElement('td');
				achievementName.setAttribute("contenteditable", "false");
				achievementName.textContent = data[i]["achievementName"];
				row.appendChild(achievementName);

				//領域
				let domainName = document.createElement('td');
				domainName.setAttribute("contenteditable", "false");
				domainName.textContent = DomainIdToDomainName(data[i]["domainId"]);
				row.appendChild(domainName);

				//達成時數條件
				let achievementThresholdHours = document.createElement('td');
				achievementThresholdHours.setAttribute("contenteditable", "false");
				achievementThresholdHours.textContent = data[i]["achievementThresholdHours"];
				row.appendChild(achievementThresholdHours);

				//修改按鈕
				let ach_upd_btn = document.createElement('td');
				ach_upd_btn.innerHTML = '<button id="ach_update_btn' + i + '" type="button" style="width:auto;" onclick="ach_update_btn(' + `${i}` + ')">修改</button>';
				row.appendChild(ach_upd_btn);

				//刪除按鈕
				let ach_del_btn = document.createElement('td');
				ach_del_btn.innerHTML = '<button id="ach_del_btn' + i + '" type="button" style="width:auto;" onclick="ach_del_btn(' + `${i}` + ')">刪除</button>';
				row.appendChild(ach_del_btn);

				Achievement_info.appendChild(row);
			}
		})
		.catch(error => {
			console.error('Error:', error);
		});
}

//新增
function ach_insert_btn() {
	let achievementName = document.querySelector("#achievementName").value.trim();
	let domainName = document.querySelector("#domainName").value;
	let achievementThresholdHours = document.querySelector("#achievementThresholdHours").value.trim();
	let ok = false;

	if (achievementName == '' || domainName == '請選擇' || achievementThresholdHours == '') {
		ok = false;
		alert("請輸入完整資料");
	} else {
		ok = true;
	}

	if (isNaN(achievementThresholdHours) || achievementThresholdHours <= 0) {
		ok = false;
		alert("請輸入正確的時數");
	} else {
		ok = true;
	}

	let rows = document.querySelector("#Achievement_info").rows;
	for (let i = 0; i < rows.length; i++) {
		if (achievementName == rows[i].cells[1].innerHTML) {
			alert("名稱重複，請重新輸入");
			ok = false;
			break;
		}
	}

	let domainId = DomainNameToDomainId(domainName);//名稱轉ID
	//console.log(domainId);
	let data = {
		"achievementName": achievementName,
		"domainId": domainId,
		"achievementThresholdHours": achievementThresholdHours
	};

	if (ok == false) {
		Achievement_selectAll();
	} else {
		fetch('/Ocean/AchievementInsertController', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify(data)
		})
			.then(response => response.text())
			.then(msg => {
				alert(msg);
				Achievement_selectAll();
			})
	}

}

//修改按鈕，進入編輯狀態
function ach_update_btn(e) {

	let Achievement_info = document.querySelector("#Achievement_info");
	// let achievementId = Achievement_info.rows[e + 1].cells[0].innerHTML;
	let tr_row = Achievement_info.rows[e + 1];
	tr_row.cells[1].setAttribute("contenteditable", "true");
	tr_row.cells[3].setAttribute("contenteditable", "true");
	let olddomainName = tr_row.cells[2].innerHTML;
	tr_row.cells[2].innerHTML = `
	<select name="field" id="newdomainName">
		<option value="請選擇" selected>請選擇</option>
		<option value="喜劇">喜劇</option>
		<option value="卡通">卡通</option>
		<option value="動漫">動漫</option>
		<option value="驚悚劇">驚悚劇</option>
		<option value="愛情劇">愛情劇</option>
		<option value="奇幻劇">奇幻劇</option>
		<option value="懸疑劇">懸疑劇</option>
		<option value="科幻劇">科幻劇</option>
		<option value="動作劇">動作劇</option>
		<option value="紀錄片">紀錄片</option>
	</select>
	`;
	document.querySelector("#newdomainName").value=olddomainName;
	//將修改變為確定新增
	document.querySelector("#ach_update_btn" + e).textContent = '確定新增';
	document.querySelector("#ach_update_btn" + e).setAttribute("onclick", "ach_up_checked_btn(" + e + ")");
	document.querySelector("#ach_update_btn" + e).setAttribute('id', 'ach_up_checked_btn' + e);

	//將刪除變更為取消
	document.querySelector("#ach_del_btn" + e).textContent = '取消';
	document.querySelector("#ach_del_btn" + e).setAttribute("onclick", "ach_cancelChange_btn()");
	document.querySelector("#ach_del_btn" + e).setAttribute("id", "ach_cancelChange_btn" + e);
}

//按下確定修改
function ach_up_checked_btn(e) {
	let Achievement_info = document.querySelector("#Achievement_info");
	let achievementId = Achievement_info.rows[e + 1].cells[0].innerHTML;
	let tr_row = Achievement_info.rows[e + 1];
	//取得成就名稱
	let achievementName = tr_row.cells[1].textContent;
	
	//取得下拉選單的文字
	let newdomainName = document.querySelector("#newdomainName").value;//options[selectedIntex].text;
	
	//取得時數條件
	let achievementThresholdHours = tr_row.cells[3].textContent;
	let up_check = true;
	//領域名稱轉ID
	let domainId = DomainNameToDomainId(newdomainName);

	if (achievementName == '' || domainId == '請選擇' || achievementThresholdHours == '') {
		alert("請輸入完整資料");
		up_check = false;
	}
	if (isNaN(achievementThresholdHours) || achievementThresholdHours < 0) {
		alert("請輸入正確的時數");
		up_check = false;
	}

	let data = {
		"achievementId": achievementId,
		"achievementName": achievementName,
		"domainId": domainId,
		"achievementThresholdHours": achievementThresholdHours
	};
	
	if (up_check == false) {

	} else {
		fetch('/Ocean/AchievementUpdateController', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify(data)
		})
			.then(response => response.text())
			.then(msg => {
				alert(msg);
				Achievement_selectAll();
			});
	}
}

//取消按鈕
function ach_cancelChange_btn() {
	Achievement_selectAll();
}


//刪除
function ach_del_btn(e) {
	let yes = confirm('你確定嗎？');
	if (!yes) {
		Achievement_selectAll();
	} else {
		let ach_row = document.querySelector("#ach_tr" + e).firstChild;
		let achievementId = ach_row.textContent;
		fetch('/Ocean/AchievementDeleteController', {
			method: 'POST',
			headers: { 'Content-Type': 'application/json' },
			body: JSON.stringify({ "achievementId": achievementId })
		})
			.then(res => res.text())
			.then(msg => {
				alert(msg);
				Achievement_selectAll();
			})
			.catch(error => {
				console.error('Error:', error);
			});
	}
}

//領域名改成ID
function DomainNameToDomainId(name) {
	let domainId;
	switch (name) {
		case '喜劇':
			domainId = 1;
			break;
		case '卡通':
			domainId = 2;
			break;
		case '動漫':
			domainId = 3;
			break;
		case '驚悚劇':
			domainId = 4;
			break;
		case '愛情劇':
			domainId = 5;
			break;
		case '奇幻劇':
			domainId = 6;
			break;
		case '懸疑劇':
			domainId = 7;
			break;
		case '科幻劇':
			domainId = 8;
			break;
		case '動作劇':
			domainId = 9;
			break;
		case '紀錄片':
			domainId = 10;
			break;
	}
	return domainId;
}

//ID改領域名
function DomainIdToDomainName(domainId) {
	let name;
	switch (domainId) {
		case 1:
			name = '喜劇';
			break;
		case 2:
			name = '卡通';
			break;
		case 3:
			name = '動漫';
			break;
		case 4:
			name = '驚悚劇';
			break;
		case 5:
			name = '愛情劇';
			break;
		case 6:
			name = '奇幻劇';
			break;
		case 7:
			name = '懸疑劇';
			break;
		case 8:
			name = '科幻劇';
			break;
		case 9:
			name = '動作劇';
			break;
		case 10:
			name = '紀錄片';
			break;
	}
	return name;
}