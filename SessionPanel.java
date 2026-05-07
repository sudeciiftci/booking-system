import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SessionPanel {

    private JPanel contentPanel;

    public SessionPanel(JPanel contentPanel) {
        this.contentPanel = contentPanel;
    }

    public void showAddSession() {

        contentPanel.removeAll();

        // ===== TITLE =====
        JLabel title = new JLabel("Add Session");
        title.setBounds(220, 30, 200, 30);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        contentPanel.add(title);

        // ===== MOVIE =====
        JLabel movieLabel = new JLabel("Select Movie:");
        movieLabel.setBounds(120, 100, 120, 30);
        contentPanel.add(movieLabel);

        JComboBox<Movie> movieBox = new JComboBox<>();
        movieBox.setBounds(240, 100, 200, 30);
        contentPanel.add(movieBox);

        // ===== HALL =====
        JLabel hallLabel = new JLabel("Select Hall:");
        hallLabel.setBounds(120, 150, 120, 30);
        contentPanel.add(hallLabel);

        JComboBox<Hall> hallBox = new JComboBox<>();
        hallBox.setBounds(240, 150, 200, 30);
        contentPanel.add(hallBox);

        // ===== DATE =====
        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(120, 200, 120, 30);
        contentPanel.add(dateLabel);

        JTextField dateField = new JTextField();
        dateField.setBounds(240, 200, 200, 30);
        contentPanel.add(dateField);

        // ===== TIME =====
        JLabel timeLabel = new JLabel("Time:");
        timeLabel.setBounds(120, 250, 120, 30);
        contentPanel.add(timeLabel);

        JTextField timeField = new JTextField();
        timeField.setBounds(240, 250, 200, 30);
        contentPanel.add(timeField);

        // ===== PRICE =====
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(120, 300, 120, 30);
        contentPanel.add(priceLabel);

        JTextField priceField = new JTextField();
        priceField.setBounds(240, 300, 200, 30);
        contentPanel.add(priceField);

        // ===== BUTTON =====
        JButton addBtn = new JButton("Add Session");
        addBtn.setBounds(240, 360, 200, 40);
        addBtn.setBackground(new Color(30, 144, 255));
        addBtn.setForeground(Color.WHITE);
        addBtn.setFocusPainted(false);
        contentPanel.add(addBtn);

        MovieDB movieDB = new MovieDB();
        HallDB hallDB = new HallDB();

        for(Movie m : movieDB.getAllMovies()){
            movieBox.addItem(m);
        }

        for(Hall h : hallDB.getAllHalls()){
            hallBox.addItem(h);
        }

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                try {
                    Movie selectedMovie = (Movie) movieBox.getSelectedItem();
                    Hall selectedHall = (Hall) hallBox.getSelectedItem();

                    String dateTime = dateField.getText();
                    double price = Double.parseDouble(priceField.getText());

                    SessionService service = new SessionService();

                    boolean success = service.addSession(
                            selectedMovie,
                            selectedHall,
                            dateTime,
                            price
                    );

                    if (success) {
                        JOptionPane.showMessageDialog(null, "Session added!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error!");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Price must be number!");
                }
            }
        });

        refresh();
    }

    public void showUpdateSession() {

        contentPanel.removeAll();

        // ===== TITLE =====
        JLabel title = new JLabel("Update Session");
        title.setBounds(200, 20, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        contentPanel.add(title);

        // ===== SESSION SELECT (ID YOK!) =====
        JLabel sessionLabel = new JLabel("Select Session:");
        sessionLabel.setBounds(80, 80, 150, 30);
        contentPanel.add(sessionLabel);

        JComboBox<Session> sessionBox = new JComboBox<>();
        sessionBox.setBounds(230, 80, 300, 30);
        contentPanel.add(sessionBox);

        // ===== MOVIE =====
        JLabel movieLabel = new JLabel("Movie:");
        movieLabel.setBounds(80, 140, 120, 30);
        contentPanel.add(movieLabel);

        JComboBox<Movie> movieBox = new JComboBox<>();
        movieBox.setBounds(230, 140, 300, 30);
        contentPanel.add(movieBox);

        // ===== HALL =====
        JLabel hallLabel = new JLabel("Hall:");
        hallLabel.setBounds(80, 190, 120, 30);
        contentPanel.add(hallLabel);

        JComboBox<Hall> hallBox = new JComboBox<>();
        hallBox.setBounds(230, 190, 300, 30);
        contentPanel.add(hallBox);

        // ===== DATE =====
        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(80, 240, 120, 30);
        contentPanel.add(dateLabel);

        JTextField dateField = new JTextField();
        dateField.setBounds(230, 240, 300, 30);
        contentPanel.add(dateField);

        // ===== TIME =====
        JLabel timeLabel = new JLabel("Time:");
        timeLabel.setBounds(80, 290, 120, 30);
        contentPanel.add(timeLabel);

        JTextField timeField = new JTextField();
        timeField.setBounds(230, 290, 300, 30);
        contentPanel.add(timeField);

        // ===== PRICE =====
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(80, 340, 120, 30);
        contentPanel.add(priceLabel);

        JTextField priceField = new JTextField();
        priceField.setBounds(230, 340, 300, 30);
        contentPanel.add(priceField);

        // ===== UPDATE BUTTON =====
        JButton updateBtn = new JButton("Update Session");
        updateBtn.setBounds(230, 400, 200, 40);
        contentPanel.add(updateBtn);

        SessionDB sessionDB = new SessionDB();

        for (Session s : sessionDB.getAllSessions()) {
            sessionBox.addItem(s);
        }
        MovieDB movieDB = new MovieDB();

        for (Movie m : movieDB.getAllMovies()) {
            movieBox.addItem(m);
        }

        HallDB hallDB = new HallDB();

        for (Hall h : hallDB.getAllHalls()) {
            hallBox.addItem(h);
        }

        updateBtn.addActionListener(e -> {

            SessionService service = new SessionService();

            try {
                Session selected = (Session) sessionBox.getSelectedItem();

                Movie movie = (Movie) movieBox.getSelectedItem();
                Hall hall = (Hall) hallBox.getSelectedItem();

                String dateTime = dateField.getText();
                double price = Double.parseDouble(priceField.getText());

                boolean result = service.updateSession(selected, movie, hall, dateTime, price);

                if (result) {
                    JOptionPane.showMessageDialog(null, "Session updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Update failed!");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        });

        refresh();
    }
    
    public void showDeleteSession() {

        contentPanel.removeAll();

        JLabel title = new JLabel("Delete Session");
        title.setBounds(200, 30, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        contentPanel.add(title);

        JLabel label = new JLabel("Select Session:");
        label.setBounds(80, 120, 150, 30);
        contentPanel.add(label);

        JComboBox<Session> sessionBox = new JComboBox<>();
        sessionBox.setBounds(230, 120, 300, 30);
        contentPanel.add(sessionBox);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(230, 200, 200, 40);
        contentPanel.add(deleteBtn);

        // 🔥 VERİYİ DOLDUR
        SessionDB db = new SessionDB();
        for (Session s : db.getAllSessions()) {
            sessionBox.addItem(s);
        }

        deleteBtn.addActionListener(e -> {

            Session selected = (Session) sessionBox.getSelectedItem();

            if (selected == null) {
                JOptionPane.showMessageDialog(null, "Select session!");
                return;
            }

            boolean result = new SessionService().deleteSession(selected.getSessionId());

            if (result) {
                JOptionPane.showMessageDialog(null, "Deleted!");
            } else {
                JOptionPane.showMessageDialog(null, "Delete failed!");
            }
        });

        refresh();
    }
    
    public void showListSession() {

        contentPanel.removeAll();

        JLabel title = new JLabel("Session List");
        title.setBounds(220, 20, 200, 30);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        contentPanel.add(title);

        String[] columns = {"ID","Movie", "Hall", "Date-Time", "Price"};

        javax.swing.table.DefaultTableModel model =
                new javax.swing.table.DefaultTableModel(columns, 0);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 80, 500, 300);

        contentPanel.add(scrollPane);

        SessionService service = new SessionService();

        for (Session s : service.getAllSessions()) {

            Object[] row = {
                    s.getSessionId(),
                    s.getMovie().getTitle(),
                    s.getHall().getName(),
                    s.getDateTime(),
                    s.getPrice()
            };

            model.addRow(row);
        }

        refresh();
    }

    private void refresh() {
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}