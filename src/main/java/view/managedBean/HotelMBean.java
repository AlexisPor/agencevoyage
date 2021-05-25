package view.managedBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import persistence.dao.HotelDaoImpl;
import persistence.entities.Hotel;

@ManagedBean
@SessionScoped
public class HotelMBean {
	
	HotelDaoImpl hotelDaoImpl = new HotelDaoImpl();
	private Hotel hotel = new Hotel();
	private Hotel selectedHotel = new Hotel();
	private List<Hotel> listHotel = new ArrayList<Hotel>();
	

	public Hotel getSelectedHotel() {
		return selectedHotel;
	}

	public void setSelectedHotel(Hotel selectedHotel) {
		this.selectedHotel = selectedHotel;
	}

	public List<Hotel> getListHotel() {
		listHotel=hotelDaoImpl.findAll();
		return listHotel;
	}

	public void setListHotel(List<Hotel> listHotel) {
		this.listHotel = listHotel;
	}

	public HotelDaoImpl getHotelDaoImpl() {
		return hotelDaoImpl;
	}

	public void setHotelDaoImpl(HotelDaoImpl hotelDaoImpl) {
		this.hotelDaoImpl = hotelDaoImpl;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public void addHotel(ActionEvent e) {
		hotelDaoImpl.add(hotel);
		hotel=null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("L'ajout à été réalisé avec succés"));
	}
	
	public void deleteHotel(ActionEvent e) {
		 if(selectedHotel==null || selectedHotel.getIdhotel()==new BigDecimal(0))
	            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention", "Aucun  client sélectionné "));
	        else {    
	        	hotelDaoImpl.delete(selectedHotel);
	        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Suppression effectuée avec succées"));
	        }
	}
	
	public String editHotel() {
		return "editHotel.xhtml";
	}
	
	public void updateHotel(ActionEvent e) {
		hotelDaoImpl.update(selectedHotel);
	}
	
}
