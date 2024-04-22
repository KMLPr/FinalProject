import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("user1", "1");
        User user2 = new User("user2", "2");
        User user3 = new User("user3", "3");

        // Create some product lists
        ArrayList<Product> productList1 = new ArrayList<>();
        productList1.add(new Product("Product1", "car", 10.99));
        productList1.add(new Product("Product2", "toy", 15.99));

        ArrayList<Product> productList2 = new ArrayList<>();
        productList2.add(new Product("Product3", "book", 20.99));
        productList2.add(new Product("Product4", "game", 25.99));


        ArrayList<Product> productList3 = new ArrayList<>();
        productList3.add(new Product("Product5", "game", 30.99));
        productList3.add(new Product("Product6", "car", 35.99));


        // Create an AVL tree to manage orders
        OrderManager orderManager = new OrderManager();
        orderManager.printOrders();

        // Insert some orders
        orderManager.addOrder(new Order(1, user1, productList1));
        orderManager.addOrder(new Order(2, user2, productList2));
        orderManager.addOrder(new Order(3, user3, productList3));

        // Print the AVL tree (inorder traversal)
        System.out.println("AVL Tree (Inorder Traversal):");
        orderManager.printOrders();
        System.out.println();

        // Remove an order
        orderManager.removeOrder(2);

        // Print the AVL tree after removal
        System.out.println("AVL Tree after Removal:");
        orderManager.printOrders();

    }
}