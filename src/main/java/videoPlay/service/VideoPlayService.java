package videoPlay.service;

import java.math.BigDecimal;

public interface VideoPlayService {

	String selectById(Integer videoId);
	
	Integer TimesWatched(Integer videoId);
	
	String UpdateDuration(String mwdJSON);
	
	String updateDomainTime(String adJSON);
	
	String addFavorite(String favJSON);
	
	String deleteFavorite(String favJSON);
	
	String addFavoriteMap(String fapJSON);
	
	String deleteFavoriteMap(String fapJSON);
	
	BigDecimal updateVideoReviewRecord(String vrrJSON);
}
