package admin.dao;

import java.util.List;

import org.hibernate.Session;

import admin.util.HibernateUtil;

public interface MemberDao<T> {
	List<T> selectAll(Integer userId);					//查全部
	
//	Integer selectMemberQuantity(Integer userId);		//查數量
	
	// 取得當前的SessionFactory
		default Session getSession() {
			return HibernateUtil.getSessionFactory().getCurrentSession();
		}
}
