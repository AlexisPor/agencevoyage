package persistence.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistence.entities.Reservation;
import persistence.util.HibernateUtil;

public class ReservationDaoImpl implements ReservationDao{
	
	private Session session;
	private Transaction tx;

	@Override
	public void add(Reservation entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx=session.beginTransaction();
		
		session.save(entity);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(Reservation entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx=session.beginTransaction();
		
		session.delete(entity);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Reservation entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx=session.beginTransaction();
		
		session.update(entity);
		tx.commit();
		session.close();
	}

	@Override
	public Reservation findById(Serializable o) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		Reservation res = session.load(Reservation.class, (Serializable) o);
		session.close();
		return res;
	}

	@Override
	public List<Reservation> findAll() {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		
		List<Reservation> list = session.createQuery("from Reservation").list();
		
		return list;
	}

}
