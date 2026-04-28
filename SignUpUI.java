import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SignUpUI extends JFrame {

    public SignUpUI() {

        UserDB userDB = new UserDB();

        setTitle("Sign Up");
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Create Account");
        title.setBounds(130, 20, 200, 30);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title);

        JLabel nameLabel = new JLabel("User Name:");
        nameLabel.setBounds(50, 70, 100, 30);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 70, 150, 30);
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 110, 100, 30);
        add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(150, 110, 150, 30);
        add(emailField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 150, 100, 30);
        add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 150, 150, 30);
        add(passField);

        JLabel prefLabel = new JLabel("Preferences:");
        prefLabel.setBounds(50, 190, 100, 30);
        add(prefLabel);

        JCheckBox action = new JCheckBox("Action");
        action.setBounds(150, 190, 100, 30);
        add(action);

        JCheckBox comedy = new JCheckBox("Comedy");
        comedy.setBounds(150, 220, 100, 30);
        add(comedy);

        JCheckBox drama = new JCheckBox("Drama");
        drama.setBounds(150, 250, 100, 30);
        add(drama);

        JCheckBox horror = new JCheckBox("Horror");
        horror.setBounds(150, 280, 100, 30);
        add(horror);

        JButton signUpButton = new JButton("Create Account");
        signUpButton.setBounds(120, 320, 150, 40);
        add(signUpButton);

        ArrayList<String> genres = new ArrayList<>();

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                if(action.isSelected()){
                    genres.add("Action");
                }
                if(comedy.isSelected()){
                    genres.add("Comedy");
                }
                if(drama.isSelected()){
                    genres.add("Drama");
                }
                if(horror.isSelected()){
                    genres.add("Horror");
                }

                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passField.getPassword());   

                if(name.isEmpty() || email.isEmpty() || password.isEmpty()){

                    JOptionPane.showMessageDialog(SignUpUI.this, "Fields cannot be empty!");
                    return;
                }else if(!email.contains("@gmail.com")){
                    JOptionPane.showMessageDialog(SignUpUI.this, 
                        "Invalid email format!\nEmail must end with @gmail.com");                    
                    return;
                }else if(name.length() < 3){
                    JOptionPane.showMessageDialog(SignUpUI.this, 
    "Name is too short!\nPlease enter at least 3 characters.");
                    return;
                }else if(!password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).+$")){

                    JOptionPane.showMessageDialog(SignUpUI.this,
    "Password must contain at least:\n- 1 uppercase letter\n- 1 number\n- 1 special character");
                    return;
                }else if(genres.isEmpty()){
                    JOptionPane.showMessageDialog(SignUpUI.this,
    "Please select at least one genre!");
                    return;
                }else{
                    System.out.print("tamamdır");
                    userDB.con();
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUpUI();
    }
}