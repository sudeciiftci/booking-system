import javax.swing.JOptionPane;
import java.util.List;

public class MovieService {

    MovieDB movieDB = new MovieDB();

    public Movie validateMovie(String title, String genre, int duration, String desc, double rating) {

        if (title == null || title.isEmpty()
                || genre == null || genre.isEmpty()
                || desc == null || desc.isEmpty()
                || duration <= 0
                || rating < 0) {

            JOptionPane.showMessageDialog(null, "Fields cannot be empty or invalid!");
            return null;
        }

        return new Movie(title, genre, duration, desc, rating);
    }

    public void addMovie(Movie movie){

        if(movie != null){
            movieDB.saveMovie(movie);
        }
    }

    public String validateTitle(String title) {

        if (title == null || title.trim().isEmpty()) {
            return "Title cannot be empty!";
        }

        return null;
    }
    
    public void updateMovie(Movie movie){

        if(movie.getRating() < 0 || movie.getRating() > 10){
            throw new IllegalArgumentException("Invalid rating!");
        }
        movieDB.updateMovie(movie);
    }

    public void deleteMovie(int id){
        movieDB.deleteMovie(id);
    }

    public List<Movie> getAllMovies() {
        return movieDB.getAllMovies();
    }

}