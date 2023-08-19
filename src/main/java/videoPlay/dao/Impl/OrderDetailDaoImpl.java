package videoPlay.dao.Impl;

import videoPlay.dao.OrderDetailDao;
import videoPlay.vo.OrderDetail;

public class OrderDetailDaoImpl implements OrderDetailDao{

	@Override
	public String insertOrderDetail(OrderDetail odd) {
		getSession().save(odd);
		return "1";
	}

}
