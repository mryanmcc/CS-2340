package TEAM79b.m4.model;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Item Container class that holds data for items
 */
public class ItemContainer extends Application {
    private List<Item> items = new ArrayList<>();
    private Location loc = null;

    /**
     * getter for itemList
     * @return item list
     */
    public List<Item> getList() {
        return this.items;
    }

    /**
     * getter for location
     * @return item location
     */
    public Location getLoc() {return this.loc; }
}
