package fr.eilco.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="Catalogweb", name="categorie")
@NamedQuery(name = "CategorieBean.findAll", query = "SELECT m FROM CategorieBean m")
public class CategorieBean implements Serializable {
	private int id;
	private String aCategorie= "";
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id= id;
	}
	
	@Column(name="categorie")
	public String getCategorie(){
		return aCategorie;
	}
	public void setCategorie(String pCategorie){
		aCategorie= pCategorie;
	}
	
	@OneToMany(targetEntity=ProduitBean.class, mappedBy="categorie", cascade=CascadeType.ALL)
	private List<ProduitBean> produits = new ArrayList<>();
	
	public List<ProduitBean> getProduits() {
		return produits;
		}
	
	public void setProduits(List<ProduitBean> produits) {
		this.produits = produits;
		}
}