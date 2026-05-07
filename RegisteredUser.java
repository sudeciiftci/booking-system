public class RegisteredUser extends User{

    private int userId;

    public RegisteredUser(String userName, String email, String password){
        super(userName, email, password, "user");
    }

    

    public RegisteredUser(int userId, String name, String email, String password, String role) {
        super(name, email, password, role);
        this.userId = userId;
    }



    public int getUserId() {
        return userId;
    }


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
