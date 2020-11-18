package fr.eilco.fa�ade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eilco.model.CommandeClientBean;

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
}
