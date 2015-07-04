/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.pagos.controllers;

import co.edu.polijic.pagos.controllers.exceptions.NonexistentEntityException;
import co.edu.polijic.pagos.controllers.exceptions.PreexistingEntityException;
import co.edu.polijic.pagos.modelos.RegistroTransaccion;
import co.edu.polijic.pagos.modelos.RegistroTransaccionPK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import co.edu.polijic.pagos.modelos.Transaccion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Natalia
 */
public class RegistroTransaccionJpaController implements Serializable {

    public RegistroTransaccionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RegistroTransaccion registroTransaccion) throws PreexistingEntityException, Exception {
        if (registroTransaccion.getRegistroTransaccionPK() == null) {
            registroTransaccion.setRegistroTransaccionPK(new RegistroTransaccionPK());
        }
        registroTransaccion.getRegistroTransaccionPK().setCdtransaccion(registroTransaccion.getTransaccion().getCdtransaccion());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Transaccion transaccion = registroTransaccion.getTransaccion();
            if (transaccion != null) {
                transaccion = em.getReference(transaccion.getClass(), transaccion.getCdtransaccion());
                registroTransaccion.setTransaccion(transaccion);
            }
            em.persist(registroTransaccion);
            if (transaccion != null) {
                transaccion.getRegistroTransaccionList().add(registroTransaccion);
                transaccion = em.merge(transaccion);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRegistroTransaccion(registroTransaccion.getRegistroTransaccionPK()) != null) {
                throw new PreexistingEntityException("RegistroTransaccion " + registroTransaccion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RegistroTransaccion registroTransaccion) throws NonexistentEntityException, Exception {
        registroTransaccion.getRegistroTransaccionPK().setCdtransaccion(registroTransaccion.getTransaccion().getCdtransaccion());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RegistroTransaccion persistentRegistroTransaccion = em.find(RegistroTransaccion.class, registroTransaccion.getRegistroTransaccionPK());
            Transaccion transaccionOld = persistentRegistroTransaccion.getTransaccion();
            Transaccion transaccionNew = registroTransaccion.getTransaccion();
            if (transaccionNew != null) {
                transaccionNew = em.getReference(transaccionNew.getClass(), transaccionNew.getCdtransaccion());
                registroTransaccion.setTransaccion(transaccionNew);
            }
            registroTransaccion = em.merge(registroTransaccion);
            if (transaccionOld != null && !transaccionOld.equals(transaccionNew)) {
                transaccionOld.getRegistroTransaccionList().remove(registroTransaccion);
                transaccionOld = em.merge(transaccionOld);
            }
            if (transaccionNew != null && !transaccionNew.equals(transaccionOld)) {
                transaccionNew.getRegistroTransaccionList().add(registroTransaccion);
                transaccionNew = em.merge(transaccionNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                RegistroTransaccionPK id = registroTransaccion.getRegistroTransaccionPK();
                if (findRegistroTransaccion(id) == null) {
                    throw new NonexistentEntityException("The registroTransaccion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(RegistroTransaccionPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RegistroTransaccion registroTransaccion;
            try {
                registroTransaccion = em.getReference(RegistroTransaccion.class, id);
                registroTransaccion.getRegistroTransaccionPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The registroTransaccion with id " + id + " no longer exists.", enfe);
            }
            Transaccion transaccion = registroTransaccion.getTransaccion();
            if (transaccion != null) {
                transaccion.getRegistroTransaccionList().remove(registroTransaccion);
                transaccion = em.merge(transaccion);
            }
            em.remove(registroTransaccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RegistroTransaccion> findRegistroTransaccionEntities() {
        return findRegistroTransaccionEntities(true, -1, -1);
    }

    public List<RegistroTransaccion> findRegistroTransaccionEntities(int maxResults, int firstResult) {
        return findRegistroTransaccionEntities(false, maxResults, firstResult);
    }

    private List<RegistroTransaccion> findRegistroTransaccionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RegistroTransaccion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public RegistroTransaccion findRegistroTransaccion(RegistroTransaccionPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RegistroTransaccion.class, id);
        } finally {
            em.close();
        }
    }

    public int getRegistroTransaccionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RegistroTransaccion> rt = cq.from(RegistroTransaccion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
