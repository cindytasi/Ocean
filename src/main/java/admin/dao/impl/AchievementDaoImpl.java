package admin.dao.impl;

import java.util.List;

import admin.dao.AchievementDao;
import admin.vo.Achievement;

//成就dao實作

public class AchievementDaoImpl implements AchievementDao<Achievement>{

	//查全部成就清單
	@Override
	public List<Achievement> selectAll() {
		String seachAllHql = "SELECT new admin.vo.Achievement(achievementId, achievementName, domainId, achievementThresholdHours) FROM Achievement";
		return getSession().createQuery(seachAllHql, Achievement.class).getResultList();
	}
	
	//修改
	@Override
	public String update(Achievement obj) {
		Achievement ach = getSession().load(Achievement.class,obj.getAchievementId());
		ach.setAchievementId(obj.getAchievementId());
		ach.setAchievementName(obj.getAchievementName());
		ach.setDomainId(obj.getDomainId());
		ach.setAchievementThresholdHours(obj.getAchievementThresholdHours());
		return "1";
	}
	
	//新增
	@Override
	public String insert(Achievement obj) {
		getSession().persist(obj);
		return "1";
	}
	
	//刪除
	@Override
	public String delete(Integer id) {
		Achievement ach = getSession().load(Achievement.class, id);
		getSession().remove(ach);
		return "1";
	}


}
