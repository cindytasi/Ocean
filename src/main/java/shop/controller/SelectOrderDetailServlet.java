package shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import shop.service.SelectOrdersService;
import shop.vo.OrderDetailVO;


@WebServlet("/SelectOrderDetailServlet")
public class SelectOrderDetailServlet extends HttpServlet {
	
	private static SelectOrdersService selectOrdersService;

	static {
		selectOrdersService = new SelectOrdersService();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String orderIdstr = request.getParameter("orderId");
		int orderId = Integer.parseInt(orderIdstr);
		List<OrderDetailVO> OrderDetailList= selectOrdersService.getOrderDetail(orderId);
		Gson gson = new Gson();
		String OrderDetailJson = gson.toJson(OrderDetailList);		
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(OrderDetailJson);
			writer.flush();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
		
		
		
	}

}
