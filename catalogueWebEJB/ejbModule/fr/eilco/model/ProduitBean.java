package fr.eilco.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


public class ProduitBean {
	private int id;
	private String nom;
	private double prix;
	private String description;
	private String dernierMaj;
	private int categorieId;
	
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
	
	@Column(name="categorie_id")
	public int getCategorieId(){
		return this.categorieId;
	}
	public void setCategorieId(int categorieId){
		this.categorieId= categorieId;
	}
}
