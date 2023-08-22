package admin.service.impl;

//import java.lang.System.Logger;

import com.google.gson.Gson;

import admin.dao.AdminDao;
import admin.dao.impl.AdminDaoImpl;
import admin.service.AdminService;
import admin.vo.AdminVo;

//管理員service實作

public class AdminServiceImpl implements AdminService {
	private final AdminDao<AdminVo> adminD;
	private final Gson gson;

	public AdminServiceImpl() {
		adminD = new AdminDaoImpl();
		gson = new Gson();
	}
	//查詢全部管理員
	@Override
	public String findAll() {

		return gson.toJson(adminD.selectAll());
	}
	
	//新增管理員
	@Override
	public String insert(AdminVo adVo) {
		AdminVo tmp = selectByAccount(adVo.getAdminAccount());
		System.out.println(tmp.getAdminAccount()!=null);
		if(tmp.getAdminAccount()!=null) {
			return "帳號或名稱重複，請重新輸入";
		}else {
			String res = adminD.insert(adVo);
			if ("1".equals(res)) {
//				this.getClass().getName() + "新增完成"
				return "新增完成";
			} else {
				return "新增失敗";
			}
		}
	}
	
	//修改管理員資料
	@Override
	public String update(AdminVo adVo) {
		AdminVo tmp = selectById(adVo.getAdminId());
//		System.out.println(adVo.getAdminPassword().equals(tmp.getAdminPassword()));
		if(adVo.getAdminPassword().equals(tmp.getAdminPassword())) {
			return "密碼重複，請重新輸入";
		}else {
			String res = adminD.update(adVo.getAdminId(), adVo.getAdminPassword());
			if ("1".equals(res)) {
				return "修改完成";
			} else {
				return "修改失敗";
			}
		}
	}
	
	//刪除管理員
	@Override
	public String delete(AdminVo adVo) {
		String res = adminD.delete(adVo.getAdminId());
		if ("1".equals(res)) {
			return "刪除完成";
		} else {
			return "刪除失敗";
		}
	}
	
	//ID查詢管理員
	@Override
	public AdminVo selectById(Integer id) {

		return adminD.selectById(id);
	}
	//帳號查詢
	@Override
	public AdminVo selectByAccount(String account) {
		
		return adminD.selectOne(account);
	}
	@Override
	public AdminVo checkLogin(AdminVo adVo) {
		
		return adminD.checkLogin(adVo);
	}

	
}
