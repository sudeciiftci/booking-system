import javax.swing.*;
import java.awt.*;

public class AdminUI extends JFrame {

    JPanel contentPanel;
    MoviePanel moviePanel;
    HallPanel hallPanel; 

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

        moviePanel = new MoviePanel(contentPanel);
        hallPanel = new HallPanel(contentPanel); 

        setPanel(new HomePanel());

        // ================= SESSION POPUP =================
        JPopupMenu sessionMenu = new JPopupMenu();

        // ===== HALL MENU =====
        JMenu hallMenu = new JMenu("Hall");

        JMenuItem addHall = new JMenuItem("Add Hall");
        JMenuItem updateHall = new JMenuItem("Update Hall");

        hallMenu.add(addHall);
        hallMenu.add(updateHall);

        addHall.addActionListener(e -> hallPanel.showAddHall());
        updateHall.addActionListener(e -> hallPanel.showUpdateHall());

        // ===== SESSION MENU =====
        JMenu sessionSubMenu = new JMenu("Session");

        JMenuItem addSession = new JMenuItem("Add Session");
        JMenuItem updateSession = new JMenuItem("Update Session");
        JMenuItem deleteSession = new JMenuItem("Delete Session");
        JMenuItem listSession = new JMenuItem("List Sessions");

        sessionSubMenu.add(addSession);
        sessionSubMenu.add(updateSession);
        sessionSubMenu.add(deleteSession);
        sessionSubMenu.add(listSession);

        sessionMenu.add(hallMenu);
        sessionMenu.add(sessionSubMenu);

        // ================= DASHBOARD =================
        dashboardBtn.addActionListener(e -> setPanel(new HomePanel()));

        usersBtn.addActionListener(e -> simple("Users Panel"));
        reportsBtn.addActionListener(e -> simple("Reports Panel"));

        // ================= MOVIES POPUP =================
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
        addMovie.addActionListener(e -> moviePanel.showAddMovie());
        updateMovie.addActionListener(e -> moviePanel.showUpdateMovie());
        deleteMovie.addActionListener(e -> moviePanel.showDeleteMovie());
        listMovie.addActionListener(e -> moviePanel.showListMovie());

        moviesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                movieMenu.show(moviesBtn, 0, moviesBtn.getHeight());
            }
        });

        sessionBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                sessionMenu.show(sessionBtn, 0, sessionBtn.getHeight());
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

    // ================= SIMPLE =================
    private void simple(String text) {
        contentPanel.removeAll();

        JLabel label = new JLabel(text);
        label.setBounds(200, 200, 200, 30);
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