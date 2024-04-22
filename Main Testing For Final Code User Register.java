import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Big Online Shopping Platform!!!");
        System.out.println("Choose an option below to get started!");
        while(choice != 3){
            System.out.println("1. Create a new User Account");
            System.out.println("2. Log in to an existing User Account");
            System.out.println("3. Exit");

            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    boolean success = false;
                    System.out.println("Please create a username and password for your account");
                    while(!success) {
                        System.out.println("Username: ");
                        String username = scanner.next();
                        System.out.println("Password:");
                        String password = scanner.next();

                        User user = new User(username, password);
                        success = userManagement.registerUser(user.getUsername(), user.getHashedPassword());
                        if(success){
                            System.out.println("User account successfully created!");
                            System.out.println(user);
                        }
                        else
                            System.out.println("Username already exists, please choose a different username.\n");
                    }
                    break;
                case 2:
                    System.out.println("In progress");
                    break;
            }
        }
        System.out.println("Have a good day");

    }
}