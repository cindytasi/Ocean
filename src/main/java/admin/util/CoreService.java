package admin.util;

import org.hibernate.Transaction;

public interface CoreService {
	default Transaction beginTransaction() {
		return HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
	}

	default void commit() {
		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
	}

	default void rollback() {
		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
	}
}
