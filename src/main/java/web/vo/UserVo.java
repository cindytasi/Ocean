package web.vo;

import java.sql.Timestamp;

public class UserVo {

	private Integer userId;
	private String userName;
	private String address;
	private String telephone;
	private String email;
	private String account;
	private String password;
	private Timestamp achievementTime;
	private byte[] profilePicture;
	private Boolean statusCode;
	
	private boolean successful;
	private String message;

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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getAchievementTime() {
		return achievementTime;
	}

	public void setAchievementTime(Timestamp achievementTime) {
		this.achievementTime = achievementTime;
	}

	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	public Boolean getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Boolean statusCode) {
		this.statusCode = statusCode;
	}

	public boolean isSuccessful() {
		return successful;
	}

	
	
	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
