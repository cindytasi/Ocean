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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		resp.setCharacterEncoding("utf-8");
		Integer tmp = Integer.parseInt(req.getParameter("attractionId"));
		
		String img = "";
		if(tmp!=null) {
			
			System.out.println(tmp);
			img = as.selectAttractionImg(tmp);
			
			resp.setContentType("application/json");
			resp.getWriter().write(img);
		}
		
	}

}
