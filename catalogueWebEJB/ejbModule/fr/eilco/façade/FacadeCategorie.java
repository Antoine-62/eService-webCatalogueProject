package fr.eilco.façade;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	public ArrayList<CategorieBean> findAll() {
		Query query = mc.createNamedQuery("CategorieBean.findAll");
	    ArrayList<CategorieBean> categoriesList = (ArrayList<CategorieBean>) query.getResultList();
	    return categoriesList;
    }
}
