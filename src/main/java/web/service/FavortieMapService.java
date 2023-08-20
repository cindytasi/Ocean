package web.service;

import java.util.List;

import web.dao.impl.FavoriteMapImpl;
import web.vo.FavoriteMap;
import web.vo.Video;
import web.vo.attraction;

public class FavortieMapService {

	private static FavoriteMapImpl favoriteMapImpl = new FavoriteMapImpl();
	
	//搜尋bar
	public List<Video> searchVideos(String videoName){
		
		videoName = videoName+"%";
		
		List<Video> sv = favoriteMapImpl.searchMovie(videoName);
		return sv;
	}
	
	public FavoriteMap getAllAttraction(Integer memberId) {
		FavoriteMap fmr = favoriteMapImpl.selectAttraction(memberId);
		return fmr;
	}
		
	public boolean deleteAttraction(Integer memberId, Integer attractionId) {
	    try {
	        favoriteMapImpl.deleteAttraction(memberId, attractionId);
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public attraction attractionImg(Integer attractionId) {
		
		attraction attraction = favoriteMapImpl.attractionImg(attractionId);
		return attraction;
	}

}
