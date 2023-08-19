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
	public String selectAttractionImg(String[] attractionId) {
		beginTransaction();
		try {
			List<Attraction> img = new ArrayList<Attraction>();
			for(int i=0;i<attractionId.length;i++) {
				int j = Integer.valueOf(attractionId[i]);
				Attraction tmp = ado.selectAttractionImgById(j);
				if(tmp!=null) {
					img.add(tmp);
				}
			}
//			Attraction tmp = ado.selectAttractionImgById(attractionId);
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
