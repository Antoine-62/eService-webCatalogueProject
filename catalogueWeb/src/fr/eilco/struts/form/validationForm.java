package fr.eilco.struts.form;

import org.apache.struts.action.*;
import javax.servlet.http.HttpServletRequest;

public class validationForm extends ActionForm {
	private String adresse;
	private String code;
	private String ville;
	private String pays;
	
	public void reset(ActionMapping mapping, HttpServletRequest request){
		this.adresse="";
		this.code=""; 
		this.ville="";
		this.pays="";
	}
	
	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request ){
		System.out.println("action2 passer");
		ActionErrors errors = new ActionErrors();
		System.out.println(errors);
		return errors;
	}
	
	public String getAdresse() {
		return this.adresse;
	}
	
	public void setAdresse(String newAdresse) {
		this.adresse = newAdresse;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public void setCode(String newCode) {
		this.code=newCode;
	}
	
	public String getVille() {
		return this.ville;
	}
	
	public void setVille(String newVille) {
		this.ville = newVille;
	}
	
	public String getPays() {
		return this.pays;
	}
	
	public void setPays(String newPays) {
		this.pays = newPays;
	}
	
	

}
