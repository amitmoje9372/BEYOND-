package com.satya.Entity;

import java.util.Date;


import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="payments")
@DiscriminatorColumn(name="payment_type",discriminatorType=DiscriminatorType.STRING,length=10)
public class Payment
{
	@Id
	private Integer txId;
	
	
	private Double amount;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	
	public Payment() {}


	public Payment(Integer txId, Double amount, Date date) {
		super();
		this.txId = txId;
		this.amount = amount;
		this.date = date;
	}


	public Integer getTxId() {
		return txId;
	}


	public void setTxId(Integer txId) {
		this.txId = txId;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	
	
	
	
	

}
