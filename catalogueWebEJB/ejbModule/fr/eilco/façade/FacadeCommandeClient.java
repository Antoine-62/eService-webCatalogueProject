package fr.eilco.façade;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eilco.model.CommandeClientBean;
import fr.eilco.model.ProduitBean;

public class FacadeCommandeClient extends FacadeAbstraite<CommandeClientBean>{

    private EntityManager mc;
	
	@Override
    protected EntityManager getEntityManager() {
        return mc;
    }
	
	public FacadeCommandeClient(EntityManager mc) {
        super(CommandeClientBean.class);
        this.mc = mc;
    } 
	
	public ArrayList<CommandeClientBean> findAllByClient(String client_email) {
		Query query = mc.createNamedQuery("CommandeClientBean.findByCatIdClient");
	    ArrayList<CommandeClientBean> commandeList = (ArrayList<CommandeClientBean>) query.setParameter("client_email", client_email).getResultList();
	    return commandeList;
    }
}
