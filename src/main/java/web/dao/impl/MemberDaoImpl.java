package web.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import web.dao.MemberDao;
import web.vo.MemberVo;

public class MemberDaoImpl implements MemberDao{

	private static String url = "jdbc:mysql://localhost:3306/Ocean?useUnicode=yes&characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Taipei";
	private static String user = "root";
	private static String password = "password";
	
	private String sqlSearchMemberImg = "select profilePicture,memberId from Member where memberId = ?;";
	
	public MemberVo selectMemberImg(Integer memberId) {
		
		MemberVo memberVo = null;
		
		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sqlSearchMemberImg)) {
			
			preparedStatement.setInt(1, memberId);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				memberVo  = new MemberVo();

				memberVo.setProfilePicture(rs.getBytes(1));
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return memberVo;
	}
}
