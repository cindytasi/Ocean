package web.service;

import java.util.List;

import web.dao.MemberDao;
import web.vo.MemberVo;
import web.vo.UserVo;

public interface MemberService {

	MemberVo addNewMember(MemberVo memberVo);
	
	List<MemberVo> selectMember(MemberVo memberVo);
}