import javax.swing.*;
import java.awt.*;

public class HallPanel {

    private JPanel contentPanel;

    public HallPanel(JPanel contentPanel) {
        this.contentPanel = contentPanel;
    }

    public void showAddHall() {

        contentPanel.removeAll();

        // ===== TITLE =====
        JLabel title = new JLabel("Add Hall");
        title.setBounds(220, 30, 200, 30);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        contentPanel.add(title);

        // ===== HALL NAME =====
        JLabel nameLabel = new JLabel("Hall Name:");
        nameLabel.setBounds(120, 120, 120, 30);
        contentPanel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(240, 120, 200, 30);
        contentPanel.add(nameField);

        // ===== CAPACITY =====
        JLabel capacityLabel = new JLabel("Seat Capacity:");
        capacityLabel.setBounds(120, 180, 120, 30);
        contentPanel.add(capacityLabel);

        JTextField capacityField = new JTextField();
        capacityField.setBounds(240, 180, 200, 30);
        contentPanel.add(capacityField);

        // ===== BUTTON =====
        JButton addBtn = new JButton("Add Hall");
        addBtn.setBounds(240, 250, 200, 40);
        addBtn.setBackground(new Color(30, 144, 255));
        addBtn.setForeground(Color.WHITE);
        addBtn.setFocusPainted(false);
        contentPanel.add(addBtn);

        // ===== ACTION =====
        addBtn.addActionListener(e -> {
            try {
                String hallName = nameField.getText();
                int hallCapacity = Integer.parseInt(capacityField.getText());

                HallService hallService = new HallService();

                boolean result = hallService.addHall(hallName, hallCapacity);

                if (result) {
                    JOptionPane.showMessageDialog(null, "Hall added successfully!");
                    nameField.setText("");
                    capacityField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Hall could not be added!");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Capacity must be a number!");
            }
        });

        refresh();
    }
   
    public void showUpdateHall() {

        contentPanel.removeAll();

        JLabel title = new JLabel("Update Hall");
        title.setBounds(200, 20, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        contentPanel.add(title);

        JLabel searchLabel = new JLabel("Search Hall:");
        searchLabel.setBounds(80, 80, 120, 30);
        contentPanel.add(searchLabel);

        JTextField searchField = new JTextField();
        searchField.setBounds(200, 80, 200, 30);
        contentPanel.add(searchField);

        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(410, 80, 100, 30);
        contentPanel.add(searchBtn);

        JLabel nameLabel = new JLabel("Hall Name:");
        nameLabel.setBounds(80, 150, 120, 30);
        contentPanel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(200, 150, 250, 30);
        contentPanel.add(nameField);

        JLabel capacityLabel = new JLabel("Capacity:");
        capacityLabel.setBounds(80, 200, 120, 30);
        contentPanel.add(capacityLabel);

        JTextField capacityField = new JTextField();
        capacityField.setBounds(200, 200, 250, 30);
        contentPanel.add(capacityField);

        JButton updateBtn = new JButton("Update Hall");
        updateBtn.setBounds(200, 280, 200, 40);
        contentPanel.add(updateBtn);

        searchBtn.addActionListener(e -> {

            String searchName = searchField.getText();

            HallService hallService = new HallService();
            Hall hall = hallService.getHallByName(searchName);

            if (hall != null) {
                nameField.setText(hall.getName());
                capacityField.setText(String.valueOf(hall.getSeatCapacity()));
            } else {
                JOptionPane.showMessageDialog(null, "Hall not found!");
            }
        });


        updateBtn.addActionListener(e -> {

            try {
                String searchName = searchField.getText();
                String newName = nameField.getText();
                int newCapacity = Integer.parseInt(capacityField.getText());

                HallService hallService = new HallService();

                boolean result = hallService.updateHall(searchName, newName, newCapacity);

                if (result) {
                    JOptionPane.showMessageDialog(null, "Hall updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Hall not found or update failed!");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Capacity must be a number!");
            }
        });

        refresh();
    }

    private void refresh() {
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}