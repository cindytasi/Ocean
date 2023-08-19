package videoPlay.dao;

import java.util.List;

import org.hibernate.Session;

import admin.util.HibernateUtil;
import videoPlay.vo.ProductImg;
import videoPlay.vo.ProductInformation;

public interface ProductInformationDao {
	
	List<ProductInformation> selectByName(String videoName);
	
	ProductInformation selectById(Integer productId);
	
	ProductImg selectImgById(Integer imgId);

	// 取得當前的SessionFactory
	default Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
}
