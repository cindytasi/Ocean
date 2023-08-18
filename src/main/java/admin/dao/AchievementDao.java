package admin.dao;

import java.util.List;

import org.hibernate.Session;

import admin.util.HibernateUtil;

public interface AchievementDao<T> {
	List<T> selectAll(); 			// 查全部
	
	String insert(T obj);			//新增單筆
	
	String update(T obj);			//更新廠商資訊
	
	String delete(Integer id);		//刪除

	// 取得當前的SessionFactory
	default Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
}
