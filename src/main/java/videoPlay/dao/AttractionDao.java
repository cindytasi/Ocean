package videoPlay.dao;

import java.util.List;

import org.hibernate.Session;

import admin.util.HibernateUtil;
import videoPlay.vo.Attraction;

public interface AttractionDao {
	
	Attraction selectAttractionImgById(Integer id);
	

	// 取得當前的SessionFactory
	default Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
}
