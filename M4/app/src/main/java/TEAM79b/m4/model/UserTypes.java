package TEAM79b.m4.model;

/**
 * enum representing user types
 */
public enum UserTypes {
    NEED_USER("Need User"), DONATING_USER("Donating User"), LOCATION_EMPLOYEE("Location Employee"),
    MANAGER("Manager"), ADMIN("Admin"), DELIVERY_DRIVER("Delivery Driver");

    private String role;

    /**
     * constructor for user types
     * @param role
     */
    private UserTypes(String role) {
        this.role = role;
    }

    /**
     * role of user types for readability
     * @return
     */
    public String getRole() {
        return role;
    }


}
