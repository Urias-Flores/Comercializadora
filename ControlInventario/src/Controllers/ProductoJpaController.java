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
import Models.Categoria;
import Models.Marca;
import Models.Compradetalle;
import java.util.ArrayList;
import java.util.List;
import Models.Ventadetalle;
import Models.Inventario;
import Models.Producto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Dell
 */
public class ProductoJpaController implements Serializable {

    public ProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producto producto) {
        if (producto.getCompradetalleList() == null) {
            producto.setCompradetalleList(new ArrayList<Compradetalle>());
        }
        if (producto.getVentadetalleList() == null) {
            producto.setVentadetalleList(new ArrayList<Ventadetalle>());
        }
        if (producto.getInventarioList() == null) {
            producto.setInventarioList(new ArrayList<Inventario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria categoriaID = producto.getCategoriaID();
            if (categoriaID != null) {
                categoriaID = em.getReference(categoriaID.getClass(), categoriaID.getCategoriaID());
                producto.setCategoriaID(categoriaID);
            }
            Marca marcaID = producto.getMarcaID();
            if (marcaID != null) {
                marcaID = em.getReference(marcaID.getClass(), marcaID.getMarcaID());
                producto.setMarcaID(marcaID);
            }
            List<Compradetalle> attachedCompradetalleList = new ArrayList<Compradetalle>();
            for (Compradetalle compradetalleListCompradetalleToAttach : producto.getCompradetalleList()) {
                compradetalleListCompradetalleToAttach = em.getReference(compradetalleListCompradetalleToAttach.getClass(), compradetalleListCompradetalleToAttach.getCompraDetalleID());
                attachedCompradetalleList.add(compradetalleListCompradetalleToAttach);
            }
            producto.setCompradetalleList(attachedCompradetalleList);
            List<Ventadetalle> attachedVentadetalleList = new ArrayList<Ventadetalle>();
            for (Ventadetalle ventadetalleListVentadetalleToAttach : producto.getVentadetalleList()) {
                ventadetalleListVentadetalleToAttach = em.getReference(ventadetalleListVentadetalleToAttach.getClass(), ventadetalleListVentadetalleToAttach.getCompraDetalleID());
                attachedVentadetalleList.add(ventadetalleListVentadetalleToAttach);
            }
            producto.setVentadetalleList(attachedVentadetalleList);
            List<Inventario> attachedInventarioList = new ArrayList<Inventario>();
            for (Inventario inventarioListInventarioToAttach : producto.getInventarioList()) {
                inventarioListInventarioToAttach = em.getReference(inventarioListInventarioToAttach.getClass(), inventarioListInventarioToAttach.getInventarioID());
                attachedInventarioList.add(inventarioListInventarioToAttach);
            }
            producto.setInventarioList(attachedInventarioList);
            em.persist(producto);
            if (categoriaID != null) {
                categoriaID.getProductoList().add(producto);
                categoriaID = em.merge(categoriaID);
            }
            if (marcaID != null) {
                marcaID.getProductoList().add(producto);
                marcaID = em.merge(marcaID);
            }
            for (Compradetalle compradetalleListCompradetalle : producto.getCompradetalleList()) {
                Producto oldProductoIDOfCompradetalleListCompradetalle = compradetalleListCompradetalle.getProductoID();
                compradetalleListCompradetalle.setProductoID(producto);
                compradetalleListCompradetalle = em.merge(compradetalleListCompradetalle);
                if (oldProductoIDOfCompradetalleListCompradetalle != null) {
                    oldProductoIDOfCompradetalleListCompradetalle.getCompradetalleList().remove(compradetalleListCompradetalle);
                    oldProductoIDOfCompradetalleListCompradetalle = em.merge(oldProductoIDOfCompradetalleListCompradetalle);
                }
            }
            for (Ventadetalle ventadetalleListVentadetalle : producto.getVentadetalleList()) {
                Producto oldProductoIDOfVentadetalleListVentadetalle = ventadetalleListVentadetalle.getProductoID();
                ventadetalleListVentadetalle.setProductoID(producto);
                ventadetalleListVentadetalle = em.merge(ventadetalleListVentadetalle);
                if (oldProductoIDOfVentadetalleListVentadetalle != null) {
                    oldProductoIDOfVentadetalleListVentadetalle.getVentadetalleList().remove(ventadetalleListVentadetalle);
                    oldProductoIDOfVentadetalleListVentadetalle = em.merge(oldProductoIDOfVentadetalleListVentadetalle);
                }
            }
            for (Inventario inventarioListInventario : producto.getInventarioList()) {
                Producto oldProductoIDOfInventarioListInventario = inventarioListInventario.getProductoID();
                inventarioListInventario.setProductoID(producto);
                inventarioListInventario = em.merge(inventarioListInventario);
                if (oldProductoIDOfInventarioListInventario != null) {
                    oldProductoIDOfInventarioListInventario.getInventarioList().remove(inventarioListInventario);
                    oldProductoIDOfInventarioListInventario = em.merge(oldProductoIDOfInventarioListInventario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producto producto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto persistentProducto = em.find(Producto.class, producto.getProductoID());
            Categoria categoriaIDOld = persistentProducto.getCategoriaID();
            Categoria categoriaIDNew = producto.getCategoriaID();
            Marca marcaIDOld = persistentProducto.getMarcaID();
            Marca marcaIDNew = producto.getMarcaID();
            List<Compradetalle> compradetalleListOld = persistentProducto.getCompradetalleList();
            List<Compradetalle> compradetalleListNew = producto.getCompradetalleList();
            List<Ventadetalle> ventadetalleListOld = persistentProducto.getVentadetalleList();
            List<Ventadetalle> ventadetalleListNew = producto.getVentadetalleList();
            List<Inventario> inventarioListOld = persistentProducto.getInventarioList();
            List<Inventario> inventarioListNew = producto.getInventarioList();
            List<String> illegalOrphanMessages = null;
            for (Compradetalle compradetalleListOldCompradetalle : compradetalleListOld) {
                if (!compradetalleListNew.contains(compradetalleListOldCompradetalle)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Compradetalle " + compradetalleListOldCompradetalle + " since its productoID field is not nullable.");
                }
            }
            for (Ventadetalle ventadetalleListOldVentadetalle : ventadetalleListOld) {
                if (!ventadetalleListNew.contains(ventadetalleListOldVentadetalle)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ventadetalle " + ventadetalleListOldVentadetalle + " since its productoID field is not nullable.");
                }
            }
            for (Inventario inventarioListOldInventario : inventarioListOld) {
                if (!inventarioListNew.contains(inventarioListOldInventario)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Inventario " + inventarioListOldInventario + " since its productoID field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (categoriaIDNew != null) {
                categoriaIDNew = em.getReference(categoriaIDNew.getClass(), categoriaIDNew.getCategoriaID());
                producto.setCategoriaID(categoriaIDNew);
            }
            if (marcaIDNew != null) {
                marcaIDNew = em.getReference(marcaIDNew.getClass(), marcaIDNew.getMarcaID());
                producto.setMarcaID(marcaIDNew);
            }
            List<Compradetalle> attachedCompradetalleListNew = new ArrayList<Compradetalle>();
            for (Compradetalle compradetalleListNewCompradetalleToAttach : compradetalleListNew) {
                compradetalleListNewCompradetalleToAttach = em.getReference(compradetalleListNewCompradetalleToAttach.getClass(), compradetalleListNewCompradetalleToAttach.getCompraDetalleID());
                attachedCompradetalleListNew.add(compradetalleListNewCompradetalleToAttach);
            }
            compradetalleListNew = attachedCompradetalleListNew;
            producto.setCompradetalleList(compradetalleListNew);
            List<Ventadetalle> attachedVentadetalleListNew = new ArrayList<Ventadetalle>();
            for (Ventadetalle ventadetalleListNewVentadetalleToAttach : ventadetalleListNew) {
                ventadetalleListNewVentadetalleToAttach = em.getReference(ventadetalleListNewVentadetalleToAttach.getClass(), ventadetalleListNewVentadetalleToAttach.getCompraDetalleID());
                attachedVentadetalleListNew.add(ventadetalleListNewVentadetalleToAttach);
            }
            ventadetalleListNew = attachedVentadetalleListNew;
            producto.setVentadetalleList(ventadetalleListNew);
            List<Inventario> attachedInventarioListNew = new ArrayList<Inventario>();
            for (Inventario inventarioListNewInventarioToAttach : inventarioListNew) {
                inventarioListNewInventarioToAttach = em.getReference(inventarioListNewInventarioToAttach.getClass(), inventarioListNewInventarioToAttach.getInventarioID());
                attachedInventarioListNew.add(inventarioListNewInventarioToAttach);
            }
            inventarioListNew = attachedInventarioListNew;
            producto.setInventarioList(inventarioListNew);
            producto = em.merge(producto);
            if (categoriaIDOld != null && !categoriaIDOld.equals(categoriaIDNew)) {
                categoriaIDOld.getProductoList().remove(producto);
                categoriaIDOld = em.merge(categoriaIDOld);
            }
            if (categoriaIDNew != null && !categoriaIDNew.equals(categoriaIDOld)) {
                categoriaIDNew.getProductoList().add(producto);
                categoriaIDNew = em.merge(categoriaIDNew);
            }
            if (marcaIDOld != null && !marcaIDOld.equals(marcaIDNew)) {
                marcaIDOld.getProductoList().remove(producto);
                marcaIDOld = em.merge(marcaIDOld);
            }
            if (marcaIDNew != null && !marcaIDNew.equals(marcaIDOld)) {
                marcaIDNew.getProductoList().add(producto);
                marcaIDNew = em.merge(marcaIDNew);
            }
            for (Compradetalle compradetalleListNewCompradetalle : compradetalleListNew) {
                if (!compradetalleListOld.contains(compradetalleListNewCompradetalle)) {
                    Producto oldProductoIDOfCompradetalleListNewCompradetalle = compradetalleListNewCompradetalle.getProductoID();
                    compradetalleListNewCompradetalle.setProductoID(producto);
                    compradetalleListNewCompradetalle = em.merge(compradetalleListNewCompradetalle);
                    if (oldProductoIDOfCompradetalleListNewCompradetalle != null && !oldProductoIDOfCompradetalleListNewCompradetalle.equals(producto)) {
                        oldProductoIDOfCompradetalleListNewCompradetalle.getCompradetalleList().remove(compradetalleListNewCompradetalle);
                        oldProductoIDOfCompradetalleListNewCompradetalle = em.merge(oldProductoIDOfCompradetalleListNewCompradetalle);
                    }
                }
            }
            for (Ventadetalle ventadetalleListNewVentadetalle : ventadetalleListNew) {
                if (!ventadetalleListOld.contains(ventadetalleListNewVentadetalle)) {
                    Producto oldProductoIDOfVentadetalleListNewVentadetalle = ventadetalleListNewVentadetalle.getProductoID();
                    ventadetalleListNewVentadetalle.setProductoID(producto);
                    ventadetalleListNewVentadetalle = em.merge(ventadetalleListNewVentadetalle);
                    if (oldProductoIDOfVentadetalleListNewVentadetalle != null && !oldProductoIDOfVentadetalleListNewVentadetalle.equals(producto)) {
                        oldProductoIDOfVentadetalleListNewVentadetalle.getVentadetalleList().remove(ventadetalleListNewVentadetalle);
                        oldProductoIDOfVentadetalleListNewVentadetalle = em.merge(oldProductoIDOfVentadetalleListNewVentadetalle);
                    }
                }
            }
            for (Inventario inventarioListNewInventario : inventarioListNew) {
                if (!inventarioListOld.contains(inventarioListNewInventario)) {
                    Producto oldProductoIDOfInventarioListNewInventario = inventarioListNewInventario.getProductoID();
                    inventarioListNewInventario.setProductoID(producto);
                    inventarioListNewInventario = em.merge(inventarioListNewInventario);
                    if (oldProductoIDOfInventarioListNewInventario != null && !oldProductoIDOfInventarioListNewInventario.equals(producto)) {
                        oldProductoIDOfInventarioListNewInventario.getInventarioList().remove(inventarioListNewInventario);
                        oldProductoIDOfInventarioListNewInventario = em.merge(oldProductoIDOfInventarioListNewInventario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = producto.getProductoID();
                if (findProducto(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
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
            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getProductoID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Compradetalle> compradetalleListOrphanCheck = producto.getCompradetalleList();
            for (Compradetalle compradetalleListOrphanCheckCompradetalle : compradetalleListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the Compradetalle " + compradetalleListOrphanCheckCompradetalle + " in its compradetalleList field has a non-nullable productoID field.");
            }
            List<Ventadetalle> ventadetalleListOrphanCheck = producto.getVentadetalleList();
            for (Ventadetalle ventadetalleListOrphanCheckVentadetalle : ventadetalleListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the Ventadetalle " + ventadetalleListOrphanCheckVentadetalle + " in its ventadetalleList field has a non-nullable productoID field.");
            }
            List<Inventario> inventarioListOrphanCheck = producto.getInventarioList();
            for (Inventario inventarioListOrphanCheckInventario : inventarioListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the Inventario " + inventarioListOrphanCheckInventario + " in its inventarioList field has a non-nullable productoID field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Categoria categoriaID = producto.getCategoriaID();
            if (categoriaID != null) {
                categoriaID.getProductoList().remove(producto);
                categoriaID = em.merge(categoriaID);
            }
            Marca marcaID = producto.getMarcaID();
            if (marcaID != null) {
                marcaID.getProductoList().remove(producto);
                marcaID = em.merge(marcaID);
            }
            em.remove(producto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producto> findProductoEntities() {
        return findProductoEntities(true, -1, -1);
    }

    public List<Producto> findProductoEntities(int maxResults, int firstResult) {
        return findProductoEntities(false, maxResults, firstResult);
    }

    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto.class));
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

    public Producto findProducto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}