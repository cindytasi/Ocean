package admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import admin.dao.adminDao;
import admin.vo.adminVo;

public class adminDaoImpl implements adminDao<adminVo> {

	private DataSource ds;
	
	final private String serchAllQuery = "SELECT adminId,adminName,adminAccount FROM Ocean.adminTable;";
	final private String insertQuery = "insert into adminTable(adminName,adminAccount,adminPassword)values(?,?,?);";
	final private String updateQuery = "update adminTable set adminPassword = ? where adminId = ? ;";
	final private String deleteQuery = "delete from adminTable where adminId = ? ;";
	
	public adminDaoImpl() {
		try {
			ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/javaFramework");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<adminVo> selectAll() {
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn
						.prepareStatement(serchAllQuery);
				ResultSet rs = pstmt.executeQuery();) {
			var selectList = new ArrayList<adminVo>();
			while (rs.next()) {
				adminVo admin = new adminVo();
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

	@Override
	public String insert(adminVo adVo) {
		int count = 0;
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(insertQuery);) {
			ps.setString(1, adVo.getAdminName());
			ps.setString(2, adVo.getAdminAccount());
			ps.setString(3, adVo.getAdminPassword());
			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return String.valueOf(count);
	}

	@Override
	public String update(Integer id,String updatePassword) {
		int count = 0;
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(updateQuery);) {
			ps.setString(1, updatePassword);
			ps.setInt(2, id);
			count = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(count);
	}

	@Override
	public String delete(Integer id) {
		int count = 0;
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(deleteQuery);) {
			ps.setInt(1, id);
			count = ps.executeUpdate();
//			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(count);
	}

}
