package fr.eilco.struts.action;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.eilco.ejb.gestionClientBeanRemote;
import fr.eilco.model.ClientBean;
import fr.eilco.model.ProduitBean;
import fr.eilco.struts.form.enregistrementForm;

public class enregistrementAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String resultat = null;
		String nom = ((enregistrementForm) form).getNom();
		String prenom = ((enregistrementForm) form).getPrenom();
		String email = ((enregistrementForm) form).getEmail();
		String phone = ((enregistrementForm) form).getPhone();
		String pwd = ((enregistrementForm) form).getPassword();
		
		if (nom.equals("")) {
			resultat = "echec";
		} 
		else if(prenom.equals("")) {
			resultat = "echec";
		}
		else if(email.equals("")) {
			resultat = "echec";
		}
		else if(phone.equals("")) {
			resultat = "echec";
		}
		else if(pwd.equals("")) {
			resultat = "echec";
		}
		else {
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
				client = remote.getClient(email);
				if(client.getEmail().equals("")) {
					resultat = "succes";
					client=remote.createClient(prenom, nom, email, phone, pwd);
					remote.enregistrementClient(client);
					session.setAttribute("beanUser", client);
				}
				else {
					resultat = "echec";
				}
				
				}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

		return mapping.findForward(resultat);
	}

}
