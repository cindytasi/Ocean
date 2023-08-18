package shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import shop.vo.OrderDetailVO;
import shop.vo.OrderVO;
import shop.vo.Product;

public class SelectOrdersDao {
	
	// 宣告一個datasource並設為靜態變數成為唯一
		private static DataSource dataSource;

		// 取得連線池
		static {
			try {
				Context initialContext = new InitialContext();
				Context context = (Context) initialContext.lookupLink("java:comp/env");
				dataSource = (DataSource) context.lookup("jdbc/javaFramework");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
	
		
		public List<OrderVO> selectOrders(String userId) {
			List<OrderVO> result = new ArrayList<OrderVO>();
			String selectOrders = """
					SELECT * from Orders where userId = ?;
					""";
			try (Connection conn = dataSource.getConnection();
					PreparedStatement ps = conn.prepareStatement(selectOrders);) {
				ps.setInt(1, Integer.valueOf(userId));
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					OrderVO orders = new OrderVO();
					orders.setOrderId(rs.getInt("orderId"));
					orders.setUserId(rs.getInt("userId"));
					orders.setOrderTotal(rs.getDouble("orderTotal"));		
						
					// 將日期轉換為所需格式
					Date orderDate = rs.getDate("orderDate");
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/M/d");
					String formattedDate = dateFormat.format(new java.util.Date());
					orders.setFormattedOrderDate(formattedDate);
					// 將轉換後的日期設置到OrderVO 對象中	
					orders.setPayFlowType(rs.getInt("payFlowType"));
					orders.setComId(rs.getInt("comId"));
					orders.setStatusCode(rs.getInt("statusCode"));
					orders.setTransactionId(rs.getInt("transactionId"));
					orders.setHODateOrderDetailId(rs.getString("HODateOrderDetailId"));
					result.add(orders);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
		
		public List<OrderDetailVO> selectOrderDetail(int orderId) {
			List<OrderDetailVO> result = new ArrayList<OrderDetailVO>();
			String selectOrderDetail = """
							SELECT od.orderDetailId,od.productId,o.orderId,od.productQuantity,od.productPrice,od.productSize,
							od.productColor,od.productName,od.ItemsQuantity,od.shipping,od.Payable,od.shippingTextValue,od.fullName,
							od.phone,od.address,od.email,o.userId,o.orderTotal,o.payFlowType,o.comId,o.HODateOrderDetailId,o.orderDate,
							od.deliveryMethod,od.paymentMethod,od.Subtotal
							FROM OrderDetail od
							JOIN Orders o ON od.orderId = o.orderId
							WHERE o.orderId = ?;
							""";
			try (Connection conn = dataSource.getConnection();
					PreparedStatement ps = conn.prepareStatement(selectOrderDetail);) {
				ps.setInt(1, orderId);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					OrderDetailVO orderDetail = new OrderDetailVO();
					orderDetail.setOrderDetailId(rs.getInt("orderDetailId"));
					orderDetail.setProductId(rs.getInt("productId"));
					orderDetail.setOrderId(rs.getInt("orderId"));
					orderDetail.setProductQuantity(rs.getInt("productQuantity"));
					orderDetail.setProductPrice(rs.getDouble("productPrice"));
					orderDetail.setProductSize(rs.getString("productSize"));
					orderDetail.setProductColor(rs.getString("productColor"));
					orderDetail.setProductName(rs.getString("productName"));
					orderDetail.setItemsQuantity(rs.getInt("ItemsQuantity"));
					orderDetail.setShipping(rs.getInt("shipping"));
					orderDetail.setPayable(rs.getDouble("Payable"));
					orderDetail.setShippingTextValue(rs.getString("shippingTextValue"));
					orderDetail.setFullName(rs.getString("fullName"));
					orderDetail.setPhone(rs.getString("phone"));
					orderDetail.setAddress(rs.getString("address"));
					orderDetail.setEmail(rs.getString("email"));
					orderDetail.setUserId(rs.getInt("userId"));
					orderDetail.setOrderTotal(rs.getInt("orderTotal"));
					orderDetail.setPayFlowType(rs.getInt("payFlowType"));
					orderDetail.setComId(rs.getInt("comId"));
					orderDetail.setHODateOrderDetailId(rs.getString("HODateOrderDetailId"));
					Date orderDate = rs.getDate("orderDate");
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/M/d");
					String formattedDate = dateFormat.format(new java.util.Date());
					orderDetail.setFormattedOrderDate(formattedDate);
					orderDetail.setDeliveryMethod(rs.getString("deliveryMethod"));//會顯示宅配
					orderDetail.setPaymentMethod(rs.getString("paymentMethod"));//會顯示中文貨到付款或線上刷卡
					orderDetail.setSubtotal(rs.getDouble("Subtotal"));
					result.add(orderDetail);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
		
		
	

}
