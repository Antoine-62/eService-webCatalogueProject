package fr.eilco.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eilco.façade.FacadeClient;
import fr.eilco.model.ClientBean;

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

}
