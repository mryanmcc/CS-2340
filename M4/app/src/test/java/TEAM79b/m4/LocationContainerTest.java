package TEAM79b.m4;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import TEAM79b.m4.model.Item;
import TEAM79b.m4.model.Location;
import TEAM79b.m4.model.LocationContainer;

/**
 * robert's unit tests
 */
public class LocationContainerTest {

    /**
     * keyList test
     */
    @Test
    public void testLocationContainerKeyListSkipLoop() {
        LocationContainer test1 = LocationContainer.getInstance();
        String[] keyList = test1.keyList();
        assertTrue(keyList.length == 0);
    }

    /**
     * keyList test
     */
    @Test
    public void testLocationContainerKeyListGeneral() {
        LocationContainer test2 = LocationContainer.getInstance();
        Location tempLoc = new Location("DOG", 23.2f, 23.5f, "DOG", "DOG", "DOG", 23, "DOG", "DOG", "DOG");
        Location tempLoc2 = new Location("CAT", 23.2f, 23.5f, "DOG", "DOG", "DOG", 23, "DOG", "DOG", "DOG");
        Location tempLoc3 = new Location("LOL", 23.2f, 23.5f, "DOG", "DOG", "DOG", 23, "DOG", "DOG", "DOG");
        test2.addLocation(tempLoc, new ArrayList<Item>());
        test2.addLocation(tempLoc2, new ArrayList<Item>());
        test2.addLocation(tempLoc3, new ArrayList<Item>());
        String[] keyListManual = new String[3];
        Set<String> keySetManual = new HashSet<>();
        for (Location l : test2.getLocationMap().keySet()) {
            if (l != null) {
                keySetManual.add(l.getName());
            }
        }
        String[] keyList = test2.keyList();
        Set<String> keySet = new HashSet<>(Arrays.asList(keyList));
        assertTrue(keySet.equals(keySetManual));
    }

    /**
     * add test
     */
    @Test
    public void testLocationContainerAdd() {
        LocationContainer test3 = LocationContainer.getInstance();
        Location tempLoc = new Location("DOG", 23.2f, 23.5f, "DOG", "DOG", "DOG", 23, "DOG", "DOG", "DOG");
        test3.addLocation(tempLoc, new ArrayList<Item>());
        assertTrue(test3.getLocationMap().containsKey(tempLoc));
    }

    /**
     * add same test
     */
    @Test
    public void testAddSameLocation() {
        LocationContainer test4 = LocationContainer.getInstance();
        Location tempLoc = new Location("DOG", 23.2f, 23.5f, "DOG", "DOG", "DOG", 23, "DOG", "DOG", "DOG");
        test4.addLocation(tempLoc, new ArrayList<Item>());
        Location tempLoc2 = new Location("DOG", 23.2f, 23.5f, "DOG", "DOG", "DOG", 23, "DOG", "DOG", "DOG");
        test4.addLocation(tempLoc2, new ArrayList<Item>());
        assertTrue(test4.getLocationMap().containsKey(tempLoc));
    }

    /**
     * value null test
     */
    @Test
    public void testLocationContainerNullValue() {
        LocationContainer test = LocationContainer.getInstance();
        Location tempLoc = new Location("DOG", 23.2f, 23.5f, "DOG", "DOG", "DOG", 23, "DOG", "DOG", "DOG");
        test.addLocation(tempLoc, new ArrayList<Item>());
        assertFalse(test.getLocationMap().get(tempLoc) == null);
    }
}