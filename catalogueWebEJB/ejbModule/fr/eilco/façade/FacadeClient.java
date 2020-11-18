package fr.eilco.façade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import fr.eilco.model.ClientBean;

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
}
