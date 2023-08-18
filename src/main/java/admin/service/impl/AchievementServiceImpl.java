package admin.service.impl;

import com.google.gson.Gson;

import admin.dao.AchievementDao;
import admin.dao.impl.AchievementDaoImpl;
import admin.service.AchievementService;
import admin.util.CoreService;
import admin.vo.Achievement;

//成就service實作

public class AchievementServiceImpl implements AchievementService,CoreService{
	private AchievementDao<Achievement> dao;
	private final Gson gson ;
	
	public AchievementServiceImpl() {
		dao = new AchievementDaoImpl();
		gson = new Gson();
	}
	
	//查詢全部成就
	@Override
	public String findAll() {
		beginTransaction();
		
		String jsonStr = "";

		jsonStr = gson.toJson(dao.selectAll());
		System.out.println(jsonStr);
		commit();
		
		return jsonStr;
	}
	
	//修改成就條件
	@Override
	public String update(Achievement ach) {
		beginTransaction();
		
		try {
			String res = dao.update(ach);
			commit();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
			return "0";
		}
	}
	
	//新增成就
	@Override
	public String insert(Achievement ach) {
		beginTransaction();
		try {
			String res = dao.insert(ach);
			commit();
			return res;
		} catch (Exception e) {
			
			e.printStackTrace();
			rollback();
			return "0";
		}
	}
	
	//刪除成就
	@Override
	public String delete(Integer id) {
		beginTransaction();
		try {
			String res = dao.delete(id);
			commit();
			return res;
		} catch (Exception e) {
			
			e.printStackTrace();
			rollback();
			return"0";
		}
	}

}
