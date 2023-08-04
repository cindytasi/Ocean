package shop.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shop.service.ProductService;
import shop.vo.Product;


@WebServlet("/MainShopServlet")
public class MainShopServlet extends HttpServlet {

	private ProductService productService;
	
    public void init() {
    	productService = new ProductService();
    }   
	
	
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		List<Product> list = productService.getNewAll();
		req.setAttribute("main", list);		
		req.getRequestDispatcher("/jsp/MainShop.jsp").forward(req, res);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.doGet(req, res);
	}

}
