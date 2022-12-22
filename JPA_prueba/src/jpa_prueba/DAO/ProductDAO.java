
package jpa_prueba.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import jpa_prueba.DataBase.ConectionJPA;
import jpa_prueba.Models.Product;
import jpa_prueba.IProduct;

public class ProductDAO implements IProduct {

    private EntityManager em = null;
    
    @Override
    public Product Save(Product product) {
        em = ConectionJPA.CreateEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
            System.out.print("Almacenado exitosamente");
        } finally {
            ConectionJPA.Disconnect(em);
        }
        return product;
    }

    @Override
    public Product Edit(Product p) {
        return p;
    }

    @Override
    public java.util.List<Product> List(Product p) {
       //List<Product> list = new List();
       return null;
    }

    @Override
    public Product Find(int ID) {
        return null;
    }
    
}
