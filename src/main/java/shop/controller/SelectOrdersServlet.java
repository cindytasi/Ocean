package shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import shop.dao.SelectOrdersDao;
import shop.service.SelectOrdersService;
import shop.vo.OrderDetailVO;
import shop.vo.OrderVO;
import web.vo.UserVo;

@WebServlet("/SelectOrdersServlet")
public class SelectOrdersServlet extends HttpServlet {

	private static SelectOrdersService selectOrdersService;

	static {
		selectOrdersService = new SelectOrdersService();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserVo userVo= (UserVo)session.getAttribute("userVo");	
		String userId = String.valueOf(userVo.getUserId());
		
		
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
				
		List<OrderVO> ordersList = selectOrdersService.getOrders(userId);
		Gson gson = new Gson();
		String ordersListJson = gson.toJson(ordersList);		
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(ordersListJson);
			writer.flush();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
		

		
		
		
	}

}
