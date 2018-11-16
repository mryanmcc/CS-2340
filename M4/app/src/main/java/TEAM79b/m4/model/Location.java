package TEAM79b.m4.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Location object type that holds necessary location info
 */
public class Location implements Serializable {
    private String name;
    private float latitude;
    private float longitude;
    private String address1;
    private String city;
    private String state;
    private int zip;
    private String type;
    private String phoneNum;
    private String url;
    private List<Item> itemList;

    /**
     * no arg constructor for firebase
     */
    public Location() {

    }

    /**
     * constructor to create a Location with proper attributes
     * @param name name of location
     * @param latitude latitude of location
     * @param longitude longitude of location
     * @param address1 address of location
     * @param city city of location
     * @param state state of location
     * @param zip zip of location
     * @param type type of location (donation, etc.)
     * @param phoneNum phone number of location
     * @param url website of location
     */
    public Location(String name, float latitude, float longitude, String address1, String city,
                    String state, int zip, String type, String phoneNum, String url) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address1 = address1;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.type = type;
        this.phoneNum = phoneNum;
        this.url = url;
    }

    /**
     * getter for name
     * @return name of location
     */
    public String getName() {
        return name;
    }

    /**
     * getter for latitude
     * @return latitude of location
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * getter for longitude
     * @return longitude of location
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * getter for address
     * @return address of location
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * getter for city of location
     * @return city of location
     */
    public String getCity() {
        return city;
    }

    /**
     * getter for state of location
     * @return state of location
     */
    public String getState() {
        return state;
    }

    /**
     * getter for zip of location
     * @return zip of location
     */
    public int getZip() {
        return zip;
    }

    /**
     * getter for location type
     * @return type of location
     */
    public String getType() {
        return type;
    }

    /**
     * getter for phone number
     * @return phone number for location
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * getter for location url
     * @return website of location
     */
    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Location location = (Location) o;
        return Float.compare(location.latitude, latitude) == 0 &&
                Float.compare(location.longitude, longitude) == 0 &&
                zip == location.zip &&
                Objects.equals(name, location.name) &&
                Objects.equals(address1, location.address1) &&
                Objects.equals(city, location.city) &&
                Objects.equals(state, location.state) &&
                Objects.equals(type, location.type) &&
                Objects.equals(phoneNum, location.phoneNum) &&
                Objects.equals(url, location.url);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, latitude, longitude, address1, city, state, zip, type, phoneNum,
                url);
    }

    @Override
    public String toString() {
        String[] tempName = name.split("\\.");
        return tempName[0];
    }
}
