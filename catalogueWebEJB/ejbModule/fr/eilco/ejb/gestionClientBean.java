package fr.eilco.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eilco.façade.FacadeClient;
import fr.eilco.façade.FacadeCommandeClient;
import fr.eilco.model.ClientBean;
import fr.eilco.model.CommandeClientBean;

/**
 * Session Bean implementation class gestionClientBean
 */
@Stateless(name="gestionClientBeanJNDI")
@LocalBean
public class gestionClientBean implements gestionClientBeanRemote, gestionClientBeanLocal {

	@PersistenceContext(unitName="managerCatalog")
	EntityManager mc;
    /**
     * Default constructor. 
     */
    public gestionClientBean() {
        // TODO Auto-generated constructor stub
    }
    public ClientBean createClient(String prenom, String nom, String mail, String telephone, String pwd) {
		ClientBean newclient = new ClientBean();
		newclient.setPrenom(prenom);
		newclient.setNom(nom);
		newclient.setEmail(mail);
		newclient.setTelephone(telephone);
		newclient.setPassword(pwd);
		return newclient;
	}
    
	public ClientBean getClient(String email) {
		FacadeClient façade = new FacadeClient(mc);
		ClientBean client = façade.findByEmail(email);
		return client;
	}
	
	public void enregistrementClient(ClientBean c) {
		mc.persist(c);
		System.out.println("Client Enregistre : "+c);
	}
	
	public ArrayList<CommandeClientBean> getCommande(String id) {
		FacadeCommandeClient façade = new FacadeCommandeClient(mc);
		ArrayList<CommandeClientBean> commandes = (ArrayList<CommandeClientBean>) façade.findAllByClient(id);
		return commandes;
	}

}
