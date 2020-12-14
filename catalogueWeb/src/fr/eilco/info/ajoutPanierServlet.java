package fr.eilco.info;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eilco.model.ProduitBean;

/**
 * Servlet implementation class ajoutPanierServlet
 */
@WebServlet("/ajoutPanierServlet")
public class ajoutPanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajoutPanierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idProduit = Integer.parseInt(request.getParameter("id").trim());
		HttpSession session = request.getSession(true);
		ProduitBean selectedProduct = new ProduitBean();
		ArrayList<ProduitBean> categorieProduit = (ArrayList<ProduitBean>) session.getAttribute("beanCategorie2");
		ArrayList<ProduitBean> produitList = (ArrayList<ProduitBean>) session.getAttribute("MonPanier");
		if(produitList == null) {
			produitList = new ArrayList<ProduitBean>();
		}
		for(ProduitBean prod : categorieProduit) {
	        if(prod.getId() == idProduit) {
	        	produitList.add(prod); 
	        }
	    }
		session.setAttribute("MonPanier", produitList);
		response.setContentType("text/plain");
		response.getWriter().write("mission accompli");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
