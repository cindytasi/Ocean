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
import shop.vo.ProductDetail;


@WebServlet("/ShopDetailServlet")
public class ShopDetailServlet extends HttpServlet {
	
	private ProductService productService;
	
	public void init() {
    	productService = new ProductService();
    }  
     
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String productName = req.getParameter("productName");
		String color = req.getParameter("color");
		
		ProductDetail result = productService.getDetailAll(productName, color);
		req.setAttribute("detail", result);
		req.getRequestDispatcher("/jsp/ShopDetail.jsp").forward(req, res);
		
	}
		
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		this.doGet(req, res);
	}

}
