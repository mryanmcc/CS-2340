package TEAM79b.m4.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Location {
    private Map<String, ArrayList> locationMap;

    private static final Location _instance = new Location();
    public static Location getInstance() {
        return _instance;
    }

    private Location() {
        locationMap = new HashMap<>();
    }

    public void addUser(String location, ArrayList data) {
        locationMap.put(location, data);
    }
}
