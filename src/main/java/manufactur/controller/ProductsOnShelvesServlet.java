package manufactur.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manufactur.dao.ManufactursDAO;
import manufactur.dao.ManufactursDAOimpl;
import manufactur.vo.Product;

@WebServlet("/ProductsOnShelvesServlet")
public class ProductsOnShelvesServlet extends HttpServlet {

    private ManufactursDAO dao;

    public void init() {
        dao = new ManufactursDAOimpl();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/plain;charset=UTF-8");
        
        // 獲取從客戶端傳遞過來的產品信息
//        String productName = req.getParameter("productName");
//        int specType = Integer.parseInt(req.getParameter("specType"));
//        String sizeType = req.getParameter("sizeType");
//        int inStock = Integer.parseInt(req.getParameter("inStock"));
//        double price = Double.parseDouble(req.getParameter("price"));
        int productId = Integer.parseInt(req.getParameter("productId"));
        String productName = req.getParameter("productName");
        int specType = Integer.parseInt(req.getParameter("specType"));
        String specInfo = req.getParameter("specInfo");
        String sizeType = req.getParameter("sizeType");
        String colorType = req.getParameter("colorType");
        int comId = Integer.parseInt(req.getParameter("comId"));
        
        String addedTime = req.getParameter("addedTime");
        String reviewTime = req.getParameter("reviewTime");
      Timestamp addedTime1 = Timestamp.valueOf(addedTime);
     Timestamp reviewTime1 = Timestamp.valueOf(reviewTime);
     
        double price = Double.parseDouble(req.getParameter("price"));
        String videoName = req.getParameter("videoName");
        int productImgId = Integer.parseInt(req.getParameter("productImgId"));
        int inStock = Integer.parseInt(req.getParameter("inStock"));
        
        String gender = req.getParameter("gender");
        int gender1 = Integer.parseInt(gender);
        
        
        // 創建一個 Product 對象並設置其屬性
//        Product product = new Product();
//        product.setProductName(productName);
//        product.setSpecType(specType);
//        product.setSizeType(sizeType);
//        product.setInStock(inStock);
//        product.setPrice(price);
        Product product = new Product();
        product.setProductId(productId);
        product.setProductName(productName);
        product.setSpecType(specType);
        product.setSpecInfo(specInfo);
        product.setSizeType(sizeType);
        product.setColorType(colorType);
        product.setComId(comId);
        product.setAddedTime(addedTime1);
        product.setReviewTime(reviewTime1);
        product.setPrice(price);
        product.setVideoName(videoName);
        product.setProductImgId(productImgId);
        product.setInStock(inStock);
        product.setGender(gender1);

        
        
        // 調用 insert 方法將 Product 對象插入到數據庫中
        int rowsInserted = dao.insert(product);

        // 返回插入結果給客戶端
        if (rowsInserted > 0) {
            res.getWriter().write("插入成功！插入了 " + rowsInserted + " 行數據。");
        } else {
            res.getWriter().write("插入失败！");
        }
    }
}
