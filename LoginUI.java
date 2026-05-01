import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame {

    public LoginUI() {

        UserService userService = new UserService();

        setTitle("Login");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Login");
        title.setBounds(160, 20, 100, 30);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 80, 100, 30);
        add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(150, 80, 150, 30);
        add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 130, 100, 30);
        add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 130, 150, 30);
        add(passField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(130, 190, 120, 40);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
                String userName = userField.getText();
                String password = new String(passField.getPassword());

                String role = userService.login(userName, password);
                userService.openPage(role);

            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginUI();
    }
}