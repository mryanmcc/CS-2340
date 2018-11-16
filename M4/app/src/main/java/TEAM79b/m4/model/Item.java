package TEAM79b.m4.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * represents an item that is tied to a location
 */
public class Item implements Serializable {
    private String timeStamp;
    private Location location;
    private String shortDesc;
    private String longDesc;
    private float value;
    private String category;

    /**
     * no arg constructor for firebase
     */
    public Item() {

    }

    /**
     * constructor to create an item with the fields our app requires
     * @param timeStamp timeStamp item was added
     * @param location location item is tied to
     * @param shortDesc short description of item
     * @param longDesc long description of item
     * @param value cost of item
     * @param category category of item
     */
    public Item(String timeStamp, Location location, String shortDesc, String longDesc, float value, String category) {
        this.timeStamp = timeStamp;
        this.location = location;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.value = value;
        this.category = category;
    }

    /**
     * getter for timestamp
     * @return timestamp
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * getter for location
     * @return location from item
     */
    public Location getLocation() {
        return location;
    }

    /**
     * getter for short description
     * @return short description of item
     */
    public String getShortDesc() {
        return shortDesc;
    }

    /**
     * getter for long description
     * @return long description of item
     */
    public String getLongDesc() {
        return longDesc;
    }

    /**
     * getter for value
     * @return cost of item
     */
    public float getValue() {
        return value;
    }

    /**
     * getter for category of item
     * @return category of item
     */
    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Float.compare(item.value, value) == 0 &&
                Objects.equals(timeStamp, item.timeStamp) &&
                Objects.equals(location, item.location) &&
                Objects.equals(shortDesc, item.shortDesc) &&
                Objects.equals(longDesc, item.longDesc) &&
                Objects.equals(category, item.category);
    }

    @Override
    public int hashCode() {

        return Objects.hash(timeStamp, location, shortDesc, longDesc, value, category);
    }

    @Override
    public String toString() {
        return "Item{" +
                "shortDesc='" + shortDesc + '\'' +
                '}';
    }
}
