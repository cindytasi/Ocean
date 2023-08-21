package admin.service.impl;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.Part;

import com.google.gson.Gson;

import admin.dao.VideoDao;
import admin.dao.impl.VideoDaoImpl;
import admin.service.VideoService;
import admin.util.CoreService;
import admin.vo.Picture;
import admin.vo.Video;

public class VideoServiceImpl implements VideoService, CoreService {
	private static final String tomcatBase = System.getProperty("catalina.base");
	private static final String CONVERTED_DIRECTORY = String.format("%s/webapps/videos", tomcatBase);
	private static final String PICFILE_DIRECTORY = "/path/to/upload/directory/pic";
	private VideoDao viDao;
	private Gson gson;

	public VideoServiceImpl() {
		viDao = new VideoDaoImpl();
		gson = new Gson();
	}
	
	@Override
	public String serchVideo(String videoName) {
		beginTransaction();
		try {
			List<Video> list = viDao.searchVideo(videoName);
			String serchList = gson.toJson(list);
			commit();
			return serchList;
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
			return "查無資料";
		}
	}

	@Override
	public boolean updateVideo(Video v) {
		beginTransaction();
		try {
			boolean b = viDao.updateVideo(v);
			commit();
			return b;
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteVideoById(Integer id) {
		beginTransaction();
		try {
			boolean b = viDao.deletePictureById(id);
			boolean c = viDao.deleteVideoById(id);
			commit();
			return b&&c;
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String uploadVideo(Part imgFilePart, Part picFilePart, Video videoInfo) {
		beginTransaction();
		try {
			// 建立影片暫存檔
			System.out.println(CONVERTED_DIRECTORY);
			File videoFile = new File(CONVERTED_DIRECTORY + File.separator + videoInfo.getVideoName() + File.separator
					+ videoInfo.getVideoName() + ".mp4");
			if (!videoFile.exists()) {
				videoFile.mkdirs();
			}
			imgFilePart.write(videoFile.getAbsolutePath());

			
			// 紀錄分割檔路徑
			videoInfo.setVideoPath(videoFile.getAbsolutePath());
			// 建立圖片暫存檔
			File picFile = new File(PICFILE_DIRECTORY + File.separator + picFilePart.getSubmittedFileName());
			if (!picFile.exists()) {
				picFile.mkdirs();
			}
			picFilePart.write(picFile.getAbsolutePath());

			// 取得影片的片長
			Long duration = getVideoDuration(videoFile.getAbsolutePath());
			System.out.println("影片片長：" + duration + " 秒");
			videoInfo.setVideoLength(duration.intValue());
			
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			videoInfo.setUploadDate(timestamp);

			// 將影片資訊存到sql
			viDao.insertVideo(videoInfo);
			System.out.println(videoInfo.getVideoId());
			
			//將圖片存到sql
			byte[] picF = readImageData(picFile);
			videoInfo.setPicture(picF);
			picFile.delete();
			
			commit();
			return "上傳完成";
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
			return "上傳失敗";
		}

	}

	// 獲取影片的片長
	private long getVideoDuration(String videoPath) throws IOException, InterruptedException {
		ProcessBuilder processBuilder = new ProcessBuilder("C:/Users/T14 Gen 3/Desktop/ffmpeg.exe", "-i",
				videoPath);
		Process process = processBuilder.start();
		process.waitFor();

		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		String line;
		StringBuilder output = new StringBuilder();
		while ((line = reader.readLine()) != null) {
			output.append(line);
		}

		// 解析 FFmpeg 輸出，獲取影片的片長
		String durationRegex = "Duration: (\\d\\d):(\\d\\d):(\\d\\d)\\.(\\d\\d)";
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(durationRegex);
		java.util.regex.Matcher matcher = pattern.matcher(output.toString());

		long durationInSeconds = 0;
		if (matcher.find()) {
			int hours = Integer.parseInt(matcher.group(1));
			int minutes = Integer.parseInt(matcher.group(2));
			int seconds = Integer.parseInt(matcher.group(3));
			durationInSeconds = hours * 3600 + minutes * 60 + seconds;
		}

		return durationInSeconds;
	}

	// 圖片轉bytes
	private byte[] readImageData(File imageFile) {
		try (FileInputStream inputStream = new FileInputStream(imageFile)) {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			return outputStream.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	
}
