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

	@Override
	public UserVo edit(UserVo userVo) {
		
//		System.out.println(userVo.getEmail());
//		System.out.println(userVo.getUserName());
		final int resultCount = userdao.updata(userVo);
		userVo.setSuccessful(resultCount > 0);
		userVo.setMessage(resultCount > 0 ? "修改成功" : "修改失敗");
		System.out.println(userVo.getMessage());
		return userVo;
	}
	
	public UserVo register(UserVo userVo) {
		
		if(duplicateregister(userVo.getEmail())) {
			userVo.setMessage("email重複");
			userVo.setSuccessful(false);
			return  userVo;
		}else {
			
			if(userdao.insert(userVo) > -1) {
				userVo.setMessage("註冊成功");
				userVo.setSuccessful(true);
				return userVo;
			}
			userVo.setMessage("註冊失敗");
			userVo.setSuccessful(false);
			return userVo;
		}
	}

//	public String login(String email, String password) {
//		System.out.println("service login");
//		return userdao.selectForLogin(email, password);
////		呼叫 loginDaoImp 物件的 authenticate 方法來進行使用者認證，並返回結果
//	}
	
	@Override
	public UserVo login(UserVo userVo) {
		final String email = userVo.getEmail();
		final String password = userVo.getPassword();
		
		if (email == null) {
			userVo.setMessage("使用者名稱未輸入");
			userVo.setSuccessful(false);
			return userVo;
		}
		
		if (password == null) {
			userVo.setMessage("密碼未輸入");
			userVo.setSuccessful(false);
			return userVo;
		}
		
		userVo = userdao.selectForLogin(email, password);

		if (userVo.getUserName() != null) {
			userVo.setMessage("登入成功");
			userVo.setSuccessful(true);
//			System.out.println("service"+userVo.isSuccessful());
			return userVo;
		}
		userVo = new UserVo();
		userVo.setMessage("使用者名稱或密碼錯誤");
		userVo.setSuccessful(false);
//		System.out.println("service"+userVo.isSuccessful());
		return userVo;
	}
}
