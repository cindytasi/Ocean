package admin.vo;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Entity
@Data
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
	
	
	
}
