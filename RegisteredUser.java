import java.util.ArrayList;
import java.util.List;

public class RegisteredUser extends User{

    private List<String> preferences;
    private List<Ticket> tickets;

    public RegisteredUser(int userId, String name, String email, String password, List<String> preferences, List<Ticket> tickets){
        super(userId, name, email, password);
        this.preferences = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    public List<String> getPreferences() { return preferences; }
    public List<Ticket> getTickets() { return tickets; }

    public void addPreference(String preference) { preferences.add(preference); }
    public void addTicket(Ticket ticket) { tickets.add(ticket); }

    void viewMovies(){

    }

    void viewMovieDetails(){

    }

    void createBooking(){

    }

    void rateMovie(){

    }

    void viewRecommendations(){

    }

}
