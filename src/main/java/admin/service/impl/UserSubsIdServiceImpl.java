package admin.service.impl;

import admin.dao.UserSubsIdDao;
import admin.dao.impl.UserSubsIdDaoImpl;
import admin.service.UserSubsIdService;
import admin.util.CoreService;

public class UserSubsIdServiceImpl implements UserSubsIdService,CoreService{
	private UserSubsIdDao us;
	
	public UserSubsIdServiceImpl() {
		us = new UserSubsIdDaoImpl();
	}
	//本月到期會員人數
	@Override
	public Integer expiresThisMonth() {
		beginTransaction();
		try {
			Integer expiresCount = us.expiresThisMonth();
			commit();
			return expiresCount;
		} catch (Exception e) {
			
			e.printStackTrace();
			rollback();
			return 0;
		}
	}
	//本月加入訂閱數量
	@Override
	public Integer subscribersThisMonth() {
		beginTransaction();
		try {
			Integer subscribers = us.subscribersThisMonth();
			commit();
			return subscribers;
		} catch (Exception e) {
			
			e.printStackTrace();
			rollback();
			return 0;
		}
	}

}
