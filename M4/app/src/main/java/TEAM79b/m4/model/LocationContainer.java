package TEAM79b.m4.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationContainer {
    private HashMap<Location, List<Item>> locationMap;
//    List<Item> itemList = new ArrayList<>();

    private static final LocationContainer _instance = new LocationContainer();
    public static LocationContainer getInstance() { return _instance; }
    public HashMap<Location, List<Item>> getLocationMap() {
        return locationMap;
    }

    private LocationContainer() {
        locationMap = new HashMap<>();
    }

    public void addLocation(Location location, ArrayList<Item> data) {
        locationMap.put(location, data);
    }

    public void addItem(Item item) {
        //locationMap.put()
    }

    //the method you made for getting the map
//    public Map<String, List<String>> locationMap() { return locationMap; }
}
