package fr.eilco.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eilco.model.CategorieBean;
import fr.eilco.model.ProduitBean;
import fr.eilco.façade.FacadeCategorie;
import fr.eilco.façade.FacadeProduit;
import java.util.ArrayList;

/**
 * Session Bean implementation class accesCatalogueBeanRemote
 */
@Stateless(name ="accesCatalogueBeanJNDI")
@LocalBean
public class accesCatalogueBean implements accesCatalogueBeanRemote, accesCatalogueBeanLocal {

	@PersistenceContext(unitName="managerCatalog")
	EntityManager mc;
    /**
     * Default constructor. 
     */
    public accesCatalogueBean() {
        // TODO Auto-generated constructor stub
    }
    
    public ArrayList<CategorieBean> getListCategories(){
    	FacadeCategorie test = new FacadeCategorie(mc);
    	ArrayList<CategorieBean> categoriesList = (ArrayList<CategorieBean>) test.findAll();
    	return categoriesList;
    }
    
    public CategorieBean getCategorie(){
    	Query q = mc.createQuery("select c.categorie from CategorieBean c where c.id=:id").setParameter("id", 1);
    	String testBean = (String)q.getSingleResult(); 
    	System.out.println("le messagefghj est :" +mc);
    	System.out.println("le messagefghj est :" + testBean);
    	FacadeCategorie test = new FacadeCategorie(mc);
    	CategorieBean categorieBean = test.find(1);
    	return categorieBean;
    }
    
    public ArrayList<ProduitBean> getListProduits(int id){
    	FacadeProduit facadeproduit = new FacadeProduit(mc);
    	System.out.print("boom23");
    	ArrayList<ProduitBean> produitList = (ArrayList<ProduitBean>) facadeproduit.findAll(id);
    	// System.out.print("la liste de produit"+produitList.get(1).getNom());
    	return produitList;
    }
}
