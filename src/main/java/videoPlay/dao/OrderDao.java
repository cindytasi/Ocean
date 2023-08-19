package videoPlay.dao;

import org.hibernate.Session;

import admin.util.HibernateUtil;
import videoPlay.vo.Orders;
import videoPlay.vo.OrderDetail;

public interface OrderDao {

	String insertOrder(Orders order);

	// 取得當前的SessionFactory
	default Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}

}
