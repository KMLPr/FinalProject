import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", "electronic", 999.99);
        Product product2 = new Product("Smartphone", "electronic", 599.99);
        Product product3 = new Product("Pizza", "food", 9.99);
        Product product4 = new Product("Car", "toy", 19.99);
        Product product5 = new Product("Car", "vehicle", 125000.00);
        Product product6 = new Product("Dinosaur", "toy", 45.00);

        // Create a product catalog
        ProductCatalog productCatalog = new ProductCatalog();

        // Add products to the catalog
        productCatalog.addProduct(product1);
        productCatalog.addProduct(product2);
        productCatalog.addProduct(product3);
        productCatalog.addProduct(product4);
        productCatalog.addProduct(product5);
        productCatalog.addProduct(product6);

        UserManagement userManagement = new UserManagement();

        User user = new User("lovegood", "123", productCatalog);
        ShoppingCart userShopping = user.getShoppingCart();
        userShopping.addProduct(product1.getName());
        userShopping.addProduct(product4.getName());

        RecommendationSystem recommendationSystem = new RecommendationSystem(productCatalog);

        // Generate recommendations for the user's shopping cart
        ArrayList<Product> recommendations = recommendationSystem.generateRecommendations(user);

        // Print the recommendations
        System.out.println("Recommendations for the user:");
        for (Product recommendation : recommendations) {
            System.out.println("- " + recommendation);
        }
    }
}