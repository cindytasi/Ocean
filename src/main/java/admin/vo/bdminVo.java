package admin.vo;

public class AdminVo {
	private Integer adminId;		//id
	private String adminName;		//名稱
	private String adminAccount;	//帳號
	private String adminPassword;	//密碼
	private String adMode;			//即將執行的方法
	
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminAccount() {
		return adminAccount;
	}
	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdMode() {
		return adMode;
	}
	public void setAdMode(String adMode) {
		this.adMode = adMode;
	}
	
	
	
}
