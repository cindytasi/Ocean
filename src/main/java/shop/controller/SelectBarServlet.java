package shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import shop.service.ProductService;
import shop.vo.Product;

/**
 * Servlet implementation class SelectBarServlet
 */
@WebServlet("/SelectBarServlet")
public class SelectBarServlet extends HttpServlet {
	
	private ProductService productService;
	
    public void init() {
    	productService = new ProductService();
    }   
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String msg = request.getParameter("msg");
		List<Product> selectKeyword = productService.selectKeyWord(msg);
		request.setAttribute("product", selectKeyword);
		request.getRequestDispatcher("/jsp/Shop.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
