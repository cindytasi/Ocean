package web.controller;

import static core.util.CommonUtil.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.vo.CoreVo;
import web.vo.UserVo;

@WebServlet("/web/controller/CheckPasswordController")
public class CheckPasswordController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userInput = json2Pojo(req, UserVo.class).getPassword();
		UserVo userVo = (UserVo) req.getSession().getAttribute("userVo");
		CoreVo coreVo = new CoreVo();
//		System.out.println("CheckPasswordController");
		if (userVo == null) {
			coreVo.setMessage("無會員資訊");
			coreVo.setSuccessful(false);
		} else {
			final String currentPassword = userVo.getPassword();
			if (userInput.equals(currentPassword)) {
//				System.out.println(userInput.equals(currentPassword));
				coreVo.setSuccessful(true);
//				System.out.println("true");
			} else {
				System.out.println(userInput.equals(currentPassword));
				coreVo.setMessage("舊密碼錯誤");
				coreVo.setSuccessful(false);
//				System.out.println("false");
			}
//			System.out.println(currentPassword);

		}
		System.out.println(userInput);
		writePojo2Json(resp, coreVo);
	}
}
