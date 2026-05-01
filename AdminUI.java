import javax.swing.*;
import java.awt.*;

public class AdminUI extends JFrame {

    JPanel contentPanel;

    public AdminUI() {

        setTitle("Admin Dashboard");
        setSize(800, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ================= LEFT MENU =================
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(null);
        menuPanel.setBounds(0, 0, 200, 500);
        menuPanel.setBackground(new Color(30, 30, 30));
        add(menuPanel);

        JLabel title = new JLabel("DASHBOARD");
        title.setBounds(40, 20, 150, 30);
        title.setForeground(Color.WHITE);
        menuPanel.add(title);

        JButton dashboardBtn = new JButton("Dashboard");
        dashboardBtn.setBounds(20, 70, 160, 35);
        menuPanel.add(dashboardBtn);

        JButton moviesBtn = new JButton("Movies");
        moviesBtn.setBounds(20, 120, 160, 35);
        menuPanel.add(moviesBtn);

        JButton sessionBtn = new JButton("Sessions");
        sessionBtn.setBounds(20, 170, 160, 35);
        menuPanel.add(sessionBtn);

        JButton usersBtn = new JButton("Users");
        usersBtn.setBounds(20, 220, 160, 35);
        menuPanel.add(usersBtn);

        JButton reportsBtn = new JButton("Reports");
        reportsBtn.setBounds(20, 270, 160, 35);
        menuPanel.add(reportsBtn);

        // ================= CONTENT =================
        contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBounds(200, 0, 600, 500);
        contentPanel.setBackground(Color.WHITE);
        add(contentPanel);

        setPanel(new HomePanel());

        // ================= DASHBOARD =================
        dashboardBtn.addActionListener(e -> setPanel(new HomePanel()));

        sessionBtn.addActionListener(e -> simple("Sessions Panel"));
        usersBtn.addActionListener(e -> simple("Users Panel"));
        reportsBtn.addActionListener(e -> simple("Reports Panel"));

        // ================= MOVIES HOVER MENU =================
        JPopupMenu movieMenu = new JPopupMenu();

        JMenuItem addMovie = new JMenuItem("Add Movie");
        JMenuItem updateMovie = new JMenuItem("Update Movie");
        JMenuItem deleteMovie = new JMenuItem("Delete Movie");
        JMenuItem listMovie = new JMenuItem("List Movies");

        movieMenu.add(addMovie);
        movieMenu.add(updateMovie);
        movieMenu.add(deleteMovie);
        movieMenu.add(listMovie);

        // ================= ACTIONS =================
        addMovie.addActionListener(e -> showAddMovie());
        updateMovie.addActionListener(e -> showUpdateMovie());
        deleteMovie.addActionListener(e -> showDeleteMovie());
        listMovie.addActionListener(e -> showListMovie());

        moviesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                movieMenu.show(moviesBtn, 0, moviesBtn.getHeight());
            }
        });

        setVisible(true);
    }

    // ================= HOME =================
    class HomePanel extends JPanel {
        public HomePanel() {
            setLayout(null);
            setBounds(0, 0, 600, 500);
            setBackground(Color.WHITE);

            JLabel title = new JLabel("Admin Overview");
            title.setBounds(200, 100, 300, 30);
            title.setFont(new Font("Arial", Font.BOLD, 20));
            add(title);

            JLabel info = new JLabel("System is running...");
            info.setBounds(200, 150, 300, 30);
            add(info);
        }
    }

    // ================= ADD MOVIE =================
    private void showAddMovie() {
        contentPanel.removeAll();

        JLabel title = new JLabel("Add Movie");
        title.setBounds(200, 50, 200, 30);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        contentPanel.add(title);

        JTextField name = new JTextField();
        name.setBounds(200, 100, 200, 30);
        contentPanel.add(name);

        JTextField genre = new JTextField();
        genre.setBounds(200, 140, 200, 30);
        contentPanel.add(genre);

        JButton save = new JButton("Save");
        save.setBounds(200, 200, 120, 30);
        contentPanel.add(save);

        save.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Movie Added: " + name.getText()));

        refresh();
    }

    // ================= UPDATE MOVIE =================
    private void showUpdateMovie() {
        contentPanel.removeAll();

        JLabel title = new JLabel("Update Movie");
        title.setBounds(200, 50, 200, 30);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        contentPanel.add(title);

        JTextField search = new JTextField();
        search.setBounds(200, 100, 200, 30);
        contentPanel.add(search);

        JTextField newName = new JTextField();
        newName.setBounds(200, 140, 200, 30);
        contentPanel.add(newName);

        JButton update = new JButton("Update");
        update.setBounds(200, 200, 120, 30);
        contentPanel.add(update);

        update.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Movie Updated"));

        refresh();
    }

    // ================= DELETE MOVIE =================
    private void showDeleteMovie() {
        contentPanel.removeAll();

        JLabel title = new JLabel("Delete Movie");
        title.setBounds(200, 50, 200, 30);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        contentPanel.add(title);

        JTextField search = new JTextField();
        search.setBounds(200, 100, 200, 30);
        contentPanel.add(search);

        JButton delete = new JButton("Delete");
        delete.setBounds(200, 150, 120, 30);
        contentPanel.add(delete);

        delete.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Deleted: " + search.getText()));

        refresh();
    }

    // ================= LIST MOVIE =================
    private void showListMovie() {
        contentPanel.removeAll();

        JLabel title = new JLabel("Movie List");
        title.setBounds(200, 50, 200, 30);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        contentPanel.add(title);

        JLabel info = new JLabel("No movies yet (DB later)");
        info.setBounds(200, 120, 300, 30);
        contentPanel.add(info);

        refresh();
    }

    // ================= SIMPLE =================
    private void simple(String text) {
        contentPanel.removeAll();

        JLabel label = new JLabel(text);
        label.setBounds(200, 200, 300, 30);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        contentPanel.add(label);

        refresh();
    }

    // ================= PANEL SWITCH =================
    public void setPanel(JPanel panel) {
        contentPanel.removeAll();
        panel.setBounds(0, 0, 600, 500);
        contentPanel.add(panel);
        refresh();
    }

    private void refresh() {
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public static void main(String[] args) {
        new AdminUI();
    }
}