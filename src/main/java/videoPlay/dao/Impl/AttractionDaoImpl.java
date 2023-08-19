package videoPlay.dao.Impl;

import org.hibernate.query.Query;

import videoPlay.dao.AttractionDao;
import videoPlay.vo.Attraction;

public class AttractionDaoImpl implements AttractionDao{

	@Override
	public Attraction selectAttractionImgById(Integer id) {
		String hql = "SELECT new videoPlay.vo.Attraction(attractionId,attractionPic) FROM Attraction WHERE attractionId = :attractionId";
		Query<Attraction> query = getSession().createQuery(hql,Attraction.class);
		query.setParameter("attractionId", id);
		return query.getSingleResult();
	}

}
