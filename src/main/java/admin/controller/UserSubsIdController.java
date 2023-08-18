package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import admin.service.UserSubsIdService;
import admin.service.impl.UserSubsIdServiceImpl;

@WebServlet("/UserSubsIdController")
public class UserSubsIdController extends HttpServlet{
	private UserSubsIdService us;
	private Gson gson;
	@Override
	public void init() throws ServletException {
		
		us = new UserSubsIdServiceImpl();
		gson = new Gson();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*"); // 允許來自所有網域的請求
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE"); // 允許的 HTTP 方法
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type"); // 允許的請求Header
		resp.setHeader("Access-Control-Allow-Credentials", "true"); // 是否允許帶有憑證的請求
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		
		Integer[] tmp = new Integer[2];
		tmp[0] = us.expiresThisMonth();
		tmp[1] = us.subscribersThisMonth();
		
		String res = gson.toJson(tmp);
		System.out.println(res);
		resp.getWriter().write(res);
	}

	
}
