package web.controller;

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

import web.service.UserService;
import web.service.imp.UserServiceImpl;
import web.vo.UserVo;


@WebServlet("/web/controller/LoginController")
public class LoginController extends HttpServlet {

	
//	private static final long serialVersionUID = 1L;
	private UserService userservice;

	@Override
	public void init() throws ServletException {
		userservice = new UserServiceImpl();
	}

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doPost(req, resp);
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession(true);
//	        建立或取得 HttpSession 物件，用於在不同的請求間共享資訊

			req.setCharacterEncoding("UTF-8");

			System.out.println("LoginController");
//			Gson gson = new Gson();
//			建立 Gson 物件，用於序列化和反序列化 JSON 格式資料
//			UserVo vo = gson.fromJson(req.getReader(), UserVo.class);
			UserVo vo = json2Pojo(req, UserVo.class);
//			從請求的輸入流中讀取 JSON 格式的資料，並將其反序列化成 loginVo 物件
			String email = vo.getEmail();
			String password = vo.getPassword();
			System.out.println(email);
			System.out.println(password);

			String username = userservice.login(email, password);
//			使用 loginService 的 login 方法來驗證使用者，並獲取認證結果

			System.out.println(username);

			if (username != null) {
//				如果認證結果不為 null，表示認證成功
				session.setAttribute("email", email);
				session.setAttribute("password", password);
				session.setAttribute("username", username);
//	            將 email、password 和認證後的使用者名稱存入 session

				// 回傳 JSON 格式的回應，示範方法一
				 String res = "{\"successful\": true, \"message\": \"OK\"}";
				 resp.getWriter().write(res);

				// 回傳 JSON 格式的回應，示範方法二，使用自定義的 Res 物件
//				 resp.getWriter().write(gson.toJson(new Res(true, "OK")));
				
			} else {
				resp.getWriter().write("false");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

