package fr.eilco.ejb;

import java.util.ArrayList;

import javax.ejb.Remote;

import fr.eilco.model.CategorieBean;
import fr.eilco.model.ProduitBean;

@Remote
public interface accesCatalogueBeanRemote {
	public ArrayList<CategorieBean> getListCategories();
	public ArrayList<ProduitBean> getListProduits(int id);
	public CategorieBean getCategorie();
}
