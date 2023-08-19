package videoPlay.service.Impl;

import com.google.gson.Gson;

import admin.util.CoreService;
import videoPlay.dao.ProductInformationDao;
import videoPlay.dao.Impl.ProductInformationDaoImpl;
import videoPlay.service.ProductInformationService;
import videoPlay.vo.ProductImg;

public class ProductInformationServiceImpl implements ProductInformationService,CoreService{
	private ProductInformationDao pInfo;
	private Gson gson;
	
	public ProductInformationServiceImpl() {
		pInfo = new ProductInformationDaoImpl();
		gson = new Gson();
	}
	@Override
	public String selectProductImgById(Integer Imgid) {
		beginTransaction();
		try {
			ProductImg tmp = new ProductImg();
			tmp = pInfo.selectImgById(Imgid);
			String toJson = gson.toJson(tmp);
			commit();
			return toJson;
		} catch (Exception e) {
			
			e.printStackTrace();
			rollback();
			return "查無資料";
		}
	}

}
