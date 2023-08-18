package manufactur.vo;

public class Manufacturers {
	private Integer comID;
	private String comAccount;
	private String comPassword;
	private Integer access;
	private Long bankAccount;
	private String uniformNumber;
	private String addr;
	private String phoneNumbers;
	private String email;
	private String principal;
	private Long bankNum;
	
	public  Manufacturers() {
	}
	
	
	public Manufacturers(Integer comID, String comAccount,String comPassword,
			Integer access,Long bankAccount,String uniformNumber,String addr,String phoneNumbers,
			String email, String principal,Long bankNum) {
		super();
		this.comID = comID;
		this.comAccount = comAccount;
		this.comPassword = comPassword;
		this.access = access;
		this.bankAccount = bankAccount;
		this.uniformNumber = uniformNumber;
		this.addr = addr;
		this.phoneNumbers = phoneNumbers;
		this.email = email;
		this.principal = principal;
		this.bankNum = bankNum;
		
		
		
	}


	public Integer getComID() {
		return comID;
	}


	public void setComID(Integer comID) {
		this.comID = comID;
	}


	public String getComAccount() {
		return comAccount;
	}


	public void setComAccount(String comAccount) {
		this.comAccount = comAccount;
	}


	public String getComPassword() {
		return comPassword;
	}


	public void setComPassword(String comPassword) {
		this.comPassword = comPassword;
	}


	public Integer getAccess() {
		return access;
	}


	public void setAccess(Integer access) {
		this.access = access;
	}


	public Long getBankAccount() {
		return bankAccount;
	}


	public void setBankAccount(Long bankAccount) {
		this.bankAccount = bankAccount;
	}


	public String getUniformNumber() {
		return uniformNumber;
	}


	public void setUniformNumber(String uniformNumber) {
		this.uniformNumber = uniformNumber;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public String getPhoneNumbers() {
		return phoneNumbers;
	}


	public void setPhoneNumbers(String phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPrincipal() {
		return principal;
	}


	public void setPrincipal(String principal) {
		this.principal = principal;
	}


	public Long getBankNum() {
		return bankNum;
	}


	public void setBankNum(Long bankNum) {
		this.bankNum = bankNum;
	}
}
