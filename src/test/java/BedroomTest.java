import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom;

    @Before
    public void before() {
        bedroom = new Bedroom(RoomType.DOUBLE, 45 );
    }


    @Test
    public void hasCapacity() {
        assertEquals(2, bedroom.getCapacity());
    }

    @Test
    public void capacityStartsEmpty() {
        assertEquals(0, bedroom.getNumberOfGuests());
    }

    @Test
    public void canAddGuests() {
        Guest guest = new Guest("Jimmy Page");
        bedroom.addGuest(guest);
        assertEquals(1, bedroom.getNumberOfGuests());
    }

    @Test
    public void canRemoveGuest() {
        Guest guest = new Guest("Jimmy Page");
        bedroom.addGuest(guest);
        bedroom.removeGuest(guest);
        assertEquals(0, bedroom.getNumberOfGuests());
    }

    @Test
    public void hasRoomType() {
        assertEquals(RoomType.DOUBLE, bedroom.getRoomType());
    }

    @Test
    public void hasRoomNumber() {
        assertEquals(45, bedroom.getRoomNumber());
    }

    @Test
    public void canCalculateRoomSize(){
        assertEquals(15, Bedroom.roomSize(3,5),0.01);
    }
}
