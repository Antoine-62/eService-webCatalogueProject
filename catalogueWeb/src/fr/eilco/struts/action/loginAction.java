package fr.eilco.struts.action;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.eilco.ejb.gestionClientBeanRemote;
import fr.eilco.model.ClientBean;
import fr.eilco.struts.form.loginForm;

public class loginAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String resultat = null;
		String email = ((loginForm) form).getEmail();
		String pwd = ((loginForm) form).getPassword();
		System.out.println("on regarde si les champs sont rempli");
		
		if(email.equals("")) {
			resultat = "echec";
		}
		else if(pwd.equals("")) {
			resultat = "echec";
		}
		else {
			System.out.println("on regarde si le client existe");
			HttpSession session = request.getSession(true);
			ClientBean client = new ClientBean();
			//ConnexionJNDI (annuairepour localiserl'EJB)

			try{
				final Hashtable jndiProperties= new Hashtable();
				jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
				final Context context= new InitialContext(jndiProperties);
				final String appName= "catalogueWebEAR";
				final String moduleName= "catalogueWebEJB";
				final String beanName= "gestionClientBeanJNDI";
				final String viewClassName=gestionClientBeanRemote.class.getName();
				
				gestionClientBeanRemote remote= (gestionClientBeanRemote) context.lookup("ejb:"+appName+"/"+moduleName+"/"+beanName+"!"+viewClassName);
				client=remote.getClient(email);
				if(client.getEmail().equals("")) {
					resultat = "echec";
					System.out.println("le client n'existe pas dans la bdd");
				}
				else {
					if(client.getPassword().equals(pwd)) {
						resultat = "succes";
						System.out.println("le client existe et bon pwd");
						session.setAttribute("beanUser", client);
					}
					else {
						resultat = "echec";
						System.out.println(client.getPrenom());
						System.out.println(client.getPassword());
						System.out.println(pwd);
						System.out.println("le client existe mais mauvais pwd");
					}
				}
				
				}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return mapping.findForward(resultat);
	}

}
