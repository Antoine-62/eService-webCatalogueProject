package fr.eilco.ejb;

import javax.ejb.Local;

import fr.eilco.model.ClientBean;


@Local
public interface gestionClientBeanLocal {
	public ClientBean createClient(String prenom ,String nom, String mail, String telephone, String pwd);
	public ClientBean getClient(String email);
	public void enregistrementClient(ClientBean c);
}
