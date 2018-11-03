package com.satya.Entity;

import java.util.Date;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="cd")
public class Card extends Payment
{
	private Long cardNo;

	private String cardType;
	
	
	
	public Card() {	}

	public Card(Integer txId, Double amount, Date date, Long cardNo, String cardType) {
		super(txId, amount, date);
		this.cardNo = cardNo;
		this.cardType = cardType;
		
	}


	public Long getCardNo() {		
		return cardNo;
	}


	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}


	public String getCardType() {
		return cardType;
	}


	public void setCardType(String cardType) {
		this.cardType = cardType;
	}


}
