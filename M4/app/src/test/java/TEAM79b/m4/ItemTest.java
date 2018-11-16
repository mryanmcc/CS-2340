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
    private Location tempLoc = new Location("Foobar", 23.2f, 23.5f,
            "Place", "Aplace", "PL", 1, "A place", "1",
            "place.place");
    private Item tempItem = new Item("1:00", tempLoc, "thing",
            "a thing", 3, "Foo");
    private Item tempItem2 = new Item("2:00", tempLoc, "it", "a bit",
            4, "Bar");
    private Item tempItem3 = new Item("3:00", tempLoc, "part",
            "some part", 5, "End");

    /**
     * time stamp test
     */
    @Test
    public void testGetTimeStamp() {
        assertTrue("1:00".equals(tempItem.getTimeStamp()));
        assertTrue("2:00".equals(tempItem.getTimeStamp()));
        assertTrue("3:00".equals(tempItem.getTimeStamp()));
    }

    /**
     * location test
     */
    @Test
    public void testGetLocation() {
        assertTrue(tempItem.getLocation().equals(tempLoc));
        assertTrue(tempItem2.getLocation().equals(tempLoc));
        assertTrue(tempItem3.getLocation().equals(tempLoc));
    }

    /**
     * short description test
     */
    @Test
    public void testGetShortDesc() {
        assertTrue("thing".equals(tempItem.getShortDesc()));
        assertTrue("it".equals(tempItem2.getShortDesc()));
        assertTrue("part".equals(tempItem3.getShortDesc()));
    }

    /**
     * long description test
     */
    @Test
    public void testGetLongDesc() {
        assertTrue("a thing".equals(tempItem.getLongDesc()));
        assertTrue("a bit".equals(tempItem2.getLongDesc()));
        assertTrue("some part".equals(tempItem3.getLongDesc()));
    }

    /**
     * value test
     */
    @Test
    public void testGetValue() {
        assertTrue(tempItem.getValue() == 3);
        assertTrue(tempItem2.getValue() == 4);
        assertTrue(tempItem3.getValue() == 5);
    }

    /**
     * category test
     */
    @Test
    public void testGetCategory() {
        assertTrue("Foo".equals(tempItem.getCategory()));
        assertTrue("Bar".equals(tempItem2.getCategory()));
        assertTrue("End".equals(tempItem3.getCategory()));
    }

    /**
     * equals test
     */
    @Test
    public void testEquals() {
        Item fooItem = new Item("1:00", tempLoc, "thing", "a thing",
                3, "Foo");
        Item fooItem2 = new Item("2:00", tempLoc, "it", "a bit",
                4, "Bar");
        Item fooItem3 = new Item("3:00", tempLoc, "part", "some part",
                5, "End");
        assertTrue(tempItem.equals(fooItem));
        assertTrue(tempItem2.equals(fooItem2));
        assertTrue(tempItem3.equals(fooItem3));
    }

    /**
     * hashCode test
     */
    @Test
    public void testHashCode() {
        assertTrue(tempItem.hashCode() == 2064192384);
        assertTrue(tempItem2.hashCode() == 1101262096);
        assertTrue(tempItem3.hashCode() == -1441123422);
    }

    /**
     * toString test
     */
    @Test
    public void testToString() {
        assertTrue("Item{shortDesc='thing'}".equals(tempItem.toString()));
        assertTrue("Item{shortDesc='it'}".equals(tempItem2.toString()));
        assertTrue("Item{shortDesc='part'}".equals(tempItem3.toString()));
    }
}