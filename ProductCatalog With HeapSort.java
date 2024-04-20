import java.util.ArrayList;

public class ProductCatalog {
    //Using an ArrayList due to constant time complexity for adding and removing a product
    //Time Complexity: O(n) where n is the number of products in the array list for the traversal and search methods
    private ArrayList<Product> products;

    public ProductCatalog() {
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts(){
        return products;
    }
    // Heap sort implementation for sorting products by price
    public void sortProductsByPrice() {
        if (products.size() < 2) {
            return; // No need to sort if there are 0 or 1 products
        }
        // Convert the list to an array for in-place sorting
        Product[] productsArray = products.toArray(new Product[products.size()]);

        // Build max heap
        for (int i = productsArray.length / 2 - 1; i >= 0; i--) {
            heapify(productsArray, productsArray.length, i);
        }

        // Heap sort
        for (int i = productsArray.length - 1; i > 0; i--) {
            // Swap root (max element) with the last element
            Product temp = productsArray[0];
            productsArray[0] = productsArray[i];
            productsArray[i] = temp;

            // Heapify the reduced heap
            heapify(productsArray, i, 0);
        }

        // Update the original list with sorted products
        products.clear();
        for (Product product : productsArray) {
            products.add(product);
        }
    }

    //Maintain heap property during sorting process
    private void heapify(Product[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left].getPrice() > arr[largest].getPrice()) {
            largest = left;
        }

        if (right < n && arr[right].getPrice() > arr[largest].getPrice()) {
            largest = right;
        }

        if (largest != i) {
            Product temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
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
