package web.dao;

import web.vo.UserVo;

public interface UserDao {

	int insert(UserVo userVo);
	
	int updata(UserVo userVo);

	UserVo selectByEmailFromEdit(String email);
	
	boolean selectByEmail(String email);

//	String selectForLogin(String email, String password);
	UserVo selectForLogin(String email, String password);

}
