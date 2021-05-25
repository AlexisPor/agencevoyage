package persistence.dao;

import persistence.entities.Utilisateur;

public interface UtilisateurDao extends GenericDao<Utilisateur> {
	
	Utilisateur findUtilisateurByUsernameAndPassword(String username,String password);

}
