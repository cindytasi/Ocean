package admin.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberId;
	
	private String memberName;
	private Integer userId;
	private Integer childMember;
	
	public Member() {
		
	}
	
	public Member(Integer memberId, String memberName, Integer userId, Integer childMember) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.userId = userId;
		this.childMember = childMember;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getChildMember() {
		return childMember;
	}

	public void setChildMember(Integer childMember) {
		this.childMember = childMember;
	}
}
