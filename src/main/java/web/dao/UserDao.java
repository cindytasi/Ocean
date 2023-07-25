package web.dao;

import web.vo.UserVo;

public interface UserDao {

	int insert(UserVo userVo);

	String selectForLogin(String email, String password);
//	UserVo selectForLogin(String email, String password);

}
