package shop.service;

import java.util.List;

import shop.dao.ImageDao;
import shop.dao.ProductDao;
import shop.dao.SelectOrdersDao;
import shop.vo.OrderDetailVO;
import shop.vo.OrderVO;

public class SelectOrdersService {

	private static SelectOrdersDao selectOrdersDao;

	static {
		selectOrdersDao = new SelectOrdersDao();
	}

	public List<OrderVO> getOrders(String userId) {
		List<OrderVO> ordersList = selectOrdersDao.selectOrders(userId);
		return ordersList;
	}

	
	public List<OrderDetailVO> getOrderDetail(int orderId) {
		List<OrderDetailVO> ordersDetailList= selectOrdersDao.selectOrderDetail(orderId);
		return ordersDetailList;
	}
	
	
	
}
