package web.service;

import web.vo.UserVo;

public interface UserService {

//	String login(String email, String password);
	
	 UserVo login(UserVo userVo);
	
	boolean duplicateregister(String email) ;

	UserVo register(UserVo userVo);
	
	UserVo edit(UserVo userVo);
	
}
