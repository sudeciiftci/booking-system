import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDB {

    DataBase dataBase = new DataBase();

    public boolean saveMovie(Movie movie){

        String sql = "INSERT INTO movies (title, genre, duration, description, rating, image_path) VALUES (?, ?, ?, ?, ?, ?)";

        try{
            Connection connection = dataBase.con();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getGenre());
            ps.setInt(3, movie.getDuration());
            ps.setString(4, movie.getDescription());
            ps.setDouble(5, movie.getRating());
            ps.setString(6, movie.getImagePath());

            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Movie getMovieByTitle(String title){

        String sql = "SELECT * FROM movies WHERE title = ?";

        try{
            Connection connection = dataBase.con();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, title);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Movie movie = new Movie(
                        rs.getInt("movie_id"),
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getInt("duration"),
                        rs.getString("description"),
                        rs.getDouble("rating")
                );
                rs.close();
                ps.close();
                return movie;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void updateMovie(Movie movie) {

        String sql = "UPDATE movies SET title=?, genre=?, duration=?, description=?, rating=? WHERE movie_id=?";

        try {
            Connection con = dataBase.con();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getGenre());
            ps.setInt(3, movie.getDuration());
            ps.setString(4, movie.getDescription());
            ps.setDouble(5, movie.getRating());

            // 🔥 kritik nokta
            ps.setInt(6, movie.getMovieId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteMovie(int id) {

    String sql = "DELETE FROM movies WHERE movie_id=?";

    try {
        Connection con = dataBase.con();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ps.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public List<Movie> getAllMovies() {

        List<Movie> movies = new ArrayList<>();

        String sql = "SELECT * FROM movies";
        try {
            Connection con = dataBase.con();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Movie movie = new Movie(
                        rs.getInt("movie_id"),
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getInt("duration"),
                        rs.getString("description"),
                        rs.getDouble("rating"),
                        rs.getString("image_path")
                );
                movies.add(movie);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }

   public Movie getMovieById(int id){

        String sql = "SELECT * FROM movies WHERE movie_id = ?";

        try{
            Connection connection = dataBase.con();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Movie movie = new Movie(
                        rs.getInt("movie_id"),
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getInt("duration"),
                        rs.getString("description"),
                        rs.getDouble("rating")
                );
                rs.close();
                ps.close();
                return movie;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    } 

    public List<String> getUserGenres(int userId) {

        List<String> genres = new ArrayList<>();

        String sql = "SELECT genre FROM genres WHERE userId = ?";

        try (Connection conn = dataBase.con();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                genres.add(rs.getString("genre"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return genres;
    }
}
