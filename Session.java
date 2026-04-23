import java.util.List;

public class Session {
    private int sessionId;
    private Movie movie;
    private Hall hall;
    private String dateTime;
    private double price;

    public Session(int sessionId, Movie movie, Hall hall, String dateTime, double price){
        this.sessionId = sessionId;
        this.movie = movie;
        this.hall = hall;
        this.dateTime = dateTime;
        this.price = price;
    }

    public int getSessionId() { return sessionId; }
    public Movie getMovie() { return movie; }
    public Hall getHall() { return hall; }
    public String getDateTime() { return dateTime; }
    public double getPrice() { return price; }

    // Setters
    public void setDateTime(String dateTime) { this.dateTime = dateTime; }
    public void setPrice(double price) { this.price = price; }

    public List<Seat> getAvailableSeats() {

    }
}
