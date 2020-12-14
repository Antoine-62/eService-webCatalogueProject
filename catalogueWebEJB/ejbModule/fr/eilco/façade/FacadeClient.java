package fr.eilco.façade;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eilco.model.ClientBean;
import fr.eilco.model.ProduitBean;

public class FacadeClient extends FacadeAbstraite<ClientBean>{
	
    private EntityManager mc;
	
	@Override
    protected EntityManager getEntityManager() {
        return mc;
	}
	
	public FacadeClient(EntityManager mc) {
        super(ClientBean.class);
        this.mc = mc;
    }  
	
	public ClientBean findByEmail(String emailLogin) {
		Query query = mc.createNamedQuery("ClientBean.findByEmail");
		ClientBean client = new ClientBean();
		ArrayList<ClientBean> clientArray = new ArrayList<ClientBean>();
		clientArray=(ArrayList<ClientBean>) query.setParameter("emailLogin", emailLogin).getResultList();
		if(!clientArray.isEmpty()) {
			client=clientArray.get(0);
		}
	    return client;
    }
}
