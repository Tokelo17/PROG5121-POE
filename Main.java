/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author TOKELO TOKZA
 */
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Register user
        System.out.println("Register:");
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
        
        //Prompt user to enter username
        System.out.print("Enter username: ");
        String username = input.nextLine();
        
        //Prompt user to enter password
        System.out.print("Enter password: ");
        String password = input.nextLine();
        
        //Prompt user to enter cell phone number with international code
        System.out.print("Enter cell phone number (+27): ");
        String cellNumber = input.nextLine();

        // Create object from login class
        Login user = new Login(username, password, cellNumber, firstName, lastName);

        // Output registration message
        String registrationMessage = user.registerUser();
        System.out.println(registrationMessage);

        // Output message when user has successfully registered
        if (registrationMessage.equals("User registered successfully.")) {
            
            // Login with registration details after successfully registering
            System.out.println("\nLogin:");
            
            // Enter the same username used when registering to 
            System.out.print("Enter username: ");
            String Username = input.nextLine();
            
            // Enter same password used when registering
            System.out.print("Enter password: ");
            String Password = input.nextLine();
            
            // Return welcome message from Login Class when user has successfully logged in
            boolean success = user.loginUser(Username, Password);

            System.out.println(user.returnLoginStatus(success));
        }

    }
}
