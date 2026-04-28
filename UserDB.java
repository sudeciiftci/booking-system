import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDB {

    public Connection con(){

        String url = "jdbc:mysql://localhost:3306/MovieDB";
        String user = "root";
        String password = "root1234";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Başarılı");

            return conn;

        } catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }
}