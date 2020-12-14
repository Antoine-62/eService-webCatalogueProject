package fr.eilco.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(schema="Catalogweb", name="produit_commande")
public class ProduitCommandeBean implements Serializable{
	
    private int quantite;
	
	@Id
	private ProduitCommandeBeanId idCommand;
	public ProduitCommandeBeanId getId(){
		return idCommand;
	}
	public void setId(ProduitCommandeBeanId id){
		this.idCommand= id;
	}
	
	@Column(name="quantite")
	public int getQuantite(){
		return this.quantite;
	}
	public void setQuantite(int quantite){
		this.quantite= quantite;
	}
	
	
	

}
