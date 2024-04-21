import java.util.ArrayList;
public class Order {
    private int orderId;
    private User user;
    private ArrayList<Product> products;
    private double totalPrice;
    private long timestamp; // Timestamp when the order was placed

    // Constructor
    public Order(int orderId, User user, ArrayList<Product> products) {
        this.orderId = orderId;
        this.user = user;
        this.products = products;
        this.totalPrice = calculateTotalPrice(); // Calculate total price based on products
        this.timestamp = System.currentTimeMillis(); // Initialize timestamp to current time
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

    public long getTimestamp() {
        return timestamp;
    }

    // Calculate total price based on products
    private double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
