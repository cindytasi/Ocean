(() => {
	const nav = document.createElement('nav');
	nav.classList.add('navbar', 'navbar-expand', 'navbar-dark', 'bg-dark');
	nav.innerHTML = `
    <div class="container-fluid">
		<a class="navbar-brand" href="${getContextPath()}/index.html">會員系統</a>
		<div class="collapse navbar-collapse" id="navbarScroll">
			<ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
				<li id="register" class="nav-item">
					<a href="${getContextPath()}/register/register.html" class="nav-link active" aria-current="page">註冊</a>
				</li>
				<li id="edit" class="nav-item">
					<a href="${getContextPath()}/edit/edit.html" class="nav-link active" aria-current="page">編輯會員資訊</a>
				</li>
                <li id="manage" class="nav-item">
					<a href="${getContextPath()}/manage" class="nav-link active" aria-current="page">會員管理</a>
				</li>
				<li id="login" class="nav-item">
					<a href="${getContextPath()}/login/login.html" class="nav-link active" aria-current="page">登入</a>
				</li>
				<li id="logout" class="nav-item">
					<a href="#" class="nav-link active" aria-current="page">登出</a>
				</li>
			</ul>
			<div class="d-flex">
				<div id="currentUser" class="me-2 text-light"></div>
			</div>
		</div>
	</div>
`;
	const body = document.querySelector('body');
	body.insertBefore(nav, body.firstChild);

	const userName = sessionStorage.getItem('userName');
	const userId = sessionStorage.getItem('userId');
//	const roleId = sessionStorage.getItem('roleId');
	const register = document.querySelector('#register');
	const edit = document.querySelector('#edit');
	const manage = document.querySelector('#manage');
	const login = document.querySelector('#login');
	const logout = document.querySelector('#logout');
	if (userName) {
		console.log(userName);
		
		register.classList.add('hide');
		edit.classList.remove('hide');
//		roleId == 1 ? manage.classList.remove('hide') : manage.classList.add('hide');
		login.classList.add('hide');
		logout.classList.remove('hide');
		document.querySelector('#currentUser').textContent = userName+userId;
	} else {
		register.classList.remove('hide');
		edit.classList.add('hide');
		manage.classList.add('hide');
		login.classList.remove('hide');
		logout.classList.add('hide');
	}

	logout.addEventListener('click', () => {
		sessionStorage.removeItem('userName');
		fetch('/Ocean/web/controller/LogoutContorller"');
		location.href = 'http://localhost:8080/Ocean/index.html';
	});

	function getContextPath() {
		return window.location.pathname.substring(0, window.location.pathname.indexOf('/', 2));
	}

})();