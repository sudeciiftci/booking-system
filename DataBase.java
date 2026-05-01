import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    public Connection con() throws SQLException {

        return DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);

    }
    
}
