package persistence.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistence.entities.Client;
import persistence.util.HibernateUtil;

public class ClientDaoImpl implements ClientDao{
	
	private Session session;
	private Transaction tx;
	
	@Override
	public void add(Client entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx=session.beginTransaction();
		
		session.save(entity);
		tx.commit();
		session.close();
		
	}

	@Override
	public void delete(Client entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx=session.beginTransaction();
		
		session.delete(entity);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Client entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx=session.beginTransaction();
		
		session.update(entity);
		tx.commit();
		session.close();
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		
		List<Client> list = session.createQuery("from Client").list();
		session.close();
		
		return list;
	}

	@Override
	public Client findById(Serializable o) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		Client client = session.load(Client.class, (Serializable) o);
		session.close();
		
		return client;
	}

}
