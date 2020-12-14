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
import fr.eilco.model.ProduitBean;

/**
 * Servlet implementation class produitEJBservlet
 */
@WebServlet("/produitEJBservlet")
public class produitEJBservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public produitEJBservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		System.out.println("id recup :" + request.getParameter("id"));
		int id = Integer.parseInt(request.getParameter("id"));
		CategorieBean bean = new CategorieBean();
		ArrayList<ProduitBean> produitList = new ArrayList<ProduitBean>();
		//ConnexionJNDI (annuairepour localiserl'EJB)
		System.out.println("bo2");

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
			System.out.print("je suis ici");
			produitList=remote.getListProduits(id);
			//System.out.print("la liste de produit"+produitList.get(1).getNom());
			}
		catch(Exception e) {
			System.out.print("meuh");
			e.printStackTrace();
		}
		//System.out.print("la liste de produit"+bean.getProduits().get(1).getNom());
		System.out.print("prout");
		session.setAttribute("beanCategorie2", produitList);
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
