package admin.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.query.Query;

import admin.dao.VideoDao;
import admin.vo.Picture;
import admin.vo.Video;

public class VideoDaoImpl implements VideoDao{
	
	@Override
	public Integer insertVideo(Video v) {
		v.setVideoReview(new BigDecimal(0));
		getSession().persist(v);
		return v.getVideoId();
	}

	@Override
	public boolean updateVideo(Video v) {
		Video tmp = getSession().load(Video.class,v.getVideoId());
		tmp.setVideoName(v.getVideoName());
		tmp.setVideoType(v.getVideoType());
		tmp.setVideoYear(v.getVideoYear());
		tmp.setVideoArea(v.getVideoArea());
		tmp.setVideoDirector(v.getVideoDirector());
		tmp.setVideoActor(v.getVideoActor());
//		tmp.setVideoLength(v.getVideoLength());
		tmp.setVideoSeason(v.getVideoSeason());
		tmp.setVideoEpisode(v.getVideoEpisode());
		tmp.setAdminId(1);
		tmp.setIntroduction(v.getIntroduction());
		tmp.setDomainId(v.getDomainId());
//		tmp.setVideoPath(v.getVideoPath());
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		tmp.setUploadDate(timestamp);
		return true;
	}

	@Override
	public boolean deleteVideoById(Integer id) {
		Query<?> query = getSession().createQuery("DELETE FROM Video WHERE videoId = :videoId");
		query.setParameter("videoId", id);
		query.executeUpdate();
		return true;
	}
	
	@Override
	public boolean deletePictureById(Integer id) {
		Query<?> query = getSession().createQuery("DELETE FROM Picture WHERE videoId = :videoId");
		query.setParameter("videoId", id);
		query.executeUpdate();
		return true;
	}

	@Override
	public Integer insertPic(Picture pic) {
		try {
			getSession().persist(pic);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public List<Video> searchVideo(String videoName) {
		String hql = "SELECT new admin.vo.Video(videoId,videoName,videoType,videoYear,videoArea,videoDirector,videoActor,videoSeason,videoEpisode,domainId,Introduction) FROM Video WHERE videoName LIKE :videoName";
		Query<Video> query = getSession().createQuery(hql,Video.class);
		query.setParameter("videoName","%"+videoName+"%");
		
		return query.list();
	}

	
	

}
