package fr.eilco.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class loginForm extends ActionForm{
	private String email;
	private String password;
	
	public void reset(ActionMapping mapping, HttpServletRequest request){
		this.email="";
		this.password="";
	}
	
	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request ){
		ActionErrors errors = new ActionErrors();
		/*if ((email == null) || (email.length() == 0))
		      errors.add("nomUtilisateur", new ActionErrors("erreur.nomutilisateur.obligatoire"));

		    if ((password == null) || (password.length() == 0))
		      errors.add("mdpUtilisateur", new ActionError("erreur.mdputilisateur.obligatoire"));*/
		return errors;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
}
