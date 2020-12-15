package fr.eilco.struts.action;

import java.util.ArrayList;
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
import fr.eilco.ejb.gestionCommandeBeanRemote;
import fr.eilco.model.ClientBean;
import fr.eilco.model.CommandeClientBean;
import fr.eilco.model.ProduitBean;
import fr.eilco.struts.form.validationForm;

public class validationAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String resultat = null;
		String adresse = ((validationForm) form).getAdresse();
		String codepost = ((validationForm) form).getCode();
		String ville = ((validationForm) form).getVille();
		String pays = ((validationForm) form).getPays();

		if (adresse.equals("")) {
			resultat = "echec";
		} 
		else if(codepost.equals("")) {
			resultat = "echec";
		}
		else if(ville.equals("")) {
			resultat = "echec";
		}
		else if(pays.equals("")) {
			resultat = "echec";
		}
		else {
			resultat = "succes";
			HttpSession session = request.getSession(true);
			CommandeClientBean command = new CommandeClientBean();
			ArrayList<ProduitBean> produitList = (ArrayList<ProduitBean>) session.getAttribute("MonPanier");
			//ConnexionJNDI (annuairepour localiserl'EJB)

			try{
				final Hashtable jndiProperties= new Hashtable();
				jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
				final Context context= new InitialContext(jndiProperties);
				final String appName= "catalogueWebEAR";
				final String moduleName= "catalogueWebEJB";
				final String beanName= "gestionCommandeBeanJNDI";
				final String viewClassName=gestionCommandeBeanRemote.class.getName();
				
				gestionCommandeBeanRemote remote= (gestionCommandeBeanRemote) context.lookup("ejb:"+appName+"/"+moduleName+"/"+beanName+"!"+viewClassName);
				command=remote.createCommande(produitList);
				ClientBean client = (ClientBean) session.getAttribute("beanUser");
				command.setEmail(client.getEmail());
				remote.validerCommande(command, adresse, codepost, ville, pays, client);
				session.removeAttribute("MonPanier");
				}
			catch(Exception e) {
				e.printStackTrace();
			}
			session.setAttribute("beanCommand", command);
		}

		return mapping.findForward(resultat);
}

}
