package fr.eilco.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fr.eilco.model.CategorieBean;

/**
 * Session Bean implementation class catalogueEJB
 */
@Stateless(name ="catalogueJNDI")
@LocalBean
public class catalogueEJB implements catalogueEJBRemote, catalogueEJBLocal {
	
	@PersistenceContext(unitName="managerCatalog")
	EntityManager mc;
    /**
     * Default constructor. 
     */
    public catalogueEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public String direBonjour(String name){ 
    	System.out.println("Preparation du message pour dire bonjour "+ name);
    	return"Bonjour "+ name;
    }
    
    public CategorieBean direBonjourEntity(String name){
    	Query q = mc.createQuery("select h from CategorieBean h");
    	CategorieBean helloBean = (CategorieBean)q.getSingleResult();
    	return helloBean;
    }
    
    public String getCategorie(){
    	Query q = mc.createQuery("select c.categorie from CategorieBean c where c.id=:id").setParameter("id", 1);
    	String categorieBean = (String)q.getSingleResult(); 
    	return categorieBean;
    }

}
