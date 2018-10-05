package TEAM79b.m4.model;

import java.util.Arrays;
import java.util.List;

public class User {
    private String email;
    private String password;
    private String userType;

    public static List<String> rolesList = Arrays.asList("Need User", "Donating User", "Location Employee", "Manager", "Admin", "Delivery Driver");

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }
}
