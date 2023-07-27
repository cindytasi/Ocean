package web.service.imp;

import web.dao.UserDao;
import web.dao.imp.UserDaoImpl;
import web.service.UserService;
import web.vo.UserVo;

public class UserServiceImpl implements UserService {

	private UserDao userdao;

	public UserServiceImpl() {
		userdao = new UserDaoImpl();
	}

	@Override
	
	public boolean duplicateregister(String email) {
		if (userdao.selectByEmail(email)) {
			return true;
		}
		return false;
	}
	
	public UserVo register(UserVo userVo) {
		
		if(duplicateregister(userVo.getEmail())) {
			userVo.setMessage("帳號重複");
			userVo.setSuccessful(false);
			return  userVo;
		}else {
			
			if(userdao.insert(userVo) > 1) {
				userVo.setMessage("註冊成功");
				userVo.setSuccessful(false);
				return userVo;
			}
			userVo.setMessage("註冊失敗");
			userVo.setSuccessful(false);
			return userVo;
		}
	}

	public String login(String email, String password) {
		System.out.println("service login");
		return userdao.selectForLogin(email, password);
//		呼叫 loginDaoImp 物件的 authenticate 方法來進行使用者認證，並返回結果
	}
}
