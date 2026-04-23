import java.util.ArrayList;
import java.util.List;

public class Booking {

    private int bookingId;
    private RegisteredUser user;
    private Session session;
    private List<Seat> selectedSeats;
    private Payment payment;
    private String status;

    public Booking(int bookingId, RegisteredUser user, Session session, List<Seat> selectedSeats) {
        this.bookingId = bookingId;
        this.user = user;
        this.session = session;
        this.selectedSeats = selectedSeats != null ? selectedSeats : new ArrayList<>();
        this.payment = null;
        this.status = "PENDING";
    }

    public int getBookingId() { return bookingId; }
    public RegisteredUser getUser() { return user; }
    public Session getSession() { return session; }
    public List<Seat> getSelectedSeats() { return selectedSeats; }
    public Payment getPayment() { return payment; }
    public String getStatus() { return status; }

    public void setPayment(Payment payment) { this.payment = payment; }
    public void setStatus(String status) { this.status = status; }

    void confirmBooking(){

    }

    void cancelBooking(){
        
    }
}
