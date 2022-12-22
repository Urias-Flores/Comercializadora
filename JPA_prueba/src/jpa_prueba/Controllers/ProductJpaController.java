package jpa_prueba.Controllers;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa_prueba.Models.Brand;
import jpa_prueba.Models.Category;
import jpa_prueba.Models.Product;
import jpa_prueba.exceptions.NonexistentEntityException;

public class ProductJpaController implements Serializable {

    public ProductJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Product product) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Brand brandID = product.getBrandID();
            if (brandID != null) {
                brandID = em.getReference(brandID.getClass(), brandID.getBrandID());
                product.setBrandID(brandID);
            }
            Category categoryID = product.getCategoryID();
            if (categoryID != null) {
                categoryID = em.getReference(categoryID.getClass(), categoryID.getCategoryID());
                product.setCategoryID(categoryID);
            }
            em.persist(product);
            if (brandID != null) {
                brandID.getProductCollection().add(product);
                brandID = em.merge(brandID);
            }
            if (categoryID != null) {
                categoryID.getProductCollection().add(product);
                categoryID = em.merge(categoryID);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Product product) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Product persistentProduct = em.find(Product.class, product.getProductID());
            Brand brandIDOld = persistentProduct.getBrandID();
            Brand brandIDNew = product.getBrandID();
            Category categoryIDOld = persistentProduct.getCategoryID();
            Category categoryIDNew = product.getCategoryID();
            if (brandIDNew != null) {
                brandIDNew = em.getReference(brandIDNew.getClass(), brandIDNew.getBrandID());
                product.setBrandID(brandIDNew);
            }
            if (categoryIDNew != null) {
                categoryIDNew = em.getReference(categoryIDNew.getClass(), categoryIDNew.getCategoryID());
                product.setCategoryID(categoryIDNew);
            }
            product = em.merge(product);
            if (brandIDOld != null && !brandIDOld.equals(brandIDNew)) {
                brandIDOld.getProductCollection().remove(product);
                brandIDOld = em.merge(brandIDOld);
            }
            if (brandIDNew != null && !brandIDNew.equals(brandIDOld)) {
                brandIDNew.getProductCollection().add(product);
                brandIDNew = em.merge(brandIDNew);
            }
            if (categoryIDOld != null && !categoryIDOld.equals(categoryIDNew)) {
                categoryIDOld.getProductCollection().remove(product);
                categoryIDOld = em.merge(categoryIDOld);
            }
            if (categoryIDNew != null && !categoryIDNew.equals(categoryIDOld)) {
                categoryIDNew.getProductCollection().add(product);
                categoryIDNew = em.merge(categoryIDNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = product.getProductID();
                if (findProduct(id) == null) {
                    throw new NonexistentEntityException("The product with id " + id + " no longer exists.");
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
            Product product;
            try {
                product = em.getReference(Product.class, id);
                product.getProductID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The product with id " + id + " no longer exists.", enfe);
            }
            Brand brandID = product.getBrandID();
            if (brandID != null) {
                brandID.getProductCollection().remove(product);
                brandID = em.merge(brandID);
            }
            Category categoryID = product.getCategoryID();
            if (categoryID != null) {
                categoryID.getProductCollection().remove(product);
                categoryID = em.merge(categoryID);
            }
            em.remove(product);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Product> findProductEntities() {
        return findProductEntities(true, -1, -1);
    }

    public List<Product> findProductEntities(int maxResults, int firstResult) {
        return findProductEntities(false, maxResults, firstResult);
    }

    private List<Product> findProductEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Product.class));
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

    public Product findProduct(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Product.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Product> rt = cq.from(Product.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
