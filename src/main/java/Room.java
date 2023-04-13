import java.util.ArrayList;

public abstract class Room {
    ArrayList<Guest> guests;
    int capacity;

    public Room(int capacity) {
        this.guests = new ArrayList<>();
        this.capacity = capacity;
    }

    public int getNumberOfGuests() {
        return guests.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public void addGuest(Guest guest){
        if (guests.size() < capacity){
            guests.add(guest);
        }
    }


    public void removeGuest(Guest guest){
            guests.remove(guest);
    }

    public static double roomSize(double width,double length){
        return width*length;
    }
}
