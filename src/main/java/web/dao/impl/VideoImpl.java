package web.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.dao.VideoDao;
import web.vo.Video;

public class VideoImpl implements VideoDao {

	private static String url = "jdbc:mysql://localhost:3306/Ocean?useUnicode=yes&characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Taipei";
	private static String user = "root";
	private static String password = "password";
//搜尋bar
	private String sqlSearch = "select * from Video where videoType = ? and videoName like ?";
	
//	篩選器
	private String sqlYear = "select * from Video \n" + "where videoType = ? and videoYear between ? and ?;";

	private String sqlArea = "select * from Video \n" + "where videoType = ? and videoArea = ?;";

	private String sqlDomain = "select * from Video \n" + "where videoType = ? and domainId = ?;";
//首頁影片(探索全部)
	private String sqlTopStatus = "select * from Video\n" + "where videoType = ? and homeTopStatus = ? ;";

	private String sqlUpLoad = "select * from Video\n" + "where videoType = ? order by uploadDate desc;";

	private String sqlUpLoadTop10 = "select * from Video \n"
			+ "where  videoType = ?  and  videoReview > '4' \n"
			+ "order by uploadDate desc;";

	private String sqlContinue = "select * from Video vid\n"
			+ "join  MemberWatchDuration mwd on vid.videoId = mwd.videoId\n"
			+ "where videoType = ? and memberId = ?;";

	private String sqlRecommended = "SELECT * FROM Video\n"
			+ "WHERE videoType = ? \n"
			+ "ORDER BY views DESC, VideoReview DESC;";

//首頁影片
	private String sqlUpLoad5 = "select * from Video where videoType = ? order by uploadDate desc limit 5;";

	private String sqlUpLoadTop105 = "select * from Video \n"
			+ "where  videoType = ?  and  videoReview > '4' \n"
			+ "order by uploadDate desc limit 5;";

	private String sqlContinue5 = "select * from Video vid\n"
			+ "join  MemberWatchDuration mwd on vid.videoId = mwd.videoId\n"
			+ "where videoType = ? and memberId = ? limit 5;";

	private String sqlRecommended5 = "SELECT * FROM Video\n"
			+ "WHERE videoType = ? \n"
			+ "ORDER BY views DESC, VideoReview DESC limit 5;";
	
//	加入片單
	private String sqlInsert ="insert  into Ocean.Favourites(videoId,memberId)\n"
			+ "values(?,?);";

	
//	private String sqlRecommendedUser = "SELECT memberId, videoType, SUM(viewCount) AS totalViewCount\n"
//			+ "FROM (\n"
//			+ "    SELECT mem.memberId, vid.videoType, COUNT(*) AS viewCount\n"
//			+ "    FROM Member mem\n"
//			+ "    JOIN MemberWatchDuration mwd ON mem.memberId = mwd.memberId\n"
//			+ "    JOIN Video vid ON mwd.videoId = vid.videoId\n"
//			+ "    GROUP BY mem.memberId, vid.videoType\n"
//			+ "\n"
//			+ "    UNION ALL\n"
//			+ "\n"
//			+ "    SELECT mem.memberId, vid.videoType, COUNT(*) AS viewCount\n"
//			+ "    FROM Member mem\n"
//			+ "    JOIN Favourites fav ON mem.memberId = fav.memberId\n"
//			+ "    JOIN Video vid ON fav.videoId = vid.videoId\n"
//			+ "    GROUP BY mem.memberId, vid.videoType\n"
//			+ ") AS combinedResults\n"
//			+ "GROUP BY memberId, videoType;";

	public static void main(String[] args) {
//		List<Video> ll = new VideoImpl().searchMovie("電影", "18%");
//		List<Video> ll = new VideoImpl().selectMovieYear("戲劇",2000 ,2001);
//		List<Video> ll = new VideoImpl().selectMovieArea("戲劇","日本");
//		List<Video> ll = new VideoImpl().selectMovieType("戲劇",3);
//		List<Video> ll = new VideoImpl().selectLastOnline("戲劇","2023-07-27 20:02:56");
//		List<Video> ll = new VideoImpl().selectMovieTop10("戲劇","5","2023-07-27 20:02:56");
//		List<Video> ll = new VideoImpl().selectMovieContinue("戲劇", 2);
//		List<Video> ll = new VideoImpl().selectRecommendedMovie("戲劇");
//		List<Video> video = new VideoImpl().selectTopMovie("戲劇", "0");
//		for (Video vv : ll) {
//			System.out.println(vv);
//		}
		new VideoImpl().insertVideo(10, 3);
	}
	
	
	//搜尋bar
	@Override
	public List<Video> searchMovie(String videoType, String videoName) {
		List<Video> videos = new ArrayList<Video>();
		
		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sqlSearch)){
			
			preparedStatement.setString(1, videoType);
			preparedStatement.setString(2, videoName);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Video v = new Video();

				v.setVideoId(rs.getInt(1));
				v.setVideoName(rs.getString(2));
				v.setVideoType(rs.getString(3));
				v.setVideoYear(rs.getInt(4));
				v.setVideoArea(rs.getString(5));
				v.setVideoDirector(rs.getString(6));
				v.setVideoActor(rs.getString(7));
				v.setVideoLength(rs.getInt(8));
				v.setVideoSeason(rs.getInt(9));
				v.setVideoEpisode(rs.getInt(10));
				v.setVideoPath(rs.getString(11));
				v.setAdminId(rs.getInt(12));
				v.setUploadDate(rs.getString(13));
				v.setVideoReview(rs.getString(14));
				v.setDomainId(rs.getInt(15));
				v.setHomeTopStatus(rs.getString(16));
				v.setIntroduction(rs.getString(17));
				v.setViews(rs.getInt(18));
				v.setSave(rs.getInt(19));
				v.setPicture(rs.getBytes(20));

				videos.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return videos;
	}

	// 透過影片年份篩選（篩選器-年份）
	@Override
	public List<Video> selectMovieYear(String videoType, Integer videostartYear, Integer videoEndYear) {
			
		List<Video> videos = new ArrayList<Video>();
			
		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sqlYear)) {
	
			preparedStatement.setString(1, videoType);
			preparedStatement.setInt(2, videostartYear);
			preparedStatement.setInt(3, videoEndYear);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Video v = new Video();

				v.setVideoId(rs.getInt(1));
				v.setVideoName(rs.getString(2));
				v.setVideoType(rs.getString(3));
				v.setVideoYear(rs.getInt(4));
				v.setVideoArea(rs.getString(5));
				v.setVideoDirector(rs.getString(6));
				v.setVideoActor(rs.getString(7));
				v.setVideoLength(rs.getInt(8));
				v.setVideoSeason(rs.getInt(9));
				v.setVideoEpisode(rs.getInt(10));
				v.setVideoPath(rs.getString(11));
				v.setAdminId(rs.getInt(12));
				v.setUploadDate(rs.getString(13));
				v.setVideoReview(rs.getString(14));
				v.setDomainId(rs.getInt(15));
				v.setHomeTopStatus(rs.getString(16));
				v.setIntroduction(rs.getString(17));
				v.setViews(rs.getInt(18));
				v.setSave(rs.getInt(19));
				v.setPicture(rs.getBytes(20));

				videos.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return videos;
	}

//	透過影片地區篩選（篩選器-地區）
	@Override
	public List<Video> selectMovieArea(String videoType, String videoArea) {

		List<Video> videos = new ArrayList<Video>();

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sqlArea)) {
			preparedStatement.setString(1, videoType);
			preparedStatement.setString(2, videoArea);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Video v = new Video();

				v.setVideoId(rs.getInt(1));
				v.setVideoName(rs.getString(2));
				v.setVideoType(rs.getString(3));
				v.setVideoYear(rs.getInt(4));
				v.setVideoArea(rs.getString(5));
				v.setVideoDirector(rs.getString(6));
				v.setVideoActor(rs.getString(7));
				v.setVideoLength(rs.getInt(8));
				v.setVideoSeason(rs.getInt(9));
				v.setVideoEpisode(rs.getInt(10));
				v.setVideoPath(rs.getString(11));
				v.setAdminId(rs.getInt(12));
				v.setUploadDate(rs.getString(13));
				v.setVideoReview(rs.getString(14));
				v.setDomainId(rs.getInt(15));
				v.setHomeTopStatus(rs.getString(16));
				v.setIntroduction(rs.getString(17));
				v.setViews(rs.getInt(18));
				v.setSave(rs.getInt(19));
				v.setPicture(rs.getBytes(20));

				videos.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return videos;
	}

//	透過影片類型篩選（篩選器-類型）
	@Override
	public List<Video> selectMovieType(String videoType, Integer domainId) {

		List<Video> videos = new ArrayList<Video>();
		
		 
		try( Connection connection  = DriverManager.getConnection(url, user, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sqlDomain)) {
		    
			preparedStatement.setString(1, videoType);
			preparedStatement.setInt(2, domainId);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Video v = new Video();

				v.setVideoId(rs.getInt(1));
				v.setVideoName(rs.getString(2));
				v.setVideoType(rs.getString(3));
				v.setVideoYear(rs.getInt(4));
				v.setVideoArea(rs.getString(5));
				v.setVideoDirector(rs.getString(6));
				v.setVideoActor(rs.getString(7));
				v.setVideoLength(rs.getInt(8));
				v.setVideoSeason(rs.getInt(9));
				v.setVideoEpisode(rs.getInt(10));
				v.setVideoPath(rs.getString(11));
				v.setAdminId(rs.getInt(12));
				v.setUploadDate(rs.getString(13));
				v.setVideoReview(rs.getString(14));
				v.setDomainId(rs.getInt(15));
				v.setHomeTopStatus(rs.getString(16));
				v.setIntroduction(rs.getString(17));
				v.setViews(rs.getInt(18));
				v.setSave(rs.getInt(19));
				v.setPicture(rs.getBytes(20));

				videos.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return videos;
	}

//	透過首頁置頂篩選影片照片（熱門影片）
	@Override
	public List<Video> selectTopMovie(String videoType, String homeTopStatus) {

		List<Video> videos = new ArrayList<Video>();

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sqlTopStatus);) {
			preparedStatement.setString(1, videoType);
			preparedStatement.setString(2, homeTopStatus);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Video v = new Video();

				v.setVideoId(rs.getInt(1));
				v.setVideoName(rs.getString(2));
				v.setVideoType(rs.getString(3));
				v.setVideoYear(rs.getInt(4));
				v.setVideoArea(rs.getString(5));
				v.setVideoDirector(rs.getString(6));
				v.setVideoActor(rs.getString(7));
				v.setVideoLength(rs.getInt(8));
				v.setVideoSeason(rs.getInt(9));
				v.setVideoEpisode(rs.getInt(10));
				v.setVideoPath(rs.getString(11));
				v.setAdminId(rs.getInt(12));
				v.setUploadDate(rs.getString(13));
				v.setVideoReview(rs.getString(14));
				v.setDomainId(rs.getInt(15));
				v.setHomeTopStatus(rs.getString(16));
				v.setIntroduction(rs.getString(17));
				v.setViews(rs.getInt(18));
				v.setSave(rs.getInt(19));
				v.setPicture(rs.getBytes(20));

				videos.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return videos;
	}

//	透過上架時間篩選影片（最新上線）
	@Override
	public List<Video> selectLastOnline(String videoType) {

		List<Video> videos = new ArrayList<Video>();

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sqlUpLoad)) {
			preparedStatement.setString(1, videoType);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Video v = new Video();

				v.setVideoId(rs.getInt(1));
				v.setVideoName(rs.getString(2));
				v.setVideoType(rs.getString(3));
				v.setVideoYear(rs.getInt(4));
				v.setVideoArea(rs.getString(5));
				v.setVideoDirector(rs.getString(6));
				v.setVideoActor(rs.getString(7));
				v.setVideoLength(rs.getInt(8));
				v.setVideoSeason(rs.getInt(9));
				v.setVideoEpisode(rs.getInt(10));
				v.setVideoPath(rs.getString(11));
				v.setAdminId(rs.getInt(12));
				v.setUploadDate(rs.getString(13));
				v.setVideoReview(rs.getString(14));
				v.setDomainId(rs.getInt(15));
				v.setHomeTopStatus(rs.getString(16));
				v.setIntroduction(rs.getString(17));
				v.setViews(rs.getInt(18));
				v.setSave(rs.getInt(19));
				v.setPicture(rs.getBytes(20));

				videos.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return videos;
	}

//	透過上架時間和評分篩選影片（最新電影top10）
	@Override
	public List<Video> selectMovieTop10(String videoType) {

		List<Video> videos = new ArrayList<Video>();

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sqlUpLoadTop10)) {
			preparedStatement.setString(1, videoType);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Video v = new Video();

				v.setVideoId(rs.getInt(1));
				v.setVideoName(rs.getString(2));
				v.setVideoType(rs.getString(3));
				v.setVideoYear(rs.getInt(4));
				v.setVideoArea(rs.getString(5));
				v.setVideoDirector(rs.getString(6));
				v.setVideoActor(rs.getString(7));
				v.setVideoLength(rs.getInt(8));
				v.setVideoSeason(rs.getInt(9));
				v.setVideoEpisode(rs.getInt(10));
				v.setVideoPath(rs.getString(11));
				v.setAdminId(rs.getInt(12));
				v.setUploadDate(rs.getString(13));
				v.setVideoReview(rs.getString(14));
				v.setDomainId(rs.getInt(15));
				v.setHomeTopStatus(rs.getString(16));
				v.setIntroduction(rs.getString(17));
				v.setViews(rs.getInt(18));
				v.setSave(rs.getInt(19));
				v.setPicture(rs.getBytes(20));

				videos.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return videos;
	}

//	透過影片編號找影片（繼續觀看）
	@Override
	public List<Video> selectMovieContinue(String videoType,Integer memberId) {

		List<Video> videos = new ArrayList<Video>();

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sqlContinue)) {
			preparedStatement.setString(1, videoType);
			preparedStatement.setInt(2, memberId);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Video v = new Video();

				v.setVideoId(rs.getInt(1));
				v.setVideoName(rs.getString(2));
				v.setVideoType(rs.getString(3));
				v.setVideoYear(rs.getInt(4));
				v.setVideoArea(rs.getString(5));
				v.setVideoDirector(rs.getString(6));
				v.setVideoActor(rs.getString(7));
				v.setVideoLength(rs.getInt(8));
				v.setVideoSeason(rs.getInt(9));
				v.setVideoEpisode(rs.getInt(10));
				v.setVideoPath(rs.getString(11));
				v.setAdminId(rs.getInt(12));
				v.setUploadDate(rs.getString(13));
				v.setVideoReview(rs.getString(14));
				v.setDomainId(rs.getInt(15));
				v.setHomeTopStatus(rs.getString(16));
				v.setIntroduction(rs.getString(17));
				v.setViews(rs.getInt(18));
				v.setSave(rs.getInt(19));
				v.setPicture(rs.getBytes(20));

				videos.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return videos;
	}

//	透過瀏覽次數 收藏次數 評分篩選影片(熱門推薦)
	@Override
	public List<Video> selectRecommendedMovie(String videoType) {

		List<Video> videos = new ArrayList<Video>();

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sqlRecommended)) {
			preparedStatement.setString(1, videoType);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Video v = new Video();

				v.setVideoId(rs.getInt(1));
				v.setVideoName(rs.getString(2));
				v.setVideoType(rs.getString(3));
				v.setVideoYear(rs.getInt(4));
				v.setVideoArea(rs.getString(5));
				v.setVideoDirector(rs.getString(6));
				v.setVideoActor(rs.getString(7));
				v.setVideoLength(rs.getInt(8));
				v.setVideoSeason(rs.getInt(9));
				v.setVideoEpisode(rs.getInt(10));
				v.setVideoPath(rs.getString(11));
				v.setAdminId(rs.getInt(12));
				v.setUploadDate(rs.getString(13));
				v.setVideoReview(rs.getString(14));
				v.setDomainId(rs.getInt(15));
				v.setHomeTopStatus(rs.getString(16));
				v.setIntroduction(rs.getString(17));
				v.setViews(rs.getInt(18));
				v.setSave(rs.getInt(19));
				v.setPicture(rs.getBytes(20));

				videos.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return videos;
	}

//	透過收藏類型 觀看類型 篩選影片（推薦給ＸＸＸ）
//	@Override
//	public List<Video> selectRecommendedUserMovie() {
//		List<Video> videos = new ArrayList<Video>();
//		try (Connection connection = DriverManager.getConnection(url, user, password);
//				PreparedStatement preparedStatement = connection.prepareStatement(sqlRecommendedUser)) {
//			preparedStatement.setString(1, videoType);
//			preparedStatement.setInt(2, views);
//			preparedStatement.setInt(3, save);
//			preparedStatement.setString(4, VideoReview);
//			ResultSet rs = preparedStatement.executeQuery();
//			while (rs.next()) {
//				Video v = new Video();
//				v.setVideoId(rs.getInt(1));
//				v.setVideoName(rs.getString(2));
//				v.setVideoType(rs.getString(3));
//				v.setVideoYear(rs.getInt(4));
//				v.setVideoArea(rs.getString(5));
//				v.setVideoDirector(rs.getString(6));
//				v.setVideoActor(rs.getString(7));
//				v.setVideoLength(rs.getInt(8));
//				v.setVideoSeason(rs.getInt(9));
//				v.setVideoEpisode(rs.getInt(10));
//				v.setVideoPath(rs.getString(11));
//				v.setAdminId(rs.getInt(12));
//				v.setUploadDate(rs.getString(13));
//				v.setVideoReview(rs.getString(14));
//				v.setDomainId(rs.getInt(15));
//				v.setHomeTopStatus(rs.getString(16));
//				v.setIntroduction(rs.getString(17));
//				v.setViews(rs.getInt(18));
//				v.setSave(rs.getInt(19));
//				v.setPicture(rs.getBytes(20));
//				videos.add(v);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return videos;
//	}
		

//透過上架時間篩選影片（最新上線）
@Override
public List<Video> selectLastOnline5(String videoType) {

	List<Video> videos = new ArrayList<Video>();

	try (Connection connection = DriverManager.getConnection(url, user, password);
			PreparedStatement preparedStatement = connection.prepareStatement(sqlUpLoad5)) {
		preparedStatement.setString(1, videoType);

		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			Video v = new Video();

			v.setVideoId(rs.getInt(1));
			v.setVideoName(rs.getString(2));
			v.setVideoType(rs.getString(3));
			v.setVideoYear(rs.getInt(4));
			v.setVideoArea(rs.getString(5));
			v.setVideoDirector(rs.getString(6));
			v.setVideoActor(rs.getString(7));
			v.setVideoLength(rs.getInt(8));
			v.setVideoSeason(rs.getInt(9));
			v.setVideoEpisode(rs.getInt(10));
			v.setVideoPath(rs.getString(11));
			v.setAdminId(rs.getInt(12));
			v.setUploadDate(rs.getString(13));
			v.setVideoReview(rs.getString(14));
			v.setDomainId(rs.getInt(15));
			v.setHomeTopStatus(rs.getString(16));
			v.setIntroduction(rs.getString(17));
			v.setViews(rs.getInt(18));
			v.setSave(rs.getInt(19));
			v.setPicture(rs.getBytes(20));

			videos.add(v);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return videos;
}

//透過上架時間和評分篩選影片（最新電影top10）
@Override
public List<Video> selectMovieTop105(String videoType) {

	List<Video> videos = new ArrayList<Video>();

	try (Connection connection = DriverManager.getConnection(url, user, password);
			PreparedStatement preparedStatement = connection.prepareStatement(sqlUpLoadTop105)) {
		preparedStatement.setString(1, videoType);

		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			Video v = new Video();

			v.setVideoId(rs.getInt(1));
			v.setVideoName(rs.getString(2));
			v.setVideoType(rs.getString(3));
			v.setVideoYear(rs.getInt(4));
			v.setVideoArea(rs.getString(5));
			v.setVideoDirector(rs.getString(6));
			v.setVideoActor(rs.getString(7));
			v.setVideoLength(rs.getInt(8));
			v.setVideoSeason(rs.getInt(9));
			v.setVideoEpisode(rs.getInt(10));
			v.setVideoPath(rs.getString(11));
			v.setAdminId(rs.getInt(12));
			v.setUploadDate(rs.getString(13));
			v.setVideoReview(rs.getString(14));
			v.setDomainId(rs.getInt(15));
			v.setHomeTopStatus(rs.getString(16));
			v.setIntroduction(rs.getString(17));
			v.setViews(rs.getInt(18));
			v.setSave(rs.getInt(19));
			v.setPicture(rs.getBytes(20));

			videos.add(v);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return videos;
}

//透過影片編號找影片（繼續觀看）
@Override
public List<Video> selectMovieContinue5(String videoType,Integer memberId) {

	List<Video> videos = new ArrayList<Video>();

	try (Connection connection = DriverManager.getConnection(url, user, password);
			PreparedStatement preparedStatement = connection.prepareStatement(sqlContinue5)) {
		preparedStatement.setString(1, videoType);
		preparedStatement.setInt(2, memberId);

		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			Video v = new Video();

			v.setVideoId(rs.getInt(1));
			v.setVideoName(rs.getString(2));
			v.setVideoType(rs.getString(3));
			v.setVideoYear(rs.getInt(4));
			v.setVideoArea(rs.getString(5));
			v.setVideoDirector(rs.getString(6));
			v.setVideoActor(rs.getString(7));
			v.setVideoLength(rs.getInt(8));
			v.setVideoSeason(rs.getInt(9));
			v.setVideoEpisode(rs.getInt(10));
			v.setVideoPath(rs.getString(11));
			v.setAdminId(rs.getInt(12));
			v.setUploadDate(rs.getString(13));
			v.setVideoReview(rs.getString(14));
			v.setDomainId(rs.getInt(15));
			v.setHomeTopStatus(rs.getString(16));
			v.setIntroduction(rs.getString(17));
			v.setViews(rs.getInt(18));
			v.setSave(rs.getInt(19));
			v.setPicture(rs.getBytes(20));

			videos.add(v);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return videos;
}

//透過瀏覽次數 收藏次數 評分篩選影片(熱門推薦)
@Override
public List<Video> selectRecommendedMovie5(String videoType) {

	List<Video> videos = new ArrayList<Video>();

	try (Connection connection = DriverManager.getConnection(url, user, password);
			PreparedStatement preparedStatement = connection.prepareStatement(sqlRecommended5)) {
		preparedStatement.setString(1, videoType);

		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			Video v = new Video();

			v.setVideoId(rs.getInt(1));
			v.setVideoName(rs.getString(2));
			v.setVideoType(rs.getString(3));
			v.setVideoYear(rs.getInt(4));
			v.setVideoArea(rs.getString(5));
			v.setVideoDirector(rs.getString(6));
			v.setVideoActor(rs.getString(7));
			v.setVideoLength(rs.getInt(8));
			v.setVideoSeason(rs.getInt(9));
			v.setVideoEpisode(rs.getInt(10));
			v.setVideoPath(rs.getString(11));
			v.setAdminId(rs.getInt(12));
			v.setUploadDate(rs.getString(13));
			v.setVideoReview(rs.getString(14));
			v.setDomainId(rs.getInt(15));
			v.setHomeTopStatus(rs.getString(16));
			v.setIntroduction(rs.getString(17));
			v.setViews(rs.getInt(18));
			v.setSave(rs.getInt(19));
			v.setPicture(rs.getBytes(20));

			videos.add(v);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return videos;
}

//加入片單
	public int insertVideo(Integer videoId,Integer memberId) {
		try(Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert)) {
			preparedStatement.setInt(1, videoId);
			preparedStatement.setInt(2, memberId);
//			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
	