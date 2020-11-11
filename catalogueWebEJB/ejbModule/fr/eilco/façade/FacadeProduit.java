package fr.eilco.façade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eilco.model.ProduitBean;

public class FacadeProduit extends FacadeAbstraite<ProduitBean>{

    private EntityManager mc;
	
	@Override
    protected EntityManager getEntityManager() {
        return mc;
    }
	
	public FacadeProduit(EntityManager mc) {
        super(ProduitBean.class);
        this.mc = mc;
    } 
}
