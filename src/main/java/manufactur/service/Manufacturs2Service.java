package manufactur.service;

import java.sql.Timestamp;

////////////裡面都還沒改


import java.util.List;
import java.util.Map;

import manufactur.dao.Manufacturs2DAO;
import manufactur.dao.Manufacturs2DAOimpl;
import manufactur.vo.Product;
public class Manufacturs2Service { 

//	private Manufacturs2DAO dao;
//
//	
//	
//	public Manufacturs2Service() {
//		dao = new Manufacturs2DAOimpl();
//	}
//
//	public Product addEmp(String ProductName, int SpecType,String SpecInfo ,
//			String SizeType, String colorType ,int comId, byte[] upFiles, Integer deptno) {
////		java.sql.Date hiredate
//		Product product = new Product();
//		
//		product.setString(1, product.getProductName());
//		product.setInt(2, product.getSpecType());
//		product.setString(3, product.getSpecInfo());
//		product.setString(4, product.getSizeType());
//		product.setString(5, product.getColorType());
//		product.setInt(6, product.getComId());
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//		//pstmt.setString(7,  timestamp.toString());
//		product.setTimestamp(7,  product.getAddedTime());			
//		product.setString(8,  timestamp.toString());
//		product.setDouble(9, product.getPrice());
//		product.setString(10, "hekkkk");
//		product.setInt(11, product.getProductImgId());
//		product.setInt(12, product.getInStock());
//		product.setInt(13, product.getGender());
//
//		product.executeUpdate();
//		
//		 BufferedReader reader = req.getReader();
//       Product product = gson.fromJson(reader, Product.class);
//       double price = Double.parseDouble(req.getParameter("price"));
//       int productId = Integer.parseInt(req.getParameter("productId"));
//       String productName = req.getParameter("productName");
//       int specType = Integer.parseInt(req.getParameter("specType"));
//       String specInfo = req.getParameter("specInfo");
//       String sizeType = req.getParameter("sizeType");
//       String colorType = req.getParameter("colorType");
//       int comId = Integer.parseInt(req.getParameter("comId"));
//       
//       String addedTime = req.getParameter("addedTime");
//       String reviewTime = req.getParameter("reviewTime");
//       Timestamp addedTime1 = Timestamp.valueOf(addedTime);
//     	Timestamp reviewTime1 = Timestamp.valueOf(reviewTime);
//    
//       double price = Double.parseDouble(req.getParameter("price"));
//       String videoName = req.getParameter("videoName");
//       int productImgId = Integer.parseInt(req.getParameter("productImgId"));
//       int inStock = Integer.parseInt(req.getParameter("inStock"));
//       
//       String gender = req.getParameter("gender");
//       int gender1 = Integer.parseInt(gender);
		
		
		
		
		
		
		
		
		
//
//		empVO.setEname(ename);
//		empVO.setJob(job);
//		empVO.setHiredate(hiredate);
//		empVO.setSal(sal);
//		empVO.setComm(comm);
//		empVO.setUpFiles(upFiles);
//		empVO.setDeptno(deptno);
//		dao.insert(empVO);
//
//		return empVO;
	//}

//	//預留給 Struts 2 或 Spring MVC 用
//	public void addEmp(EmpVO empVO) {
//		dao.insert(empVO);
//	}
//	
//	public EmpVO updateEmp(Integer empno, String ename, String job,	java.sql.Date hiredate, 
//			Double sal, Double comm, byte[] upFiles, Integer deptno) {
//
//		EmpVO empVO = new EmpVO();
//
//		empVO.setEmpno(empno);
//		empVO.setEname(ename);
//		empVO.setJob(job);
//		empVO.setHiredate(hiredate);
//		empVO.setSal(sal);
//		empVO.setComm(comm);
//		empVO.setUpFiles(upFiles);
//		empVO.setDeptno(deptno);
//		dao.update(empVO);
//
//		return dao.findByPrimaryKey(empno);
//	}
	
//	//預留給 Struts 2 或 Spring MVC 用
//	public void updateEmp(EmpVO empVO) {
//		dao.update(empVO);
//	}
//
//	public void deleteEmp(Integer empno) {
//		dao.delete(empno);
//	}
//
//	public EmpVO getOneEmp(Integer empno) {
//		return dao.findByPrimaryKey(empno);
//	}
//
//	public List<EmpVO> getAll() {
//		return dao.getAll();
//	}
//	
//	public List<EmpVO> getAll(Map<String, String[]> map) {
//		return dao.getAll(map);
//	}

}