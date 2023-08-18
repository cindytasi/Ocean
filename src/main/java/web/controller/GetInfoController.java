package web.controller;


import static core.util.CommonUtil.writePojo2Json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.UserService;
import web.service.imp.UserServiceImpl;
import web.vo.UserVo;

@WebServlet("/web/controller/GetInfoController")
public class GetInfoController extends HttpServlet{

	private UserService userservice;
	
	@Override
	public void init() throws ServletException {
		userservice = new UserServiceImpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserVo userVo =(UserVo) req.getSession().getAttribute("userVo");
		if(userVo == null) {
			userVo = new UserVo();
			userVo.setMessage("無會員資訊");
			userVo.setSuccessful(false);
		}else {
			userVo.setStatusCode(true);
		}
		writePojo2Json(resp, userVo);
	}
}
