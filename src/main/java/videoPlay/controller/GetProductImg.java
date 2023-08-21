package videoPlay.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import videoPlay.service.ProductInformationService;
import videoPlay.service.Impl.ProductInformationServiceImpl;

@WebServlet("/GetProductImg")
public class GetProductImg extends HttpServlet{

	private ProductInformationService pis;
	@Override
	public void init() throws ServletException {
		pis = new ProductInformationServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		Integer productImgId = Integer.parseInt(req.getParameter("productImgId"));
		System.out.println(productImgId);
		String img = pis.selectProductImgById(Integer.valueOf(productImgId));
		
		resp.setContentType("text/plain");
		resp.getWriter().write(img);
	}

}
