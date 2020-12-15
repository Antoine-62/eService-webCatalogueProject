package fr.eilco.info;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eilco.ejb.gestionClientBeanRemote;
import fr.eilco.model.ClientBean;
import fr.eilco.model.CommandeClientBean;

/**
 * Servlet implementation class userServlet
 */
@WebServlet("/user")
public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		ArrayList<CommandeClientBean> commandes = new ArrayList<CommandeClientBean>();
		ClientBean client = new ClientBean();
		client = (ClientBean) session.getAttribute("beanUser");
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
			commandes=remote.getCommande(client.getEmail());
			session.setAttribute("beanCommandes", commandes);
			response.sendRedirect("compteUser.jsp");
			
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
