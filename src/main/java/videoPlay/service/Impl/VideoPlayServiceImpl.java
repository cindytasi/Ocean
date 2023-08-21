package videoPlay.service.Impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import admin.util.CoreService;
import admin.vo.Member;
import admin.vo.Video;
import videoPlay.dao.ProductInformationDao;
import videoPlay.dao.VideoPlayDao;
import videoPlay.dao.Impl.ProductInformationDaoImpl;
import videoPlay.dao.Impl.VideoPlayDaoImpl;
import videoPlay.service.VideoPlayService;
import videoPlay.vo.AchievementDuration;
import videoPlay.vo.AchievementDurationPK;
import videoPlay.vo.Attraction;
import videoPlay.vo.Favourites;
import videoPlay.vo.FavoriteMap;
import videoPlay.vo.FavouritesPK;
import videoPlay.vo.MemberWatchDuration;
import videoPlay.vo.MemberWatchDurationPK;
import videoPlay.vo.ProductInformation;
import videoPlay.vo.ProductLink;
import videoPlay.vo.VideoAttraction;
import videoPlay.vo.VideoReviewRecord;


public class VideoPlayServiceImpl implements VideoPlayService,CoreService{
	private VideoPlayDao vd;
	private ProductInformationDao pid;
	private Gson gson;
	
	public VideoPlayServiceImpl() {
		vd = new VideoPlayDaoImpl();
		pid = new ProductInformationDaoImpl();
		gson = new Gson();
	}
	//查詢影片資訊、標記時間戳的商品、景點
	@Override
	public Video selectVideoById(Integer videoId) {
		beginTransaction();
		try {
			Video vi = vd.selectById(videoId);
			Video videoInfo = new Video();
			videoInfo.setVideoId(vi.getVideoId());
			videoInfo.setVideoName(vi.getVideoName());
			videoInfo.setVideoYear(vi.getVideoYear());
			videoInfo.setVideoArea(vi.getVideoArea());
			videoInfo.setVideoDirector(vi.getVideoDirector());
			videoInfo.setVideoActor(vi.getVideoActor());
			videoInfo.setVideoLength(vi.getVideoLength());
			videoInfo.setVideoSeason(vi.getVideoSeason());
			videoInfo.setVideoEpisode(vi.getVideoEpisode());
			videoInfo.setDomainId(vi.getDomainId());
			videoInfo.setIntroduction(vi.getIntroduction());
			videoInfo.setVideoReview(vi.getVideoReview());
			videoInfo.setVideoType(vi.getVideoType());
			videoInfo.setViews(vi.getViews());

			String tojson = gson.toJson(videoInfo);
			System.out.println(tojson);
			commit();
			return videoInfo;
		} catch (Exception e) {
			
			e.printStackTrace();
			rollback();
			return null;
		}
	}
	
	//增加觀看次數
	@Override
	public Integer TimesWatched(Integer videoId) {
		beginTransaction();
		try {
			Integer views = vd.TimesWatched(videoId);
			commit();
			return views;
		} catch (Exception e) {
			
			e.printStackTrace();
			rollback();
			return 0;
		}
	}
	
	//更新影片中斷點
	@Override
	public String UpdateDuration(String mwdJSON) {
		beginTransaction();
		try {
			MemberWatchDurationPK mpk = gson.fromJson(mwdJSON, MemberWatchDurationPK.class);
		
			MemberWatchDuration mwd = gson.fromJson(mwdJSON, MemberWatchDuration.class);
			mwd.setId(mpk);
			
			vd.UpdateDuration(mwd);
			commit();
			return "更新完成";
		} catch (Exception e) {
			
			e.printStackTrace();
			rollback();
			return "更新失敗";
		}
	}
	
	//累計領域時數(以分鐘累加)
	@Override
	public String updateDomainTime(String adJSON) {
		beginTransaction();
		try {
			AchievementDurationPK adpk = gson.fromJson(adJSON, AchievementDurationPK.class);
			
			AchievementDuration adn = gson.fromJson(adJSON, AchievementDuration.class);
			adn.setApk(adpk);
			vd.updateDomainTime(adn);
			commit();
			return "更新完成";
		} catch (JsonSyntaxException e) {
			
			e.printStackTrace();
			rollback();
			return "更新失敗";
		}
	}
	
	//影片加入最愛
	@Override
	public String addFavorite(String favJSON) {
		beginTransaction();
		try {
			FavouritesPK fpk = gson.fromJson(favJSON, FavouritesPK.class);
			
			Favourites fp = new Favourites();
			fp.setFpk(fpk);
			vd.addFavourite(fp);
			commit();
			return "新增完成";
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
			rollback();
			return "新增失敗";
		}
	}
	
	//影片刪除最愛
	@Override
	public String deleteFavorite(String favJSON) {
		beginTransaction();
		try {
			FavouritesPK fpk = gson.fromJson(favJSON, FavouritesPK.class);
			
			Favourites fp = new Favourites();
			fp.setFpk(fpk);
			
			vd.deleteFavorite(fp);
			commit();
			return "刪除完成";
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
			rollback();
			return "刪除失敗";
		}
	}
	
	//景點加入最愛
	@Override
	public String addFavoriteMap(String fapJSON) {
		beginTransaction();
		try {
			Member member = gson.fromJson(fapJSON, Member.class);
			Attraction at = gson.fromJson(fapJSON, Attraction.class);
			FavoriteMap fmp = new FavoriteMap();
			fmp.setMember(member);
			fmp.setAttraction(at);
			vd.addFavouriteMap(fmp);
			commit();
			return "新增完成";
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
			rollback();
			return "新增失敗";
		}
	}
	
	//景點刪除最愛
	@Override
	public String deleteFavoriteMap(String fapJSON) {
		beginTransaction();
		try {
			Member member = gson.fromJson(fapJSON, Member.class);
			Attraction at = gson.fromJson(fapJSON, Attraction.class);
			FavoriteMap fmp = new FavoriteMap();
			fmp.setMember(member);
			fmp.setAttraction(at);
			vd.deleteFavoriteMap(fmp);
			commit();
			return "刪除完成";
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
			rollback();
			return "刪除失敗";
		}
	}
	
	//影片評分
	@Override
	public BigDecimal updateVideoReviewRecord(String vrrJSON) {
		beginTransaction();
		try {
			VideoReviewRecord vrr = gson.fromJson(vrrJSON, VideoReviewRecord.class);
			//新增評分記錄
			vd.insertVideoReviewRecord(vrr);
			//重新計算平均
			BigDecimal bd = vd.SelectAvgVideoReviewRecord(vrr.getVideoId());
			//更新影片評分
			vd.updateVideoReview(bd, vrr.getVideoId());
			
			commit();
			return bd;
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rollback();
			return BigDecimal.valueOf(0);
		}
	}
	
	//查詢影片相關產品
	@Override
	public String selectProductByVideoId(Integer videoId) {
		beginTransaction();
		try {
			//取得有關聯的商品
			List<ProductLink> pl = vd.selectProductTimeById(videoId);
			
			List<ProductInformation> pri = new ArrayList<ProductInformation>();
			for(int i=0;i<pl.size();i++) {
				ProductInformation tmp = new ProductInformation();
				//再利用關聯商品的Id查詢商品後存到商品清單
				tmp = pid.selectById(pl.get(i).getProductId());
				if(tmp != null) {
					pri.add(tmp);
				}
			}
			String productInfo = gson.toJson(pri);
			commit();
			return productInfo;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
			return "查無商品";
		}
	}
	
	
	//查詢影片相關景點資訊
	@Override
	public String selectAttractionByVideoId(Integer videoId) {
		beginTransaction();
		try {
			//取得有關聯的景點
			List<VideoAttraction> va = vd.selectVideoAttraction(videoId);
			List<Attraction> att = new ArrayList<Attraction>();
			for(int i=0;i<va.size();i++) {
				Attraction tmp = new Attraction();
				//再用Id取得景點資訊
				tmp = vd.selectAttractionById(va.get(i).getAttractionId());
				if(tmp!= null) {
					att.add(tmp);
				}
//			sec[i] = va.get(i).getLocationTimestamp();
			}
			String attInfo = gson.toJson(att);
			commit();
			return attInfo;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
			return "沒有景點";
		}
	}
	
	//查詢影片景點時間戳
	@Override
	public String selectAttractionTimeByVideoId(Integer VideoId) {
		beginTransaction();
		try {
			List<VideoAttraction> va = vd.selectVideoAttraction(VideoId);
			int[] sec = new int[va.size()];
			for(int i=0;i<va.size();i++) {
				sec[i] = va.get(i).getLocationTimestamp();
			}
			String secToJson = gson.toJson(sec);
			commit();
			return secToJson;
		} catch (Exception e) {
			
			e.printStackTrace();
			rollback();
			return "沒有景點";
		}
	}
	@Override
	public String selectProductTimeByVideoId(Integer videoId) {
		beginTransaction();
		try {
			List<ProductLink> list = vd.selectProductTimeById(videoId);
			int[] sec = new int[list.size()];
			for(int i=0;i<list.size();i++) {
				sec[i] = list.get(i).getLinkTimestamp();
			}
			String secToJson = gson.toJson(sec);
			commit();
			return secToJson;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
			return "沒有商品";
		}
	}

}
