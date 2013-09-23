/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.JPA;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author javier
 */
public abstract class AbstractFacade<T> implements Serializable {
       protected  EntityManagerFactory emf = null;
    protected  EntityManager em = null;
    
    
    public AbstractFacade() {
        this.emf = Persistence.createEntityManagerFactory("EjemploPersona-ejbPU");
        em = emf.createEntityManager();
    }


    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    
    public void create(T entity) {
    
        EntityManager em = null;
        try {
            
            em = getEntityManager();
        
            em.getTransaction().begin();
         
            em.persist(entity);
            
            em.getTransaction().commit();
            
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(T entity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
            entity = em.merge(entity);
            
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(T entity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
            em.remove(em.merge(entity));
            
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<T> findAll(Class<T> aClass) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(aClass));
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
   public T find(Class<T> aClass, Long id) {
         em = getEntityManager();
        try {
            
            return em.find(aClass, id);
        } finally {
            em.close();
        }
    }
}
