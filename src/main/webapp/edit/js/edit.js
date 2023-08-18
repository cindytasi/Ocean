(() => {
	const btn1 = document.querySelector('#btn1');
	const email = document.querySelector('#email');
	const username = document.querySelector('#username');
	const telephone = document.querySelector('#telephone');
	const address = document.querySelector('#address');
	const oPassword = document.querySelector('#oPassword');
	init();

	function init() {
		btn1.addEventListener('click', edit);

		fetch('/Ocean/web/controller/GetInfoController', {
			method: 'POST',
			headers: { 'Content-Type': 'application/json' },
		})
			.then(resp => resp.json())
			.then(body => {
				email.value = body['email'];
				username.value = body['userName'];
				address.value = body['address'];
				telephone.value = body['telephone'];
			});

		oPassword.addEventListener('blur', checkOldPassword);
	}

	function checkOldPassword() {
		fetch('/Ocean/web/controller/CheckPasswordController', {
			method: 'POST',
			headers: { 'Content-Type': 'application/json' },
			body: JSON.stringify({ 
				password: oPassword.value 
				})
		})
			.then(resp => resp.json())
			.then(body => {
				btn1.disabled = !body['successful']
			});
	}

	const msg = document.querySelector('#msg');
	const nPassword = document.querySelector('#nPassword');
	const confirmPassword = document.querySelector('#confirmPassword');
	const currentUser = document.querySelector('#currentUser');

	function edit() {
		if (nPassword.value && confirmPassword.value) {
			if (nPassword.value.length < 6 || nPassword.value.length > 12) {
				msg.textContent = '密碼長度須介於6~12字元';
				return;
			}

			if (confirmPassword.value !== nPassword.value) {
				msg.textContent = '密碼與確認密碼不相符';
				return;
			}
		}

		const telLength = telephone.value.length;
		if (telLength == 0) {
			msg.textContent = '電話未輸入';
			return;
		}

		if (telLength != 10) {
			msg.textContent = '電話輸入錯誤';
			return;
		}
		
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

		msg.textContent = '';

		fetch('/Ocean/web/controller/EditController', {
			method: 'POST',
			headers: {'Content-Type': 'application/json'},
			body: JSON.stringify({
				email: email.value,
				userName: username.value,
				password: nPassword.value,
				telephone: telephone.value,
				address: address.value
			}),
		})
			.then(resp => resp.json())
			.then(body => {
				const { successful, message, nickname: nicknameValue } = body;
				if (successful) {
					msg.className = 'info';
					sessionStorage.setItem('nickname', nicknameValue);
					currentUser.textContent = nicknameValue;
					oPassword.value = '';
					nPassword.value = '';
					confirmPassword.value = '';
					nickname.value = nicknameValue;
					btn1.disabled = true;
				} else {
					msg.className = 'error';
				}
				msg.textContent = message;
			});
	}
})();