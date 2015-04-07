package dao;

// Generated Mar 30, 2015 12:55:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import model.Chitiethoadon;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ChitiethoadonHome {



	private static SessionFactory sessionFactory;
	static{
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}

	protected static SessionFactory getSessionFactory() {
		try {
			return sessionFactory;
		} catch (Exception e) {
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Chitiethoadon transientInstance) {

		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void attachDirty(Chitiethoadon instance) {
		try {
			Session sess=ChitiethoadonHome.getSessionFactory().openSession();
			sess.beginTransaction();
			sess.save(instance);
			sess.getTransaction().commit();
			sess.close();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void attachClean(Chitiethoadon instance) {
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);			
		} catch (RuntimeException re) {			
			throw re;
		}
	}

	public void delete(Chitiethoadon persistentInstance) {
		try {
			Session sess=ChitiethoadonHome.getSessionFactory().openSession();
			sess.beginTransaction();
			sess.delete(persistentInstance);
			sess.getTransaction().commit();
			sess.close();			
		} catch (RuntimeException re) {			
			throw re;
		}
	}

	public Chitiethoadon merge(Chitiethoadon detachedInstance) {		
		try {
			Session sess=ChitiethoadonHome.getSessionFactory().openSession();
			sess.beginTransaction();
			Chitiethoadon result = (Chitiethoadon) sess.merge(detachedInstance);
			sess.getTransaction().commit();
			sess.close();						
			return result;
		} catch (RuntimeException re) {			
			throw re;
		}
	}

	public Chitiethoadon findById(java.lang.String id) {	
		try {
			Session sess=ChitiethoadonHome.getSessionFactory().openSession();
			Chitiethoadon instance = (Chitiethoadon) sess.get("model.Chitiethoadon", id);
			sess.close();			
			return instance;
		} catch (RuntimeException re) {			
			throw re;
		}
	}

	public List<Chitiethoadon> findByExample() {		
		try {
			Session sess=ChitiethoadonHome.getSessionFactory().openSession();
			List<Chitiethoadon> results = sess.createCriteria("model.Chitiethoadon").list();	
			sess.close();
			return results;
		} catch (RuntimeException re) {			
			throw re;
		}
	}
}
