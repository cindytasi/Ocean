package videoPlay.service.Impl;

import java.sql.Timestamp;
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
			Timestamp now = new Timestamp(System.currentTimeMillis());
			order.setOrderDate(now);
			order.setPayFlowType(1);
			order.setStatusCode(1);
			order.setTransactionId(1);
			Orders ods = new Orders();
			ods = order;
			od.insertOrder(ods);
			
//			String res = "";
			odd.setOrderId(ods.getOrderId());
			odd.setOrderDetailCode(1);
			odd.setPayable(0.0);
			odd.setShippingTextValue("");
			odd.setFullName("");
			odd.setPhone("");
			odd.setAddress("");
			odd.setEmail("");
			odd.setProductSize("");
			odd.setProductColor("");
			odd.setProductName("");
			odd.setItemsQuantity(0);
			odd.setShipping(0);
			odd.setDeliveryMethod("");
			odd.setPaymentMethod("");
			odd.setSubtotal(0.0);
			
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
