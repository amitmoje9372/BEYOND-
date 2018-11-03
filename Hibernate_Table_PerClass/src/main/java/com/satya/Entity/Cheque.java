package com.satya.Entity;

import java.util.Date;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ch")
public class Cheque extends Payment
{
	private Long chequeNo;
	

	private String chequeType;
	
	public Cheque() {}
	
	public Cheque(Integer txId, Double amount, Date date, Long chequeNo, String chequeType) {
		super(txId, amount, date);
		this.chequeNo = chequeNo;
		this.chequeType = chequeType;
	}




	public Long getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(Long chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getChequeType() {
		return chequeType;
	}
	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}
	
	
	

}
