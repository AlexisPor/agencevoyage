package persistence.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import persistence.entities.Utilisateur;
import persistence.util.HibernateUtil;

public class UtilisateurDaoImpl implements UtilisateurDao {
	private Session session;
	private Transaction tx;
	
	@Override
	public Utilisateur findUtilisateurByUsernameAndPassword(String username,String password) {
		
		session=HibernateUtil.getSessionFactory().openSession();
		Criteria crt=session.createCriteria(Utilisateur.class);
		Criterion crit1=Restrictions.eq("username", username);
		Criterion crit2=Restrictions.eq("password", password);
		crt.add(crit1);
		crt.add(crit2);
		Utilisateur u=(Utilisateur) crt.uniqueResult();
		session.close();
		return u;
	}

	@Override
	public void add(Utilisateur entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Utilisateur entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Utilisateur entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Utilisateur> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur findById(Serializable o) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
