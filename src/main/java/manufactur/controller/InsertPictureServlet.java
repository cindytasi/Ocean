package manufactur.controller;



import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;

import manufactur.dao.ManufactursDAO;
import manufactur.dao.ManufactursDAOimpl;
import manufactur.service.ManufacturServiceimpl;
import manufactur.vo.Product;

@WebServlet("/InsertPictureServlet")
public class InsertPictureServlet extends HttpServlet {

    private ManufactursDAO dao;

    public void init() {
        dao = new ManufactursDAOimpl();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/plain;charset=UTF-8");
        System.out.println("ProductsOnShelvesServlet");// 測試console
        // 獲取從客戶端傳遞過來的產品信息
        Gson gson = new Gson();
//     
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        Product product = gson.fromJson(req.getReader(), Product.class); 
        
        
      //  System.out.println(product.getProductName());
        product.setGender(1);
        product.setComId(4);
        product.setProductImgId(1);
     
        
        
        
//        dao.insert(product);

        // 返回插入結果給客戶端	
        
        Product products = new Product();
        		
    	products =	new ManufacturServiceimpl().insertNum(product);
   
    	res.getWriter().write(gson.toJson(products));
    	
    	
    	
//    	InputStream in = req.getPart("upFiles").getInputStream(); //從javax.servlet.http.Part物件取得上傳檔案的InputStream
//		byte[] upFiles = null;
//		if(in.available()!=0){
//			upFiles = new byte[in.available()];
//			in.read(upFiles);
//			in.close();
//		}  else errorMsgs.put("upFiles","員工照片: 請上傳照片");
//		
//		Integer deptno = Integer.valueOf(req.getParameter("deptno").trim());
//
//		// Send the use back to the form, if there were errors
//		if (!errorMsgs.isEmpty()) {
//			RequestDispatcher failureView = req
//					.getRequestDispatcher("/back-end/emp/addEmp.jsp");
//			failureView.forward(req, res);
//			return;
//		}
//		
//		/***************************2.開始新增資料***************************************/
//		EmpService empSvc = new EmpService();
//		empSvc.addEmp(ename, job, hiredate, sal, comm, upFiles, deptno);
//		
//		/***************************3.新增完成,準備轉交(Send the Success view)***********/
//		req.setAttribute("success", "- (新增成功)");
//		String url = "/back-end/emp/listAllEmp.jsp";
//		RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
//		successView.forward(req, res);				
//}
    	
    	
    	
    	
    	
    	
    	
    	
        	
        	
      
    }
}