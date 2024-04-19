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

    public ArrayList<String> getAllProducts() {
        ArrayList<String> productStrings = new ArrayList<>();
        for (Product curr : products) {
            productStrings.add(curr.toString());
        }
        return productStrings;
    }
    public ArrayList<String> searchByDescription(String description) {
        ArrayList<String> matchingProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getDescription().equalsIgnoreCase(description)) {
                matchingProducts.add(product.toString());
            }
        }
        return matchingProducts;
    }

    public ArrayList<String> searchByPriceRange(double minPrice, double maxPrice) {
        ArrayList<String> matchingProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                matchingProducts.add(product.toString());
            }
        }
        return matchingProducts;
    }

    public ArrayList<String> searchByName(String name) {
        ArrayList<String> matchingProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                matchingProducts.add(product.toString());
            }
        }
        return matchingProducts;
    }
}
