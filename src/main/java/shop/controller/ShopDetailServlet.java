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
import shop.vo.ProdIdSizeColorImgStock;
import shop.vo.Product;
import shop.vo.ProductDetail2;


@WebServlet("/ShopDetailServlet")
public class ShopDetailServlet extends HttpServlet {
	
	private ProductService productService;
	
	public void init() {
    	productService = new ProductService();
    }  
     
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String productName = req.getParameter("productName");
		String color = req.getParameter("color");
		
		ProductDetail2 result = productService.getDetailAll(productName, color);

		Gson gson = new Gson();
		String mappingJson = gson.toJson(result.getProdIdSizeColorImgStockList());
		
		req.setAttribute("detail", result);
		req.setAttribute("defaultColorType", color);
		req.setAttribute("mappingJson", mappingJson);
		req.getRequestDispatcher("/jsp/ShopDetail.jsp").forward(req, res);
		
	}
		
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		this.doGet(req, res);
	}

}
