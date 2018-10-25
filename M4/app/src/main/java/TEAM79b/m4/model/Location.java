package TEAM79b.m4.model;

import java.io.Serializable;

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

    public Location(String name, float latitude, float longitude, String address1, String city, String state, int zip, String type, String phoneNum, String url) {
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

    public String getName() {
        return name;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getAddress1() {
        return address1;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public String getType() {
        return type;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longtitude) {
        this.longitude = longtitude;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
