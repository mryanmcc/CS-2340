package TEAM79b.m4.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LocationContainer {
    private HashMap<Location, List<Item>> locationMap;

    private static final LocationContainer _instance = new LocationContainer();
    public static LocationContainer getInstance() { return _instance; }
    public HashMap<Location, List<Item>> getLocationMap() {
        return locationMap;
    }

    private LocationContainer() {
        locationMap = new HashMap<>();
    }

    public void addLocation(Location location, List<Item> data) {
        locationMap.put(location, data);
    }

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
