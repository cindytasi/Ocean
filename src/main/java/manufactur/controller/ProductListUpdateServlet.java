package manufactur.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import manufactur.dao.ManufactursDAOimpl;
import manufactur.service.ManufacturServiceimpl;
import manufactur.service.ManufacturService;
import manufactur.vo.Product;

@WebServlet("/ProductListUpdateServlet")
public class ProductListUpdateServlet extends HttpServlet {

    private ManufactursDAOimpl dao;

    public void init() {
        dao = new  ManufactursDAOimpl();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        try {
            // 從請求參數中獲取更新的產品數據
        	  Gson gson = new Gson();
              BufferedReader reader = req.getReader();
              Product updatedProduct = gson.fromJson(reader, Product.class);

//    		
//        	System.out.println(Integer.parseInt(req.getParameter("productId")));
//            int productId = Integer.parseInt(req.getParameter("productId"));
//            double price = Double.parseDouble(req.getParameter("price"));
//            System.out.println(price);
//            String productName = req.getParameter("productName");
//            int specType = Integer.parseInt(req.getParameter("specType"));
//            String sizeType = req.getParameter("sizeType");
//            String colorType = req.getParameter("colorType");
//            String videoName = req.getParameter("videoName");
//            int inStock = Integer.parseInt(req.getParameter("inStock"));
//            String gender = req.getParameter("gender");

            // 創建 Product 對象，並設置更新的數據
//            Product product1 = new Product();
//            
//            // 設置其他產品數據
//           product1.setProductId(productId); // 設置要更新的產品的ID
//            product1.setPrice(price);
//            product1.setProductName(productName);
//            product1.setSpecType(specType);
//            product1.setSizeType(sizeType);
//            product1.setColorType(colorType);
//            product1.setVideoName(videoName);
//            product1.setInStock(inStock);
//            product1.setGender(Integer.parseInt(gender));

            // 使用您的服務來更新產品
            int rowsAffected = dao.updateProductInformation(updatedProduct);
            
            // 根據需要處理更新後的產品數據
           
            String redirectUrl = "/Ocean/jsp/test4.html"; // 更新後重定向的URL
            res.sendRedirect(redirectUrl);
        } catch (Exception e) {
            e.printStackTrace();
            res.getWriter().println("Error: " + e.getMessage());
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        
    }
}
