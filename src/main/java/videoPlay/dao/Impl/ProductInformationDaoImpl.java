package videoPlay.dao.Impl;

import java.util.List;

import org.hibernate.query.Query;

import videoPlay.dao.ProductInformationDao;
import videoPlay.vo.ProductImg;
import videoPlay.vo.ProductInformation;

public class ProductInformationDaoImpl implements ProductInformationDao {

	@Override
	public List<ProductInformation> selectByName(String videoName) {
		String hql = "SELECT new videoPlay.vo.ProductInformation(productId,productName,specType,specInfo,sizeType,colorType,comId,price,videoName,productImgId,gender) FROM ProductInformation WHERE videoName = :videoName";
		Query<ProductInformation> query = getSession().createQuery(hql, ProductInformation.class);
		query.setParameter("videoName", videoName);
		return query.list();
	}
	
	
	
	public ProductImg selectImgById(Integer imgId) {
		String hql = "SELECT new videoPlay.vo.ProductImg(productImgId,img1,img2,img3,img4) FROM ProductImg WHERE productImgId = :productImgId";
		Query<ProductImg> query = getSession().createQuery(hql, ProductImg.class);
		query.setParameter("productImgId", imgId);
		
		return query.getSingleResult();
	}



	@Override
	public ProductInformation selectById(Integer productId) {
		String hql = "SELECT new videoPlay.vo.ProductInformation(productId,productName,specType,specInfo,sizeType,colorType,comId,price,videoName,productImgId,gender) FROM ProductInformation WHERE productId = :productId";
		Query<ProductInformation> query = getSession().createQuery(hql, ProductInformation.class);
		query.setParameter("productId",productId);
		return query.getSingleResult();
	}

}
