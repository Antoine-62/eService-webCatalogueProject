package fr.eilco.façade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eilco.model.ProduitCommandeBean;

public class FacadadeProduitCommande extends FacadeAbstraite<ProduitCommandeBean>{

    private EntityManager mc;
	
	@Override
    protected EntityManager getEntityManager() {
        return mc;
    }
	
	public FacadadeProduitCommande(EntityManager mc) {
        super(ProduitCommandeBean.class);
        this.mc = mc;
    }  
}
