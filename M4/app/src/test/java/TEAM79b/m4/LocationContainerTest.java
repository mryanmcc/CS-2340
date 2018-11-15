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

public class LocationContainerTest {

    @Test
    public void testLocationContainerKeyListSkipLoop() {
        LocationContainer test = LocationContainer.getInstance();
        String[] keyList = test.keyList();
        assertTrue(keyList.length == 0);
    }

    @Test
    public void testLocationContainerKeyListGeneral() {
        LocationContainer test = LocationContainer.getInstance();
        Location tempLoc = new Location("DOG", 23.2f, 23.5f, "DOG", "DOG", "DOG", 23, "DOG", "DOG", "DOG");
        Location tempLoc2 = new Location("CAT", 23.2f, 23.5f, "DOG", "DOG", "DOG", 23, "DOG", "DOG", "DOG");
        Location tempLoc3 = new Location("LOL", 23.2f, 23.5f, "DOG", "DOG", "DOG", 23, "DOG", "DOG", "DOG");
        test.addLocation(tempLoc, new ArrayList<Item>());
        test.addLocation(tempLoc2, new ArrayList<Item>());
        test.addLocation(tempLoc3, new ArrayList<Item>());
        String[] keyListManual = new String[3];
        Set<String> keySetManual = new HashSet<>();
        for (Location l : test.getLocationMap().keySet()) {
            if (l != null) {
                keySetManual.add(l.getName());
            }
        }
        String[] keyList = test.keyList();
        Set<String> keySet = new HashSet<String>(Arrays.asList(keyList));
        assertTrue(keySet.equals(keySetManual));
    }

    @Test
    public void testLocationContainerAdd() {
        LocationContainer test = LocationContainer.getInstance();
        Location tempLoc = new Location("DOG", 23.2f, 23.5f, "DOG", "DOG", "DOG", 23, "DOG", "DOG", "DOG");
        test.addLocation(tempLoc, new ArrayList<Item>());
        assertTrue(test.getLocationMap().containsKey(tempLoc));
    }

    @Test
    public void testAddSameLocation() {
        LocationContainer test = LocationContainer.getInstance();
        Location tempLoc = new Location("DOG", 23.2f, 23.5f, "DOG", "DOG", "DOG", 23, "DOG", "DOG", "DOG");
        test.addLocation(tempLoc, new ArrayList<Item>());
        Location tempLoc2 = new Location("DOG", 23.2f, 23.5f, "DOG", "DOG", "DOG", 23, "DOG", "DOG", "DOG");
        test.addLocation(tempLoc2, new ArrayList<Item>());
        assertTrue(test.getLocationMap().containsKey(tempLoc));
    }

    @Test
    public void testLocationContainerNullValue() {
        LocationContainer test = LocationContainer.getInstance();
        Location tempLoc = new Location("DOG", 23.2f, 23.5f, "DOG", "DOG", "DOG", 23, "DOG", "DOG", "DOG");
        test.addLocation(tempLoc, new ArrayList<Item>());
        assertFalse(test.getLocationMap().get(tempLoc) == null);
    }
}