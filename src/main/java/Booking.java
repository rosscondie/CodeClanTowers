public class Booking {
    private int numberOfNights;
    private Bedroom bedroom;

    public Booking(int numberOfNights, Bedroom bedroom) {
        this.numberOfNights = numberOfNights;
        this.bedroom = bedroom;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public Bedroom getBedroom() {
        return bedroom;
    }

    public int getTotalPrice() {
      return bedroom.getRoomType().getPrice() * numberOfNights;
    }
}
