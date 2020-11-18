package fr.eilco.ejb;

import java.util.ArrayList;

import javax.ejb.Local;

import fr.eilco.model.CategorieBean;
import fr.eilco.model.ProduitBean;

@Local
public interface accesCatalogueBeanLocal {
	public ArrayList<CategorieBean> getListCategories();
	public ArrayList<ProduitBean> getListProduits(int id);
	public CategorieBean getCategorie();
}
