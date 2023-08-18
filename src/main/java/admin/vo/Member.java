package admin.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
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
	
	
}
