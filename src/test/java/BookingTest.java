import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    Booking booking;
    Bedroom bedroom;
    @Before
    public void before() {
        bedroom = new Bedroom(RoomType.DOUBLE, 3);
        booking = new Booking(4, bedroom);
    }

    @Test
    public void hasNumberOfNights() {
        assertEquals(4, booking.getNumberOfNights());
    }

    @Test
    public void hasBedroom(){
        assertEquals(bedroom, booking.getBedroom());
    }

    @Test
    public void canCalculatePrice(){
        assertEquals(400,booking.getTotalPrice());
    }
}
