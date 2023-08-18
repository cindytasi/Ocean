package admin.dao;

import org.hibernate.Session;

import admin.util.HibernateUtil;
import videoPlay.vo.Orders;

public interface OrdersDao {

	Orders selectOrdersById(Integer id);

	// 取得當前的SessionFactory
	default Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
}
