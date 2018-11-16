package TEAM79b.m4.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Links locations to item lists
 */
public class LocationContainer {
    private HashMap<Location, List<Item>> locationMap;

    private static final LocationContainer _instance = new LocationContainer();

    /**
     * singleton instance of locationContainer
     * @return instance of location container
     */
    public static LocationContainer getInstance() { return _instance; }

    /**
     * getter for location map
     * @return location map with item lists as values
     */
    public HashMap<Location, List<Item>> getLocationMap() {
        return locationMap;
    }

    /**
     * constructor for Location Container
     */
    private LocationContainer() {
        locationMap = new HashMap<>();
    }

    /**
     * method to add new locations to the location map
     * @param location new location to be added
     * @param data associated item list
     */
    public void addLocation(Location location, List<Item> data) {
        locationMap.put(location, data);
    }

    /**
     * method to generate an array of keys from the location container
     * @return array of keys
     */
    public String[] keyList() {
        LocationContainer currLoc = LocationContainer.getInstance();
        Map<Location, List<Item>> currMap = currLoc.getLocationMap();
        Set<Location> keys = currMap.keySet();
        Location[] keyListTemp = keys.toArray(new Location[keys.size()]);
        String[] keyList = new String[keys.size()];
        for (int i = 0; i < keyListTemp.length; i++) {
            keyList[i] = keyListTemp[i].getName();
        }
        return keyList;
    }

    //the method you made for getting the map
//    public Map<String, List<String>> locationMap() { return locationMap; }
}
