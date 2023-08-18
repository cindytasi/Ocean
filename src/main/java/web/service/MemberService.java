package web.service;

import web.dao.impl.MemberDaoImpl;
import web.vo.MemberVo;

public class MemberService {
	
	private static MemberDaoImpl memberDaoImpl = new MemberDaoImpl();
	
	public MemberVo selectMemberImg(Integer memberId) {
		
		MemberVo memberVo = memberDaoImpl.selectMemberImg(memberId);
		return memberVo;
	}
}
