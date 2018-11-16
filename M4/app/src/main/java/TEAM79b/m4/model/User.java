package TEAM79b.m4.model;

import java.util.Arrays;
import java.util.List;

/**
 * User of app
 */
public class User {
    private String email;
    private String password;
    private UserTypes role;

    public static List<String> rolesList = Arrays.asList("Need User", "Donating User",
            "Location Employee", "Manager", "Admin", "Delivery Driver");

    /**
     * no arg constructor for firebase
     */
    public User() {

    }

    /**
     * constructor with appropriate data fields for instantiation
     * @param email email of user
     * @param password password for user
     * @param role user role in the app
     */
    public User(String email, String password, UserTypes role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    /**
     * setter for email field
     * @param email new email for user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * setter for password field
     * @param password new password for user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getter for password for user
     * @return password of user
     */
    public String getPassword() {
        return password;
    }
}
