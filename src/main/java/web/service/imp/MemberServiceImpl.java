package web.service.imp;

import java.util.List;

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
			memberVo.setSuccessful(false);
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
}
