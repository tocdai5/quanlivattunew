package dao;

// Generated Mar 30, 2015 12:55:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import model.Vattu;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class VattuHome {



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

	public void persist(Vattu transientInstance) {

		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void attachDirty(Vattu instance) {
		try {
			Session sess=VattuHome.getSessionFactory().openSession();
			sess.beginTransaction();
			sess.save(instance);
			sess.getTransaction().commit();
			sess.close();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void attachClean(Vattu instance) {
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);			
		} catch (RuntimeException re) {			
			throw re;
		}
	}

	public void delete(Vattu persistentInstance) {
		try {
			Session sess=VattuHome.getSessionFactory().openSession();
			sess.beginTransaction();
			sess.delete(persistentInstance);
			sess.getTransaction().commit();
			sess.close();			
		} catch (RuntimeException re) {			
			throw re;
		}
	}

	public Vattu merge(Vattu detachedInstance) {		
		try {
			Session sess=VattuHome.getSessionFactory().openSession();
			sess.beginTransaction();
			Vattu result = (Vattu) sess.merge(detachedInstance);
			sess.getTransaction().commit();
			sess.close();						
			return result;
		} catch (RuntimeException re) {			
			throw re;
		}
	}

	public Vattu findById(int id) {	
		try {
			Session sess=VattuHome.getSessionFactory().openSession();
			Vattu instance = (Vattu) sess.get("model.Vattu", id);
			sess.close();			
			return instance;
		} catch (RuntimeException re) {			
			throw re;
		}
	}

	public List<Vattu> findByExample() {		
		try {
			Session sess=VattuHome.getSessionFactory().openSession();
			List<Vattu> results = sess.createCriteria("model.Vattu").list();	
			sess.close();
			return results;
		} catch (RuntimeException re) {			
			throw re;
		}
	}
}
