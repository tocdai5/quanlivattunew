package dao;

// Generated Mar 30, 2015 12:55:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import model.Hoadon;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HoadonHome {



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

	public void persist(Hoadon transientInstance) {

		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void attachDirty(Hoadon instance) {
		try {
			Session sess=HoadonHome.getSessionFactory().openSession();
			sess.beginTransaction();
			sess.save(instance);
			sess.getTransaction().commit();
			sess.close();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void attachClean(Hoadon instance) {
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);			
		} catch (RuntimeException re) {			
			throw re;
		}
	}

	public void delete(Hoadon persistentInstance) {
		try {
			Session sess=HoadonHome.getSessionFactory().openSession();
			sess.beginTransaction();
			sess.delete(persistentInstance);
			sess.getTransaction().commit();
			sess.close();			
		} catch (RuntimeException re) {			
			throw re;
		}
	}

	public Hoadon merge(Hoadon detachedInstance) {		
		try {
			Session sess=HoadonHome.getSessionFactory().openSession();
			sess.beginTransaction();
			Hoadon result = (Hoadon) sess.merge(detachedInstance);
			sess.getTransaction().commit();
			sess.close();						
			return result;
		} catch (RuntimeException re) {			
			throw re;
		}
	}

	public Hoadon findById(java.lang.String id) {	
		try {
			Session sess=HoadonHome.getSessionFactory().openSession();
			Hoadon instance = (Hoadon) sess.get("model.Hoadon", id);
			sess.close();			
			return instance;
		} catch (RuntimeException re) {			
			throw re;
		}
	}
	

	public Hoadon findBySoChungtu(String sct) {
		
		try {
			Session sess = sessionFactory.openSession();
			Query q = sess.createQuery("from Hoadon hd where hd.sochungtu like :sochungtu");
			q.setParameter("sochungtu", sct);
			q.setMaxResults(1);
			
			Hoadon instance = (Hoadon) q.list().get(0);
			sess.close();
			
			return instance;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}
	

	public List<Hoadon> findByExample() {		
		try {
			Session sess=HoadonHome.getSessionFactory().openSession();
			List<Hoadon> results = sess.createCriteria("model.Hoadon").list();	
			sess.close();
			return results;
		} catch (RuntimeException re) {			
			throw re;
		}
	}
}
