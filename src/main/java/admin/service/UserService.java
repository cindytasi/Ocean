package admin.service;

import admin.vo.User;

public interface UserService {
	
	public Integer selectAllSubscribe();		//訂閱會員總數
	
	public String selectById(Integer id);		//ID搜尋會員

	public String selectOne(String tag);		//名字搜尋會員
	
	public Integer selectUserAchievementDuration(Integer id);//Id搜尋成就數量
	
	public Integer selectOrdersById(Integer id); //id搜尋訂單數量
	
//	public Integer selectByExpiresCount();		//本月到期會員數量
//	
//	public Integer selectSubscribeThisMonth();	//本月訂閱會員數量
	
	public Integer selectNosubscribeCount();	//非訂閱會員數量
}
