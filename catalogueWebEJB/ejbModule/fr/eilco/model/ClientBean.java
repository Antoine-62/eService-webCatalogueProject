package fr.eilco.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(schema="Catalogweb", name="client")
@NamedQuery(name = "ClientBean.findByEmail", query = "SELECT c FROM ClientBean c where c.email = :emailLogin")
public class ClientBean implements Serializable{
	private int id;
	private String aPrenom= "";
	private String aNom= "";
	private String email= "";
	private String aTelephone= "";
	private String aPassword = "";
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id= id;
	}
	
	@Column(name="prenom")
	public String getPrenom(){
		return this.aPrenom;
	}
	public void setPrenom(String pNom){
		this.aPrenom= pNom;
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
		return this.email;
	}
	public void setEmail(String pEmail){
		this.email= pEmail;
	}
	
	@Column(name="telephone")
	public String getTelephone(){
		return this.aTelephone;
	}
	public void setTelephone(String pTelephone){
		this.aTelephone= pTelephone;
	}
	
	@Column(name="password")
	public String getPassword(){
		return this.aPassword;
	}
	public void setPassword(String pPassword){
		this.aPassword= pPassword;
	}

}
