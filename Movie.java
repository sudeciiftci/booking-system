public class Movie {
    private int movieId;
    private String title;
    private String genre;
    private int duration;
    private String description;
    private double rating;

    public Movie(int movieId, String title, String genre, int duration, String description, double rating){
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.description = description;
        this.rating = rating;
    }

    public int getMovieId() { return movieId; }
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getDuration() { return duration; }
    public String getDescription() { return description; }
    public double getRating() { return rating; }

  
    public void setTitle(String title) { this.title = title; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setDuration(int duration) { this.duration = duration; }
    public void setDescription(String description) { this.description = description; }

    void addRating(int rating){

    }

    void getAverageRating(){
        
    }
}
