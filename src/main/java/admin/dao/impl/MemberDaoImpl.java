package admin.dao.impl;

import java.util.List;

import org.hibernate.query.Query;

import admin.dao.MemberDao;
import admin.vo.Member;

public class MemberDaoImpl implements MemberDao<Member>{

	@Override
	public List<Member> selectAll(Integer userId) {			//查成員清單
		String hql="SELECT new admin.vo.Member(memberId, memberName, userId, childMember) FROM Member WHERE userId = :userId";
		Query<Member> query = getSession().createQuery(hql,Member.class);
		query.setParameter("userId", userId);
		
		return query.getResultList();
	}

//	@Override
//	public Integer selectMemberQuantity(Integer userId) {	//查成員數量
//		String hql = "SELECT count(*) FROM Member WHERE userId = :userId";
//		Query query = getSession().createQuery(hql);
//		query.setParameter("userId", userId);
//		Long tmp = (Long) query.uniqueResult();
//		
//		return tmp.intValue();
//	}

}
