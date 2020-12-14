package fr.eilco.ejb;

import java.util.ArrayList;
import javax.ejb.Remote;

import fr.eilco.model.ClientBean;
import fr.eilco.model.CommandeClientBean;
import fr.eilco.model.ProduitBean;
import fr.eilco.model.ProduitCommandeBean;

@Remote
public interface gestionCommandeBeanRemote {
	public CommandeClientBean createCommande(ArrayList<ProduitBean> produitList);
	//public ArrayList<ProduitCommandeBean> gererCommande();
	public void validerCommande(CommandeClientBean c, String adresse, String codepost,  String ville, String pays, ClientBean client);
}
