import java.util.List;

public class RegisteredUser extends User{

    private List<String> preferences;

    public RegisteredUser(int userId, String userName, String email, String password, List<String> preferences, List<Ticket> tickets){
        super(userName, email, password);
        this.preferences = preferences;
    }

    public List<String> getPreferences() { return preferences; }

    public void addPreference(String preference) { preferences.add(preference); }

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
