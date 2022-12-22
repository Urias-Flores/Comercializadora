/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Controllers.exceptions.IllegalOrphanException;
import Controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Models.Cliente;
import Models.Usuario;
import Models.Venta;
import Models.Ventadetalle;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Dell
 */
public class VentaJpaController implements Serializable {

    public VentaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Venta venta) {
        if (venta.getVentadetalleList() == null) {
            venta.setVentadetalleList(new ArrayList<Ventadetalle>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente clienteID = venta.getClienteID();
            if (clienteID != null) {
                clienteID = em.getReference(clienteID.getClass(), clienteID.getClienteID());
                venta.setClienteID(clienteID);
            }
            Usuario usuarioID = venta.getUsuarioID();
            if (usuarioID != null) {
                usuarioID = em.getReference(usuarioID.getClass(), usuarioID.getUsuarioID());
                venta.setUsuarioID(usuarioID);
            }
            List<Ventadetalle> attachedVentadetalleList = new ArrayList<Ventadetalle>();
            for (Ventadetalle ventadetalleListVentadetalleToAttach : venta.getVentadetalleList()) {
                ventadetalleListVentadetalleToAttach = em.getReference(ventadetalleListVentadetalleToAttach.getClass(), ventadetalleListVentadetalleToAttach.getCompraDetalleID());
                attachedVentadetalleList.add(ventadetalleListVentadetalleToAttach);
            }
            venta.setVentadetalleList(attachedVentadetalleList);
            em.persist(venta);
            if (clienteID != null) {
                clienteID.getVentaList().add(venta);
                clienteID = em.merge(clienteID);
            }
            if (usuarioID != null) {
                usuarioID.getVentaList().add(venta);
                usuarioID = em.merge(usuarioID);
            }
            for (Ventadetalle ventadetalleListVentadetalle : venta.getVentadetalleList()) {
                Venta oldCompraIDOfVentadetalleListVentadetalle = ventadetalleListVentadetalle.getCompraID();
                ventadetalleListVentadetalle.setCompraID(venta);
                ventadetalleListVentadetalle = em.merge(ventadetalleListVentadetalle);
                if (oldCompraIDOfVentadetalleListVentadetalle != null) {
                    oldCompraIDOfVentadetalleListVentadetalle.getVentadetalleList().remove(ventadetalleListVentadetalle);
                    oldCompraIDOfVentadetalleListVentadetalle = em.merge(oldCompraIDOfVentadetalleListVentadetalle);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Venta venta) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venta persistentVenta = em.find(Venta.class, venta.getVentaID());
            Cliente clienteIDOld = persistentVenta.getClienteID();
            Cliente clienteIDNew = venta.getClienteID();
            Usuario usuarioIDOld = persistentVenta.getUsuarioID();
            Usuario usuarioIDNew = venta.getUsuarioID();
            List<Ventadetalle> ventadetalleListOld = persistentVenta.getVentadetalleList();
            List<Ventadetalle> ventadetalleListNew = venta.getVentadetalleList();
            List<String> illegalOrphanMessages = null;
            for (Ventadetalle ventadetalleListOldVentadetalle : ventadetalleListOld) {
                if (!ventadetalleListNew.contains(ventadetalleListOldVentadetalle)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ventadetalle " + ventadetalleListOldVentadetalle + " since its compraID field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (clienteIDNew != null) {
                clienteIDNew = em.getReference(clienteIDNew.getClass(), clienteIDNew.getClienteID());
                venta.setClienteID(clienteIDNew);
            }
            if (usuarioIDNew != null) {
                usuarioIDNew = em.getReference(usuarioIDNew.getClass(), usuarioIDNew.getUsuarioID());
                venta.setUsuarioID(usuarioIDNew);
            }
            List<Ventadetalle> attachedVentadetalleListNew = new ArrayList<Ventadetalle>();
            for (Ventadetalle ventadetalleListNewVentadetalleToAttach : ventadetalleListNew) {
                ventadetalleListNewVentadetalleToAttach = em.getReference(ventadetalleListNewVentadetalleToAttach.getClass(), ventadetalleListNewVentadetalleToAttach.getCompraDetalleID());
                attachedVentadetalleListNew.add(ventadetalleListNewVentadetalleToAttach);
            }
            ventadetalleListNew = attachedVentadetalleListNew;
            venta.setVentadetalleList(ventadetalleListNew);
            venta = em.merge(venta);
            if (clienteIDOld != null && !clienteIDOld.equals(clienteIDNew)) {
                clienteIDOld.getVentaList().remove(venta);
                clienteIDOld = em.merge(clienteIDOld);
            }
            if (clienteIDNew != null && !clienteIDNew.equals(clienteIDOld)) {
                clienteIDNew.getVentaList().add(venta);
                clienteIDNew = em.merge(clienteIDNew);
            }
            if (usuarioIDOld != null && !usuarioIDOld.equals(usuarioIDNew)) {
                usuarioIDOld.getVentaList().remove(venta);
                usuarioIDOld = em.merge(usuarioIDOld);
            }
            if (usuarioIDNew != null && !usuarioIDNew.equals(usuarioIDOld)) {
                usuarioIDNew.getVentaList().add(venta);
                usuarioIDNew = em.merge(usuarioIDNew);
            }
            for (Ventadetalle ventadetalleListNewVentadetalle : ventadetalleListNew) {
                if (!ventadetalleListOld.contains(ventadetalleListNewVentadetalle)) {
                    Venta oldCompraIDOfVentadetalleListNewVentadetalle = ventadetalleListNewVentadetalle.getCompraID();
                    ventadetalleListNewVentadetalle.setCompraID(venta);
                    ventadetalleListNewVentadetalle = em.merge(ventadetalleListNewVentadetalle);
                    if (oldCompraIDOfVentadetalleListNewVentadetalle != null && !oldCompraIDOfVentadetalleListNewVentadetalle.equals(venta)) {
                        oldCompraIDOfVentadetalleListNewVentadetalle.getVentadetalleList().remove(ventadetalleListNewVentadetalle);
                        oldCompraIDOfVentadetalleListNewVentadetalle = em.merge(oldCompraIDOfVentadetalleListNewVentadetalle);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = venta.getVentaID();
                if (findVenta(id) == null) {
                    throw new NonexistentEntityException("The venta with id " + id + " no longer exists.");
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
            Venta venta;
            try {
                venta = em.getReference(Venta.class, id);
                venta.getVentaID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The venta with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Ventadetalle> ventadetalleListOrphanCheck = venta.getVentadetalleList();
            for (Ventadetalle ventadetalleListOrphanCheckVentadetalle : ventadetalleListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Venta (" + venta + ") cannot be destroyed since the Ventadetalle " + ventadetalleListOrphanCheckVentadetalle + " in its ventadetalleList field has a non-nullable compraID field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cliente clienteID = venta.getClienteID();
            if (clienteID != null) {
                clienteID.getVentaList().remove(venta);
                clienteID = em.merge(clienteID);
            }
            Usuario usuarioID = venta.getUsuarioID();
            if (usuarioID != null) {
                usuarioID.getVentaList().remove(venta);
                usuarioID = em.merge(usuarioID);
            }
            em.remove(venta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Venta> findVentaEntities() {
        return findVentaEntities(true, -1, -1);
    }

    public List<Venta> findVentaEntities(int maxResults, int firstResult) {
        return findVentaEntities(false, maxResults, firstResult);
    }

    private List<Venta> findVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Venta.class));
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

    public Venta findVenta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Venta.class, id);
        } finally {
            em.close();
        }
    }

    public int getVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Venta> rt = cq.from(Venta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}