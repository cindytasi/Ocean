package admin.service;

import admin.vo.Manufacturers;

//廠商service介面

public interface ManufacturersService {


	public String findAll();					//查全部

	public String selectOne(String tag);		//查單筆
	
	public String update(Manufacturers mf);		//更新權限
	
}
