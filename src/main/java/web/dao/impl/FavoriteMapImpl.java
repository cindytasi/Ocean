package web.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dao.FavoriteMapDao;
import web.vo.FavoriteMap;
import web.vo.Video;
import web.vo.attraction;

public class FavoriteMapImpl implements FavoriteMapDao {

	private String url = "jdbc:mysql://localhost:3306/Ocean?useUnicode=yes&characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Taipei";
	private String user = "root";
	private String password = "password";
	
	//搜尋bar
	private String sqlSearch = "select * from Video where  videoName like ?";
	//找出使用者收藏的景點
	private String sql = "select \n"
			+ "	att.attractionName,att.googleMapLink,att.attractionIntroduce,att.address,att.phoneNumber,att.attractionPic,att.longitude,att.latitude,att.attractionId\n"
			+ "from FavoriteMap fm \n"
			+ "join attraction  att on att.attractionId = fm.attractionId\n"
			+ "where memberId = ?;";
	//透過景點id刪除收藏地圖中的景點
	private String sqlDelete = "delete from FavoriteMap where memberId = ? and attractionId = ?;";
	
	private String sqlAttImg = "select attractionId,attractionPic from attraction where attractionId = ?;";
	
	
//	public static void main(String[] args) {
//		String xx = "%";
//		List<Video> ll = new FavoriteMapImpl().searchMovie( "海"+xx);
//		for (Video vv : ll) {
//			System.out.println(vv);
//		}
//	}
	
	//搜尋bar
	@Override
	public List<Video> searchMovie(String videoName) {
		List<Video> videos = new ArrayList<Video>();
		
		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sqlSearch)){
			
			preparedStatement.setString(1, videoName);
			
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


	
	//找出使用者收藏的景點
	@Override
	public FavoriteMap selectAttraction(Integer memberId) {
		List<attraction> attractions = new ArrayList<attraction>();
		FavoriteMap favoriteMap = new FavoriteMap();

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setInt(1, memberId);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				attraction att = new attraction();
				favoriteMap.setMemberId(memberId);
				att.setAttractionName(rs.getString(1));
				att.setGoogleMapLink(rs.getString(2));
				att.setAttractionIntroduce(rs.getString(3));
				att.setAddress(rs.getString(4));
				att.setPhoneNumber(rs.getString(5));
				att.setAttractionPic(rs.getBytes(6));
				att.setLongitude(rs.getDouble(7));
				att.setLatitude(rs.getDouble(8));
				att.setAttractionId(rs.getInt(9));

				attractions.add(att);
				favoriteMap.setAttractions(attractions);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return favoriteMap;
	}
	
	
	public void deleteAttraction(Integer memberId, Integer attractionId) {
	    try (Connection connection = DriverManager.getConnection(url, user, password);
	         PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete)) {
	        preparedStatement.setInt(1, memberId);
	        preparedStatement.setInt(2, attractionId);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public attraction attractionImg(Integer attractionId) {
		
		attraction attraction = null;
		
		try (Connection connection = DriverManager.getConnection(url, user, password);
		         PreparedStatement preparedStatement = connection.prepareStatement(sqlAttImg)) {
		        preparedStatement.setInt(1, attractionId);
		        ResultSet rs = preparedStatement.executeQuery();
				
				while (rs.next()) {
					attraction = new attraction();
					
					attraction.setAttractionPic(rs.getBytes(2));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return attraction;
		}

}
