package admin.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.MemberService;
import admin.service.impl.MemberServiceImpl;

@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private MemberService ms;

	public MemberController() {
		ms = new MemberServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*"); // 允許來自所有網域的請求
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE"); // 允許的 HTTP 方法
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type"); // 允許的請求Header
		resp.setHeader("Access-Control-Allow-Credentials", "true"); // 是否允許帶有憑證的請求
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		
		// 讀取收到的request資訊
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = req.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String reqq = sb.toString();
		String [] tmp = reqq.split(":");
		String userId = tmp[1];
		userId = userId.substring(1,userId.length()-2);
		
		String res = ms.selectByUserId(Integer.valueOf(userId));
		
		resp.getWriter().write(res);
	}

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		resp.setHeader("Access-Control-Allow-Origin", "*"); // 允許來自所有網域的請求
//		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE"); // 允許的 HTTP 方法
//		resp.setHeader("Access-Control-Allow-Headers", "Content-Type"); // 允許的請求Header
//		resp.setHeader("Access-Control-Allow-Credentials", "true"); // 是否允許帶有憑證的請求
//		resp.setCharacterEncoding("utf-8");
//		resp.setContentType("application/json");
//		var out = resp.getWriter();
//		
//		Integer memberQuantity = ms.selectMemberQuantity();
//		out.write(String.valueOf(memberQuantity));
//		
//	}
	
	

}
