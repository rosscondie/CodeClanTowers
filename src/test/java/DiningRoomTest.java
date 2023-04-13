import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {

    DiningRoom diningRoom;

    @Before
    public void before() {
        diningRoom = new DiningRoom(10, "Dining Room");
    }

    @Test
    public void hasName() {
        assertEquals("Dining Room", diningRoom.getName());
    }

    @Test
    public void hasCapacity() {
        assertEquals(10, diningRoom.getCapacity());
    }

    @Test
    public void capacityStartsEmpty() {
        assertEquals(0, diningRoom.getNumberOfGuests());
    }

    @Test
    public void canAddGuests() {
        Guest guest = new Guest("Jimmy Page");
        diningRoom.addGuest(guest);
        assertEquals(1, diningRoom.getNumberOfGuests());
    }

    @Test
    public void canRemoveGuest() {
        Guest guest = new Guest("Jimmy Page");
        diningRoom.addGuest(guest);
        diningRoom.removeGuest(guest);
        assertEquals(0, diningRoom.getNumberOfGuests());
    }

    @Test
    public void canCalculateRoomSize(){
        assertEquals(25, DiningRoom.roomSize(5,5),0.01);
    }
}
