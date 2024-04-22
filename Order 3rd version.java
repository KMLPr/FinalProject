import java.util.ArrayList;
public class Order {
    private int orderId;
    private User user;
    private ArrayList<Product> products;
    private double totalPrice;

    // Constructor
    public Order(int orderId, User user, ArrayList<Product> products) {
        this.orderId = orderId;
        this.user = user;
        this.products = products;
        this.totalPrice = calculateTotalPrice(); // Calculate total price based on products
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }


    // Calculate total price based on products
    private double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public String toString() {
        String line = "";
        line += "Order ID: " + orderId + "\n";
        line += "User: " + user.getUsername() + "\n";
        line += "Products: " + products + "\n";
        line += "Price: " + calculateTotalPrice() + "\n";
        return line;
    }

}
