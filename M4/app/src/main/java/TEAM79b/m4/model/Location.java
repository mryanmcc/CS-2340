package TEAM79b.m4.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Location {
    private HashMap<String, List<String>> locationMap;

    private static final Location _instance = new Location();
    public static Location getInstance() { return _instance; }
    public static HashMap<String, List<String>> getLocationMap() {
        return _instance.locationMap;
    }

    private Location() {
        locationMap = new HashMap<>();
    }

    public void addUser(String location, List<String> data) {
        locationMap.put(location, data);
    }

    //the method you made for getting the map
//    public Map<String, List<String>> locationMap() { return locationMap; }
}
