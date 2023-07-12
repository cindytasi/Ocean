package admin.service.impl;

import java.lang.System.Logger;

import com.google.gson.Gson;

import admin.dao.adminDao;
import admin.dao.impl.adminDaoImpl;
import admin.service.adminService;
import admin.vo.adminVo;

public class adminServiceImpl implements adminService {
	private adminDao<adminVo> adminD;

	public adminServiceImpl() {
		adminD = new adminDaoImpl();
	}

	@Override
	public String findAll() {
		String jsonStr = "";
		Gson gson = new Gson();
		jsonStr = gson.toJson(adminD.selectAll());
		return jsonStr;
	}

	@Override
	public String insert(adminVo adVo) {
		String res = adminD.insert(adVo);
		if ("1".equals(res)) {
//			this.getClass().getName() + "新增完成"
			return "新增完成";
		} else {
			return "新增失敗";
		}
	}

	@Override
	public String update(adminVo adVo) {
		String res = adminD.update(adVo.getAdminId(), adVo.getAdminPassword());
		if ("1".equals(res)) {
			return "更新完成";
		} else {
			return "更新失敗";
		}
	}

	@Override
	public String delete(adminVo adVo) {
		String res = adminD.delete(adVo.getAdminId());
		if ("1".equals(res)) {
			return "刪除完成";
		} else {
			return "刪除失敗";
		}
	}

}
