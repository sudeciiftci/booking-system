import java.util.ArrayList;
import java.util.List;

public class Hall {
    private int hallId;
    private String name;
    private int seatCapacity;
    private List<Seat> seats;

    public Hall(int hallId, String name, int seatCapacity, String[] seats){
        this.hallId = hallId;
        this.name = name;
        this.seatCapacity = seatCapacity;
        this.seats = new ArrayList<>();
    }

    public int getHallId() { return hallId; }
    public String getName() { return name; }
    public int getSeatCapacity() { return seatCapacity; }
    public List<Seat> getSeats() { return seats; }

    void addSeat(Seat seat){

    }

    void getAvailableSeats(){

    }
}
