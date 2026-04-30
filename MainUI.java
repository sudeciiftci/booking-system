import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainUI extends JFrame {

    public MainUI() {

        setTitle("User System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel title = new JLabel("Welcome");
        title.setBounds(150, 30, 100, 30);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(120, 100, 150, 40);
        add(signUpButton);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(120, 160, 150, 40);
        add(loginButton);

        signUpButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new SignUpUI();
        }
        });

        loginButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new LoginUI();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainUI(); 
    }
}