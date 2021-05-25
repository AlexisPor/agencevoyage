package view.managedBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import persistence.dao.ReservationDaoImpl;
import persistence.entities.Reservation;

@ManagedBean
@SessionScoped
public class ReservationMBean {
	
	ReservationDaoImpl resDaoImpl = new ReservationDaoImpl();
	private Reservation res = new Reservation();
	private List<Reservation> listeRes = new ArrayList<Reservation>();
	private Reservation selectedRes = new Reservation();
	
	public List<Reservation> getListeRes() {
		listeRes = resDaoImpl.findAll();
		return listeRes;
	}


	public void setListeRes(List<Reservation> listeRes) {
		this.listeRes = listeRes;
	}


	public Reservation getSelectedRes() {
		return selectedRes;
	}


	public void setSelectedRes(Reservation selectedRes) {
		this.selectedRes = selectedRes;
	}


	public ReservationDaoImpl getResDaoImpl() {
		return resDaoImpl;
	}


	public void setResDaoImpl(ReservationDaoImpl resDaoImpl) {
		this.resDaoImpl = resDaoImpl;
	}


	public Reservation getRes() {
		return res;
	}


	public void setRes(Reservation res) {
		this.res = res;
	}


	public void addReservation(ActionEvent e) {
		resDaoImpl.add(res);
		res = new Reservation();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("L'ajout à été réalisé avec succés"));
	}
	
	public void deleteReservation(ActionEvent e) 
	{
		if(selectedRes==null || selectedRes.getIdreservation()==new BigDecimal(0)) {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention", "Aucun  client sélectionné "));
		}
        else {    
        	resDaoImpl.delete(selectedRes);
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Suppression effectuée avec succées"));
        }
		
	}
	
	public void editReservation(ActionEvent e) {
        System.out.println("reservation="+selectedRes);
	}
	
	public void updateReservation(ActionEvent e) {
		resDaoImpl.update(selectedRes);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modification réalisé avec succés"));
	}
}
    

