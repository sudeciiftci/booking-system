import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HallDB {

    DataBase dataBase = new DataBase();

    public boolean addHall(Hall hall) {

        String sql = "INSERT INTO hall(name, seat_capacity) VALUES(?, ?)";

        try (Connection conn = dataBase.con();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, hall.getName());
            ps.setInt(2, hall.getSeatCapacity());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateHall(String searchName, String newName, int newCapacity) {

        String sql = "UPDATE hall SET name = ?, seat_capacity = ? WHERE name = ?";

        try (Connection conn = dataBase.con();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newName);
            ps.setInt(2, newCapacity);
            ps.setString(3, searchName);

            int updated = ps.executeUpdate();

            return updated > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Hall getHallByName(String name) {

        String sql = "SELECT * FROM hall WHERE name = ?";

        try (Connection conn = dataBase.con();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Hall(
                    rs.getInt("hall_id"),
                    rs.getString("name"),
                    rs.getInt("seat_capacity")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}