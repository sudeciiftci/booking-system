import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MoviePanel {

    private JPanel contentPanel;

    public MoviePanel(JPanel contentPanel) {
        this.contentPanel = contentPanel;
    }

    // ================= ADD MOVIE =================
    public void showAddMovie() {

        contentPanel.removeAll();

        JLabel titleLabel = new JLabel("Movie Name:");
        titleLabel.setBounds(20, 20, 120, 30);
        contentPanel.add(titleLabel);

        JTextField titleField = new JTextField();
        titleField.setBounds(140, 20, 200, 30);
        contentPanel.add(titleField);

        JLabel genreLabel = new JLabel("Genre:");
        genreLabel.setBounds(20, 60, 120, 30);
        contentPanel.add(genreLabel);

        JTextField genreField = new JTextField();
        genreField.setBounds(140, 60, 200, 30);
        contentPanel.add(genreField);

        JLabel durationLabel = new JLabel("Duration:");
        durationLabel.setBounds(20, 100, 120, 30);
        contentPanel.add(durationLabel);

        JTextField durationField = new JTextField();
        durationField.setBounds(140, 100, 200, 30);
        contentPanel.add(durationField);

        JLabel descLabel = new JLabel("Description:");
        descLabel.setBounds(20, 140, 120, 30);
        contentPanel.add(descLabel);

        JTextField descField = new JTextField();
        descField.setBounds(140, 140, 200, 30);
        contentPanel.add(descField);

        JLabel ratingLabel = new JLabel("Rating:");
        ratingLabel.setBounds(20, 180, 120, 30);
        contentPanel.add(ratingLabel);

        JTextField ratingField = new JTextField();
        ratingField.setBounds(140, 180, 200, 30);
        contentPanel.add(ratingField);

        // ===== IMAGE =====
        JLabel imageLabel = new JLabel("Poster:");
        imageLabel.setBounds(20, 220, 120, 30);
        contentPanel.add(imageLabel);

        JTextField imageField = new JTextField();
        imageField.setBounds(140, 220, 200, 30);
        contentPanel.add(imageField);

        JButton browseBtn = new JButton("Select");
        browseBtn.setBounds(350, 220, 90, 30);
        contentPanel.add(browseBtn);

        browseBtn.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                imageField.setText(chooser.getSelectedFile().getAbsolutePath());
            }
        });

        JButton save = new JButton("Save Movie");
        save.setBounds(140, 270, 200, 35);
        contentPanel.add(save);

        save.addActionListener(e -> {

            try {
                String title = titleField.getText();
                String genre = genreField.getText();
                int duration = Integer.parseInt(durationField.getText());
                String desc = descField.getText();
                double rating = Double.parseDouble(ratingField.getText());
                String imagePath = imageField.getText();

                MovieService service = new MovieService();

                Movie movie = service.validateMovie(title, genre, duration, desc, rating, imagePath);

                if (movie != null) {
                    service.addMovie(movie);
                    JOptionPane.showMessageDialog(null, "Movie saved: " + movie.getTitle());
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid data!");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        });

        refresh();
    }
    
    // ================= UPDATE MOVIE =================
    public void showUpdateMovie() {

    contentPanel.removeAll();

    // ================= TITLE =================
    JLabel title = new JLabel("Update Movie");
    title.setBounds(200, 20, 300, 30);
    title.setFont(new Font("Arial", Font.BOLD, 20));
    contentPanel.add(title);

    // ================= SEARCH =================
    JLabel searchLabel = new JLabel("Search Movie:");
    searchLabel.setBounds(50, 80, 120, 30);
    contentPanel.add(searchLabel);

    JTextField searchField = new JTextField();
    searchField.setBounds(170, 80, 200, 30);
    contentPanel.add(searchField);

    JButton searchBtn = new JButton("Search");
    searchBtn.setBounds(380, 80, 100, 30);
    contentPanel.add(searchBtn);

    // ================= FORM =================
    JLabel nameLabel = new JLabel("Name:");
    nameLabel.setBounds(50, 130, 120, 30);
    contentPanel.add(nameLabel);

    JTextField nameField = new JTextField();
    nameField.setBounds(170, 130, 250, 30);
    nameField.setBackground(new Color(245, 245, 245));
    contentPanel.add(nameField);

    JLabel genreLabel = new JLabel("Genre:");
    genreLabel.setBounds(50, 170, 120, 30);
    contentPanel.add(genreLabel);

    JTextField genreField = new JTextField();
    genreField.setBounds(170, 170, 250, 30);
    genreField.setBackground(new Color(245, 245, 245));
    contentPanel.add(genreField);

    JLabel durationLabel = new JLabel("Duration:");
    durationLabel.setBounds(50, 210, 120, 30);
    contentPanel.add(durationLabel);

    JTextField durationField = new JTextField();
    durationField.setBounds(170, 210, 250, 30);
    durationField.setBackground(new Color(245, 245, 245));
    contentPanel.add(durationField);

    JLabel descLabel = new JLabel("Description:");
    descLabel.setBounds(50, 250, 120, 30);
    contentPanel.add(descLabel);

    JTextField descField = new JTextField();
    descField.setBounds(170, 250, 250, 30);
    descField.setBackground(new Color(245, 245, 245));
    contentPanel.add(descField);

    JLabel ratingLabel = new JLabel("Rating:");
    ratingLabel.setBounds(50, 290, 120, 30);
    contentPanel.add(ratingLabel);

    JTextField ratingField = new JTextField();
    ratingField.setBounds(170, 290, 250, 30);
    ratingField.setBackground(new Color(245, 245, 245));
    contentPanel.add(ratingField);

    // ================= BUTTON =================
    JButton updateBtn = new JButton("Update Movie");
    updateBtn.setBounds(170, 340, 200, 40);
    updateBtn.setBackground(new Color(30, 144, 255));
    updateBtn.setForeground(Color.WHITE);
    updateBtn.setFocusPainted(false);
    contentPanel.add(updateBtn);

    searchBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){

            MovieService movieService = new MovieService();
            MovieDB movieDB = new MovieDB();

            String title = searchField.getText();

            String error = movieService.validateTitle(title);

            if (error != null) {
                JOptionPane.showMessageDialog(null, error);
                return;
            }

            Movie movie = movieDB.getMovieByTitle(title);

            if (movie == null) {
                JOptionPane.showMessageDialog(null, "Movie not found!");
                return;
            }
            nameField.setText(movie.getTitle());
            genreField.setText(movie.getGenre());
            durationField.setText(String.valueOf(movie.getDuration()));
            descField.setText(movie.getDescription());
            ratingField.setText(String.valueOf(movie.getRating()));
        }
    });

    updateBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                String title = nameField.getText();
                String genre = genreField.getText();
                int duration = Integer.parseInt(durationField.getText());
                String description = descField.getText();
                double rating = Double.parseDouble(ratingField.getText());

                Movie movie = new Movie(title, genre, duration, description, rating);

                MovieService service = new MovieService();
                service.updateMovie(movie);

                JOptionPane.showMessageDialog(null, "Movie updated successfully!");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid number format!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    });

    refresh();
}

    // ================= DELETE MOVIE =================
    public void showDeleteMovie() {

    contentPanel.removeAll();

    JPanel deletePanel = new JPanel();
    deletePanel.setLayout(null);
    deletePanel.setBounds(0, 0, 600, 500);
    deletePanel.setBackground(Color.WHITE);

    // TITLE
    JLabel titleLabel = new JLabel("Delete Movie");
    titleLabel.setBounds(200, 30, 200, 30);
    titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
    deletePanel.add(titleLabel);

    // SEARCH FIELD
    JTextField searchField = new JTextField();
    searchField.setBounds(150, 100, 200, 30);
    deletePanel.add(searchField);

    JButton searchBtn = new JButton("Search");
    searchBtn.setBounds(360, 100, 100, 30);
    deletePanel.add(searchBtn);

    // INFO AREA
    JTextArea infoArea = new JTextArea();
    infoArea.setBounds(150, 150, 250, 120);
    infoArea.setEditable(false);
    infoArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    deletePanel.add(infoArea);

    // DELETE BUTTON
    JButton deleteBtn = new JButton("Delete");
    deleteBtn.setBounds(200, 300, 150, 40);
    deleteBtn.setBackground(Color.RED);
    deleteBtn.setForeground(Color.WHITE);
    deletePanel.add(deleteBtn);

    // PANEL EKLE
    contentPanel.add(deletePanel);

    contentPanel.revalidate();
    contentPanel.repaint();

    // ================= SEARCH LOGIC =================
    searchBtn.addActionListener(e -> {

        MovieDB movieDB = new MovieDB();

        String title = searchField.getText();

        Movie movie = movieDB.getMovieByTitle(title);

        if (movie == null) {
            infoArea.setText("Movie not found!");
            return;
        }

        infoArea.setText(
                "Title: " + movie.getTitle() + "\n" +
                "Genre: " + movie.getGenre() + "\n" +
                "Duration: " + movie.getDuration()
        );
    });

    // ================= DELETE LOGIC =================
    deleteBtn.addActionListener(e -> {

        MovieService movieService = new MovieService();
        MovieDB movieDB = new MovieDB();

        String title = searchField.getText();
        Movie movie = movieDB.getMovieByTitle(title);

        if (movie == null) {
            JOptionPane.showMessageDialog(null, "Movie not found!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                null,
                "Are you sure?",
                "Confirm",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            movieService.deleteMovie(movie.getMovieId());
            JOptionPane.showMessageDialog(null, "Deleted!");
        }
    });
}

    // ================= LIST =================
    public void showListMovie() {

        contentPanel.removeAll();

        JLabel title = new JLabel("Movie List");
        title.setBounds(220, 20, 200, 30);
        contentPanel.add(title);

        JTextArea area = new JTextArea();
        area.setBounds(50, 80, 500, 350);
        area.setEditable(false);
        contentPanel.add(area);

        MovieDB movieDB = new MovieDB();
        StringBuilder text = new StringBuilder();

        for (Movie movie : movieDB.getAllMovies()) {
            text.append("Title: ").append(movie.getTitle())
                .append(" | Genre: ").append(movie.getGenre())
                .append(" | Rating: ").append(movie.getRating())
                .append("\n");
        }

        area.setText(text.toString());

        refresh();
    }

    private void refresh() {
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}