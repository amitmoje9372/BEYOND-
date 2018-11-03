package com.satya.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.satya.Entity.Payment;
import com.satya.Util.HibernateUtil;

public class TablePerClassImpl implements TablePerClass 
{
	private SessionFactory factory;
	{
		factory=HibernateUtil.getSessionFactory();			
	}

	public void save(Payment p)
	{		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(p);
		tx.commit();
		session.close();
		
	}

}
