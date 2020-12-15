package fr.eilco.ejb;

import java.util.ArrayList;

import javax.ejb.Remote;

import fr.eilco.model.ClientBean;
import fr.eilco.model.CommandeClientBean;

@Remote
public interface gestionClientBeanRemote {
	public ClientBean createClient(String prenom, String nom, String mail, String telephone, String pwd);
	public ClientBean getClient(String email);
	public void enregistrementClient(ClientBean c);
	public ArrayList<CommandeClientBean> getCommande(String id);
}
