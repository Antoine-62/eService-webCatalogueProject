package fr.eilco.model;
import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.List;

@Entity
@Table(schema="Catalogweb", name="categorie")
@NamedQuery(name = "CategorieBean.findAll", query = "SELECT m FROM CategorieBean m")
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