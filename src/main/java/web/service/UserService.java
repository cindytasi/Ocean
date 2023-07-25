package web.service;

import web.vo.UserVo;

public interface UserService {

	public String login(String email, String password);
	
	UserVo register(UserVo userVo);
	
}
