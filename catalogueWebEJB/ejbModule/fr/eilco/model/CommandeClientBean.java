package fr.eilco.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

public class CommandeClientBean {
	private int id;
	private double aMontant;
	private String aDateCreation;
	private int aNoConfirmation;
	private int aClientId;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id= id;
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
	
	@Column(name="client_id")
	public int getClientId(){
		return this.aClientId;
	}
	public void setClientId(int pClientId){
		this.aClientId= pClientId;
	}
}
