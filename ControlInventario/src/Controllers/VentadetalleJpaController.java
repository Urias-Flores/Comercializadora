/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Models.Producto;
import Models.Venta;
import Models.Ventadetalle;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Dell
 */
public class VentadetalleJpaController implements Serializable {

    public VentadetalleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ventadetalle ventadetalle) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto productoID = ventadetalle.getProductoID();
            if (productoID != null) {
                productoID = em.getReference(productoID.getClass(), productoID.getProductoID());
                ventadetalle.setProductoID(productoID);
            }
            Venta compraID = ventadetalle.getCompraID();
            if (compraID != null) {
                compraID = em.getReference(compraID.getClass(), compraID.getVentaID());
                ventadetalle.setCompraID(compraID);
            }
            em.persist(ventadetalle);
            if (productoID != null) {
                productoID.getVentadetalleList().add(ventadetalle);
                productoID = em.merge(productoID);
            }
            if (compraID != null) {
                compraID.getVentadetalleList().add(ventadetalle);
                compraID = em.merge(compraID);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ventadetalle ventadetalle) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ventadetalle persistentVentadetalle = em.find(Ventadetalle.class, ventadetalle.getCompraDetalleID());
            Producto productoIDOld = persistentVentadetalle.getProductoID();
            Producto productoIDNew = ventadetalle.getProductoID();
            Venta compraIDOld = persistentVentadetalle.getCompraID();
            Venta compraIDNew = ventadetalle.getCompraID();
            if (productoIDNew != null) {
                productoIDNew = em.getReference(productoIDNew.getClass(), productoIDNew.getProductoID());
                ventadetalle.setProductoID(productoIDNew);
            }
            if (compraIDNew != null) {
                compraIDNew = em.getReference(compraIDNew.getClass(), compraIDNew.getVentaID());
                ventadetalle.setCompraID(compraIDNew);
            }
            ventadetalle = em.merge(ventadetalle);
            if (productoIDOld != null && !productoIDOld.equals(productoIDNew)) {
                productoIDOld.getVentadetalleList().remove(ventadetalle);
                productoIDOld = em.merge(productoIDOld);
            }
            if (productoIDNew != null && !productoIDNew.equals(productoIDOld)) {
                productoIDNew.getVentadetalleList().add(ventadetalle);
                productoIDNew = em.merge(productoIDNew);
            }
            if (compraIDOld != null && !compraIDOld.equals(compraIDNew)) {
                compraIDOld.getVentadetalleList().remove(ventadetalle);
                compraIDOld = em.merge(compraIDOld);
            }
            if (compraIDNew != null && !compraIDNew.equals(compraIDOld)) {
                compraIDNew.getVentadetalleList().add(ventadetalle);
                compraIDNew = em.merge(compraIDNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ventadetalle.getCompraDetalleID();
                if (findVentadetalle(id) == null) {
                    throw new NonexistentEntityException("The ventadetalle with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ventadetalle ventadetalle;
            try {
                ventadetalle = em.getReference(Ventadetalle.class, id);
                ventadetalle.getCompraDetalleID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ventadetalle with id " + id + " no longer exists.", enfe);
            }
            Producto productoID = ventadetalle.getProductoID();
            if (productoID != null) {
                productoID.getVentadetalleList().remove(ventadetalle);
                productoID = em.merge(productoID);
            }
            Venta compraID = ventadetalle.getCompraID();
            if (compraID != null) {
                compraID.getVentadetalleList().remove(ventadetalle);
                compraID = em.merge(compraID);
            }
            em.remove(ventadetalle);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ventadetalle> findVentadetalleEntities() {
        return findVentadetalleEntities(true, -1, -1);
    }

    public List<Ventadetalle> findVentadetalleEntities(int maxResults, int firstResult) {
        return findVentadetalleEntities(false, maxResults, firstResult);
    }

    private List<Ventadetalle> findVentadetalleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ventadetalle.class));
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

    public Ventadetalle findVentadetalle(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ventadetalle.class, id);
        } finally {
            em.close();
        }
    }

    public int getVentadetalleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ventadetalle> rt = cq.from(Ventadetalle.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
