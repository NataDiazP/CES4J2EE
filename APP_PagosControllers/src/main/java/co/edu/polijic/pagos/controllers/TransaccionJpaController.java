/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.pagos.controllers;

import co.edu.polijic.pagos.controllers.exceptions.IllegalOrphanException;
import co.edu.polijic.pagos.controllers.exceptions.NonexistentEntityException;
import co.edu.polijic.pagos.controllers.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import co.edu.polijic.pagos.modelos.TipoPago;
import co.edu.polijic.pagos.modelos.RegistroTransaccion;
import co.edu.polijic.pagos.modelos.Tarjeta;
import co.edu.polijic.pagos.modelos.Transaccion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author Natalia
 */
public class TransaccionJpaController implements Serializable {

    public TransaccionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean create(Transaccion transaccion) throws PreexistingEntityException, Exception {
        if (transaccion.getRegistroTransaccionList() == null) {
            transaccion.setRegistroTransaccionList(new ArrayList<RegistroTransaccion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
            
            
            TipoPago cdtipopago = transaccion.getCdtipopago();
            if (cdtipopago != null) {
                cdtipopago = em.getReference(cdtipopago.getClass(), cdtipopago.getCdtipopago());
                transaccion.setCdtipopago(cdtipopago);
            }
            List<RegistroTransaccion> attachedRegistroTransaccionList = new ArrayList<RegistroTransaccion>();
            for (RegistroTransaccion registroTransaccionListRegistroTransaccionToAttach : transaccion.getRegistroTransaccionList()) {
                registroTransaccionListRegistroTransaccionToAttach = em.getReference(registroTransaccionListRegistroTransaccionToAttach.getClass(), registroTransaccionListRegistroTransaccionToAttach.getRegistroTransaccionPK());
                attachedRegistroTransaccionList.add(registroTransaccionListRegistroTransaccionToAttach);
            }
            transaccion.setRegistroTransaccionList(attachedRegistroTransaccionList);
            em.persist(transaccion);
            if (cdtipopago != null) {
                cdtipopago.getTransaccionList().add(transaccion);
                cdtipopago = em.merge(cdtipopago);
            }
            for (RegistroTransaccion registroTransaccionListRegistroTransaccion : transaccion.getRegistroTransaccionList()) {
                Transaccion oldTransaccionOfRegistroTransaccionListRegistroTransaccion = registroTransaccionListRegistroTransaccion.getTransaccion();
                registroTransaccionListRegistroTransaccion.setTransaccion(transaccion);
                registroTransaccionListRegistroTransaccion = em.merge(registroTransaccionListRegistroTransaccion);
                if (oldTransaccionOfRegistroTransaccionListRegistroTransaccion != null) {
                    oldTransaccionOfRegistroTransaccionListRegistroTransaccion.getRegistroTransaccionList().remove(registroTransaccionListRegistroTransaccion);
                    oldTransaccionOfRegistroTransaccionListRegistroTransaccion = em.merge(oldTransaccionOfRegistroTransaccionListRegistroTransaccion);
                }
            }
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            if (findTransaccion(transaccion.getCdtransaccion()) != null) {
                throw new PreexistingEntityException("Transaccion " + transaccion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Transaccion transaccion) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Transaccion persistentTransaccion = em.find(Transaccion.class, transaccion.getCdtransaccion());
            TipoPago cdtipopagoOld = persistentTransaccion.getCdtipopago();
            TipoPago cdtipopagoNew = transaccion.getCdtipopago();
            List<RegistroTransaccion> registroTransaccionListOld = persistentTransaccion.getRegistroTransaccionList();
            List<RegistroTransaccion> registroTransaccionListNew = transaccion.getRegistroTransaccionList();
            List<String> illegalOrphanMessages = null;
            for (RegistroTransaccion registroTransaccionListOldRegistroTransaccion : registroTransaccionListOld) {
                if (!registroTransaccionListNew.contains(registroTransaccionListOldRegistroTransaccion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain RegistroTransaccion " + registroTransaccionListOldRegistroTransaccion + " since its transaccion field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (cdtipopagoNew != null) {
                cdtipopagoNew = em.getReference(cdtipopagoNew.getClass(), cdtipopagoNew.getCdtipopago());
                transaccion.setCdtipopago(cdtipopagoNew);
            }
            List<RegistroTransaccion> attachedRegistroTransaccionListNew = new ArrayList<RegistroTransaccion>();
            for (RegistroTransaccion registroTransaccionListNewRegistroTransaccionToAttach : registroTransaccionListNew) {
                registroTransaccionListNewRegistroTransaccionToAttach = em.getReference(registroTransaccionListNewRegistroTransaccionToAttach.getClass(), registroTransaccionListNewRegistroTransaccionToAttach.getRegistroTransaccionPK());
                attachedRegistroTransaccionListNew.add(registroTransaccionListNewRegistroTransaccionToAttach);
            }
            registroTransaccionListNew = attachedRegistroTransaccionListNew;
            transaccion.setRegistroTransaccionList(registroTransaccionListNew);
            transaccion = em.merge(transaccion);
            if (cdtipopagoOld != null && !cdtipopagoOld.equals(cdtipopagoNew)) {
                cdtipopagoOld.getTransaccionList().remove(transaccion);
                cdtipopagoOld = em.merge(cdtipopagoOld);
            }
            if (cdtipopagoNew != null && !cdtipopagoNew.equals(cdtipopagoOld)) {
                cdtipopagoNew.getTransaccionList().add(transaccion);
                cdtipopagoNew = em.merge(cdtipopagoNew);
            }
            for (RegistroTransaccion registroTransaccionListNewRegistroTransaccion : registroTransaccionListNew) {
                if (!registroTransaccionListOld.contains(registroTransaccionListNewRegistroTransaccion)) {
                    Transaccion oldTransaccionOfRegistroTransaccionListNewRegistroTransaccion = registroTransaccionListNewRegistroTransaccion.getTransaccion();
                    registroTransaccionListNewRegistroTransaccion.setTransaccion(transaccion);
                    registroTransaccionListNewRegistroTransaccion = em.merge(registroTransaccionListNewRegistroTransaccion);
                    if (oldTransaccionOfRegistroTransaccionListNewRegistroTransaccion != null && !oldTransaccionOfRegistroTransaccionListNewRegistroTransaccion.equals(transaccion)) {
                        oldTransaccionOfRegistroTransaccionListNewRegistroTransaccion.getRegistroTransaccionList().remove(registroTransaccionListNewRegistroTransaccion);
                        oldTransaccionOfRegistroTransaccionListNewRegistroTransaccion = em.merge(oldTransaccionOfRegistroTransaccionListNewRegistroTransaccion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = transaccion.getCdtransaccion();
                if (findTransaccion(id) == null) {
                    throw new NonexistentEntityException("The transaccion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Transaccion transaccion;
            try {
                transaccion = em.getReference(Transaccion.class, id);
                transaccion.getCdtransaccion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The transaccion with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<RegistroTransaccion> registroTransaccionListOrphanCheck = transaccion.getRegistroTransaccionList();
            for (RegistroTransaccion registroTransaccionListOrphanCheckRegistroTransaccion : registroTransaccionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Transaccion (" + transaccion + ") cannot be destroyed since the RegistroTransaccion " + registroTransaccionListOrphanCheckRegistroTransaccion + " in its registroTransaccionList field has a non-nullable transaccion field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            TipoPago cdtipopago = transaccion.getCdtipopago();
            if (cdtipopago != null) {
                cdtipopago.getTransaccionList().remove(transaccion);
                cdtipopago = em.merge(cdtipopago);
            }
            em.remove(transaccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Transaccion> findTransaccionEntities() {
        return findTransaccionEntities(true, -1, -1);
    }

    public List<Transaccion> findTransaccionEntities(int maxResults, int firstResult) {
        return findTransaccionEntities(false, maxResults, firstResult);
    }

    private List<Transaccion> findTransaccionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Transaccion.class));
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

    public Transaccion findTransaccion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Transaccion.class, id);
        } finally {
            em.close();
        }
    }

    public int getTransaccionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Transaccion> rt = cq.from(Transaccion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Tarjeta> getTransaccionesTarjetaOrigen(int nmtarjeta) {
        EntityManager em = getEntityManager();
        Query q = em.createQuery("SELECT tarj FROM Tarjeta tarj WHERE tarj.nmtarjeta = :nmtarjeta", Tarjeta.class);
        q.setParameter("nmtarjeta", nmtarjeta);
        return q.getResultList();
    }

    public List<Tarjeta> getTransaccionesRealizadasCuentaOrigenCuentaDestino(int nmCuentaOrigen, int nmCuentaDestino) {
        EntityManager em = getEntityManager();
        Query q = em.createQuery("SELECT tarj FROM Tarjeta tarj JOIN FETCH tarj.transaccionList po where po.cdtarjetadestino = :nmtarjetaDestino and tarj.nmtarjeta = :nmtarjetaOrigen", Tarjeta.class);
        q.setParameter("nmtarjetaOrigen", nmCuentaOrigen);
        q.setParameter("nmtarjetaDestino", nmCuentaDestino);
        return q.getResultList();

    }

    public List<Transaccion> getTransaccionByEstado(String estado) {
        List<String> estadoTransaccion = new ArrayList<String>();
        estadoTransaccion.add(estado);
        EntityManager em = getEntityManager();
        Query q = em.createQuery("SELECT c FROM Transaccion c JOIN FETCH c.transacciones po WHERE po.opestado IN :estadoTransaccion");
        q.setParameter("estadoTransaccion", estadoTransaccion);
        return q.getResultList();
    }

    public List<Transaccion> getTransaccionByFecha(Date fecha) {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Transaccion> cq = cb.createQuery(Transaccion.class);
            Root<Transaccion> emp = cq.from(Transaccion.class);
            cq.select(emp).where(cb.equal(emp.get("transacciones").get("fefechatransaccion"), fecha));
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
}
