package admin.dao;

import org.hibernate.Session;

import admin.util.HibernateUtil;
import admin.vo.User;

public interface UserDao<T> {
	
	Integer selectAllSubscribe();		//訂閱會員總數
	
	User selectById(Integer id);		//ID搜尋會員

	User selectOne(String tag);			//名字搜尋會員
	
	Integer selectUserAchievementDuration(Integer id);//Id搜尋成就數量
	
	Integer selectOrdersById(Integer id); //id搜尋訂單數量
	
	Integer selectNosubscribeCount();	//非訂閱會員數量

	// 取得當前的SessionFactory
	default Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
}
