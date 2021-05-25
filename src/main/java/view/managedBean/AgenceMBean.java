package view.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import persistence.dao.UtilisateurDao;
import persistence.dao.UtilisateurDaoImpl;

@ManagedBean
@SessionScoped
public class AgenceMBean {

	private List<ImageAgence> images;
	private String username;
	private String pwd;
	private UtilisateurDao utilisateurDaoImpl=new UtilisateurDaoImpl();
	
	
    public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public List<ImageAgence> getImages() {
		return images;
	}


	public void setImages(List<ImageAgence> images) {
		this.images = images;
	}


	public AgenceMBean() {
    	images = new ArrayList<ImageAgence>();
       ImageAgence image1 = new ImageAgence("/images/1.jpg","Voyage organisé");
       ImageAgence image2 = new ImageAgence("/images/2.jpg","Voyage de noce");
       ImageAgence image3 = new ImageAgence("/images/3.jpg","Voyage en Thailande");
       
       images.add(image1);
       images.add(image2);
       images.add(image3);
       
            //images.add("/images/" + i + ".jpg");
        
    }
	
	public String login() {
		if(utilisateurDaoImpl.findUtilisateurByUsernameAndPassword(username, pwd)!=null)
		return "Acceuil.xhtml";
		else {
			
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention", "Utilisateur inexistant. "));
			return "login.xhtml";
		}
		
	}

}