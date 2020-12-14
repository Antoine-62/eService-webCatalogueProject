package fr.eilco.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class enregistrementForm extends ActionForm{
	private String nom;
	private String prenom;
	private String email;
	private String phone;
	private String password;
	
	public void reset(ActionMapping mapping, HttpServletRequest request){
		this.nom="";
		this.prenom=""; 
		this.email="";
		this.phone="";
		this.password="";
	}
	
	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request ){
		ActionErrors errors = new ActionErrors();
		return errors;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String newNom) {
		this.nom = newNom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public void setPrenom(String newPrenom) {
		this.prenom = newPrenom;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String newPhone) {
		this.phone = newPhone;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
}
