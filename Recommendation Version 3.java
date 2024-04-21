import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class RecommendationSystem {
    private ProductCatalog productCatalog;
    private HashMap<String, ArrayList<Product>> memoizationCache;
    private HashSet<Product> visitedProducts;

    public RecommendationSystem(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
        this.memoizationCache = new HashMap<>();
        this.visitedProducts = new HashSet<>();
    }

    // Method to generate recommendations for a given product using memoization
    public ArrayList<Product> generateRecommendations(User user) {
        ArrayList<Product> recommendations = new ArrayList<>();
        for (Product product : user.getShoppingCart().getProducts()) {
            recommendations.addAll(generateRecommendationsForProduct(product));
        }

        recommendations.removeAll(user.getShoppingCart().getProducts());

        return recommendations;
    }

    // Method to generate recommendations for a single product
    private ArrayList<Product> generateRecommendationsForProduct(Product product) {
        if (product == null || product.getDescription() == null || product.getDescription().isEmpty()) {
            return new ArrayList<>();
        }

        // Check if recommendations for this product are already calculated and cached
        String description = product.getDescription();
        if (memoizationCache.containsKey(description)) {
            return memoizationCache.get(description);
        }

        // Check if the product has been visited before to avoid infinite recursion
        if (visitedProducts.contains(product)) {
            return new ArrayList<>();
        }

        // Mark the current product as visited
        visitedProducts.add(product);

        // Get similar products based on the description
        ArrayList<Product> similarProducts = productCatalog.getByDescription(description);

        // Create a new list to hold the recommendations
        ArrayList<Product> recommendations = new ArrayList<>(similarProducts);

        // Recursively generate recommendations for similar products
        for (Product similarProduct : similarProducts) {
            recommendations.addAll(generateRecommendationsForProduct(similarProduct));
        }
        recommendations.remove(product);

        // Cache the recommendations for future use
        memoizationCache.put(description, recommendations);

        return recommendations;
    }
}
