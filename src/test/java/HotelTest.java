import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    Hotel hotel;
    ArrayList<Bedroom> bedrooms;
    ArrayList<ConferenceRoom> conferenceRooms;

    HashMap<String, DiningRoom> diningRooms;

    @Before
    public void before() {
        bedrooms = new ArrayList<>();
        bedrooms.add(new Bedroom(RoomType.SINGLE, 1));
        bedrooms.add(new Bedroom(RoomType.DOUBLE, 2));
        conferenceRooms = new ArrayList<>();
        conferenceRooms.add(new ConferenceRoom(10, "Conference Room 1"));
        conferenceRooms.add(new ConferenceRoom(15, "Conference Room 2"));
        diningRooms = new HashMap<>();
        DiningRoom diningRoom1 = new DiningRoom(8,"Dining Room 1");
        diningRooms.put(diningRoom1.getName(), diningRoom1);
        DiningRoom diningRoom2 = new DiningRoom(10,"Dining Room 2");
        diningRooms.put(diningRoom2.getName(), diningRoom2);
        hotel = new Hotel(bedrooms, conferenceRooms, diningRooms);
    }

    @Test
    public void canCheckGuestInToBedroom() {
        Guest guest = new Guest("Neil Armstrong");
        hotel.checkGuestInBedroom(guest, 1);
        assertEquals(1, bedrooms.get(0).getNumberOfGuests());

    }

    @Test
    public void canCheckGuestOutToBedroom() {
        Guest guest = new Guest("Neil Armstrong");
        hotel.checkGuestInBedroom(guest, 1);
        hotel.checkGuestOutBedroom(guest, 1);
        assertEquals(0, bedrooms.get(0).getNumberOfGuests());
    }

    @Test
    public void canCheckGuestInFromConferenceRoomByName() {
        Guest guest = new Guest("Neil Armstrong");
        hotel.checkGuestInConferenceRoom(guest, "Conference Room 1");
        assertEquals(1, conferenceRooms.get(0).getNumberOfGuests());

    }@Test
    public void canCheckGuestOutFromConferenceRoomByName() {
        Guest guest = new Guest("Neil Armstrong");
        hotel.checkGuestInConferenceRoom(guest, "Conference Room 1");
        hotel.checkGuestOutConferenceRoom(guest, "Conference Room 1");
        assertEquals(0, conferenceRooms.get(0).getNumberOfGuests());

    }

    @Test
    public void canBookBedroomForNumberOfNights() {
        Booking booking = hotel.bookRoom(1,4);
        assertEquals(200, booking.getTotalPrice());
    }

    @Test
    public void hotelHasDiningRooms() {
        assertEquals(diningRooms, hotel.getDiningRooms());
    }

    @Test
    public void canGetEmptyBedrooms(){
        Guest guest = new Guest("Neil Armstrong");
        hotel.checkGuestInBedroom(guest, 1);
        ArrayList<Bedroom> emptyRooms = hotel.getEmptyBedrooms();
        assertEquals(1,emptyRooms.size());
    }

    @Test
    public void canNotCheckInIntoAOccupiedRoom() {
        Guest guest = new Guest("Neil Armstrong");
        hotel.checkGuestInBedroom(guest, 2);
        Guest guest2  = new Guest("Buzz Aldrin");
        hotel.checkGuestInBedroom(guest, 2);
        assertEquals(1, bedrooms.get(1).getNumberOfGuests());
    }

}
