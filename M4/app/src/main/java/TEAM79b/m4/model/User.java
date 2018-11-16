package TEAM79b.m4.model;

import java.util.Arrays;
import java.util.List;

/**
 * User of app
 */
public class User {
    private String password;

    public static List<String> rolesList = Arrays.asList("Need User", "Donating User",
            "Location Employee", "Manager", "Admin", "Delivery Driver");

    /**
     * no arg constructor for firebase
     */
    public User() {

    }

}
