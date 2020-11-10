package fr.eilco.façade;
import java.util.List;

import javax.persistence.EntityManager;

public abstract class FacadeAbstraite<T> {
	private Class<T> entity;
	
    public FacadeAbstraite(Class<T> entity) {
        this.entity = entity;
    }
    
    protected abstract EntityManager getEntityManager();
    
    public void create(T entity) {
        getEntityManager().persist(entity);
    }
    
    public void update(T entity) {
        getEntityManager().merge(entity);
    }
    
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(this.entity, id);
    }

}
