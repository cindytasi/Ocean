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


@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {

	private ProductService productService;
	
    public void init() {
    	productService = new ProductService();
    }   
	
	
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String type = (String)req.getParameter("type");	
		List<Product> list = productService.getTopBarData(type);
		req.setAttribute("product", list);	
		req.getRequestDispatcher("/jsp/Shop.jsp").forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.doGet(req, res);
	}

}
