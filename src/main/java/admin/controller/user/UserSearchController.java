package admin.controller.user;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import admin.service.UserService;
import admin.service.impl.UserServiceImpl;
import admin.vo.User;

@WebServlet("/userSearchController")
public class UserSearchController extends HttpServlet{
	private UserService service;
	private Gson gson;
	
	public UserSearchController() {
		service = new UserServiceImpl();
		gson = new Gson();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*"); // 允許來自所有網域的請求
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE"); // 允許的 HTTP 方法
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type"); // 允許的請求Header
		resp.setHeader("Access-Control-Allow-Credentials", "true"); // 是否允許帶有憑證的請求
		resp.setCharacterEncoding("utf-8");
		
		//讀取收到的request資訊
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = req.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String requestBody = sb.toString();
		User user = gson.fromJson(requestBody, User.class);
		String res="";
		resp.setContentType("application/json");
		
		if(user.getUserId()==null) {
			res = service.selectOne(user.getUserName());
		}
		if(user.getUserName()==null) {
			res = service.selectById(user.getUserId());
		}
		if(res!=null) {
			
			resp.getWriter().write(res);
		}else {
			resp.getWriter().write("查無資料");
		}
	}

}
