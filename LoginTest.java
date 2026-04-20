/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author TOKELO TOKZA
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    
    // Test if username is correct and meets all conditions
    @Test
    public void testUsernameCorrectlyFormatted() {
        Login user = new Login("kyl_1", "Password@1", "+27838968976", "Kyle", "Smith");
        assertTrue(user.checkUserName());
    }

    //Test if username is incorrectly formatted
    @Test
    public void testUsernameIncorrectlyFormatted() {
        Login user = new Login("kyle!!!!!!", "Password@1", "+27838968976", "Kyle", "Smith");
        assertFalse(user.checkUserName());
    }

    
    //Test if password meets complexity conditions
    @Test
    public void testPasswordMeetsComplexity() {
        Login user = new Login("kyl_1", "Ch&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(user.checkPasswordComplexity());
    }
    //Test if password does not meet complexity conditions
    @Test
    public void testPasswordDoesNotMeetComplexity() {
        Login user = new Login("kyl_1", "password", "+27838968976", "Kyle", "Smith");
        assertFalse(user.checkPasswordComplexity());
    }

    
    // Test if cellphone number has international country code
    @Test
    public void testCellPhoneCorrectFormat() {
        Login user = new Login("kyl_1", "Password@1", "+27838968976", "Kyle", "Smith");
        assertTrue(user.checkCellPhoneNumber());
    }
    // Test if cellphone number is incorrectly formatted and does not have international country code
    @Test
    public void testCellPhoneIncorrectFormat() {
        Login user = new Login("kyl_1", "Password@1", "08966553", "Kyle", "Smith");
        assertFalse(user.checkCellPhoneNumber());
    }

    
    // Test if login has the same has the same username and password as registerration
    @Test
    public void testLoginSuccessful() {
        Login user = new Login("kyl_1", "Password@1", "+27838968976", "Kyle", "Smith");

        boolean result = user.loginUser("kyl_1", "Password@1");
        assertTrue(result);
    }
    // Test login failed when username and password does not match registration
    @Test
    public void testLoginFailed() {
        Login user = new Login("kyl_1", "Password@1", "+27838968976", "Kyle", "Smith");

        boolean result = user.loginUser("wrongUser", "wrongPass");
        assertFalse(result);
    }

   
    //Test if register user is sucessful
    @Test
    public void testRegisterUserSuccess() {
        Login user = new Login("kyl_1", "Password@1", "+27838968976", "Kyle", "Smith");

        String result = user.registerUser();
        assertEquals("User registered successfully.", result);
    }
    //Test if username is not correctly formatted
    @Test
    public void testRegisterUserUsernameFail() {
        Login user = new Login("kyle!!!!!!", "Password@1", "+27838968976", "Kyle", "Smith");

        String result = user.registerUser();
        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.", result);
    }
    //Test if password is not correctly formatted
    @Test
    public void testRegisterUserPasswordFail() {
        Login user = new Login("kyl_1", "password", "+27838968976", "Kyle", "Smith");

        String result = user.registerUser();
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", result);
    }
    // Test if cellphone number is incorrectly formatted
    @Test
    public void testRegisterUserCellFail() {
        Login user = new Login("kyl_1", "Password@1", "08966553", "Kyle", "Smith");

        String result = user.registerUser();
        assertEquals("Cell phone number incorrectly formatted or does not contain international code.", result);
    }

    
    //Test if login is successful and returns welcome message
    @Test
    public void testReturnLoginStatusSuccess() {
        Login user = new Login("kyl_1", "Password@1", "+27838968976", "Kyle", "Smith");

        String result = user.returnLoginStatus(true);
        assertEquals("Welcome Kyle, Smith it is great to see you again.", result);
    }
    //Test if login failed and returns error message
    @Test
    public void testReturnLoginStatusFail() {
        Login user = new Login("kyl_1", "Password@1", "+27838968976", "Kyle", "Smith");

        String result = user.returnLoginStatus(false);
        assertEquals("Username or password incorrect, please try again.", result);
    }
}
