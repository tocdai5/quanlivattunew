package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory=null;
	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null){
			try {
				sessionFactory=new Configuration().configure().buildSessionFactory();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println("sessionFactory Error");
			}
		}
		return sessionFactory;
	}
	
	public static Session getCurrentSession(){
		return getSessionFactory().getCurrentSession();
	}
	private static Session openSession(){
		return getSessionFactory().openSession();		
	}
}
