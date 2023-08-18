package admin.service;

import java.util.Collection;

import javax.servlet.http.Part;

import admin.vo.Video;

public interface VideoService {
	
	String serchVideo(String videoName);
	
	String uploadVideo(Part imgFilePart, Part picFilePart,Video v);
	
	boolean updateVideo(Video v);

	boolean deleteVideoById(Integer id);
	
}
