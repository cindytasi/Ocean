package web.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sound.midi.MetaMessage;
import javax.sql.DataSource;

import web.dao.MemberDao;
import web.vo.MemberVo;
import web.vo.UserVo;;

public class MemberDaoImpl implements MemberDao {

	private static DataSource ds;

//	執行sql語法，用於比對login資料是否正確

	static {
		try {
			ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/javaFramework");
			// 從 JNDI 中查找名為 "java:comp/env/jdbc/javaFramework" 的 DataSource 物件
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(MemberVo memberVo) {
		final String sql = "insert INTO Ocean.Member (memberName, userId, childMember,  memberPassword) "
				+ "values( ?, ?, ?, ?)";

		System.out.println("insertMember");
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, memberVo.getMemberName());
			pstmt.setInt(2, memberVo.getUserId());
			pstmt.setBoolean(3, memberVo.getChildMember());
			pstmt.setString(4, memberVo.getMemberPassword());

			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<MemberVo> selectMemberById(Integer userId) {
		final String sql = "select * FROM Member WHERE userId=? ";
		try (Connection connection = ds.getConnection(); 
				PreparedStatement pstm = connection.prepareStatement(sql);) {
			pstm.setInt(1, userId);
			ResultSet rs = pstm.executeQuery();
			System.out.println("Dao selectByEmailFromEdit");
			MemberVo memberVo ;
			List <MemberVo> list = new ArrayList<MemberVo>();
			while(rs.next()) {
				memberVo = new MemberVo();
				memberVo.setMemberId(rs.getInt("memberId"));
				memberVo.setMemberName(rs.getString("memberName"));
				memberVo.setChildMember(rs.getBoolean("childMember"));
				memberVo.setMemberPassword(rs.getString("memberPassword"));;
				list.add(memberVo);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
