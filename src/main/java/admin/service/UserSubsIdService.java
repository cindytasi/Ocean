package admin.service;

public interface UserSubsIdService {
	Integer expiresThisMonth();			//本月到期會員人數
	
	Integer subscribersThisMonth();		//本月加入訂閱數量
}
