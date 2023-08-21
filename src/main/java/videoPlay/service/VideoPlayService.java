package videoPlay.service;

import java.math.BigDecimal;

import admin.vo.Video;

public interface VideoPlayService {

	Video selectVideoById(Integer videoId);
	
	String selectProductByVideoId(Integer videoId);
	
	String selectProductTimeByVideoId(Integer videoId);
	
	String selectAttractionByVideoId(Integer videoId);
	
	String selectAttractionTimeByVideoId(Integer VideoId);
	
	Integer TimesWatched(Integer videoId);
	
	String UpdateDuration(String mwdJSON);
	
	String updateDomainTime(String adJSON);
	
	String addFavorite(String favJSON);
	
	String deleteFavorite(String favJSON);
	
	String addFavoriteMap(String fapJSON);
	
	String deleteFavoriteMap(String fapJSON);
	
	BigDecimal updateVideoReviewRecord(String vrrJSON);
}
