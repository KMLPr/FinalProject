import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    //Using an ArrayList due to constant time complexity for adding and removing a product
    //Time Complexity: O(n) where n is the number of products in the array list for the traversal and search methods
    private List<Product> products;

    public ProductCatalog() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product){
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
