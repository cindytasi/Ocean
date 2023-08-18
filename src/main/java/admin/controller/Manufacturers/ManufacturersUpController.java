package admin.controller.Manufacturers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import admin.service.ManufacturersService;
import admin.service.impl.ManufacturersServiceImpl;
import admin.vo.Manufacturers;

//修改廠商權限

@WebServlet("/manufacturersUpController")
public class ManufacturersUpController extends HttpServlet {
	private ManufacturersService ms;

	public ManufacturersUpController() {
		ms = new ManufacturersServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*"); // 允許來自所有網域的請求
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE"); // 允許的 HTTP 方法
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type"); // 允許的請求Header
		resp.setHeader("Access-Control-Allow-Credentials", "true"); // 是否允許帶有憑證的請求
		resp.setCharacterEncoding("utf-8");
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = req.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String requestBody = sb.toString();
		
		Manufacturers msVo = new Manufacturers();
		Gson gson = new Gson();
		//更新單筆
		msVo = gson.fromJson(requestBody, Manufacturers.class);
		String msg=ms.update(msVo);
		if("1".equals(msg)) {
			msg="權限修改成功!";
		}else {
			msg="權限修改失敗!";
		}
		resp.setContentType("application/json");
		resp.getWriter().write(msg);
	}

}
