package dao;

// Generated Mar 30, 2015 12:55:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import model.User;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UserHome {



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

	public void persist(User transientInstance) {

		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void attachDirty(User instance) {
		try {
			Session sess=UserHome.getSessionFactory().openSession();
			sess.beginTransaction();
			sess.save(instance);
			sess.getTransaction().commit();
			sess.close();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void attachClean(User instance) {
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);			
		} catch (RuntimeException re) {			
			throw re;
		}
	}

	public void delete(User persistentInstance) {
		try {
			Session sess=UserHome.getSessionFactory().openSession();
			sess.beginTransaction();
			sess.delete(persistentInstance);
			sess.getTransaction().commit();
			sess.close();			
		} catch (RuntimeException re) {			
			throw re;
		}
	}

	public User merge(User detachedInstance) {		
		try {
			Session sess=UserHome.getSessionFactory().openSession();
			sess.beginTransaction();
			User result = (User) sess.merge(detachedInstance);
			sess.getTransaction().commit();
			sess.close();						
			return result;
		} catch (RuntimeException re) {			
			throw re;
		}
	}

	public User findById(java.lang.String id) {	
		try {
			Session sess=UserHome.getSessionFactory().openSession();
			User instance = (User) sess.get("model.User", id);
			sess.close();			
			return instance;
		} catch (RuntimeException re) {			
			throw re;
		}
	}

	public List<User> findByExample() {		
		try {
			Session sess=UserHome.getSessionFactory().openSession();
			List<User> results = sess.createCriteria("model.User").list();	
			sess.close();
			return results;
		} catch (RuntimeException re) {			
			throw re;
		}
	}
}
