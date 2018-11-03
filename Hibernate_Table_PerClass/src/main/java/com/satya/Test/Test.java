package com.satya.Test;

import java.util.Date;

import com.satya.Dao.TablePerClass;
import com.satya.Dao.TablePerClassImpl;
import com.satya.Entity.Card;
import com.satya.Entity.Cheque;
import com.satya.Entity.Payment;

public class Test {

	public static void main(String[] args) 
	{
		TablePerClass t=new TablePerClassImpl();
		
		Payment p=new Card(112301,15000.00,new Date(),123456L,"visa");		
		t.save(p);
		
		
		Payment p1=new Cheque(101231,15000.00,new Date(),123456L,"order");	
		t.save(p1);
	

	}

}
