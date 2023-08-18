package admin.dao;


import java.util.List;

import org.hibernate.Session;

import admin.util.HibernateUtil;
import admin.vo.Picture;
import admin.vo.Video;

public interface VideoDao {
	
	List<Video> searchVideo(String videoName);

	Integer insertVideo(Video v);
	
	Integer insertPic(Picture pic);

	boolean updateVideo(Video v);

	boolean deleteVideoById(Integer id);
	
	boolean deletePictureById(Integer id);

	// 取得當前的SessionFactory
	default Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
}
