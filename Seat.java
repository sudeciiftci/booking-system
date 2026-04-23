public class Seat extends Hall{

    private String seatNumber;
    private boolean isReserved;

    public Seat(int hallId, String name, int seatCapacity, String[] seats, String seatNumber, boolean isReserved){
        super(hallId, name, seatCapacity, seats);
        this.seatNumber = seatNumber;
        this.isReserved = isReserved;
    }

    public String getSeatNumber() { return seatNumber; }
    public boolean isReserved() { return isReserved; }

    void reserve(){

    }

    void release(){
        
    }
}
