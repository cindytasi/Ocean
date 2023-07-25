(() => {
	const btn1 = document.querySelector('#btn1');
	const msg = document.querySelector('#msg');
	const username = document.querySelector('#username');
	const password = document.querySelector('#password');
	const telephone = document.querySelector('#telephone');
	const email = document.querySelector('#email');
	const address = document.querySelector('#address');
	const confirmPassword = document.querySelector('#confirmPassword');
	const inputs = document.querySelectorAll('input');
	btn1.addEventListener('click', () => {

		const unameLength = username.value.length;

		if (unameLength == 0) {
			msg.textContent = '使用者名稱未輸入';
			return;
		}
		
		if (unameLength < 4 || unameLength > 10) {
			msg.textContent = '使用者名稱長度須介於4~10字元';
			return;
		}
		
		
		const addreLength = address.value.length;

		if (addreLength == 0) {
			msg.textContent = '地址未輸入';
			return;
		}
		
//		if (unameLength < 6 || unameLength > 10) {
//			msg.textContent = 'username未輸入';
//			return;
//		}

		const telLength = telephone.value.length;
		if (telLength == 0) {
			msg.textContent = '電話未輸入';
			return;
		}

		if (telLength != 10) {
			msg.textContent = '電話輸入錯誤';
			return;
		}
		
		const emailLength = email.value.length;


		if (emailLength == 0) {
			msg.textContent = 'email未輸入';
			return;
		}

		const pwdLength = password.value.length;
		if (pwdLength == 0) {
			msg.textContent = '密碼未輸入';
			return;
		}

		if (pwdLength < 6 || pwdLength > 12) {
			msg.textContent = '密碼長度須介於6~12字元';
			return;
		}

		if (confirmPassword.value !== password.value) {
			msg.textContent = '密碼與確認密碼不相符';
			return;
		}


		msg.textContent = '';
		fetch('/Ocean/web/controller/RegisterController', {
			method: 'POST',
			headers: { 'Content-Type': 'application/json' },
			body: JSON.stringify({
				userName: username.value,
				password: password.value,
				telephone: telephone.value,
				email: email.value,
				address: address.value
			}),
		})
			.then(resp => resp.json())
			.then(body => {
				const { successful, errormessage, message } = body;
				console.log(errormessage);
				if (successful) {
					for (let input of inputs) {
						input.disabled = true;
					}
					btn1.disabled = true;
					msg.className = 'info';
					msg.textContent = '註冊成功';
				} else {
					msg.className = 'error';
					msg.textContent = '註冊失敗';
				}
			});
	});

})();