package fr.eilco.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.List;

@Entity
@Table(schema="Catalogweb", name="commande")
public class CommandeClientBean implements Serializable {
	private int id;
	private int numeroCommande;
	private String adresse;
	private String codepost;
	private String ville;
	private String pays;
	private double aMontant;
	private String aDateCreation;
	private int aNoConfirmation;
	private ClientBean aClientId;
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
	
	@Column(name="numeroCommande")
	public int getNumero(){
		return numeroCommande;
	}
	public void setNumero(int numero){
		this.numeroCommande= numero;
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
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch= FetchType.LAZY)
	public ClientBean getClientId(){
		return this.aClientId;
	}
	public void setClientId(ClientBean pClientId){
		this.aClientId= pClientId;
	}
	
	@OneToMany(mappedBy = "idCommand.commande", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<ProduitCommandeBean> getLignesCommandes() {
		return produits;
	}
	public void setLignesCommandes(List<ProduitCommandeBean> lignesCommandes) {
		this.produits = lignesCommandes;
	}
}
