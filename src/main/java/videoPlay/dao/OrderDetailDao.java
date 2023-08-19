package videoPlay.dao;

import org.hibernate.Session;

import admin.util.HibernateUtil;
import videoPlay.vo.OrderDetail;

public interface OrderDetailDao {

	String insertOrderDetail(OrderDetail odd);

	// 取得當前的SessionFactory
	default Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
}
