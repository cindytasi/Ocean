package videoPlay.dao.Impl;

import videoPlay.dao.OrderDao;
import videoPlay.vo.Orders;
import videoPlay.vo.OrderDetail;

public class OrderDaoImpl implements OrderDao{

	@Override
	public String insertOrder(Orders order) {
		getSession().save(order);
		return "1";
	}

}
