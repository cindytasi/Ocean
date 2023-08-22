package admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import admin.dao.AdminDao;
import admin.vo.AdminVo;

//管理員dao實作

public class AdminDaoImpl implements AdminDao<AdminVo> {

	private DataSource ds;
	
	//確認登入
	final private String checkLogin = "SELECT adminId,adminName,adminAccount FROM Ocean.adminTable WHERE adminAccount = ? AND adminPassword = ?;";
	//查全部語法
	final private String serchAllQuery = "SELECT adminId,adminName,adminAccount FROM Ocean.adminTable;";
	//新增語法
	final private String insertQuery = "insert into adminTable(adminName,adminAccount,adminPassword)values(?,?,?);";
	//更新語法
	final private String updateQuery = "update adminTable set adminPassword = ? where adminId = ? ;";
	//刪除語法
	final private String deleteQuery = "delete from adminTable where adminId = ? ;";
	//ID查單筆
	final private String selectByIdQuery = "select adminId,adminName,adminAccount,adminPassword from adminTable where adminId = ? ";
	//帳號查單筆
	final private String selectByAccountQuery = "select adminId,adminName,adminAccount,adminPassword from adminTable where adminAccount = ? ";
	
	public AdminDaoImpl() {
		try {
			//創建dataSource實體
			ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/javaFramework");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
					//確認登入
	@Override
	public AdminVo checkLogin(AdminVo avo) {
		AdminVo admin = new AdminVo();
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(checkLogin);
				) {
						//放入ID
			ps.setString(1, avo.getAdminAccount());
			ps.setString(2, avo.getAdminPassword());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
						//將結果放入物件
				admin.setAdminId(rs.getInt("adminId"));
				admin.setAdminName(rs.getString("adminName"));
				admin.setAdminAccount(rs.getString("adminAccount"));
//				admin.setAdminPassword(rs.getString("adminPassword"));
			}
			return admin;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override		//查全部
	public List<AdminVo> selectAll() {
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn
						.prepareStatement(serchAllQuery);
				ResultSet rs = pstmt.executeQuery();) {
			List<AdminVo> selectList = new ArrayList<AdminVo>();
			//將結果裝到list
			while (rs.next()) {
				AdminVo admin = new AdminVo();
				admin.setAdminId(rs.getInt("adminId"));
				admin.setAdminName(rs.getString("adminName"));
				admin.setAdminAccount(rs.getString("adminAccount"));
				selectList.add(admin);
			}
			return selectList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override			//新增
	public String insert(AdminVo adVo) {
		int count = 0;
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(insertQuery);) {
						//將資料依序放入問號欄位
			ps.setString(1, adVo.getAdminName());
			ps.setString(2, adVo.getAdminAccount());
			ps.setString(3, adVo.getAdminPassword());
			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return String.valueOf(count);
	}

	@Override			//更新
	public String update(Integer id,String updatePassword) {
		int count = 0;
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(updateQuery);) {
						//將修改的密碼放到問號裡
			ps.setString(1, updatePassword);
			ps.setInt(2, id);
			count = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(count);
	}

	@Override			//刪除
	public String delete(Integer id) {
		int count = 0;
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(deleteQuery);) {
						//刪除指定ID
			ps.setInt(1, id);
			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(count);
	}

	@Override			//查單筆
	public AdminVo selectById(Integer id) {
		AdminVo admin = new AdminVo();
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(selectByIdQuery);
				) {
						//放入ID
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
						//將結果放入物件
				admin.setAdminId(rs.getInt("adminId"));
				admin.setAdminName(rs.getString("adminName"));
				admin.setAdminAccount(rs.getString("adminAccount"));
				admin.setAdminPassword(rs.getString("adminPassword"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

	@Override			//帳號查單筆
	public AdminVo selectOne(String account) {
		AdminVo admin = new AdminVo();
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(selectByAccountQuery);
				) {
						//放入條件
			ps.setString(1, account);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
						//將結果放入物件
				admin.setAdminId(rs.getInt("adminId"));
				admin.setAdminName(rs.getString("adminName"));
				admin.setAdminAccount(rs.getString("adminAccount"));
				admin.setAdminPassword(rs.getString("adminPassword"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

///////////////////////////以下沒用到////////////////////////////////////
	@Override
	public String update(AdminVo obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Integer id, Integer hours) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
