package web.dao;

import java.util.List;

import web.vo.FavoriteMap;
import web.vo.Video;
import web.vo.attraction;

public interface FavoriteMapDao {

//透過使用者輸入文字搜尋影片
	public List<Video> searchMovie(String videoName);
	
//	透過ＩＤ搜尋景點
	public FavoriteMap selectAttraction(Integer memberId);
	
//透過景點id刪除收藏地圖中的景點
	public void deleteAttraction(Integer memberId,Integer attractionId);

//	透過頁籤名稱篩選景點
	
	
//	新增頁籤名稱到資料庫
	
	public attraction attractionImg(Integer attractionId);
	
}
