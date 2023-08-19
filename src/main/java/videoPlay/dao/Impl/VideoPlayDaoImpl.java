package videoPlay.dao.Impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;

import admin.vo.Member;
import admin.vo.Video;
import videoPlay.dao.VideoPlayDao;
import videoPlay.vo.AchievementDuration;
import videoPlay.vo.Attraction;
import videoPlay.vo.FavoriteMap;
import videoPlay.vo.Favourites;
import videoPlay.vo.MemberWatchDuration;
import videoPlay.vo.ProductLink;
import videoPlay.vo.VideoAttraction;
import videoPlay.vo.VideoReviewRecord;

public class VideoPlayDaoImpl implements VideoPlayDao {

	//影片Id查詢影片詳細資訊
	@Override
	public Video selectById(Integer id) {
		String hql = "SELECT new admin.vo.Video(videoId, videoName, videoType, videoYear, videoArea, videoDirector, videoActor, videoLength, videoSeason, videoEpisode, uploadDate, VideoReview, domainId, Introduction, views, save) FROM Video WHERE videoId = :videoId";
		Query<Video> query = getSession().createQuery(hql, Video.class);
		query.setParameter("videoId", id);
		return query.getSingleResult();
	}
	
	//影片Id取得所有綁定時間戳的商品
	@Override
	public List<ProductLink> selectProductTimeById(Integer id) {
		String hql = "SELECT new videoPlay.vo.ProductLink(productLinkId,linkTimestamp,productId) FROM ProductLink WHERE videoId = :videoId";
		Query<ProductLink> query = getSession().createQuery(hql, ProductLink.class);
		query.setParameter("videoId", id);
		return query.list();
	}
	
	//更新觀看次數
	@Override
	public Integer TimesWatched(Integer videoId) {
		Video vInfo = getSession().load(Video.class, videoId);
		vInfo.setViews(vInfo.getViews()+1);
		int views = vInfo.getViews();
		return views;
	}
	
	//更新觀看記錄
	@Override
	public String UpdateDuration(MemberWatchDuration mwd) {
		//雙主鍵取得觀看記錄
		MemberWatchDuration tmp = getSession().get(MemberWatchDuration.class, mwd.getId());
		if(tmp ==null) {
			MemberWatchDuration newMWD = new MemberWatchDuration();
			newMWD.setId(mwd.getId());
			newMWD.setWatchTimePoint(mwd.getWatchTimePoint());
			//新增記錄
			getSession().save(newMWD);
		}else {
			tmp.setWatchTimePoint(mwd.getWatchTimePoint());
			//更新紀錄
			getSession().update(tmp);
		}
		
		return "1";
	}
	
	//累計領域時數(以分鐘累加)
	@Override
	public String updateDomainTime(AchievementDuration ad) {
		AchievementDuration adn = getSession().get(AchievementDuration.class, ad.getApk());
		
		if(adn ==null) {
			AchievementDuration newADN = new AchievementDuration();
			newADN.setApk(ad.getApk());
			newADN.setWatchDuration(ad.getWatchDuration());
			getSession().save(newADN);
		}else {
			adn.setWatchDuration(ad.getWatchDuration()+1);
			getSession().update(adn);
		}
		return "1";
	}
	
	//影片加入最愛
	@Override
	public String addFavourite(Favourites fav) {
		Favourites tmp = getSession().get(Favourites.class, fav.getFpk());
		if(tmp==null) {
			Favourites newFAV = new Favourites();
			newFAV.setFpk(fav.getFpk());
			getSession().save(newFAV);
		}
		return "1";
	}
	
	//影片刪除最愛
	@Override
	public String deleteFavorite(Favourites fav) {
		Favourites tmp = getSession().get(Favourites.class, fav.getFpk());
		if(tmp!=null) {
			getSession().delete(tmp);
		}
		return "1";
	}
	//insert評價紀錄
	@Override
	public String insertVideoReviewRecord(VideoReviewRecord vrrd) {
		VideoReviewRecord vrr = new VideoReviewRecord();
		vrr = vrrd;
		getSession().persist(vrr);
		return "1";
	}
	//更新影片評價
	@Override
	public String updateVideoReview(BigDecimal bd,Integer videoId) {
		Video vi = getSession().load(Video.class, videoId);
		vi.setVideoReview(bd);
		getSession().update(vi);
		return "1";
	}
	
	//查詢該影片的平均評價
		@Override
		public BigDecimal SelectAvgVideoReviewRecord(Integer videoId) {
			String hql = "SELECT avg(score) FROM VideoReviewRecord WHERE videoId = :videoId";
			Query query = getSession().createQuery(hql);
			query.setParameter("videoId", videoId);
			Double tmp = (Double)query.uniqueResult();
			
			BigDecimal bd = BigDecimal.valueOf(tmp);
			return bd;
		}
	
	//景點加入最愛
	@Override
	public String addFavouriteMap(FavoriteMap fap) {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<FavoriteMap> query = criteriaBuilder.createQuery(FavoriteMap.class);
		Root<FavoriteMap> root = query.from(FavoriteMap.class);
		query.select(root);
		query.where(
				criteriaBuilder.equal(root.get("attraction").get("attractionId"),fap.getAttraction()),
				criteriaBuilder.equal(root.get("member").get("memberId"),fap.getMember())
				);
		FavoriteMap tmp = getSession().createQuery(query).getSingleResult();
		if(tmp ==null) {
			Member member = getSession().get(Member.class, fap.getMember().getMemberId());
			Attraction at = getSession().get(Attraction.class, fap.getAttraction().getAttractionId());
			if(member!=null && at!=null) {
				FavoriteMap fp = new FavoriteMap();
				fp.setAttraction(at);
				fp.setMember(member);
				getSession().save(fp);
			}
		}
//		FavoriteMap tmp = getSession().//get(FavoriteMap.class, fap.getAttractionId(),fap.getMemberId());
//		if(tmp==null) {
//			FavoriteMap newFap = new FavoriteMap();
//			newFap = fap;
//			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//			newFap.setLastModifiedDate(timestamp);
//			getSession().save(newFap);
//		}
		return "1";
	}
	
	//景點刪除最愛
	@Override
	public String deleteFavoriteMap(FavoriteMap fap) {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<FavoriteMap> query = criteriaBuilder.createQuery(FavoriteMap.class);
		Root<FavoriteMap> root = query.from(FavoriteMap.class);
		query.select(root);
		query.where(
				criteriaBuilder.equal(root.get("attractionId").get("attractionId"),fap.getAttraction()),
				criteriaBuilder.equal(root.get("memberId").get("memberId"),fap.getMember())
				);
		FavoriteMap tmp = getSession().createQuery(query).getSingleResult();
		if(tmp !=null) {
			Member member = getSession().get(Member.class, fap.getMember().getMemberId());
			Attraction at = getSession().get(Attraction.class, fap.getAttraction().getAttractionId());
			if(member!=null && at!=null) {
				FavoriteMap fp = new FavoriteMap();
				fp.setAttraction(at);
				fp.setMember(member);
				getSession().delete(fp);
			}
		}
		return "1";
	}
	
	//查詢影片景點
	@Override
	public List<VideoAttraction> selectVideoAttraction(Integer videoId) {
		String hql = "SELECT new videoPlay.vo.VideoAttraction(videoAttractionId, attractionId, videoId, attReviewStatus, locationTimestamp) FROM VideoAttraction WHERE videoId = :videoId";
		Query<VideoAttraction> query = getSession().createQuery(hql,VideoAttraction.class);
		query.setParameter("videoId", videoId);
		return query.getResultList();
	}

	//搜尋景點
	@Override
	public Attraction selectAttractionById(Integer AttractionId) {
		String hql = "SELECT new videoPlay.vo.Attraction(attractionId, attractionName, attractionIntroduce, address, phoneNumber) FROM Attraction WHERE attractionId = :attractionId";
		Query<Attraction> query = getSession().createQuery(hql,Attraction.class);
		query.setParameter("attractionId", AttractionId);
		return query.getSingleResult();
	}
	
}