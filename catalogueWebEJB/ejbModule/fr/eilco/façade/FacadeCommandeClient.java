package fr.eilco.façade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eilco.model.CommandeClientBean;

public class FacadeCommandeClient extends FacadeAbstraite<CommandeClientBean>{
	@PersistenceContext(unitName = "managerCatalog")
    private EntityManager mc;
	
	@Override
    protected EntityManager getEntityManager() {
        return mc;
    }
	
	public FacadeCommandeClient() {
        super(CommandeClientBean.class);
    } 
}
