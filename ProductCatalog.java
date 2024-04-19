import java.util.ArrayList;

public class ProductCatalog {
    //Using an ArrayList due to constant time complexity for adding and removing a product
    //Time Complexity: O(n) where n is the number of products in the array list for the traversal and search methods
    private ArrayList<Product> products;

    public ProductCatalog() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product){
        products.remove(product);
    }

    public ArrayList<String> getProducts() {
        ArrayList<String> productStrings = new ArrayList<>();
        for (Product curr : products) {
            productStrings.add(curr.toString());
        }
        return productStrings;
    }
}
