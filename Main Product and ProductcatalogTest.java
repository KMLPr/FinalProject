public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", "electronic", 999.99);
        Product product2 = new Product("Smartphone", "electronic", 599.99);
        Product product3 = new Product("Pizza", "food", 9.99);
        Product product4 = new Product("Toy Car", "toy", 19.99);

        // Create a product catalog
        ProductCatalog productCatalog = new ProductCatalog();

        // Add products to the catalog
        productCatalog.addProduct(product1);
        productCatalog.addProduct(product2);
        productCatalog.addProduct(product3);
        productCatalog.addProduct(product4);

        System.out.println(productCatalog.getProducts());
    }
}