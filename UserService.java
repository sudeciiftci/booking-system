import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UserService {

    UserDB userDB = new UserDB();
    
    public boolean validateUser(String name, String email, String password, ArrayList<String> genres){

        if(name.isEmpty() || email.isEmpty() || password.isEmpty()){
            JOptionPane.showMessageDialog(null, "Fields cannot be empty!");
            return false;
        }

        if(!email.contains("@gmail.com")){
            JOptionPane.showMessageDialog(null, "Invalid email format!\nEmail must end with @gmail.com");
            return false;
        }

        if(name.length() < 3){
            JOptionPane.showMessageDialog(null, "Name is too short!\nPlease enter at least 3 characters.");
            return false;
        }

        if(!password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).+$")){
            JOptionPane.showMessageDialog(null,
                "Password must contain at least:\n- 1 uppercase letter\n- 1 number\n- 1 special character");
            return false;
        }

        if(genres.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please select at least one genre!");
            return false;
        }

        return true;
    }

    public boolean register(String name, String email, String password, ArrayList<String> genres){

        if(validateUser(name, email, password, genres)){

            User user = new RegisteredUser(name, email, password);
            int userId = userDB.addUser(user);

            if(userId != -1){
                userDB.addGenre(userId, genres);
                JOptionPane.showMessageDialog(null,
                    "User registered successfully!");
                return true;
            }else{
                JOptionPane.showMessageDialog(null,
                    "An error occurred while registering the user. Please try again.");
                return false;
            }
        }
        return false;
    }

}
