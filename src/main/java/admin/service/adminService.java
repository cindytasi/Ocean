package admin.service;

import admin.vo.adminVo;

//import java.util.List;



public interface adminService {
	public String findAll();
	
	public String insert(adminVo adVo);
	
	public String update(adminVo adVo);
	
	public String delete(adminVo adVo);
}
