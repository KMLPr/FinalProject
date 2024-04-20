import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class RecommendationSystem {
    private ProductCatalog productCatalog;
    private HashMap<Product, ArrayList<Product>> memoizationCache;
    private HashSet<Product> visited;

    public RecommendationSystem(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
        this.memoizationCache = new HashMap<>();
        this.visited = new HashSet<>();
    }

    // Method to generate recommendations for a given product using memoization
    public ArrayList<Product> generateRecommendations(Product product) {
        if (memoizationCache.containsKey(product)) {
            return memoizationCache.get(product);
        } else {
            ArrayList<Product> recommendations = generateRecommendationsRecursive(product, visited);
            memoizationCache.put(product, recommendations);
            return recommendations;
        }
    }

    // Recursive helper function to calculate recommendations for a product
    private ArrayList<Product> generateRecommendationsRecursive(Product product, HashSet<Product> visited) {
        // Base case: If the product's description is empty or null, return an empty list
        if (product.getDescription() == null || product.getDescription().isEmpty()) {
            return new ArrayList<>();
        }

        visited.add(product);

        // Get similar products based on the description
       ArrayList<Product> similarProducts = productCatalog.getByDescription(product.getDescription());

        // Remove the current product and visited products from the list of similar products
        similarProducts.removeIf(visited::contains);

        // Generate recommendations for each similar product recursively
        for (Product similarProduct : similarProducts) {
            similarProduct.setRecommendations(generateRecommendationsRecursive(similarProduct, visited));
        }

        return similarProducts;
    }
}
