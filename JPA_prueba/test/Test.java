
import jpa_prueba.DAO.ProductDAO;
import jpa_prueba.IProduct;
import jpa_prueba.Models.Brand;
import jpa_prueba.Models.Category;
import jpa_prueba.Models.Product;

public class Test {
    
    public static void main(String[] args){
        //Instance for save
        IProduct productDAO = new ProductDAO();
        
        //Instance for create object to insert
        Product product = new Product();
        
        //Auxiliar instance for define object
        Brand b = new Brand(1, "Joma");
        Category c = new Category(1, "Utencilios de cocina");
        
        //Editing object to save
        product.setName("Destornillador");
        product.setDescrption("Destornillador tipo estrellas 3.5mm");
        product.setBrandID(b);
        product.setCategoryID(c);
        
        //saving object
        productDAO.Save(product);
    }
    
}
