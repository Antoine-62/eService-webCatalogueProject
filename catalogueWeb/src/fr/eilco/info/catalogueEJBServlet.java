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

import fr.eilco.ejb.accesCatalogueBeanRemote;
import fr.eilco.model.CategorieBean;

/**
 * Servlet implementation class catalogueEJBServlet
 */
@WebServlet("/catalogueEJBServlet")
public class catalogueEJBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public catalogueEJBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String name= "titi";
		String message = "";
		ArrayList<CategorieBean> bean = new ArrayList<CategorieBean>();
		//ConnexionJNDI (annuairepour localiserl'EJB)

		try{
			final Hashtable jndiProperties= new Hashtable();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			final Context context= new InitialContext(jndiProperties);
			final String appName= "catalogueWebEAR";
			final String moduleName= "catalogueWebEJB";//final String distinctName = "";
			//localierejbsurjboss7.2
			//sur jbosse ap n'est plus nécessaire de spécifier distinct name
			final String beanName= "accesCatalogueBeanJNDI";
			final String viewClassName=accesCatalogueBeanRemote.class.getName();//probléme ici
			
			//HelloEJBRemote remote = (HelloEJBRemote) 
			// context.lookup("ejb:"+appName+"/"+moduleName+"/"+
			//"/"+distinctName+"/"+beanName+"!"+viewClassName);
			accesCatalogueBeanRemote remote= (accesCatalogueBeanRemote) context.lookup("ejb:"+appName+"/"+moduleName+"/"+beanName+"!"+viewClassName);
			bean = remote.getListCategories();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("le message est");
		session.setAttribute("beanCategorie", bean);
		response.sendRedirect("categories.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
