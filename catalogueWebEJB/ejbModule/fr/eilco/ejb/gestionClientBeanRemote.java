package fr.eilco.ejb;

import javax.ejb.Remote;

import fr.eilco.model.ClientBean;

@Remote
public interface gestionClientBeanRemote {
	public ClientBean createClient(String prenom, String nom, String mail, String telephone, String pwd);
	public ClientBean getClient(String email);
	public void enregistrementClient(ClientBean c);
}
