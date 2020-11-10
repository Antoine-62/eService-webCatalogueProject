package fr.eilco.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class gestionCommandeBean
 */
@Stateless
@LocalBean
public class gestionCommandeBean implements gestionCommandeBeanRemote, gestionCommandeBeanLocal {

    /**
     * Default constructor. 
     */
    public gestionCommandeBean() {
        // TODO Auto-generated constructor stub
    }

}
