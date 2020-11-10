package fr.eilco.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class accesCatalogueBeanRemote
 */
@Stateless
@LocalBean
public class accesCatalogueBeanRemote implements accesCatalogueBeanRemoteRemote, accesCatalogueBeanRemoteLocal {

    /**
     * Default constructor. 
     */
    public accesCatalogueBeanRemote() {
        // TODO Auto-generated constructor stub
    }

}
