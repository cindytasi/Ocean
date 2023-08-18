package web.service;

import java.util.List;

import web.dao.impl.VideoImpl;
import web.vo.Video;

public class seriesService {

private static VideoImpl videoImpl = new VideoImpl();
	
	//篩選器
	public List<Video> filterVideos(String type,String videoType,Integer videoStartYear,Integer videoendYear,String videoArea,Integer domainId) {
		
		switch(type) {
		case "seriesYear":
			List<Video> rmy = videoImpl.selectMovieYear(videoType, videoStartYear, videoendYear);
			return rmy;
		case "seriesArea" :
			List<Video> rma = videoImpl.selectMovieArea(videoType, videoArea);
			return rma;
		case "seriesType" :
			List<Video> rmt = videoImpl.selectMovieType(videoType, domainId);
			return rmt;
		}
		return null;
	}
		
	//影片頁面全部影片
	public List<Video> getAllSeriesVideo(String videoType,String type , Integer videoId){
		
		switch (type) {
		case "topseries": 
			List<Video> rv = videoImpl.selectTopMovie(videoType, "1");
			return rv;
		case "seriesLastOnline" :
			List<Video> rv2 = videoImpl.selectLastOnline(videoType);
			return rv2;
		case "seriesTop電影0" :
			List<Video> rv3 = videoImpl.selectMovieTop10(videoType);
			return rv3;
		case "seriesContinue" :
			List<Video> rv4 = videoImpl.selectMovieContinue(videoType, videoId);
			return rv4;
		case "seriesRecommended" :
			List<Video> rv5 = videoImpl.selectRecommendedMovie(videoType);
			return rv5;
		}
		return null;
	}
}
