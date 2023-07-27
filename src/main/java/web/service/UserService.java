package web.service;

import web.vo.UserVo;

public interface UserService {

	public String login(String email, String password);
	
	public boolean duplicateregister(String email) ;

	UserVo register(UserVo userVo);
	
}
