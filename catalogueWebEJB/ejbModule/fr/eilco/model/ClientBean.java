package fr.eilco.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="Catalogweb", name="client")
public class ClientBean implements Serializable{
	private int id;
	private String aNom= "";
	private String aEmail= "";
	private String aTelephone= "";
	private String aAdresse= "";
	
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
		return this.aNom;
	}
	public void setNom(String pNom){
		this.aNom= pNom;
	}
	
	@Column(name="email")
	public String getEmail(){
		return this.aEmail;
	}
	public void setEmail(String pEmail){
		this.aEmail= pEmail;
	}
	
	@Column(name="telephone")
	public String getTelephone(){
		return this.aTelephone;
	}
	public void setTelephone(String pTelephone){
		this.aTelephone= pTelephone;
	}
	
	@Column(name="adresse")
	public String getAdresse(){
		return this.aAdresse;
	}
	public void setAdresse(String pAdresse){
		this.aAdresse= pAdresse;
	}

}
