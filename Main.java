public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", "electronic", 999.99);
        Product product2 = new Product("Smartphone", "electronic", 599.99);
        Product product3 = new Product("Pizza", "food", 9.99);
        Product product4 = new Product("Car", "toy", 19.99);
        Product product5 = new Product("Car", "vehicle", 125000.00);

        // Create a product catalog
        ProductCatalog productCatalog = new ProductCatalog();

        // Add products to the catalog
        productCatalog.addProduct(product1);
        productCatalog.addProduct(product2);
        productCatalog.addProduct(product3);
        productCatalog.addProduct(product4);
        productCatalog.addProduct(product5);

        System.out.println("All products");
        System.out.println(productCatalog.getAllProducts());
        System.out.println("Test search by name: ");
        System.out.println(productCatalog.searchByName("Car"));
        System.out.println("Test search by description: ");
        System.out.println(productCatalog.searchByDescription("electronic"));
        System.out.println("Test by price: ");
        System.out.println(productCatalog.searchByPriceRange(10.00, 1000.00));
    }
}

*/
Current output: 
All products
[
Product Name: Laptop
Description: electronic
Price: $999.99
, 
Product Name: Smartphone
Description: electronic
Price: $599.99
, 
Product Name: Pizza
Description: food
Price: $9.99
, 
Product Name: Car
Description: toy
Price: $19.99
, 
Product Name: Car
Description: vehicle
Price: $125000.0
]
Test search by name: 
[
Product Name: Car
Description: toy
Price: $19.99
, 
Product Name: Car
Description: vehicle
Price: $125000.0
]
Test search by description: 
[
Product Name: Laptop
Description: electronic
Price: $999.99
, 
Product Name: Smartphone
Description: electronic
Price: $599.99
]
Test by price: 
[
Product Name: Laptop
Description: electronic
Price: $999.99
, 
Product Name: Smartphone
Description: electronic
Price: $599.99
, 
Product Name: Car
Description: toy
Price: $19.99
]
/*
