package admin.dao;

import java.util.List;

import org.hibernate.Session;

import admin.util.HibernateUtil;
import admin.vo.AdminVo;


public interface AdminDao<T> {
	
	AdminVo checkLogin(AdminVo avo);				//確認登入
	
	List<T> selectAll();							//查全部
	
	T selectById(Integer id); 						//ID查詢單筆
	
	T selectOne(String tag);						//關鍵字查詢單筆
	
	String insert(T obj);							//新增單筆
	
	String update(Integer id,String updatePassword);//更新管理員密碼
	
	String update(Integer id, Integer hours);		//成就修改
	
	String update(T obj);							//更新廠商資訊
	
	String delete(Integer id);						//刪除
	
	//取得當前的SessionFactory
	default Session getSession() {
		  return HibernateUtil.getSessionFactory().getCurrentSession();
		 }
}
