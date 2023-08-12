package manufactur.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import manufactur.dao.ManufactursDAO;
import manufactur.dao.ManufactursDAOimpl;
import manufactur.service.ManufacturServiceimpl;
import manufactur.service.ManufactursService;
import manufactur.vo.Product;
import manufactur.vo.ProductImg;

@WebServlet("/ProductsOnShelvesServlet")
@MultipartConfig
public class ProductsOnShelvesServlet extends HttpServlet {

    private ManufactursService dao;

    public void init() {
        dao = new ManufacturServiceimpl();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		res.setContentType("text/plain;charset=UTF-8");
		System.out.println("ProductsOnShelvesServlet");// 測試console
		// 獲取從客戶端傳遞過來的產品信息
		
		  try {
			  
			  List<byte[]> imageList = new ArrayList<>();   // 建立byte[]的list
			  
				for (Part part : req.getParts()) {   // 圖片們是用request.getParts()取 forEach迴圈來對每個Part做處理
					if (part.getName().startsWith("images")) {  // 這裡images就是前端設的key
						try (InputStream inputStream = part.getInputStream()) { //這裡用到trywithresources寫法 讓IS自動關閉
					            imageList.add(inputStream.readAllBytes());     // 用IS的readAllBytes()加到list裡
					        } catch (IOException e) {
					            e.printStackTrace();  // 處理Exception
					        }
					    }
					}

	            double price = Double.parseDouble(req.getParameter("price"));
	            String productName = req.getParameter("productName");
	            int specType = Integer.parseInt(req.getParameter("specType"));
	            String specInfo = req.getParameter("specInfo");
	            String sizeType = req.getParameter("sizeType");
	            String colorType = req.getParameter("colorType");
	            String videoName = req.getParameter("videoName");
	            int inStock = Integer.parseInt(req.getParameter("inStock"));
	            String gender = req.getParameter("gender");

//	            InputStream inputStream1 = imagePart1.getInputStream();
//	            InputStream inputStream2 = imagePart2.getInputStream();
//	            InputStream inputStream3 = imagePart3.getInputStream();
//	            InputStream inputStream4 = imagePart4.getInputStream();

	            // 創建 Product 物件並設置相關屬性
	            Product product = new Product();
	            ProductImg productimg =new ProductImg();
	            
	            productimg.setImg1(imageList.get(1));
	            productimg.setImg2(imageList.get(2));
	            productimg.setImg3(imageList.get(3));
	            productimg.setImg4(imageList.get(4));
	            
	            
	            product.setPrice(price);
	            product.setProductName(productName);
	            product.setSpecType(specType);
	            product.setSpecInfo(specInfo);
	            product.setSizeType(sizeType);
	            product.setColorType(colorType);
	            product.setVideoName(videoName);
	            product.setInStock(inStock);
	            product.setGender(Integer.parseInt(gender));
	            
	            
	            Product product1 = dao.insertNum(product,productimg);
	            
//
//	            // 執行 ManufacturServiceimpl 的 insertNum 方法，並將回傳的 Product 物件用於錯誤判斷
//	            Product products = new ManufacturServiceimpl().insertNum(product);
//
//	            // 返回結果給客戶端
//	            res.getWriter().write(gson.toJson(products));

	        } catch (Exception e) {
	            e.printStackTrace();
	            res.getWriter().println("Error: " + e.getMessage());
	        }
	    }
	}
    	
    	
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
    	
    	
    	
    	
    	
    	
    	
    	
