package admin.service;

import admin.vo.Achievement;

//成就service介面
public interface AchievementService {
	public String findAll();				//查全部
	
	public String update(Achievement ach);	//更新修改
	
	public String insert(Achievement ach);	//新增
	
	public String delete(Integer id);		//刪除
}
