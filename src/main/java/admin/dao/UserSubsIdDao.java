package admin.dao;

import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.Session;

import admin.util.HibernateUtil;

public interface UserSubsIdDao {
	Integer expiresThisMonth();				//本月到期會員人數

	Integer subscribersThisMonth();			//本月加入訂閱數量
	
	Timestamp expirationDateById(Integer id);	//ID搜尋到期日期
	
	// 取得當前的SessionFactory
	default Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
}
