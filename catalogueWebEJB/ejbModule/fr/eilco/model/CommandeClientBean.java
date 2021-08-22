package fr.eilco.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import fr.eilco.model.ClientBean;

@Entity
@Table(schema="Catalogweb", name="commande")
@NamedQuery(name = "CommandeClientBean.findByCatIdClient", query = "SELECT c FROM CommandeClientBean c where c.email = :client_email")
public class CommandeClientBean implements Serializable {
	private int id;
	private String adresse;
	private String codepost;
	private String ville;
	private String pays;
	private double aMontant;
	private String aDateCreation;
	private int aNoConfirmation;
	private String email;
	private List<ProduitCommandeBean> produits = new ArrayList<>();
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id= id;
	}
	
	@Column(name="adresse")
	public String getAdresse(){
		return this.adresse;
	}
	public void setAdresse(String adresse){
		this.adresse= adresse;
	}
	
	@Column(name="codepost")
	public String getCodepost(){
		return this.codepost;
	}
	public void setCodepost(String codepost){
		this.codepost= codepost;
	}
	
	@Column(name="ville")
	public String getVille(){
		return this.ville;
	}
	public void setVille(String ville){
		this.ville= ville;
	}
	
	@Column(name="pays")
	public String getPays(){
		return this.pays;
	}
	public void setPays(String pays){
		this.pays= pays;
	}
	
	@Column(name="montant")
	public double getMontant(){
		return this.aMontant;
	}
	public void setMontant(double pMontant){
		this.aMontant= pMontant;
	}
	
	@Column(name="date_creation")
	public String getDateCreation(){
		return this.aDateCreation;
	}
	public void setDateCreation(String pDateCreation){
		this.aDateCreation= pDateCreation;
	}
	
	@Column(name="no_confirmation")
	public int getNoConfirmation(){
		return this.aNoConfirmation;
	}
	public void setNoConfirmation(int pNoConfirmation){
		this.aNoConfirmation= pNoConfirmation;
	}
	
	@Column(name="email")
	public String getEmail(){
		return this.email;
	}
	public void setEmail(String pClientId){
		this.email= pClientId;
	}
	
	@OneToMany(mappedBy = "idCommand.commande", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<ProduitCommandeBean> getLignesCommandes() {
		return produits;
	}
	public void setLignesCommandes(List<ProduitCommandeBean> lignesCommandes) {
		this.produits = lignesCommandes;
	}
}
