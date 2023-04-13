import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    ConferenceRoom conferenceRoom;

    @Before
    public void before() {
        conferenceRoom = new ConferenceRoom(10, "Conference Suite");
    }

    @Test
    public void hasName() {
        assertEquals("Conference Suite", conferenceRoom.getName());
    }

    @Test
    public void hasCapacity() {
        assertEquals(10, conferenceRoom.getCapacity());
    }

    @Test
    public void capacityStartsEmpty() {
        assertEquals(0, conferenceRoom.getNumberOfGuests());
    }

    @Test
    public void canAddGuests() {
        Guest guest = new Guest("Jimmy Page");
        conferenceRoom.addGuest(guest);
        assertEquals(1, conferenceRoom.getNumberOfGuests());
    }

    @Test
    public void canRemoveGuest() {
        Guest guest = new Guest("Jimmy Page");
        conferenceRoom.addGuest(guest);
        conferenceRoom.removeGuest(guest);
        assertEquals(0, conferenceRoom.getNumberOfGuests());
    }

    @Test
    public void canCalculateRoomSize(){
        assertEquals(15, ConferenceRoom.roomSize(3,5),0.01);
    }
}
