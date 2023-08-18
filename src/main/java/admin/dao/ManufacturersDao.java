package admin.dao;

import java.util.List;

import org.hibernate.Session;

import admin.util.HibernateUtil;
import admin.vo.Manufacturers;

public interface ManufacturersDao<T> {
	List<Manufacturers> selectAll();

	Manufacturers selectOne(String uniformNumbers);

	String update(Manufacturers obj);

	// 取得當前的SessionFactory
	default Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
}
