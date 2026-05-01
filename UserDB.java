import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDB {

    DataBase dataBase = new DataBase();

    public int addUser(User user){

        String sql = "INSERT INTO users (userName, email, password, role) VALUES(?, ?, ?, ?)";

        try{
            Connection conn = dataBase.con();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, "user");

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            int id = -1;

            if(rs.next()){
                id = rs.getInt(1);
            }

            ps.close();
            rs.close();
            return id;

        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }  
    }

    public void addGenre(int userId, ArrayList<String> genres){

        String sql = "INSERT INTO genres (userId, genre) VALUES (?, ?)";

        try{
            Connection connection = dataBase.con();
            PreparedStatement ps = connection.prepareStatement(sql);

            for(String genre : genres){
                ps.setInt(1, userId);
                ps.setString(2, genre);

                ps.executeUpdate();
                
            }
            ps.close();
      
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public String getRole(String userName, String password){

        String sql = "SELECT role FROM users WHERE userName = ? and password = ?";

        try{
            Connection connection = dataBase.con();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return rs.getString("role");
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}