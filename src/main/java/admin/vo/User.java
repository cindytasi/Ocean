package admin.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
}

