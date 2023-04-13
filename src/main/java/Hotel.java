import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Hotel {
    
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;

    private HashMap<String, DiningRoom> diningRooms;

    public Hotel(ArrayList<Bedroom> bedrooms, ArrayList<ConferenceRoom> conferenceRooms, HashMap<String, DiningRoom> diningRooms) {
        this.bedrooms = bedrooms;
        this.conferenceRooms = conferenceRooms;
        this.diningRooms = diningRooms;
    }

    private Bedroom findRoomByNumber(int roomNumber){
        for(Bedroom room : bedrooms){
            if (room.getRoomNumber() == roomNumber){
                return room;
            }
        }
        return null;
    }

    private ConferenceRoom findRoomByName(String roomName){
        for(ConferenceRoom room : conferenceRooms){
            if (room.getName() == roomName){
                return room;
            }
        }
        return null;
    }

    public void checkGuestInBedroom(Guest guest, int roomNumber) {
        Bedroom room = findRoomByNumber(roomNumber);
        if(room.getNumberOfGuests()==0){
            room.addGuest(guest);
        }
    }

    public void checkGuestInConferenceRoom(Guest guest, String roomName) {
        ConferenceRoom room = findRoomByName(roomName);
        room.addGuest(guest);
    }

    public void checkGuestOutBedroom(Guest guest, int roomNumber) {
        Bedroom room = findRoomByNumber(roomNumber);
        room.removeGuest(guest);
    }

    public void checkGuestOutConferenceRoom(Guest guest, String roomName) {
        ConferenceRoom room = findRoomByName(roomName);
        room.removeGuest(guest);
    }

    public Booking bookRoom(int roomNumber, int numberOfNights ) {
        Bedroom room = findRoomByNumber(roomNumber);
        return new Booking(numberOfNights, room);
    }

    public HashMap<String,DiningRoom> getDiningRooms() {
        return diningRooms;
    }

    public ArrayList<Bedroom> getEmptyBedrooms(){
        return  bedrooms.stream()
                .filter(bedroom -> bedroom.getNumberOfGuests() == 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
