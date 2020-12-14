package fr.eilco.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eilco.model.ClientBean;
import fr.eilco.model.CommandeClientBean;
import fr.eilco.model.ProduitBean;
import fr.eilco.model.ProduitCommandeBean;
import fr.eilco.model.ProduitCommandeBeanId;

/**
 * Session Bean implementation class gestionCommandeBean
 */
@Stateless(name ="gestionCommandeBeanJNDI")
@LocalBean
public class gestionCommandeBean implements gestionCommandeBeanRemote, gestionCommandeBeanLocal {
	@PersistenceContext(unitName="managerCatalog")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public gestionCommandeBean() {
        // TODO Auto-generated constructor stub
    }
    
    public CommandeClientBean createCommande(ArrayList<ProduitBean> produitList) {
    	CommandeClientBean commande = new CommandeClientBean();
    	commande.setNoConfirmation(97);
    	ArrayList<ProduitCommandeBean> commandList = new ArrayList<ProduitCommandeBean>();
    	for (int counter = 0; counter < produitList.size(); counter++) { 
    		ProduitCommandeBean commandItem = new ProduitCommandeBean();
    		ProduitCommandeBeanId idcommand = new ProduitCommandeBeanId();
    		idcommand.setProduit(produitList.get(counter));
    		idcommand.setCommande(commande);
    		commandItem.setId(idcommand);
    		commandItem.setQuantite(1);
    		commandList.add(commandItem);
        }
    	commande.setLignesCommandes(commandList);
    	for (int counter = 0; counter < produitList.size(); counter++) { 
    		System.out.println("test"+counter);
    		System.out.println(commande.getLignesCommandes().get(counter).getId().getProduit().getNom());
    		System.out.println(commande.getLignesCommandes().get(counter).getId().getCommande().getNoConfirmation());
        }
    	return commande;
    }
	/*public ArrayList<ProduitCommandeBean> gererCommande(){
		
	}*/
	public void validerCommande(CommandeClientBean c, String adresse, String codepost,  String ville, String pays, ClientBean client) {
		c.setAdresse(adresse);
		c.setCodepost(codepost);
		c.setVille(ville);
		c.setPays(pays);
		c.setClientId(client);
		em.persist(c);
		System.out.println("commande enregistré : "+c);
	}

}
