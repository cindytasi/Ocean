package web.dao.imp;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
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
		final String sql = "insert INTO Ocean.Member (memberName, userId, childMember,  memberPassword , profilePicture) "
				+ "values( ?, ?, ?, ? , ?)";
		final String path = "/Users/J_s_Kai/Desktop/memberImage/";
		String fileName = null;
		File directory = new File(path);
		File[] files = directory.listFiles();

		// 確認目錄存在且是一個目錄
		if (directory.exists() && directory.isDirectory()) {
			// 取得目錄中的所有檔案和子目錄
			// 檢查是否有檔案
			if (files != null) {
				// 遍歷所有檔案和子目錄
				for (File file : files) {
					// 檢查是否是檔案
					if (file.isFile()) {
						// 取得檔案名稱
						fileName = file.getName();
						System.out.println("檔案名稱: " + fileName);
					}
				}
			} else {
				System.out.println("目錄中沒有檔案");
			}
		} else {
			System.out.println("目錄不存在或不是一個目錄");
		}
		
		
		
		System.out.println("insertMember");
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				InputStream in = Files.newInputStream(Path.of(path + fileName))) {

			// 建立 File 物件，代表目錄路徑

			pstmt.setString(1, memberVo.getMemberName());
			pstmt.setInt(2, memberVo.getUserId());
			pstmt.setBoolean(3, memberVo.getChildMember());
			pstmt.setString(4, memberVo.getMemberPassword());
			pstmt.setBinaryStream(5, in, in.available());

//			if (files != null) {
//				directory.delete();
//			}

			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<MemberVo> selectMemberById(Integer userId) {
		final String sql = "select * FROM Member WHERE userId=? ";
		try (Connection connection = ds.getConnection(); PreparedStatement pstm = connection.prepareStatement(sql);) {
			pstm.setInt(1, userId);
			ResultSet rs = pstm.executeQuery();
			System.out.println("Dao selectByEmailFromEdit");
			MemberVo memberVo;
			List<MemberVo> list = new ArrayList<MemberVo>();
			while (rs.next()) {
				memberVo = new MemberVo();
				memberVo.setMemberId(rs.getInt("memberId"));
				memberVo.setMemberName(rs.getString("memberName"));
				memberVo.setChildMember(rs.getBoolean("childMember"));
				memberVo.setMemberPassword(rs.getString("memberPassword"));
				;
				list.add(memberVo);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public int memberImageinsert() {
//		// 存圖片到資料庫
//		String sql = "insert into ProductImg(img1)values(?);";
//		try (Connection connection = ds.getConnection(); PreparedStatement pstm = connection.prepareStatement(sql);) {
//			// 讀入圖檔後插入。省略第3個參數length可能有效能問題，建議查看JDBC driver文件
//			ps.setBinaryStream(1, in, in.available());
//			int rowCount = ps.executeUpdate();
//			System.out.println(rowCount + " row(s) inserted!!");
//		}
//
//	}catch(
//
//	Exception e)
//	{
//         e.printStackTrace();
//     }return 0;
//}
}
