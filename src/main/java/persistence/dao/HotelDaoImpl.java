package persistence.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistence.entities.Hotel;
import persistence.util.HibernateUtil;

public class HotelDaoImpl implements HotelDao {
	
	private Session session;
	private Transaction tx;

	@Override
	public void add(Hotel entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx=session.beginTransaction();
		
		session.save(entity);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(Hotel entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx=session.beginTransaction();
		
		session.delete(entity);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Hotel entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx=session.beginTransaction();
		
		session.update(entity);
		tx.commit();
		session.close();
	}

	@Override
	public List<Hotel> findAll() {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		
		List<Hotel> list = session.createQuery("from Hotel").list();
		session.close();
		return list;
		
	}

	@Override
	public Hotel findById(Serializable o) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		Hotel hotel = session.load(Hotel.class, (Serializable) o);
		
		return hotel;
		
	}

}
