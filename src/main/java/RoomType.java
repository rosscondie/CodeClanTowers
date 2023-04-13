public enum RoomType {
    SINGLE (1, 50),
    DOUBLE(2, 100);

    private int capacity;
    private int price;

    RoomType(int capacity, int price) {
        this.capacity = capacity;
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice(){
        return price;
    }
}

