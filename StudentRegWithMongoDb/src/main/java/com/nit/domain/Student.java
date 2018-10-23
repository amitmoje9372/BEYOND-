package com.nit.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="StudentRegistration")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student
{
	
	private Integer stdId;
	private String stdName;
	private String stdAddress;
	private Integer stdContactNo;
	
	
	public Integer getStdId() {
		return stdId;
	}
	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdAddress() {
		return stdAddress;
	}
	public void setStdAddress(String stdAddress) {
		this.stdAddress = stdAddress;
	}
	public Integer getStdContactNo() {
		return stdContactNo;
	}
	public void setStdContactNo(Integer stdContactNo) {
		this.stdContactNo = stdContactNo;
	}
	
	
	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdAddress=" + stdAddress + ", stdContactNo="
				+ stdContactNo + "]";
	}	

}
