import java.util.HashMap; 
public class UserManagement {
    private HashMap<String, User> userMap;
    private HashMap<String, String> usernameToCustomerIdMap; // Map username to customer ID

    public UserManagement() {
        userMap = new HashMap<>();
        usernameToCustomerIdMap = new HashMap<>();
    }

    public void registerUser(String username, String password) {
        // Check if the username already exists
        if (usernameToCustomerIdMap.containsKey(username)) {
            System.out.println("Username already exists. Please choose another username.");
            return;
        }

        // Hash the password
        String hashedPassword = hashPassword(password);

        // Create a new user and add it to the userMap
        User newUser = new User(username, hashedPassword);
        userMap.put(newUser.getCustomerId(), newUser);
        usernameToCustomerIdMap.put(username, newUser.getCustomerId());
        System.out.println("User successfully registered");
    }

    public boolean authenticateUser(String username, String password) {
        if (usernameToCustomerIdMap.containsKey(username)) {
            // Retrieve the customer ID from the username
            String customerId = usernameToCustomerIdMap.get(username);
            // Retrieve the user from the userMap using the customer ID
            User user = userMap.get(customerId);
            // Hash the input password
            String hashedPassword = hashPassword(password);
            // Compare the hashed input password with the stored hashed password
            return hashedPassword.equals(user.getHashedPassword());
        }
        return false; // User not found
    }

    private String hashPassword(String password) {
        int hashCode = password.hashCode();

        // Convert the hash code to a string representation
        return Integer.toString(hashCode);
    }
}
