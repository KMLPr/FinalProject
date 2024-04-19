import java.util.HashMap;
public class User {
    private String customerID;
    private HashMap<String, String> userData;

    public User(String username, String hashedPassword){
        this.customerID = username.hashCode() + "-" + hashedPassword.hashCode();
        this.userData = new HashMap<>();
        userData.put("username", username);
        userData.put("password", hashedPassword);
    }
    public String getCustomerId() {
        return customerID;
    }

    public String getUsername() {
        return userData.get("username");
    }

    public String getHashedPassword() {
        return userData.get("hashedPassword");
    }

    // Additional methods to access and modify user data
    public String getUserData(String key) {
        return userData.get(key);
    }

    public void setUserData(String key, String value) {
        userData.put(key, value);
    }
}


