package view.managedBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import persistence.dao.ClientDao;
import persistence.dao.ClientDaoImpl;
import persistence.entities.Client;

@ManagedBean
@SessionScoped
public class ClientMBean {
	
	private Client client = new Client();
	private Client selectedClient = new Client();
	ClientDao clientDaoImpl = new ClientDaoImpl();
	private List<Client> listClient = new ArrayList<Client>();
	
	public Client getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}


	
	public ClientDao getClientDaoImpl() {
		return clientDaoImpl;
	}

	public void setClientDaoImpl(ClientDao clientDaoImpl) {
		this.clientDaoImpl = clientDaoImpl;
	}

	public List<Client> getListClient() {
		listClient=clientDaoImpl.findAll();
		return listClient;
	}

	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addClient(ActionEvent e) {
		clientDaoImpl.add(client);
		client=null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("L'ajout à été réalisé avec succés"));
		
	}
	
	public void deleteClient(ActionEvent e) {
        if(selectedClient==null || selectedClient.getId()==new BigDecimal(0))
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention", "Aucun  client sélectionné "));
        else {    
        	clientDaoImpl.delete(selectedClient);
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Suppression effectuée avec succées"));
        }
    }
	
	public String editClient() {
		return "editClient.xhtml";
	}
	
	public void updateClient(ActionEvent e) {
		clientDaoImpl.update(selectedClient);
	}
	
}
