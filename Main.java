public class Main {
    public static void main(String[] args) {
        // Create a user manager instance
        UserManagement userManager = new UserManagement();

        // Register a new user
        userManager.registerUser("user1", "password123");

        // Authenticate the user
        boolean isAuthenticated = userManager.authenticateUser("user1", "password123");
        System.out.println("Authentication result for user1: " + isAuthenticated);

        // Attempt authentication with incorrect password
        isAuthenticated = userManager.authenticateUser("user1", "wrongpassword");
        System.out.println("Authentication result for user1 with wrong password: " + isAuthenticated);

        userManager.registerUser("user2", "5432");

        isAuthenticated = userManager.authenticateUser("user3", "5432");
        if(isAuthenticated){
            System.out.println("Authentication successful!");
        }
        else{
            System.out.println("Incorrect sign in");
        }
    }
}