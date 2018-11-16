package TEAM79b.m4.model;

import java.util.Map;
import java.util.HashMap;

/**
 * login class
 */
public class Login {
    private static final Login _instance = new Login();

    /**
     * singleton instance
     * @return instance of login
     */
    public static Login getInstance() {
        return _instance;
    }

    private Map<String, String> userAccounts;
    private int totalUsers;

    /**
     * no arg constructor
     */
    private Login() {
        userAccounts = new HashMap<>();
    }

    /**
     * getter for user accounts
     * @return user accounts
     */
    public Map<String, String> getUserAccounts() {
        return userAccounts;
    }

    /**
     * add a user
     * @param email email of user
     * @param pass pass of user
     */
    public void addUser(String email, String pass) {
        userAccounts.put(email, pass);
        totalUsers++;
    }


}
