package admin.service.impl;


import com.google.gson.Gson;

import admin.dao.ManufacturersDao;
import admin.dao.impl.ManufacturersDaoImpl;
import admin.service.ManufacturersService;
import admin.util.CoreService;
import admin.vo.Manufacturers;

//廠商service實作

public class ManufacturersServiceImpl implements ManufacturersService,CoreService{
	
	private ManufacturersDao<Manufacturers> dao;
	private final Gson gson;
	
	public ManufacturersServiceImpl() {
		dao = new ManufacturersDaoImpl();
		gson = new Gson();
	}
	
	//查詢全部廠商
	@Override
	public String findAll() {
		beginTransaction();
		
		String jsonStr = "";

		jsonStr = gson.toJson(dao.selectAll());
		System.out.println(jsonStr);
		commit();
		
		return jsonStr;
	}

	//統編查詢廠商
	@Override
	public String selectOne(String uniformNumbers) {
		beginTransaction();
		Manufacturers mf=null;
		Manufacturers tmp = null;
		try {
			tmp = gson.fromJson(uniformNumbers, Manufacturers.class);
			mf = dao.selectOne(tmp.getUniformNumbers());
			String res = gson.toJson(mf);
			commit();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//修改廠商權限
	@Override
	public String update(Manufacturers mf) {
		beginTransaction();
		
		try {
			String res = dao.update(mf);
			commit();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
			return "false";
		}
	}

}
