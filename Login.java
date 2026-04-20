/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author TOKELO TOKZA
 */
import java.util.Scanner;

public class Login {

    // Attributes
    private String username;
    private String password;
    private String cellPhone;
    private String firstName;
    private String lastName;

    // Login method
    public Login(String username, String password, String cellPhone, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Method to check username has all conditions
    public boolean checkUserName() {
        // Must contain an underscore "_" and must not be longer than 5 characters
        if (username.contains("_") && username.length() <= 5) {
            //Username correctly formatted, return true
            return true;
        }
        //Username incorrectly formatted return false
        return false;
    }

    // Method to check password complexity has all conditions
    public boolean checkPasswordComplexity() {
        boolean hasUpperCase = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;

        // Check if characters meets all password conditions
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecialCharacter = true;
            }
        }

        // Must be at least 8 characters and follow  all conditions
        if (password.length() >= 8 && hasUpperCase && hasNumber && hasSpecialCharacter) {
            // Password meets complexity conditions, return true
            return true;
        }
        //Password does not meet complexity conditions, return false
        return false;
    }

    // Method to check if cellphone number has an international country code and length is not longer than 12 characters
    public boolean checkCellPhoneNumber() {
        if (cellPhone.startsWith("+27")) {
            String remaining = cellPhone.substring(3);

            // Must be numbers only and not more than 10 digits
            if (remaining.length() <= 10) {
                for (int i = 0; i < remaining.length(); i++) {
                    if (!Character.isDigit(remaining.charAt(i))) {
                        return false;
                    }
                }
                //Cell phone number correctly formatted, return true
                return true;
            }
        }
        //Cell phone incorrectlly formatted, return false
        return false;
    }

    // Registration method
    public String registerUser() {
        
        // If username does not have all conditions, output this message
        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        // If password does not have complexity conditions,output message
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        //If cell phone number does not have all conditions,output message
        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        //Output message when user has followed all conditions
        return "User registered successfully.";
    }

    // Login method uses information from REGISTRATION to log in
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(username) && enteredPassword.equals(password);
    }

    // Username and password from REGISTRATION must match in order to successfully login
    public String returnLoginStatus(boolean loginSuccess) {
        //User successfully logged in
        if (loginSuccess) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        // User failed to log in because of incorrect username and password    
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}












