package fr.eilco.fa�ade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eilco.model.ProduitCommandeBean;

public class FacadadeProduitCommande extends FacadeAbstraite<ProduitCommandeBean>{
	@PersistenceContext(unitName = "managerCatalog")
    private EntityManager mc;
	
	@Override
    protected EntityManager getEntityManager() {
        return mc;
    }
	
	public FacadadeProduitCommande() {
        super(ProduitCommandeBean.class);
    }  
}
