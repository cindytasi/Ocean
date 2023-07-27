package web.controller;

import java.io.IOException;

import static core.util.CommonUtil.json2Pojo;
import static core.util.CommonUtil.writePojo2Json;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import web.service.UserService;
import web.service.imp.UserServiceImpl;
import web.vo.UserVo;

@WebServlet("/web/controller/RegisterController")
public class RegisterController extends HttpServlet {

//	public static final UserService SERVICE = new UserServiceImpl();
	
	private UserService userservice;

	@Override
	public void init() throws ServletException {
		userservice = new UserServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("RegisterController");
		UserVo userVo = json2Pojo(req, UserVo.class);
		
		if (userVo== null) {
			userVo = new UserVo();
			userVo.setMessage("無會員資訊");
			userVo.setSuccessful(false);
			writePojo2Json(resp, userVo);
			return ;
		}

		userVo = userservice.register(userVo);
		resp.setCharacterEncoding("UTF-8");
		writePojo2Json(resp, userVo);
	}
}
