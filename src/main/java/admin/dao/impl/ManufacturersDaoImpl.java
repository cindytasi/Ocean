package admin.dao.impl;

import java.util.List;

import org.hibernate.query.Query;

import admin.dao.ManufacturersDao;
import admin.vo.Manufacturers;

//廠商dao實作

public class ManufacturersDaoImpl implements ManufacturersDao<Manufacturers> {
	
	//查詢全部廠商
	@Override
	public List<Manufacturers> selectAll() {					//查全部
		try {
			String selectAllHql = "SELECT new admin.vo.Manufacturers(comId, comAccount, access, bankAccount, uniformNumbers, addr, phoneNumbers, email, principal, bankNum) FROM Manufacturers";
			return getSession().createQuery(selectAllHql, Manufacturers.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//以統編查詢單筆廠商
	@Override
	public Manufacturers selectOne(String uniformNumbers) {		//查單筆
		String selectAllHql = "SELECT new admin.vo.Manufacturers(comId, comAccount, access, bankAccount, uniformNumbers, addr, phoneNumbers, email, principal, bankNum) FROM Manufacturers where uniformNumbers = :uniformNumbers";
		Query<Manufacturers> query = getSession().createQuery(selectAllHql,Manufacturers.class);
		query.setParameter("uniformNumbers", uniformNumbers);
		return query.getSingleResult();
	}
	//更新單筆
	@Override
	public String update(Manufacturers obj) {					//更新權限
		Manufacturers mfs = getSession().load(Manufacturers.class,obj.getComId());
		mfs.setAccess(obj.getAccess());
		mfs.setComId(obj.getComId());
		return "1";
	}
	

}
