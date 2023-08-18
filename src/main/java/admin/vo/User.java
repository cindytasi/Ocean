package admin.vo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	private String userName;
	private String address;
	private String telephone;
	private String email;
//	private String password;
//	private Timestamp achievementTime;
//	private String profilePicture;
	private String statusCode;
	
	public User(){
		
	}
	
	public User(Integer userId, String userName, String address, String telephone, 
			String email, String statusCode) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.statusCode = statusCode;
	}

}

