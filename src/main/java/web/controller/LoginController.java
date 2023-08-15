package web.controller;

import static core.util.CommonUtil.writePojo2Json;
import static core.util.CommonUtil.json2Pojo;
//import static core.util.CommonUtil.writePojo2Json;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import core.vo.CoreVo;
import web.service.UserService;
import web.service.imp.UserServiceImpl;
import web.vo.UserVo;

@WebServlet("/web/controller/LoginController")
public class LoginController extends HttpServlet {

	private UserService userservice;

	@Override
	public void init() throws ServletException {
		userservice = new UserServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		try {
//			HttpSession session = req.getSession(true);
////	        建立或取得 HttpSession 物件，用於在不同的請求間共享資訊
//
//			req.setCharacterEncoding("UTF-8");
//		 
//			UserVo vo = json2Pojo(req, UserVo.class);
////			從請求的輸入流中讀取 JSON 格式的資料，並將其反序列化成 loginVo 物件
//			String email = vo.getEmail();
//			String password = vo.getPassword();
//			String username = userservice.login(email, password);
////			使用 loginService 的 login 方法來驗證使用者，並獲取認證結果
//			
//			if (username != null) {
////				如果認證結果不為 null，表示認證成功
//				session.setAttribute("email", email);
//				session.setAttribute("password", password);
//				session.setAttribute("username", username);
////	            將 email、password 和認證後的使用者名稱存入 session
//
//				// 回傳 JSON 格式的回應，示範方法一
////				String res = "{\"successful\": true, \"message\": \"OK\"}";
////				resp.getWriter().write(res);
//
//				// 回傳 JSON 格式的回應，示範方法二，使用自定義的 Res 物件
////				 resp.getWriter().write(gson.toJson(new Res(true, "OK")));
//				
//				writePojo2Json(resp, userservice.login(vo));
//				
//				System.out.println(username);
//			} else {
//				resp.getWriter().write("false");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
		System.out.println("LoginServlet");
		UserVo userVo = json2Pojo(req, UserVo.class);
//		CoreVo coreVo = new CoreVo();
		if (userVo == null) {
			userVo = new UserVo();
			userVo.setMessage("無會員資訊");
			userVo.setSuccessful(false);
			writePojo2Json(resp, userVo);
			return;
		}

		userVo = userservice.login(userVo);
		System.out.println(userVo.isSuccessful());
		if (userVo.isSuccessful()) {
			if (req.getSession(false) != null) {
				req.changeSessionId();
			}
			final HttpSession session = req.getSession();
			session.setAttribute("loggedin", true);
			session.setAttribute("userVo", userVo);
//			System.out.println(userVo.toString());
		}
		writePojo2Json(resp, userVo);
	}

}
