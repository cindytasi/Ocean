package admin.service;

import admin.vo.AdminVo;

//管理員service介面

public interface AdminService {
	
	public AdminVo checkLogin(AdminVo adVo);			//登入確認
	
	public String findAll();						//查全部
	
	public String insert(AdminVo adVo);				//新增
	
	public String update(AdminVo adVo);				//更新
	
	public String delete(AdminVo adVo);				//刪除
	
	public AdminVo selectById(Integer id);			//ID查尋
	
	public AdminVo selectByAccount(String account);	//帳號查詢
}

