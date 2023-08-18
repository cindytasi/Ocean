package manufactur.controller;




import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import manufactur.service.Manufacturs2Service;
import manufactur.vo.Product;

import javax.servlet.annotation.MultipartConfig;

import java.util.*;
//import com.emp.model.*;

@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
public class Manufacturs2Servlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		 if ("listAll".equals(action)) { // 單純秀出資料

	            /***************************開始查詢資料*****************************************/
			 Manufacturs2Service empSvc = new Manufacturs2Service();
	         //   List<Product> product = empSvc.getAll(); // 取得所有員工資料

	            /***************************查詢完成,準備轉交(Send the Success view)*************/
	         //   req.setAttribute("product", product); // 將員工資料存入 request 物件
	            RequestDispatcher successView = req.getRequestDispatcher("/back-end/emp/listAllEmp.jsp"); // 成功轉交 listAllEmp.jsp
	            successView.forward(req, res);
	        }

	        // ... 省略其他程式碼 ...
	    
	
		
//		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
//
//			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
//			req.setAttribute("errorMsgs", errorMsgs);
//
//				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
//				String str = req.getParameter("productName");
//				if (str == null || (str.trim()).length() == 0) {
//					errorMsgs.put("productName","請輸入商品名稱");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/back-end/emp/select_page.jsp");
//					failureView.forward(req, res);
//					return;//程式中斷
//				}
				
//				Integer empno = null;
//				try {
//					empno = Integer.valueOf(str);
//				} catch (Exception e) {
//					errorMsgs.put("empno","員工編號格式不正確");
//				}
				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/back-end/emp/select_page.jsp");
//					failureView.forward(req, res);
//					return;//程式中斷
//				}
				
				/***************************2.開始查詢資料*****************************************/
//				Manufacturs2Servlet empSvc = new Manufacturs2Servlet();
//				Product product = empSvc.getOneEmp(empno);
//				if (empVO == null) {
//					errorMsgs.put("empno","查無資料");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/back-end/emp/select_page.jsp");
//					failureView.forward(req, res);
//					return;//程式中斷
//				}
//				
//				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
//				req.setAttribute("empVO", empVO); // 資料庫取出的empVO物件,存入req
//				req.setAttribute("getOne_For_Display", "true"); // 旗標getOne_For_Display見select_page.jsp的第155行 -->
////				String url = "/back-end/emp/listOneEmp.jsp";    // 成功轉交 listOneEmp.jsp
//				String url = "/back-end/emp/select_page.jsp";   // 查詢完成後轉交select_page.jsp由其include file="listOneEmp-div.fragment"
//				RequestDispatcher successView = req.getRequestDispatcher(url);
//				successView.forward(req, res);
//		}
		
		
//		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求
//
//			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
//			req.setAttribute("errorMsgs", errorMsgs);
//			
//				/***************************1.接收請求參數****************************************/
//				Integer empno = Integer.valueOf(req.getParameter("empno"));
//				
//				/***************************2.開始查詢資料****************************************/
//				EmpService empSvc = new EmpService();
//				EmpVO empVO = empSvc.getOneEmp(empno);
//								
//				/***************************3.查詢完成,準備轉交(Send the Success view)************/
//				String param = "?empno="  +empVO.getEmpno()+
//						       "&ename="  +empVO.getEname()+
//						       "&job="    +empVO.getJob()+
//						       "&hiredate="+empVO.getHiredate()+
//						       "&sal="    +empVO.getSal()+
//						       "&comm="   +empVO.getComm()+
//						       "&deptno=" +empVO.getDeptno();
//				String url = "/back-end/emp/update_emp_input.jsp"+param;
//				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
//				successView.forward(req, res);
//		}
		
		
//		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
//			
//			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
//			req.setAttribute("errorMsgs", errorMsgs);
//		
//				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
//				Integer empno = Integer.valueOf(req.getParameter("empno").trim());
//				
//				String ename = req.getParameter("ename");
//				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//				if (ename == null || ename.trim().length() == 0) {
//					errorMsgs.put("ename","員工姓名: 請勿空白");
//				} else if(!ename.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.put("ename","員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//	            }
//				
//				String job = req.getParameter("job").trim();
//				String jobReg = "^.{2,10}$"; //此正則(規)表示式(regular-expression)- 用來比對JSR 303 的@Size
//				if (job == null || job.trim().length() == 0) {
//					errorMsgs.put("job","員工職位: 請勿空白");
//				} else if(!job.trim().matches(jobReg)) {
//					errorMsgs.put("job","員工職位: 長度必需在2到10之間");
//	            }
//				
//				java.sql.Date hiredate = null;
//				try {
//					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//				} catch (IllegalArgumentException e) {
//					errorMsgs.put("hiredate","雇用日期: 請勿空白");
//				}
//				
//				Double sal = null;
//				try {
//					sal = Double.valueOf(req.getParameter("sal").trim());
//				} catch (NumberFormatException e) {
//					errorMsgs.put("sal","員工薪水: 請輸入數字");
//				}
//				
//				Double comm = null;
//				try {
//					comm = Double.valueOf(req.getParameter("comm").trim());
//				} catch (NumberFormatException e) {
//					errorMsgs.put("comm","員工獎金: 請輸入數字");
//				}
//				
//				//照片
//				InputStream in = req.getPart("upFiles").getInputStream(); //從javax.servlet.http.Part物件取得上傳檔案的InputStream
//				byte[] upFiles = null;
//				if(in.available()!=0){
//					upFiles = new byte[in.available()];
//					in.read(upFiles);
//					in.close();
//				}  else {
//					EmpService empSvc = new EmpService();
//					upFiles = empSvc.getOneEmp(empno).getUpFiles();
//				}
//				
//				Integer deptno = Integer.valueOf(req.getParameter("deptno").trim());
//
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					errorMsgs.put("Exception","修改資料失敗:---------------");
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/back-end/emp/update_emp_input.jsp");
//					failureView.forward(req, res);
//					return; //程式中斷
//				}
//				
//				/***************************2.開始修改資料*****************************************/
//				EmpService empSvc = new EmpService();
//				EmpVO empVO = empSvc.updateEmp(empno, ename, job, hiredate, sal, comm, upFiles, deptno);
//				
//				/***************************3.修改完成,準備轉交(Send the Success view)*************/
//				req.setAttribute("success", "- (修改成功)");
//				req.setAttribute("empVO", empVO); // 資料庫update成功後,正確的的empVO物件,存入req
//				String url = "/back-end/emp/listOneEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
//				successView.forward(req, res);
//		}

        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
			
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String ename = req.getParameter("ename");
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (ename == null || ename.trim().length() == 0) {
					errorMsgs.put("ename","員工姓名: 請勿空白");
				} else if(!ename.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.put("ename","員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				
				String job = req.getParameter("job").trim();
				String jobReg = "^.{2,10}$"; //此正則(規)表示式(regular-expression)- 用來比對JSR 303 的@Size
				if (job == null || job.trim().length() == 0) {
					errorMsgs.put("job","員工職位: 請勿空白");
				} else if(!job.trim().matches(jobReg)) {
					errorMsgs.put("job","員工職位: 長度必需在2到10之間");
	            }
				
				java.sql.Date hiredate = null;
				try {
					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
				} catch (IllegalArgumentException e) {
					errorMsgs.put("hiredate","雇用日期: 請勿空白");
				}
				
				Double sal = null;
				try {
					sal = Double.valueOf(req.getParameter("sal").trim());
				} catch (NumberFormatException e) {
					errorMsgs.put("sal","員工薪水: 請輸入數字");
				}
				
				Double comm = null;
				try {
					comm = Double.valueOf(req.getParameter("comm").trim());
				} catch (NumberFormatException e) {
					errorMsgs.put("comm","員工獎金: 請輸入數字");
				}
				
				//照片
				InputStream in = req.getPart("upFiles").getInputStream(); //從javax.servlet.http.Part物件取得上傳檔案的InputStream
				byte[] upFiles = null;
				if(in.available()!=0){
					upFiles = new byte[in.available()];
					in.read(upFiles);
					in.close();
				}  else errorMsgs.put("upFiles","員工照片: 請上傳照片");
				
				Integer deptno = Integer.valueOf(req.getParameter("deptno").trim());

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/emp/addEmp.jsp");
					failureView.forward(req, res);
					return;
				}
				
//				/***************************2.開始新增資料***************************************/
////				EmpService empSvc = new EmpService();
//				empSvc.addEmp(ename, job, hiredate, sal, comm, upFiles, deptno);
//				
//				/***************************3.新增完成,準備轉交(Send the Success view)***********/
//				req.setAttribute("success", "- (新增成功)");
//				String url = "/back-end/emp/listAllEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
//				successView.forward(req, res);				
		}
		
		
//		if ("delete".equals(action)) { // 來自listAllEmp.jsp
//
//			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
//			req.setAttribute("errorMsgs", errorMsgs);
//	
//				/***************************1.接收請求參數***************************************/
//				Integer empno = Integer.valueOf(req.getParameter("empno"));
//				
//				/***************************2.開始刪除資料***************************************/
//				EmpService empSvc = new EmpService();
//				empSvc.deleteEmp(empno);
//				
//				/***************************3.刪除完成,準備轉交(Send the Success view)***********/
//				req.setAttribute("success", "- (刪除成功)");
//				String url = "/back-end/emp/listAllEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
//				successView.forward(req, res);
//		}
		
//		if ("listEmps_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//				
//				/***************************1.將輸入資料轉為Map**********************************/ 
//				//採用Map<String,String[]> getParameterMap()的方法 
//				//注意:an immutable java.util.Map 
//				Map<String, String[]> map = req.getParameterMap();
//				
//				/***************************2.開始複合查詢***************************************/
//				EmpService empSvc = new EmpService();
//				List<EmpVO> list  = empSvc.getAll(map);
//				
//				/***************************3.查詢完成,準備轉交(Send the Success view)************/
//				req.setAttribute("empListData", list); // 資料庫取出的list物件,存入request
//				RequestDispatcher successView = req.getRequestDispatcher("/back-end/emp/listAllEmp.jsp"); // 成功轉交listEmps_ByCompositeQuery.jsp
//				successView.forward(req, res);
//		}		
	}
}
