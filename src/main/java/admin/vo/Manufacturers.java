package admin.vo;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Manufacturers implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer comId;//id
	
//	private String comName;//廠商名稱
	
	private String comAccount;//帳號
	
	private String comPassword;//密碼
	
	private Integer access;//權限
	
	private BigInteger bankAccount;//銀行帳號
	
	private String uniformNumbers;//公司編號
	
	private String addr;//地址
	
	private String phoneNumbers;//電話
	
	private String email;//email
	
	private String principal;//負責人
	
	private String bankNum;//銀行代號
	
// comId, comAccount, access, bankAccount, createDate, uniformNumbers, addr, phoneNumbers, email, principal, bankNum
	public Manufacturers(Integer comId,String comAccount, Integer access, BigInteger bankAccount,
			String uniformNumbers, String addr, String phoneNumbers, String email, String principal, String bankNum) {
		super();
		this.comId = comId;
//		this.comName = comName;
		this.comAccount = comAccount;
		this.access = access;
		this.bankAccount = bankAccount;
		
		this.uniformNumbers = uniformNumbers;
		this.addr = addr;
		this.phoneNumbers = phoneNumbers;
		this.email = email;
		this.principal = principal;
		this.bankNum = bankNum;
	}

	public Manufacturers() {
		// TODO Auto-generated constructor stub
	}

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
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

	public BigInteger getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BigInteger bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getUniformNumbers() {
		return uniformNumbers;
	}

	public void setUniformNumbers(String uniformNumbers) {
		this.uniformNumbers = uniformNumbers;
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

	public String getBankNum() {
		return bankNum;
	}

	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}
}
