
public class Ticket {

    private int ticketId;
    private Session session;
    private Seat seat;
    private String qrCode;

    public Ticket(int ticketId, Session session, Seat seat) {
        this.ticketId = ticketId;
        this.session = session;
        this.seat = seat;
        this.qrCode = null;
    }

    public int getTicketId() { return ticketId; }
    public Session getSession() { return session; }
    public Seat getSeat() { return seat; }
    public String getQrCode() { return qrCode; }

    public void generateTicket() {

    }
    
}
