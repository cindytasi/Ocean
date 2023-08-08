package web.vo;

import core.vo.CoreVo;

public class MemberVo extends CoreVo{

	private Integer memberId;
	private String memberName;
	private Integer userId;
	private Boolean childMember;
	private String memberPassword;
	private byte[] profilePicture;

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

	public Boolean getChildMember() {
		return childMember;
	}

	public void setChildMember(Boolean childMember) {
		this.childMember = childMember;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	

}
