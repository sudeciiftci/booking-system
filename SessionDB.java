import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SessionDB {

    DataBase dataBase = new DataBase();

    public boolean addSession(Session session) {
        String sql = "INSERT INTO session (movie_id, hall_id, date_time, price) VALUES (?, ?, ?, ?)";
        try (Connection conn = dataBase.con();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, session.getMovie().getMovieId());
            ps.setInt(2, session.getHall().getHallId());
            ps.setString(3, session.getDateTime());
            ps.setDouble(4, session.getPrice());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Session> getAllSessions() {

        List<Session> list = new ArrayList<>();

        String sql = "SELECT * FROM session";

        try (Connection conn = dataBase.con();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Movie movie = new MovieDB().getMovieById(rs.getInt("movie_id"));
                Hall hall = new HallDB().getHallById(rs.getInt("hall_id"));

                Session session = new Session(
                        rs.getInt("session_id"),
                        movie,
                        hall,
                        rs.getString("date_time"),
                        rs.getDouble("price")
                );

                list.add(session);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean updateSession(int sessionId, Session session) {

        String sql = "UPDATE session SET movie_id=?, hall_id=?, date_time=?, price=? WHERE session_id=?";

        try (Connection conn = dataBase.con();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, session.getMovie().getMovieId());
            ps.setInt(2, session.getHall().getHallId());
            ps.setString(3, session.getDateTime());
            ps.setDouble(4, session.getPrice());
            ps.setInt(5, sessionId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteSession(int sessionId) {

        String sql = "DELETE FROM session WHERE session_id=?";

        try (Connection conn = dataBase.con();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, sessionId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}