package web.dao;

import java.util.List;

import javax.sound.midi.MetaMessage;

import web.vo.MemberVo;
import web.vo.UserVo;

public interface MemberDao {

	int insert(MemberVo memberVo);

	List<MemberVo> selectMemberById(Integer userId);

}