import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> products;
    private ProductCatalog productCatalog;

    public ShoppingCart(ProductCatalog productCatalog) {
        this.products = new ArrayList<>();
        this.productCatalog = productCatalog;
    }
    public ShoppingCart(){
        this.products = new ArrayList<>();
        this.productCatalog = new ProductCatalog();
    }

    public void addProduct(String productName) {
        // Find the product in the catalog and add it to the cart
        ArrayList<Product> catalogProducts = productCatalog.getProducts();
        for (Product product : catalogProducts) {
            if (product.getName().equalsIgnoreCase(productName)) {
                products.add(product);
                return; // Product found and added, exit loop
            }
        }
        // Product not found in the catalog
        System.out.println("Product not found in the catalog: " + productName);
    }

    public void removeProduct(String productName) {
        // Find and remove the product from the cart
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                products.remove(product);
                return; // Product found and removed, exit loop
            }
        }
        // Product not found in the cart
        System.out.println("Product not found in the cart: " + productName);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
