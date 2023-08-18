package admin.dao.impl;

import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.query.Query;

import admin.dao.UserSubsIdDao;

public class UserSubsIdDaoImpl implements UserSubsIdDao{

	@Override
	public Integer expiresThisMonth() {				//本月到期會員人數
		String hql = "SELECT COUNT(*) FROM UserSubsId as UserSubsId where month(expirationDate) = month(now()) AND YEAR(expirationDate) = YEAR(NOW())";
		Query query = getSession().createQuery(hql);
		Long tmp = (Long) query.uniqueResult();
		
		return tmp.intValue();
	}

	@Override
	public Integer subscribersThisMonth() {			//本月加入訂閱數量
		
		String hql = "SELECT COUNT(*) FROM UserSubsId as UserSubsId where month(subscriptionDate) = month(now()) AND YEAR(subscriptionDate) = YEAR(NOW())";
		Query query = getSession().createQuery(hql);
		Long tmp = (Long) query.uniqueResult();
		
		return tmp.intValue();
	}

	@Override
	public Timestamp expirationDateById(Integer id) {		//ID搜尋到期日
		String hql = "select expirationDate from UserSubsId where userId = :userId and (year(expirationDate)>=year(now()) and month(expirationDate)>=month(now()))";
		Query query = getSession().createQuery(hql);
		query.setParameter("userId", id);
		Timestamp tmp = (Timestamp)query.uniqueResult();
		return tmp;
	}

}
