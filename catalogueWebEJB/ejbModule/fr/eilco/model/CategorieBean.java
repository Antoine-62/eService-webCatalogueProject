package fr.eilco.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="Catalogweb", name="categorie")
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
}