package fr.eilco.façade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eilco.model.CategorieBean;

public class FacadeCategorie extends FacadeAbstraite<CategorieBean>{
	
    private EntityManager mc;
	
	@Override
    protected EntityManager getEntityManager() {
        return mc;
    }
	
	public FacadeCategorie(EntityManager mc) {
        super(CategorieBean.class);
        this.mc = mc;
    }  
}
