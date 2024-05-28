package com.app.utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
//create singleton , immutable , heavy weight SF(Session Factor)
	private static SessionFactory factory;
//	why static? cuz we want a singel copy of SessionFactory for entire application
	static {
		factory=new Configuration()  //empty hibernate config
				.configure() //loads all the settings / props from hibernate config xml 
				.buildSessionFactory();
	}
	public static SessionFactory getFactory() {
		return factory;
	}
	
	
}
