package login.service.imp;

import login.dao.LoginDao;
import login.dao.imp.LoginDaoImp;
import login.service.LoginService;

public class LoginServiceImp implements LoginService {

	private LoginDao logindao;
	
	public LoginServiceImp() {
		logindao = new LoginDaoImp();
	}
	
	public String login(String email, String password) {
		return logindao.authenticate(email, password);
//		呼叫 loginDaoImp 物件的 authenticate 方法來進行使用者認證，並返回結果
	}
}
