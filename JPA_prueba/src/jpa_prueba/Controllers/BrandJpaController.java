package jpa_prueba.Controllers;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa_prueba.Models.Product;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa_prueba.Models.Brand;
import jpa_prueba.exceptions.IllegalOrphanException;
import jpa_prueba.exceptions.NonexistentEntityException;

/**
 *
 * @author Dell
 */
public class BrandJpaController implements Serializable {

    public BrandJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Brand brand) {
        if (brand.getProductCollection() == null) {
            brand.setProductCollection(new ArrayList<Product>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Product> attachedProductCollection = new ArrayList<Product>();
            for (Product productCollectionProductToAttach : brand.getProductCollection()) {
                productCollectionProductToAttach = em.getReference(productCollectionProductToAttach.getClass(), productCollectionProductToAttach.getProductID());
                attachedProductCollection.add(productCollectionProductToAttach);
            }
            brand.setProductCollection(attachedProductCollection);
            em.persist(brand);
            for (Product productCollectionProduct : brand.getProductCollection()) {
                Brand oldBrandIDOfProductCollectionProduct = productCollectionProduct.getBrandID();
                productCollectionProduct.setBrandID(brand);
                productCollectionProduct = em.merge(productCollectionProduct);
                if (oldBrandIDOfProductCollectionProduct != null) {
                    oldBrandIDOfProductCollectionProduct.getProductCollection().remove(productCollectionProduct);
                    oldBrandIDOfProductCollectionProduct = em.merge(oldBrandIDOfProductCollectionProduct);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Brand brand) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Brand persistentBrand = em.find(Brand.class, brand.getBrandID());
            Collection<Product> productCollectionOld = persistentBrand.getProductCollection();
            Collection<Product> productCollectionNew = brand.getProductCollection();
            List<String> illegalOrphanMessages = null;
            for (Product productCollectionOldProduct : productCollectionOld) {
                if (!productCollectionNew.contains(productCollectionOldProduct)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Product " + productCollectionOldProduct + " since its brandID field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Product> attachedProductCollectionNew = new ArrayList<Product>();
            for (Product productCollectionNewProductToAttach : productCollectionNew) {
                productCollectionNewProductToAttach = em.getReference(productCollectionNewProductToAttach.getClass(), productCollectionNewProductToAttach.getProductID());
                attachedProductCollectionNew.add(productCollectionNewProductToAttach);
            }
            productCollectionNew = attachedProductCollectionNew;
            brand.setProductCollection(productCollectionNew);
            brand = em.merge(brand);
            for (Product productCollectionNewProduct : productCollectionNew) {
                if (!productCollectionOld.contains(productCollectionNewProduct)) {
                    Brand oldBrandIDOfProductCollectionNewProduct = productCollectionNewProduct.getBrandID();
                    productCollectionNewProduct.setBrandID(brand);
                    productCollectionNewProduct = em.merge(productCollectionNewProduct);
                    if (oldBrandIDOfProductCollectionNewProduct != null && !oldBrandIDOfProductCollectionNewProduct.equals(brand)) {
                        oldBrandIDOfProductCollectionNewProduct.getProductCollection().remove(productCollectionNewProduct);
                        oldBrandIDOfProductCollectionNewProduct = em.merge(oldBrandIDOfProductCollectionNewProduct);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = brand.getBrandID();
                if (findBrand(id) == null) {
                    throw new NonexistentEntityException("The brand with id " + id + " no longer exists.");
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
            Brand brand;
            try {
                brand = em.getReference(Brand.class, id);
                brand.getBrandID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The brand with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Product> productCollectionOrphanCheck = brand.getProductCollection();
            for (Product productCollectionOrphanCheckProduct : productCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Brand (" + brand + ") cannot be destroyed since the Product " + productCollectionOrphanCheckProduct + " in its productCollection field has a non-nullable brandID field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(brand);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Brand> findBrandEntities() {
        return findBrandEntities(true, -1, -1);
    }

    public List<Brand> findBrandEntities(int maxResults, int firstResult) {
        return findBrandEntities(false, maxResults, firstResult);
    }

    private List<Brand> findBrandEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Brand.class));
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

    public Brand findBrand(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Brand.class, id);
        } finally {
            em.close();
        }
    }

    public int getBrandCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Brand> rt = cq.from(Brand.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
