package com.satya.Util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil 
{
	private static SessionFactory factory=null;
	public synchronized static SessionFactory getSessionFactory()
	{
		if(factory==null){
	Configuration conf=new Configuration();		
	conf.configure("com/satya/config/hibernate.cfg.xml");

	StandardServiceRegistryBuilder builder= new StandardServiceRegistryBuilder();
	builder.applySettings(conf.getProperties());
	ServiceRegistry registry=builder.build();
	
	 factory=conf.buildSessionFactory(registry);
		}
		return factory;		
	}
	

}
