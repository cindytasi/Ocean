package web.controller;

import static core.util.CommonUtil.json2Pojo;
import static core.util.CommonUtil.writePojo2Json;
import java.io.IOException;
import java.lang.reflect.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.service.UserService;
import web.service.imp.UserServiceImpl;
import web.vo.UserVo;

@WebServlet("/web/controller/EditController")
public class EditController extends HttpServlet {

	private UserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("EditController");

		UserVo userVo = json2Pojo(req, UserVo.class);
		writePojo2Json(resp, userService.edit(userVo));
	}
}
