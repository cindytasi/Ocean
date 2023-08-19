package videoPlay.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import videoPlay.service.AttractionService;
import videoPlay.service.Impl.AttractionServiceImpl;

@WebServlet("/GetAttractionImg")
public class GetAttractionImg extends HttpServlet{
	private AttractionService as;
	
	@Override
	public void init() throws ServletException {
		as = new AttractionServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*"); // 允許來自所有網域的請求
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE"); // 允許的 HTTP 方法
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type"); // 允許的請求Header
		resp.setHeader("Access-Control-Allow-Credentials", "true"); // 是否允許帶有憑證的請求
		resp.setCharacterEncoding("utf-8");
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = req.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String tmp = sb.toString();
		tmp = tmp.substring(17,tmp.length()-2);
		String[] tmp2 = tmp.split(",");
//		String id = tmp2[1].substring(0,tmp2[1].length()-1);
//		System.out.println(tmp2.toString());
		String img = as.selectAttractionImg(tmp2);
		
		resp.setContentType("application/json");
		resp.getWriter().write(img);
	}

}
