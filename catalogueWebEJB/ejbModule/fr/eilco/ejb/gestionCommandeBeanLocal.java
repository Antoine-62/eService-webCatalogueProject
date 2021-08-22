package fr.eilco.ejb;

import java.util.ArrayList;

import javax.ejb.Local;

import fr.eilco.model.ClientBean;
import fr.eilco.model.CommandeClientBean;
import fr.eilco.model.ProduitBean;
import fr.eilco.model.ProduitCommandeBean;

@Local
public interface gestionCommandeBeanLocal {
	public CommandeClientBean createCommande(ArrayList<ProduitBean> produitList);
	//public ArrayList<ProduitCommandeBean> gererCommande();
	public void validerCommande(CommandeClientBean c, String adresse, String codepost,  String ville, String pays, ClientBean client);
}
