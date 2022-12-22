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
import Models.Empleado;
import Models.Compra;
import Models.Usuario;
import java.util.ArrayList;
import java.util.List;
import Models.Venta;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Dell
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        if (usuario.getCompraList() == null) {
            usuario.setCompraList(new ArrayList<Compra>());
        }
        if (usuario.getVentaList() == null) {
            usuario.setVentaList(new ArrayList<Venta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado empleadoID = usuario.getEmpleadoID();
            if (empleadoID != null) {
                empleadoID = em.getReference(empleadoID.getClass(), empleadoID.getEmpleadoID());
                usuario.setEmpleadoID(empleadoID);
            }
            List<Compra> attachedCompraList = new ArrayList<Compra>();
            for (Compra compraListCompraToAttach : usuario.getCompraList()) {
                compraListCompraToAttach = em.getReference(compraListCompraToAttach.getClass(), compraListCompraToAttach.getCompraID());
                attachedCompraList.add(compraListCompraToAttach);
            }
            usuario.setCompraList(attachedCompraList);
            List<Venta> attachedVentaList = new ArrayList<Venta>();
            for (Venta ventaListVentaToAttach : usuario.getVentaList()) {
                ventaListVentaToAttach = em.getReference(ventaListVentaToAttach.getClass(), ventaListVentaToAttach.getVentaID());
                attachedVentaList.add(ventaListVentaToAttach);
            }
            usuario.setVentaList(attachedVentaList);
            em.persist(usuario);
            if (empleadoID != null) {
                empleadoID.getUsuarioList().add(usuario);
                empleadoID = em.merge(empleadoID);
            }
            for (Compra compraListCompra : usuario.getCompraList()) {
                Usuario oldUsuarioIDOfCompraListCompra = compraListCompra.getUsuarioID();
                compraListCompra.setUsuarioID(usuario);
                compraListCompra = em.merge(compraListCompra);
                if (oldUsuarioIDOfCompraListCompra != null) {
                    oldUsuarioIDOfCompraListCompra.getCompraList().remove(compraListCompra);
                    oldUsuarioIDOfCompraListCompra = em.merge(oldUsuarioIDOfCompraListCompra);
                }
            }
            for (Venta ventaListVenta : usuario.getVentaList()) {
                Usuario oldUsuarioIDOfVentaListVenta = ventaListVenta.getUsuarioID();
                ventaListVenta.setUsuarioID(usuario);
                ventaListVenta = em.merge(ventaListVenta);
                if (oldUsuarioIDOfVentaListVenta != null) {
                    oldUsuarioIDOfVentaListVenta.getVentaList().remove(ventaListVenta);
                    oldUsuarioIDOfVentaListVenta = em.merge(oldUsuarioIDOfVentaListVenta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getUsuarioID());
            Empleado empleadoIDOld = persistentUsuario.getEmpleadoID();
            Empleado empleadoIDNew = usuario.getEmpleadoID();
            List<Compra> compraListOld = persistentUsuario.getCompraList();
            List<Compra> compraListNew = usuario.getCompraList();
            List<Venta> ventaListOld = persistentUsuario.getVentaList();
            List<Venta> ventaListNew = usuario.getVentaList();
            List<String> illegalOrphanMessages = null;
            for (Compra compraListOldCompra : compraListOld) {
                if (!compraListNew.contains(compraListOldCompra)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Compra " + compraListOldCompra + " since its usuarioID field is not nullable.");
                }
            }
            for (Venta ventaListOldVenta : ventaListOld) {
                if (!ventaListNew.contains(ventaListOldVenta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Venta " + ventaListOldVenta + " since its usuarioID field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (empleadoIDNew != null) {
                empleadoIDNew = em.getReference(empleadoIDNew.getClass(), empleadoIDNew.getEmpleadoID());
                usuario.setEmpleadoID(empleadoIDNew);
            }
            List<Compra> attachedCompraListNew = new ArrayList<Compra>();
            for (Compra compraListNewCompraToAttach : compraListNew) {
                compraListNewCompraToAttach = em.getReference(compraListNewCompraToAttach.getClass(), compraListNewCompraToAttach.getCompraID());
                attachedCompraListNew.add(compraListNewCompraToAttach);
            }
            compraListNew = attachedCompraListNew;
            usuario.setCompraList(compraListNew);
            List<Venta> attachedVentaListNew = new ArrayList<Venta>();
            for (Venta ventaListNewVentaToAttach : ventaListNew) {
                ventaListNewVentaToAttach = em.getReference(ventaListNewVentaToAttach.getClass(), ventaListNewVentaToAttach.getVentaID());
                attachedVentaListNew.add(ventaListNewVentaToAttach);
            }
            ventaListNew = attachedVentaListNew;
            usuario.setVentaList(ventaListNew);
            usuario = em.merge(usuario);
            if (empleadoIDOld != null && !empleadoIDOld.equals(empleadoIDNew)) {
                empleadoIDOld.getUsuarioList().remove(usuario);
                empleadoIDOld = em.merge(empleadoIDOld);
            }
            if (empleadoIDNew != null && !empleadoIDNew.equals(empleadoIDOld)) {
                empleadoIDNew.getUsuarioList().add(usuario);
                empleadoIDNew = em.merge(empleadoIDNew);
            }
            for (Compra compraListNewCompra : compraListNew) {
                if (!compraListOld.contains(compraListNewCompra)) {
                    Usuario oldUsuarioIDOfCompraListNewCompra = compraListNewCompra.getUsuarioID();
                    compraListNewCompra.setUsuarioID(usuario);
                    compraListNewCompra = em.merge(compraListNewCompra);
                    if (oldUsuarioIDOfCompraListNewCompra != null && !oldUsuarioIDOfCompraListNewCompra.equals(usuario)) {
                        oldUsuarioIDOfCompraListNewCompra.getCompraList().remove(compraListNewCompra);
                        oldUsuarioIDOfCompraListNewCompra = em.merge(oldUsuarioIDOfCompraListNewCompra);
                    }
                }
            }
            for (Venta ventaListNewVenta : ventaListNew) {
                if (!ventaListOld.contains(ventaListNewVenta)) {
                    Usuario oldUsuarioIDOfVentaListNewVenta = ventaListNewVenta.getUsuarioID();
                    ventaListNewVenta.setUsuarioID(usuario);
                    ventaListNewVenta = em.merge(ventaListNewVenta);
                    if (oldUsuarioIDOfVentaListNewVenta != null && !oldUsuarioIDOfVentaListNewVenta.equals(usuario)) {
                        oldUsuarioIDOfVentaListNewVenta.getVentaList().remove(ventaListNewVenta);
                        oldUsuarioIDOfVentaListNewVenta = em.merge(oldUsuarioIDOfVentaListNewVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuario.getUsuarioID();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getUsuarioID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Compra> compraListOrphanCheck = usuario.getCompraList();
            for (Compra compraListOrphanCheckCompra : compraListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Compra " + compraListOrphanCheckCompra + " in its compraList field has a non-nullable usuarioID field.");
            }
            List<Venta> ventaListOrphanCheck = usuario.getVentaList();
            for (Venta ventaListOrphanCheckVenta : ventaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Venta " + ventaListOrphanCheckVenta + " in its ventaList field has a non-nullable usuarioID field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Empleado empleadoID = usuario.getEmpleadoID();
            if (empleadoID != null) {
                empleadoID.getUsuarioList().remove(usuario);
                empleadoID = em.merge(empleadoID);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
