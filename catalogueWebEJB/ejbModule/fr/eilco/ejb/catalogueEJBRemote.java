package fr.eilco.ejb;

import javax.ejb.Remote;

import fr.eilco.model.CategorieBean;

@Remote
public interface catalogueEJBRemote {
	public String direBonjour(String name);
	public CategorieBean direBonjourEntity(String name);
	public String getCategorie();
}
