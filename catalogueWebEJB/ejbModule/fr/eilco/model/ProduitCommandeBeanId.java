package fr.eilco.model;

import javax.persistence.*;

@Embeddable
public class ProduitCommandeBeanId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
		
	@ManyToOne
	@JoinColumn(name="produit_id")
	ProduitBean produit;
	public ProduitBean getProduit() {
		return this.produit;
	}
	public void setProduit(ProduitBean cate) {
		this.produit = cate;
	}
	
	@ManyToOne
	@JoinColumn(name="commande_id")
	CommandeClientBean commande;
	public CommandeClientBean getCommande() {
		return this.commande;
	}
	public void setCommande(CommandeClientBean cate) {
		this.commande = cate;
	}


}
