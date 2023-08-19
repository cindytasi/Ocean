package videoPlay.service;

import videoPlay.vo.Orders;
import videoPlay.vo.OrderDetail;

public interface OrderService {

	String insertToOrder(Orders order,OrderDetail odd);
}
