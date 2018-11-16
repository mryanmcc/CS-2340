package TEAM79b.m4;

import org.junit.Test;

import TEAM79b.m4.model.Item;
import TEAM79b.m4.model.Location;

import static org.junit.Assert.*;

/**
 * ryan's unit tests
 */
public class ItemTest {

    //Michael McCorkle M10
    private Location tempLoc = new Location("Foobar", 23.2f, 23.5f, "Place", "Aplace", "PL", 1, "A place", "1", "place.place");
    private Item tempItem = new Item("1:00", tempLoc, "thing", "a thing", 3, "Foo");
    private Item tempItem2 = new Item("2:00", tempLoc, "it", "a bit", 4, "Bar");
    private Item tempItem3 = new Item("3:00", tempLoc, "part", "some part", 5, "End");

    @Test
    public void testGetTimeStamp() {
        assertTrue(tempItem.getTimeStamp() == "1:00");
        assertTrue(tempItem2.getTimeStamp() == "2:00");
        assertTrue(tempItem3.getTimeStamp() == "3:00");
    }

    @Test
    public void testGetLocation() {
        assertTrue(tempItem.getLocation() == tempLoc);
        assertTrue(tempItem2.getLocation() == tempLoc);
        assertTrue(tempItem3.getLocation() == tempLoc);
    }

    @Test
    public void testGetShortDesc() {
        assertTrue(tempItem.getShortDesc() == "thing");
        assertTrue(tempItem2.getShortDesc() == "it");
        assertTrue(tempItem3.getShortDesc() == "part");
    }

    @Test
    public void testGetLongDesc() {
        assertTrue(tempItem.getLongDesc() == "a thing");
        assertTrue(tempItem2.getLongDesc() == "a bit");
        assertTrue(tempItem3.getLongDesc() == "some part");
    }

    @Test
    public void testGetValue() {
        assertTrue(tempItem.getValue() == 3);
        assertTrue(tempItem2.getValue() == 4);
        assertTrue(tempItem3.getValue() == 5);
    }

    @Test
    public void testGetCategory() {
        assertTrue(tempItem.getCategory() == "Foo");
        assertTrue(tempItem2.getCategory() == "Bar");
        assertTrue(tempItem3.getCategory() == "End");
    }

    @Test
    public void testEquals() {
        Item fooItem = new Item("1:00", tempLoc, "thing", "a thing", 3, "Foo");
        Item fooItem2 = new Item("2:00", tempLoc, "it", "a bit", 4, "Bar");
        Item fooItem3 = new Item("3:00", tempLoc, "part", "some part", 5, "End");
        assertTrue(tempItem.equals(fooItem));
        assertTrue(tempItem2.equals(fooItem2));
        assertTrue(tempItem3.equals(fooItem3));
    }

    @Test
    public void testHashCode() {
        assertTrue(tempItem.hashCode() == 2064192384);
        assertTrue(tempItem2.hashCode() == 1101262096);
        assertTrue(tempItem3.hashCode() == -1441123422);
    }

    @Test
    public void testToString() {
        assertTrue(tempItem.toString().equals("Item{shortDesc='thing'}"));
        assertTrue(tempItem2.toString().equals("Item{shortDesc='it'}"));
        assertTrue(tempItem3.toString().equals("Item{shortDesc='part'}"));
    }
}