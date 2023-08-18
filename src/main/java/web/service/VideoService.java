package web.service;

import java.util.List;

import web.dao.impl.VideoImpl;
import web.vo.Video;

public class VideoService {

	private static VideoImpl videoImpl = new VideoImpl();
	
	//搜尋bar
	public List<Video> searchVideos(String videoType , String videoName){
		
		videoName = videoName+"%";
		
		List<Video> sv = videoImpl.searchMovie(videoType, videoName);
		return sv;
	}
	
	//篩選器
	public List<Video> filterVideos(String type,String videoType,Integer videoStartYear,Integer videoEndYear,String videoArea,Integer domainId) {
		
		switch(type) {
		case "movieYear":
			List<Video> rmy = videoImpl.selectMovieYear(videoType, videoStartYear, videoEndYear);
			return rmy;
		case "movieArea" :
			List<Video> rma = videoImpl.selectMovieArea(videoType, videoArea);
			return rma;
		case "movieType" :
			System.out.println("movieType");
			List<Video> rmt = videoImpl.selectMovieType(videoType, domainId);
			return rmt;
		}
		return null;
	}
		
	//影片頁面全部影片
	public List<Video> getAllMovieVideo(String type,String videoType , Integer memberId){
		
		switch (type) {
		case "topMovie": 
			List<Video> rv = videoImpl.selectTopMovie(videoType , "1");
			return rv;
		case "lastOnline" :
			List<Video> rv2 = videoImpl.selectLastOnline(videoType);
			return rv2;
		case "movieTop10" :
			List<Video> rv3 = videoImpl.selectMovieTop10(videoType);
			return rv3;
		case "continue" :
			List<Video> rv4 = videoImpl.selectMovieContinue(videoType, memberId);
			return rv4;
		case "recommended" :
			List<Video> rv5 = videoImpl.selectRecommendedMovie(videoType);
			return rv5;
		}
		return null;
	}
	
	//影片頁面全部影片5部
	public List<Video> getAllMovieVideo5(String type,String videoType , Integer memberId){
		
		switch (type) {
		case "lastOnline" :
			List<Video> rv2 = videoImpl.selectLastOnline5(videoType);
			return rv2;
		case "movieTop10" :
			List<Video> rv3 = videoImpl.selectMovieTop105(videoType);
			return rv3;
		case "continue" :
			List<Video> rv4 = videoImpl.selectMovieContinue5(videoType, memberId);
			return rv4;
		case "recommended" :
			List<Video> rv5 = videoImpl.selectRecommendedMovie5(videoType);
			return rv5;
		}
		return null;
	}
	
//	加入片單
	public int insertVideoList(Integer videoId,Integer memberId) {
		System.out.println("insertVideoList");
		int vi = new VideoImpl().insertVideo(videoId, memberId);
		return vi;
	}
	
	//首頁頁面全部影片
	public List<Video> getIndexAllMovieVideo(String type, Integer memberId){
		
		switch (type) {
		case "topMovie": 
			List<Video> rv = videoImpl.selectTopMovie("1");
			return rv;
		case "lastOnline" :
			List<Video> rv2 = videoImpl.selectLastOnline();
			return rv2;
		case "movieTop10" :
			List<Video> rv3 = videoImpl.selectMovieTop10();
			return rv3;
		case "continue" :
			List<Video> rv4 = videoImpl.selectMovieContinue(memberId);
			return rv4;
		case "recommended" :
			List<Video> rv5 = videoImpl.selectRecommendedMovie();
			return rv5;
		}
		return null;
	}
	
	//首頁全部影片5部
	public List<Video> getIndexAllMovieVideo5(String type,Integer memberId){
		
		switch (type) {
		case "lastOnline" :
			List<Video> rv2 = videoImpl.selectLastOnline5();
			return rv2;
		case "movieTop10" :
			List<Video> rv3 = videoImpl.selectMovieTop105();
			return rv3;
		case "continue" :
			List<Video> rv4 = videoImpl.selectMovieContinue5(memberId);
			return rv4;
		case "recommended" :
			List<Video> rv5 = videoImpl.selectRecommendedMovie5();
			return rv5;
		}
		return null;
	}
	
	//搜尋bar
	public List<Video> searchVideos(String videoName){
		
		videoName = videoName+"%";
		
		List<Video> sv = videoImpl.searchMovie(videoName);
		return sv;
	}
	
	
//	找出全部照片
	public Video searchAllImg(Integer videoId){
		
		Video video = videoImpl.searchAllImg(videoId);
		return video;
	}
}
