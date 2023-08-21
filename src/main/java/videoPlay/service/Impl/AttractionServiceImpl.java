package videoPlay.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import admin.util.CoreService;
import videoPlay.dao.AttractionDao;
import videoPlay.dao.Impl.AttractionDaoImpl;
import videoPlay.service.AttractionService;
import videoPlay.vo.Attraction;

public class AttractionServiceImpl implements AttractionService,CoreService{
	private AttractionDao ado;
	private Gson gson;
	
	public AttractionServiceImpl() {
		ado = new AttractionDaoImpl();
		gson = new Gson();
	}
	@Override
	public String selectAttractionImg(Integer attractionId) {
		beginTransaction();
		try {
			Attraction img = ado.selectAttractionImgById(attractionId);
					
				String toJson = gson.toJson(img);
			
			
			commit();
			return toJson;
		} catch (Exception e) {
			
			e.printStackTrace();
			rollback();
			return "查無圖片";
		}
	}

}
