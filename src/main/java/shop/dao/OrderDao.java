package shop.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.google.gson.Gson;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.util.JedisUtil;
import shop.vo.CheckoutVo;
import shop.vo.Product;
import shop.vo.ShopCartVo;
import shop.vo.TransportInfoVo;

public class OrderDao {
	private static final String shopCartRedisKey = "shopCart";
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

	// 生成訂單編號
	private static String generateOrderNumber(String comId) {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
		String currentDate = sdFormat.format(new java.util.Date());
		return "HO" + currentDate + comId;
	}

	// 計算訂單總額
	private static double calculateOrderTotal(List<ShopCartVo> products) {
		double total = 0.0;
		for (ShopCartVo product : products) {
			total += product.getTotal(); // 假設 ShopCartVo 有 getTotal() 方法返回商品總額
		}
		return total;
	}
	
	//----------------------------------insert Orders----------------------------------------------------//
	public boolean insertOrder(String userId, TransportInfoVo transportInfoVo, String comId,
			List<ShopCartVo> products ,int totalItems , double orderTotal , int shipping) {
		String ordersQuery = "INSERT INTO Ocean.Orders (userId, orderTotal, orderDate, payFlowType, comId, statusCode, transactionId,HODateOrderDetailId) VALUES ( ?, ?, ?, ?, ?,?, ?,?)";
		String detailsQuery = "INSERT INTO Ocean.OrderDetail ( productId, orderId, productQuantity, productPrice, orderDetailCode,productSize, productColor, "
				+ "productName, ItemsQuantity, shipping, Payable, shippingTextValue, fullName, phone, address, email,deliveryMethod,paymentMethod,Subtotal) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		boolean success = false;
		Integer orderId = null;
		PreparedStatement ordersStmt = null;
	    PreparedStatement detailsStmt = null;
	    		
		try (Connection conn = dataSource.getConnection();) {
			 ordersStmt = conn.prepareStatement(ordersQuery,PreparedStatement.RETURN_GENERATED_KEYS);
			 detailsStmt = conn.prepareStatement(detailsQuery);
			// 設置自動提交為 false，以便進行事務處理
			conn.setAutoCommit(false); //開啟事務
			
			// -----------插入訂單orders---------------
			ordersStmt.setInt(1, Integer.valueOf(userId));
			ordersStmt.setDouble(2, orderTotal);//應付金額(含運費)
			LocalDate currentDate = LocalDate.now();
			ordersStmt.setDate(3, Date.valueOf(currentDate));
			ordersStmt.setInt(4, 1);// 1.付款成功/2.交易失敗
			ordersStmt.setInt(5, Integer.valueOf(comId));
			ordersStmt.setInt(6, 1); // 1.訂單已成立
			ordersStmt.setInt(7, 1); // 交易狀態碼\n(0. 確認訂單是否成功\n1.付款給廠商(不退貨)\n2.退款給會員(退貨)))
			ordersStmt.setString(8, generateOrderNumber(comId)); // 新的訂單編號
			ordersStmt.executeUpdate();
	//--------------------------------------insert OrderDetail------------------------------------------------//
			// 獲取插入的訂單的自動生成ID			
			try (ResultSet generatedKeys = ordersStmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					orderId = generatedKeys.getInt(1);
				} else {
					throw new SQLException("無法獲取自動生成的訂單ID");
				}
			}
			
			// 设置订单明细中的共同字段值
			CheckoutVo checkoutVo = new CheckoutVo();
			checkoutVo.setTotalItems(totalItems); //商品總件數(同個廠商)
			checkoutVo.setPayableAmount(calculateOrderTotal(products));//只有商品總金額(含運費)
			checkoutVo.setShippingCost(shipping);
			checkoutVo.setShippingTextValue("全館免運"); 
			transportInfoVo.setFullName(transportInfoVo.getFullName()); //訂購者姓名
			transportInfoVo.setPhone(transportInfoVo.getPhone()); //訂購者手機
			transportInfoVo.setAddress(transportInfoVo.getAddress()); //訂購者住址
			transportInfoVo.setEmail(transportInfoVo.getEmail()); //訂購者email
					
			// 循环插入每个订单明细
			for (ShopCartVo shopCartVo : products) {
			    detailsStmt.setInt(1, Integer.valueOf(shopCartVo.getProductId())); //輸入產品Id
			    detailsStmt.setInt(2, orderId); //輸入訂單Id
			    detailsStmt.setInt(3, shopCartVo.getQuantityValue());//輸入每一筆的件數
			    detailsStmt.setDouble(4, shopCartVo.getPrice()); //輸入每一筆的單價
			    detailsStmt.setInt(5, 1); // 明細狀態碼\n(1.訂單明細 		    
			    detailsStmt.setString(6, shopCartVo.getSelectedSize()); 
			    detailsStmt.setString(7, shopCartVo.getSelectedColor());
			    detailsStmt.setString(8, shopCartVo.getProdName());
			    
			    // 設置每次循環中相同的字值
			    detailsStmt.setInt(9, totalItems);  //輸入同一個廠商商品的總件數
			    detailsStmt.setInt(10, shipping); //輸入同一個廠商商品的總運費
			    detailsStmt.setDouble(11, calculateOrderTotal(products)); //輸入同一個廠商總應付金額
			    detailsStmt.setString(12, checkoutVo.getShippingTextValue());// (全館免運)
			    detailsStmt.setString(13, transportInfoVo.getFullName());
			    detailsStmt.setString(14, transportInfoVo.getPhone());
			    detailsStmt.setString(15, transportInfoVo.getAddress());
			    detailsStmt.setString(16, transportInfoVo.getEmail());
			    detailsStmt.setString(17, transportInfoVo.getDeliveryMethod());//顯示中文宅配
			    detailsStmt.setString(18, transportInfoVo.getPaymentMethod());//顯示中文貨到付款或線上刷卡
			    detailsStmt.setDouble(19, shopCartVo.getPrice() * shopCartVo.getQuantityValue()); //每一筆產品的小計，有可能是商品買兩個金額就要乘以2
			    try {
		            detailsStmt.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();

		            // 出现异常，执行回滚操作并更新订单状态
		            try (PreparedStatement updateStatusCodeStmt = conn.prepareStatement("UPDATE Ocean.Orders SET statusCode = 2 WHERE orderId = ?");) {
		                conn.rollback();
		                updateStatusCodeStmt.setInt(1, orderId);
		                updateStatusCodeStmt.executeUpdate();
		            } catch (SQLException rollbackEx) {
		                rollbackEx.printStackTrace();
		            }
		        } 
		    }
			// 提交事務
			conn.commit();
			success = true;
			
			// 成功插入訂單後，刪除 Redis 購物車數據
			JedisPool pool = JedisUtil.getJedisPool();
			try (Jedis jedis = pool.getResource()) {
				jedis.set(shopCartRedisKey + ":" + userId, new Gson().toJson(new ArrayList<ShopCartVo>()));
			}
			
			// 如果订单插入成功，执行库存更新操作
			if (success) {
	            try (PreparedStatement updateStockStmt = conn.prepareStatement("UPDATE Ocean.ProductInformation SET inStock = ? WHERE productId = ?");) {
	                conn.setAutoCommit(false);

	                for (ShopCartVo shopCartVo : products) {
	                    int currentStock = getCurrentStock(conn, shopCartVo.getProductId());
	                    int newStock = currentStock - shopCartVo.getQuantityValue();

	                    updateStockStmt.setInt(1, newStock);
	                    updateStockStmt.setInt(2, Integer.valueOf(shopCartVo.getProductId()));
	                    updateStockStmt.executeUpdate();
	                }
	                //執行庫存更動
	                conn.commit();
	            } catch (SQLException ex) {
	                ex.printStackTrace();

	                // 出现异常，执行回滚操作并更新订单状态
	                try (PreparedStatement updateStatusCodeStmt = conn.prepareStatement("UPDATE Ocean.Orders SET statusCode = 2 WHERE orderId = ?");){
	                    conn.rollback();
	                    updateStatusCodeStmt.setInt(1, orderId);
	                    updateStatusCodeStmt.executeUpdate();
	                } catch (SQLException rollbackEx) {
	                    rollbackEx.printStackTrace();
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        if (orderId != null) {
	            try (Connection conn = dataSource.getConnection();
	                 PreparedStatement updateStatusCodeStmt = conn.prepareStatement("UPDATE Ocean.Orders SET statusCode = 2 WHERE orderId = ?")) {
	                conn.rollback();
	                updateStatusCodeStmt.setInt(1, orderId);
	                updateStatusCodeStmt.executeUpdate();
	            } catch (SQLException rollbackEx) {
	                rollbackEx.printStackTrace();
	            }
	        }
	    }finally {
	        // 关闭 detailsStmt
	        try {
	            if (detailsStmt != null) {
	                detailsStmt.close();
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }

	    return success;
	}
	
	private int getCurrentStock(Connection conn, String productId) throws SQLException {
	    int currentStock = 0;
	    String selectQuery = "SELECT inStock FROM Ocean.ProductInformation WHERE productId = ?";

	    try (PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
	        selectStmt.setInt(1, Integer.valueOf(productId));
	        try (ResultSet resultSet = selectStmt.executeQuery()) {
	            if (resultSet.next()) {
	                currentStock = resultSet.getInt("inStock");
	            }
	        }
	    }

	    return currentStock;
	}
	
	

}
