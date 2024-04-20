import java.util.HashMap;
public class User {
    private String customerID;
    private HashMap<String, String> userData;
    private ShoppingCart shoppingCart;

    public User(String username, String hashedPassword, ProductCatalog catalog){
        this.customerID = username.hashCode() + "-" + hashedPassword.hashCode();
        this.userData = new HashMap<>();
        this.shoppingCart = new ShoppingCart(catalog);
        userData.put("username", username);
        userData.put("password", hashedPassword);
    }
    public User(String username, String hashedPassword){
        this.customerID = username.hashCode() + "-" + hashedPassword.hashCode();
        this.userData = new HashMap<>();
        userData.put("username", username);
        userData.put("password", hashedPassword);
    }
    public String getCustomerId() {
        return customerID;
    }
    public ShoppingCart getShoppingCart(){
        return shoppingCart;
    }

    public void updateCart(ShoppingCart cart){
        if(cart != null){
            shoppingCart = cart;
        }
    }

    public String getUsername() {
        return userData.get("username");
    }

    public String getHashedPassword() {
        return userData.get("password");
    }

    // Additional methods to access and modify user data
    public String getUserData(String key) {
        return userData.get(key);
    }

    public void setUserData(String key, String value) {
        userData.put(key, value);
    }

    public String toString(){
        String info = "Username: " + getUsername() + " and Password: " + getHashedPassword() + " and customer ID: ";
        info += getCustomerId();

        return info;
    }
}


