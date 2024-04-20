import java.util.ArrayList;
import java.util.HashMap;

public class RecommendationSystem {
    private ProductCatalog productCatalog;
    private HashMap<Product, ArrayList<Product>> memoizationCache;

    public RecommendationSystem(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
        this.memoizationCache = new HashMap<>();
    }

    // Method to generate recommendations for a given product using memoization
    public ArrayList<Product> generateRecommendations(Product product) {
        if (memoizationCache.containsKey(product)) {
            return memoizationCache.get(product);
        } else {
            ArrayList<Product> recommendations = generateRecommendationsRecursive(product);
            memoizationCache.put(product, recommendations);
            return recommendations;
        }
    }

    // Recursive helper function to calculate recommendations for a product
    private ArrayList<Product> generateRecommendationsRecursive(Product product) {
        // Base case: If the product's description is empty or null, return an empty list
        if (product.getDescription() == null || product.getDescription().isEmpty()) {
            return new ArrayList();
        }

        // Get similar products based on the description
        ArrayList<Product> similarProducts = productCatalog.getByDescription(product.getDescription());

        // Remove the current product from the list of similar products (optional)
        similarProducts.remove(product);

        // Generate recommendations for each similar product recursively
        for (Product similarProduct : similarProducts) {
            similarProduct.setRecommendations(generateRecommendationsRecursive(similarProduct));
        }

        return similarProducts;
    }
}
