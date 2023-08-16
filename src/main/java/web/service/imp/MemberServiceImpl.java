package web.service.imp;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.Part;

import core.vo.CoreVo;
import web.dao.MemberDao;
import web.dao.UserDao;
import web.dao.imp.MemberDaoImpl;
import web.dao.imp.UserDaoImpl;
import web.service.MemberService;
import web.vo.MemberVo;
import web.vo.UserVo;

public class MemberServiceImpl implements MemberService {

	private MemberDao memberDao;

	public MemberServiceImpl() {
		memberDao = new MemberDaoImpl();
	}

	@Override
	public MemberVo addNewMember(MemberVo memberVo) {
		CoreVo coreVo = new CoreVo();
		System.out.println("addNewMember");
//		if(duplicateregister(memberVo.getEmail())) {
//			memberVo.setMessage("帳號重複");
//			memberVo.setSuccessful(false);
//			return  memberVo;
//		}else {

		if (memberDao.insert(memberVo) > -1) {
			memberVo.setMessage("註冊成功");
			memberVo.setSuccessful(true);
			return memberVo;
		}
		memberVo.setMessage("註冊失敗");
		memberVo.setSuccessful(false);
		return memberVo;
	}

	@Override
	public List<MemberVo> selectMember(MemberVo memberVo) {
		final Integer userIdInteger = memberVo.getUserId();

		return memberDao.selectMemberById(userIdInteger);
	}

	private static final String PICFILE_DIRECTORY = "/Users/J_s_Kai/Desktop/memberImage/";

	@Override
	public void memberImage(Part profilePicture) {

		System.out.println("memberImage");

		MemberVo memberVo = new MemberVo();
		File picFile = new File(PICFILE_DIRECTORY + profilePicture.getSubmittedFileName());
		System.out.println(profilePicture.getSubmittedFileName());
		try {

			// 建立圖片暫存檔
			if (!picFile.exists()) {
				picFile.mkdirs();
			}
			profilePicture.write(picFile.getAbsolutePath());

			// 將圖片存到sql
			byte[] picF = readImageData(picFile);
			memberVo.setProfilePicture(picF);
//			picFile.delete();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fileImageDelet(Part profilePicture) {

		MemberVo memberVo = new MemberVo();
		File picFile = new File(PICFILE_DIRECTORY + profilePicture.getSubmittedFileName());
		
			picFile.delete();
	}

		

	private byte[] readImageData(File imageFile) {
		try (FileInputStream inputStream = new FileInputStream(imageFile)) {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			return outputStream.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
