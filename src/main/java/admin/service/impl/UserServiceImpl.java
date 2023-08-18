package admin.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.Gson;

import admin.dao.UserDao;
import admin.dao.UserSubsIdDao;
import admin.dao.impl.UserDaoImpl;
import admin.dao.impl.UserSubsIdDaoImpl;
import admin.service.UserService;
import admin.util.CoreService;
import admin.vo.User;

public class UserServiceImpl implements UserService,CoreService{
	
	private UserDao<User> dao;
	private UserSubsIdDao usiDao;
	private final Gson gson;
	
	public UserServiceImpl() {
		dao = new UserDaoImpl();
		gson = new Gson();
		usiDao = new UserSubsIdDaoImpl();
	}
	
	@Override
	public Integer selectAllSubscribe() {			//訂閱會員總數
		beginTransaction();
		try {
			Integer count = dao.selectAllSubscribe();
			commit();
			return count;
		} catch (Exception e) {
			
			e.printStackTrace();
			rollback();
			return 0;
		}
	}
	
	@Override
	public String selectById(Integer id) {			//ID搜尋會員
		beginTransaction();
		try {
			Object[] obj = new Object[4];
			Integer achCount = selectUserAchievementDuration(id);
			Integer OrderQuantity = selectOrdersById(id);
			Timestamp tmp = usiDao.expirationDateById(id);
			
			
			User user = null;
			user = dao.selectById(id);
			obj[0] = user;
			obj[1] = achCount;
			obj[2] = OrderQuantity;
			if(tmp!=null) {
				String expirationDate = DateTimeFormat(tmp);
				obj[3] = expirationDate;
			}
			
			System.out.println(gson.toJson(obj));
			commit();
			return gson.toJson(obj);
		} catch (Exception e) {
			
			e.printStackTrace();
			rollback();
			return "";
		}
	}

	@Override
	public String selectOne(String tag) {			//名字搜尋會員
		beginTransaction();
		try {
			
			User user = null;
			user = dao.selectOne(tag);
			commit();
			return gson.toJson(user);
		} catch (Exception e) {
			
			e.printStackTrace();
			rollback();
			return "";
		}
	}

	@Override										//Id搜尋成就數量
	public Integer selectUserAchievementDuration(Integer id) {
		
		try {
			Integer count = dao.selectUserAchievementDuration(id);
			
			return count;
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return 0;
		}
	}
	
	@Override
	public Integer selectOrdersById(Integer id) {	//id搜尋訂單數量
		
		try {
			Integer count = dao.selectOrdersById(id);
			
			return count;
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return 0;
		}
	}

	@Override
	public Integer selectNosubscribeCount() {		//非訂閱會員數量
		beginTransaction();
		try {
			Integer count = dao.selectNosubscribeCount();
			commit();
			return count;
		} catch (Exception e) {
			
			e.printStackTrace();
			rollback();
			return 0;
		}
	}
	
	public String DateTimeFormat(Timestamp t) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm");
		// 將Timestamp轉換為LocalDateTime
        LocalDateTime localDateTime = t.toLocalDateTime();
     // 將LocalDateTime格式化為指定格式的字串
        String formattedDateTime = localDateTime.format(formatter);
		return formattedDateTime;
	}

}
