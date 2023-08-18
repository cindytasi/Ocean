package admin.service.impl;

import java.util.List;

import com.google.gson.Gson;

import admin.dao.MemberDao;
import admin.dao.impl.MemberDaoImpl;
import admin.service.MemberService;
import admin.util.CoreService;
import admin.vo.Member;

public class MemberServiceImpl implements MemberService,CoreService{
	private MemberDao<Member> dao;
	private Gson gson;
	
	public MemberServiceImpl() {
		dao = new MemberDaoImpl();
		gson = new Gson();
	}
	
	@Override
	public String selectByUserId(Integer userId) {
		System.out.println(userId);
		beginTransaction();
		try {
			List<Member> list = dao.selectAll(userId);
			String memberlist = gson.toJson(list);
			commit();
			return memberlist;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
			return "查無資料";
		}
	}

//	@Override
//	public Integer selectMemberQuantity(Integer userId) {
//		beginTransaction();
//		try {
//			Integer count = dao.selectMemberQuantity(userId);
//			commit();
//			return count;
//		} catch (Exception e) {
//			e.printStackTrace();
//			rollback();
//			return 0;
//		}
//	}

}
