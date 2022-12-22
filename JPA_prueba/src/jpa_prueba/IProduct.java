
package jpa_prueba;

import java.util.List;
import jpa_prueba.Models.Product;

public interface IProduct {
    Product Save(Product p);
    Product Edit(Product p);
    List<Product> List(Product p);
    Product Find(int ID);
}
