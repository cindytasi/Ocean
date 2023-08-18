package shop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import shop.dao.ImageDao;
import shop.dao.OrderDao;
import shop.dao.ProductDao;
import shop.vo.CheckoutVo;
import shop.vo.ShopCartVo;
import shop.vo.TransportInfoVo;

public class OrderService {
	
	private static OrderDao orderDao;
	private static ImageDao imageDao;
	private static CheckoutVo checkoutVo;
	static {
		orderDao = new OrderDao();
		imageDao = new ImageDao();
		checkoutVo = new CheckoutVo();
	}
	
    public static void createOrders(String userId,TransportInfoVo transportInfoVo, List<ShopCartVo> productlist) {

		
		
		// 使用 Map 分類不同廠商的產品
		Map<String, List<ShopCartVo>> comIdToProductsMap = new HashMap<>();
		for (ShopCartVo shopCartVo : productlist) {
			String comId = shopCartVo.getProductcomId();
			if (!comIdToProductsMap.containsKey(comId)) { // 不同廠商就加入
				comIdToProductsMap.put(comId, new ArrayList<>());
			}
			comIdToProductsMap.get(comId).add(shopCartVo);    
		}

		// 創建訂單並插入到資料庫中
		boolean allOrdersInsertedSuccessfully = true; // 檢查所有訂單是否都成功insert

		for (Map.Entry<String, List<ShopCartVo>> entry : comIdToProductsMap.entrySet()) {
			String comId = entry.getKey();
			int totalItems = 0; // 初始化總件數
			int shipping = 0; // 初始化運費
			double orderTotal = 0; // 初始化應付金額

			List<ShopCartVo> products = entry.getValue();

		    for (ShopCartVo shopCartVo : products) {
	            totalItems += shopCartVo.getQuantityValue(); //同一個廠商的件數加總
	            orderTotal += (shopCartVo.getTotal()+ shipping);// 應付金額
	        }
			
			try {
				boolean success = orderDao.insertOrder(userId, transportInfoVo, comId, products ,totalItems,orderTotal,shipping);
				if (!success) {
					allOrdersInsertedSuccessfully = false;
					System.out.println("訂單輸入失敗，廠商ID：" + comId);
				}
			} catch (Exception e) {
				allOrdersInsertedSuccessfully = false;
				System.out.println("輸入訂單時發生異常狀況，廠商ID：" + comId);
				e.printStackTrace();
			}
		}

		// 所以訂單輸入完成後執行成功或失敗的邏輯
		if (allOrdersInsertedSuccessfully) {
			System.out.println("所有訂單接輸入成功！");
		} else {
			System.out.println("部分或所有訂單輸入失敗！");
		}
	}
}
