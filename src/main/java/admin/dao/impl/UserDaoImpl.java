package admin.dao.impl;

import org.hibernate.query.Query;

import admin.dao.UserDao;
import admin.vo.User;

public class UserDaoImpl implements UserDao<User> {

	@Override
	public Integer selectAllSubscribe() { // 訂閱會員總數
		String hql = "select count(*) from User where statusCode = 1";
		Query query = getSession().createQuery(hql);
		Long tmp = (Long) query.uniqueResult();
		
		return tmp.intValue();
	}

	@Override
	public User selectById(Integer id) { // ID搜尋會員
		String seachIdHql = "SELECT new admin.vo.User(userId, userName, address, telephone, email, statusCode) FROM User WHERE userId = :userId";
		Query<User> query = getSession().createQuery(seachIdHql, User.class);
		query.setParameter("userId", id);
		return query.getSingleResult();
	}
	////////////////////////////////////////////////////////////
	
	@Override							//ID查詢會員的成就數量
	public Integer selectUserAchievementDuration(Integer id) {
		String hql = "select count(*) from UserAchievementDuration where userId = :userId";
		Query query = getSession().createQuery(hql);
		query.setParameter("userId", id);
		Long tmp = (Long) query.uniqueResult();
		
		return tmp.intValue();
	}
	
	@Override							//ID查詢會員的訂單數量
	public Integer selectOrdersById(Integer id) {
		String hql = "select count(*) from Orders  where userId = :userId";
		Query query = getSession().createQuery(hql);
		query.setParameter("userId", id);
		Long tmp = (Long) query.uniqueResult();
		
		return tmp.intValue();
	}


	////////////////////////////////////////////////////////////

	@Override
	public User selectOne(String name) { // 名字搜尋會員
		String seachIdHql = "SELECT new admin.vo.User(userId, userName, address, telephone, email, account, statusCode) FROM User WHERE userName = :userName";
		Query<User> query = getSession().createQuery(seachIdHql, User.class);
		query.setParameter("userName", name);
		return query.getSingleResult();
	}

	@Override
	public Integer selectNosubscribeCount() { // 非訂閱會員數量
		String hql = "select count(*) from User as User where statusCode = 2";

		Query query = getSession().createQuery(hql);
		Long tmp = (Long) query.uniqueResult();
		
		return tmp.intValue();
	}

	
	

}
