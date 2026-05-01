import javax.swing.*;
import java.awt.*;

public class FilmPanel extends JPanel {

    private JPanel formPanel;

    public FilmPanel() {

        setLayout(null);
        setBackground(Color.WHITE);

        // ================= TITLE =================
        JLabel title = new JLabel("Movie Management");
        title.setBounds(180, 20, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        // ================= BUTTONS =================
        JButton addBtn = new JButton("Add");
        addBtn.setBounds(50, 80, 100, 30);
        add(addBtn);

        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(170, 80, 100, 30);
        add(updateBtn);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(290, 80, 100, 30);
        add(deleteBtn);

        // ================= FORM PANEL =================
        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(50, 130, 450, 250);
        formPanel.setBackground(Color.LIGHT_GRAY);
        add(formPanel);

        // DEFAULT
        showAddForm();

        // ================= ACTIONS =================
        addBtn.addActionListener(e -> showAddForm());
        updateBtn.addActionListener(e -> showUpdateForm());
        deleteBtn.addActionListener(e -> showDeleteForm());
    }

    // ================= ADD =================
    private void showAddForm() {

        formPanel.removeAll();

        JLabel nameLabel = new JLabel("Movie Name:");
        nameLabel.setBounds(20, 20, 120, 30);
        formPanel.add(nameLabel);

        JTextField name = new JTextField();
        name.setBounds(140, 20, 200, 30);
        formPanel.add(name);

        JLabel genreLabel = new JLabel("Genre:");
        genreLabel.setBounds(20, 60, 120, 30);
        formPanel.add(genreLabel);

        JTextField genre = new JTextField();
        genre.setBounds(140, 60, 200, 30);
        formPanel.add(genre);

        JButton save = new JButton("Save");
        save.setBounds(140, 110, 120, 30);
        formPanel.add(save);

        save.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Movie Added: " + name.getText()));

        refresh();
    }

    // ================= UPDATE =================
    private void showUpdateForm() {

        formPanel.removeAll();

        JLabel searchLabel = new JLabel("Search Movie:");
        searchLabel.setBounds(20, 20, 120, 30);
        formPanel.add(searchLabel);

        JTextField search = new JTextField();
        search.setBounds(140, 20, 200, 30);
        formPanel.add(search);

        JTextField newName = new JTextField();
        newName.setBounds(140, 60, 200, 30);
        formPanel.add(newName);

        JButton update = new JButton("Update");
        update.setBounds(140, 110, 120, 30);
        formPanel.add(update);

        update.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Movie Updated"));

        refresh();
    }

    // ================= DELETE =================
    private void showDeleteForm() {

        formPanel.removeAll();

        JLabel searchLabel = new JLabel("Movie Name:");
        searchLabel.setBounds(20, 20, 120, 30);
        formPanel.add(searchLabel);

        JTextField search = new JTextField();
        search.setBounds(140, 20, 200, 30);
        formPanel.add(search);

        JButton delete = new JButton("Delete");
        delete.setBounds(140, 70, 120, 30);
        formPanel.add(delete);

        delete.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Deleted: " + search.getText()));

        refresh();
    }

    // ================= REFRESH =================
    private void refresh() {
        formPanel.revalidate();
        formPanel.repaint();
    }
}