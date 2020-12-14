package fr.eilco.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import fr.eilco.model.CategorieBean;

@Entity
@Table(schema="Catalogweb", name="produit")
@NamedQuery(name = "ProduitBean.findAllByCatId", query = "SELECT p FROM ProduitBean p where p.categorie.id = :categorie_id")
public class ProduitBean implements Serializable{
	private int id;
	private String nom;
	private double prix;
	private String description;
	private String dernierMaj;
	private CategorieBean categorie;
	private List<ProduitCommandeBean> commandes = new ArrayList<>();
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id= id;
	}
	
	@Column(name="nom")
	public String getNom(){
		return this.nom;
	}
	public void setNom(String nom){
		this.nom= nom;
	}
	
	@Column(name="prix")
	public double getPrix(){
		return this.prix;
	}
	public void setprix(double prix){
		this.prix= prix;
	}
	
	@Column(name="description")
	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description= description;
	}
	
	@Column(name="dernier_maj")
	public String getDernierMaj(){
		return this.dernierMaj;
	}
	public void setDernierMaj(String dernierMaj){
		this.dernierMaj= dernierMaj;
	}
	
	@ManyToOne
	public CategorieBean getCategorie() {
		return this.categorie;
	}
	public void setCategorie(CategorieBean cate) {
		this.categorie = cate;
	}
	
	@OneToMany(mappedBy = "idCommand.produit", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<ProduitCommandeBean> getLignesCommandes() {
		return commandes;
	}
	public void setLignesCommandes(List<ProduitCommandeBean> lignesCommandes) {
		this.commandes = lignesCommandes;
	}
}
