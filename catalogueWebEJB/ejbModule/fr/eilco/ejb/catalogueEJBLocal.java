package fr.eilco.ejb;

import javax.ejb.Local;

import fr.eilco.model.CategorieBean;

@Local
public interface catalogueEJBLocal {
	public String direBonjour(String name);
	public CategorieBean direBonjourEntity(String name);
	public String getCategorie();
}
