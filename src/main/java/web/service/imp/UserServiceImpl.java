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
	public UserVo register(UserVo userVo) {
		
		
		final int resultCount = userdao.insert(userVo);
		if (resultCount < 1) {
			userVo.setMessage("註冊錯誤，請聯絡管理員!");
			userVo.setSuccessful(false);
			return userVo;
		}
		userVo.setMessage("註冊成功");
		userVo.setSuccessful(true);
		return userVo;
	}

	public String login(String email, String password) {
		System.out.println("service login");
		return userdao.selectForLogin(email, password);
//		呼叫 loginDaoImp 物件的 authenticate 方法來進行使用者認證，並返回結果
	}
}
