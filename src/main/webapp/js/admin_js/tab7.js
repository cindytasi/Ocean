//全部廠商清單
function manufacturers_selectAll() {
	const table = document.querySelector("#manufacturers_info");
	let ms_count = document.querySelector("#ms_count");
	let count = 0;
	table.innerHTML = `
                <tr>
							<th>廠商編號</th>
							<th>廠商帳號</th>
							<th>權限</th>
							<th>匯款帳戶</th>
							<th>統一編號</th>
							<th>註冊地址</th>
							<th>手機</th>
							<th>email</th>
							<th>負責人</th>
							<th>匯款銀行戶號</th>
							<th></th>
						</tr>
                `;
	fetch('/Ocean/manufacturersSelectController')
		.then(response => response.json())
		.then(data => {
			//console.log(data);
			for (let i = 0; i < data.length; i++) {
				count= data.length;
				let row = document.createElement('tr');
				row.setAttribute('id', 'ms_tr' + i);
				
				//Id
				let comId = document.createElement('td');
				comId.textContent = data[i]["comId"];
				row.appendChild(comId);
				
				//廠商名稱
				// let comName = document.createElement('td');
				// comName.textContent = data[i]["comName"];
				// row.appendChild(comName);

				//帳號
				let comAccount = document.createElement('td');
				comAccount.textContent = data[i]["comAccount"];
				row.appendChild(comAccount);
				
				//權限
				let access = document.createElement('td');
				access.textContent = data[i]["access"];
				row.appendChild(access);
				
				//銀行帳號
				let bankAccount = document.createElement('td');
				bankAccount.textContent = data[i]["bankAccount"];
				row.appendChild(bankAccount);
				
				//公司編號
				let uniformNumbers = document.createElement('td');
				uniformNumbers.textContent = data[i]["uniformNumbers"];
				row.appendChild(uniformNumbers);
				
				//地址
				let addr = document.createElement('td');
				addr.textContent = data[i]["addr"];
				row.appendChild(addr);
				
				//電話
				let phoneNumbers = document.createElement('td');
				phoneNumbers.textContent = data[i]["phoneNumbers"];
				row.appendChild(phoneNumbers);
				
				//email
				let email = document.createElement('td');
				email.textContent = data[i]["email"];
				row.appendChild(email);
				
				//負責人
				let principal = document.createElement('td');
				principal.textContent = data[i]["principal"];
				row.appendChild(principal);
				
				//銀行代號
				let bankNum = document.createElement('td');
				bankNum.textContent = data[i]["bankNum"];
				row.appendChild(bankNum);
				
				//修改按鈕
				let ms_upd_btn = document.createElement('td');
				ms_upd_btn.innerHTML = '<button id="ms_update_btn' + i + '" type="button" style="width:auto;" onclick="msupdate_btn(' + `${i}` + ')">修改權限</button>';
				row.appendChild(ms_upd_btn);
				
				table.appendChild(row);
			}
			document.querySelector("#ms_search").innerHTML = '';
			ms_count.innerHTML = '';
			ms_count.innerHTML= "廠商總數: "+count;
		})
		.catch(error => {
			console.error('Error:', error);
		});
}

//修改權限
function msupdate_btn(tr_id) {
	let tr_row = tr_id + 1;
	let ms_table = document.querySelector("#manufacturers_info");
	let old_access = ms_table.rows[tr_row].cells[3].innerHTML;
	let firstTd = document.querySelector('#ms_tr' + tr_id).firstChild;
	let comId = firstTd.textContent;

	let access = prompt('請輸入權限(1.正常,0.有違規)');
	
	if (!(access === "1" || access === "0")) {
		alert("請輸入正確的權限號碼");
	}else if(old_access===access){
			alert("請輸入不同的權限號碼");
	} else {
		fetch('/Ocean/manufacturersUpController', {
			
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({
				"comId": comId,
				"access": access
			})
		})
			.then(response => response.text())
			.then(msg => {
				alert(msg);
				manufacturers_selectAll();
			})
			.catch(console.error('Error:', error));
	}

}

//搜尋廠商
function ms_selectOne() {
	const table = document.querySelector("#manufacturers_info");
	table.innerHTML = '';
	table.innerHTML = `
                <tr>
							<th>廠商編號</th>
							<th>廠商名稱</th>
							<th>廠商帳號</th>
							<th>權限</th>
							<th>匯款帳戶</th>
							<th>統一編號</th>
							<th>註冊地址</th>
							<th>手機</th>
							<th>email</th>
							<th>負責人</th>
							<th>匯款銀行戶號</th>
							<th></th>
						</tr>
                `;

	let uniformNumbers = document.querySelector("#ms_search").value.trim();
	console.log(uniformNumbers, uniformNumbers.length);
	if (isNaN(uniformNumbers) || uniformNumbers.length != 8) {
		alert("請輸入正確的統編");
	} else {

		fetch('/Ocean/manufacturersSelectOne', {
			method: 'POST',
			headers: { 'Content-Type': 'application/json' },
			body: JSON.stringify({ "uniformNumbers": uniformNumbers })
		})
			.then(response => response.json())
			.then(data => {
				//console.log(data);
				for (let i = 0; i < 1; i++) {

					let row = document.createElement('tr');
					row.setAttribute('id', 'ms_tr' + i);

					//Id
					let comId = document.createElement('td');
					comId.textContent = data["comId"];
					row.appendChild(comId);

					//廠商名稱
					let comName = document.createElement('td');
					comName.textContent = data["comName"];
					row.appendChild(comName);

					//帳號
					let comAccount = document.createElement('td');
					comAccount.textContent = data["comAccount"];
					row.appendChild(comAccount);

					//權限
					let access = document.createElement('td');
					access.textContent = data["access"];
					row.appendChild(access);

					//銀行帳號
					let bankAccount = document.createElement('td');
					bankAccount.textContent = data["bankAccount"];
					row.appendChild(bankAccount);

					//公司編號
					let uniformNumbers = document.createElement('td');
					uniformNumbers.textContent = data["uniformNumbers"];
					row.appendChild(uniformNumbers);

					//地址
					let addr = document.createElement('td');
					addr.textContent = data["addr"];
					row.appendChild(addr);

					//電話
					let phoneNumbers = document.createElement('td');
					phoneNumbers.textContent = data["phoneNumbers"];
					row.appendChild(phoneNumbers);

					//email
					let email = document.createElement('td');
					email.textContent = data["email"];
					row.appendChild(email);

					//負責人
					let principal = document.createElement('td');
					principal.textContent = data["principal"];
					row.appendChild(principal);

					//銀行代號
					let bankNum = document.createElement('td');
					bankNum.textContent = data["bankNum"];
					row.appendChild(bankNum);

					//修改按鈕
					let ms_upd_btn = document.createElement('td');
					ms_upd_btn.innerHTML = '<button id="ms_update_btn' + i + '" type="button" style="width:auto;" onclick="msupdate_btn(' + `${i}` + ')">修改權限</button>';
					row.appendChild(ms_upd_btn);

					table.appendChild(row);
				}
			})
			.catch(error => {
				console.error('Error:', error);
			});
	}
}