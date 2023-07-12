package admin.dao;

import java.util.List;

import admin.vo.adminVo;


public interface adminDao<T> {
	
	List<adminVo> selectAll();
	
	String insert(T obj);
	
	String update(Integer id,String updatePassword);
	
	String delete(Integer id);
}
