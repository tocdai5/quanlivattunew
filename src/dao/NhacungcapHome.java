package dao;

// Generated Mar 30, 2015 12:55:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import model.Nhacungcap;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class NhacungcapHome {



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

	public void persist(Nhacungcap transientInstance) {

		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void attachDirty(Nhacungcap instance) {
		try {
			Session sess=NhacungcapHome.getSessionFactory().openSession();
			sess.beginTransaction();
			sess.save(instance);
			sess.getTransaction().commit();
			sess.close();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void attachClean(Nhacungcap instance) {
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);			
		} catch (RuntimeException re) {			
			throw re;
		}
	}

	public void delete(Nhacungcap persistentInstance) {
		try {
			Session sess=NhacungcapHome.getSessionFactory().openSession();
			sess.beginTransaction();
			sess.delete(persistentInstance);
			sess.getTransaction().commit();
			sess.close();			
		} catch (RuntimeException re) {			
			throw re;
		}
	}

	public Nhacungcap merge(Nhacungcap detachedInstance) {		
		try {
			Session sess=NhacungcapHome.getSessionFactory().openSession();
			sess.beginTransaction();
			Nhacungcap result = (Nhacungcap) sess.merge(detachedInstance);
			sess.getTransaction().commit();
			sess.close();						
			return result;
		} catch (RuntimeException re) {			
			throw re;
		}
	}

	public Nhacungcap findById(java.lang.String id) {	
		try {
			Session sess=NhacungcapHome.getSessionFactory().openSession();
			Nhacungcap instance = (Nhacungcap) sess.get("model.Nhacungcap", id);
			sess.close();			
			return instance;
		} catch (RuntimeException re) {			
			throw re;
		}
	}

	public List<Nhacungcap> findByExample() {		
		try {
			Session sess=NhacungcapHome.getSessionFactory().openSession();
			List<Nhacungcap> results = sess.createCriteria("model.Nhacungcap").list();	
			sess.close();
			return results;
		} catch (RuntimeException re) {			
			throw re;
		}
	}
}
