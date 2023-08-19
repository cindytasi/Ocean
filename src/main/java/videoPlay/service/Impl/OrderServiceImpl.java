package videoPlay.service.Impl;

import java.util.Date;

import admin.util.CoreService;
import videoPlay.dao.OrderDao;
import videoPlay.dao.OrderDetailDao;
import videoPlay.dao.Impl.OrderDaoImpl;
import videoPlay.dao.Impl.OrderDetailDaoImpl;
import videoPlay.service.OrderService;
import videoPlay.vo.Orders;
import videoPlay.vo.OrderDetail;

public class OrderServiceImpl implements OrderService, CoreService {
	private OrderDao od;
	private OrderDetailDao odo;

	public OrderServiceImpl() {
		od = new OrderDaoImpl();
		odo = new OrderDetailDaoImpl();
	}

	@Override
	public String insertToOrder(Orders order, OrderDetail odd) {
		beginTransaction();
		try {
			Date now = new Date(System.currentTimeMillis());
			order.setOrderDate(now);
			order.setPayFlowType(1);
			order.setStatusCode(1);
			order.setTransactionId(1);
			Orders ods = new Orders();
			ods = order;
			od.insertOrder(ods);
			
			String res = "";
			odd.setOrderId(ods.getOrderId());
			odd.setOrderDetailCode(1);
			OrderDetail odls = new OrderDetail();
			odls = odd;
			odo.insertOrderDetail(odls);
			
			commit();
			return "訂單已成立!";
		} catch (Exception e) {

			e.printStackTrace();
			rollback();
			return "訂單成立失敗";
		}
	}
}
