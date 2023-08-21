package admin.controller.video;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import admin.service.VideoService;
import admin.service.impl.VideoServiceImpl;
import admin.vo.Video;

@WebServlet("/videoUpload")
@MultipartConfig
public class VideoUpload extends HttpServlet {
	
	private VideoService vs;

	@Override
	public void init() throws ServletException {
		vs = new VideoServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*"); // 允許來自所有網域的請求
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE"); // 允許的 HTTP 方法
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type"); // 允許的請求Header
		resp.setHeader("Access-Control-Allow-Credentials", "true"); // 是否允許帶有憑證的請求
		resp.setCharacterEncoding("utf-8");
		String videoType = getPartValue(req.getPart("videoType"));
		String videoName = getPartValue(req.getPart("videoName"));
		String domainId = getPartValue(req.getPart("domainId"));
		String videoYear = getPartValue(req.getPart("videoYear"));
		String videoArea = getPartValue(req.getPart("videoArea"));
		String videoDirector = getPartValue(req.getPart("videoDirector"));
		String videoActor = getPartValue(req.getPart("videoActor"));
		String videoSeason = getPartValue(req.getPart("videoSeason"));
		String videoEpisode = getPartValue(req.getPart("videoEpisode"));
		String Introduction = getPartValue(req.getPart("Introduction"));
		
		Part imgFilePart = req.getPart("imgFile");
        Part picFilePart = req.getPart("picFile");
		
		System.out.println(videoType + videoName + domainId + videoYear + videoArea + videoDirector + videoActor
				+ videoSeason + videoEpisode + Introduction);

		Video video = new Video();
		video.setVideoName(videoName);
		video.setDomainId(Integer.valueOf(domainId));
		video.setVideoYear(Integer.valueOf(videoYear));
		video.setVideoArea(videoArea);
		video.setVideoDirector(videoDirector);
		video.setVideoActor(videoActor);
		video.setVideoSeason(Integer.valueOf(videoSeason));
		video.setVideoEpisode(Integer.valueOf(videoEpisode));
		video.setIntroduction(Introduction);
		video.setVideoType(getPartValue(req.getPart("videoType")));
		video.setAdminId(1);
		video.setViews(0);
		video.setSave(0);
		String res = vs.uploadVideo(imgFilePart, picFilePart, video);
		
		resp.setContentType("text/plain");
		resp.getWriter().write(res);

	}
	//將part裡的內容取出
	private String getPartValue(Part part) throws IOException {
		if (part != null) {
			InputStream inputStream = part.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			StringBuilder value = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				value.append(line);
			}
			return value.toString();
		}
		return null;
	}
}
