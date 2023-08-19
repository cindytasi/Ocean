package videoPlay.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;

import admin.util.HibernateUtil;
import admin.vo.Video;
import videoPlay.vo.AchievementDuration;
import videoPlay.vo.Attraction;
import videoPlay.vo.FavoriteMap;
import videoPlay.vo.Favourites;
import videoPlay.vo.MemberWatchDuration;
import videoPlay.vo.ProductLink;
import videoPlay.vo.VideoAttraction;
import videoPlay.vo.VideoReviewRecord;

public interface VideoPlayDao {
	Video selectById(Integer videoId);
	
	List<ProductLink> selectProductTimeById(Integer videoId);
	
	Integer TimesWatched(Integer videoId);
	
	String UpdateDuration(MemberWatchDuration mwd);
	
	String updateDomainTime(AchievementDuration ad);
	
	String addFavourite(Favourites fav);
	
	String deleteFavorite(Favourites fav);
	
	String addFavouriteMap(FavoriteMap fap);
	
	String deleteFavoriteMap(FavoriteMap fap);
	
	String insertVideoReviewRecord(VideoReviewRecord vrr);
	
	BigDecimal SelectAvgVideoReviewRecord(Integer videoId);
	
	String updateVideoReview(BigDecimal bd,Integer videoId);
	
	Attraction selectAttractionById(Integer AttractionId);
	
	List<VideoAttraction> selectVideoAttraction(Integer videoId);
	
	// 取得當前的SessionFactory
	default Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
}
