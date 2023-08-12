package web.dao;

import java.util.List;

import web.vo.Video;

public interface VideoDao {
	
//	透過使用者輸入文字搜尋影片
	public List<Video> searchMovie(String videoType, String videoName);
	
	
	
//	透過影片年份篩選（篩選器-年份）
	public List<Video> selectMovieYear(String videoType,Integer videostartYear,Integer videoEndYear);
	
//	透過影片地區篩選（篩選器-地區）
	public List<Video>  selectMovieArea(String videoType,String videoArea);
	
//	透過影片類型篩選（篩選器-類型）
	public List<Video>  selectMovieType(String videoType,Integer domainId);
	
	
	
//	透過首頁置頂篩選影片照片（熱門影片）
	public List<Video>  selectTopMovie(String videoType , String homeTopStatus);
	
//	透過上架時間篩選影片（最新上線）
	public List<Video>  selectLastOnline(String videoType);
	
//	透過上架時間和評分篩選影片（最新電影top10）
	public List<Video>  selectMovieTop10(String videoType);
	
//	透過影片編號找影片（繼續觀看）
	public List<Video>  selectMovieContinue(String videoType,Integer memberId);
	
//	透過瀏覽次數 收藏次數 評分篩選影片(熱門推薦)
	public List<Video> selectRecommendedMovie(String videoType);
	
//	透過收藏類型 觀看類型 篩選影片（推薦給ＸＸＸ）
//	public List<Video> selectRecommendedUserMovie();
	
//	透過上架時間篩選影片（最新上線）
	public List<Video>  selectLastOnline5(String videoType);
	
//	透過上架時間和評分篩選影片（最新電影top10）
	public List<Video>  selectMovieTop105(String videoType);
	
//	透過影片編號找影片（繼續觀看）
	public List<Video>  selectMovieContinue5(String videoType,Integer memberId);
	
//	透過瀏覽次數 收藏次數 評分篩選影片(熱門推薦)
	public List<Video> selectRecommendedMovie5(String videoType);
	
	public int insertVideo(Integer videoId,Integer memberId);
	
}
