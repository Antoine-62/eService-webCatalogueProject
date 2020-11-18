package fr.eilco.façade;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eilco.model.CategorieBean;
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
	public ArrayList<ProduitBean> findAll(int categorie_id) {
		Query query = mc.createNamedQuery("ProduitBean.findAllByCatId");
	    ArrayList<ProduitBean> categoriesList = (ArrayList<ProduitBean>) query.setParameter("categorie_id", categorie_id).getResultList();
	    return categoriesList;
    }
}
