package TEAM79b.m4.model;

public class Item {
    private String timeStamp;
    private Location location;
    private String shortDesc;
    private String longDesc;
    private float value;
    private String category;

    public Item(String timeStamp, Location location, String shortDesc, String longDesc, float value, String category) {
        this.timeStamp = timeStamp;
        this.location = location;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.value = value;
        this.category = category;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public Location getLocation() {
        return location;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public float getValue() {
        return value;
    }

    public String getCategory() {
        return category;
    }
}
