import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class UserUI extends JFrame {

    MovieDB movieDB = new MovieDB();
    UserDB userDB = new UserDB();

    private RegisteredUser currentUser;

    public UserUI(RegisteredUser user) {

        this.currentUser = user;

        setTitle("Cinema App");
        setSize(1100, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(Color.WHITE);

        // ================= SEARCH =================
        JTextField searchField = new JTextField();
        searchField.setBounds(350, 25, 400, 35);
        add(searchField);

        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(760, 25, 120, 35);
        add(searchBtn);

        // ================= DATA =================
        List<Movie> allMovies = movieDB.getAllMovies();

        List<Movie> forYouMovies = getForYouMovies(allMovies);
        List<Movie> topRatedMovies = getTopRatedMovies(allMovies);

        // ================= SECTIONS =================
        addSection("🔥 For You", 90, forYouMovies);
        addSection("⭐ Top Rated", 320, topRatedMovies);
        addSection("🎬 All Movies", 550, allMovies);

        setVisible(true);
    }

    // ================= SECTION =================
    private void addSection(String titleText, int y, List<Movie> movies) {

        JLabel title = new JLabel(titleText);
        title.setBounds(40, y, 400, 30);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title);

        JScrollPane scroll = createScroll();
        scroll.setBounds(40, y + 40, 1000, 230);
        add(scroll);

        JPanel panel = (JPanel) scroll.getViewport().getView();
        loadMovies(panel, movies);
    }

    // ================= SCROLL =================
    private JScrollPane createScroll() {

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
        panel.setPreferredSize(new Dimension(3000, 210));
        panel.setBackground(Color.WHITE);

        JScrollPane scroll = new JScrollPane(panel);

        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        scroll.setBorder(null);
        scroll.getViewport().setBackground(Color.WHITE);

        return scroll;
    }

    // ================= MOVIES =================
    private void loadMovies(JPanel panel, List<Movie> movies) {

        panel.removeAll();

        for (Movie m : movies) {

            JPanel card = new JPanel();
            card.setPreferredSize(new Dimension(150, 210));
            card.setLayout(null);
            card.setBackground(new Color(245, 245, 245));
            card.setCursor(new Cursor(Cursor.HAND_CURSOR));

            JLabel img = new JLabel();
            img.setBounds(10, 10, 130, 90);

            try {
                ImageIcon icon = new ImageIcon(m.getImagePath());
                Image image = icon.getImage().getScaledInstance(130, 90, Image.SCALE_SMOOTH);
                img.setIcon(new ImageIcon(image));
            } catch (Exception e) {
                img.setText("No Image");
            }

            card.add(img);

            JLabel title = new JLabel(m.getTitle());
            title.setBounds(10, 105, 130, 20);
            title.setFont(new Font("Arial", Font.BOLD, 11));
            card.add(title);

            JLabel genre = new JLabel(m.getGenre());
            genre.setBounds(10, 125, 130, 20);
            card.add(genre);

            JLabel rating = new JLabel("⭐ " + m.getRating());
            rating.setBounds(10, 145, 130, 20);
            card.add(rating);

            card.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    showDetail(m);
                }
            });

            panel.add(card);
        }

        panel.revalidate();
        panel.repaint();
    }

    // ================= DETAIL =================
    private void showDetail(Movie m) {

        JFrame detail = new JFrame("Movie Detail");
        detail.setSize(500, 450);
        detail.setLayout(null);
        detail.setLocationRelativeTo(null);
        detail.getContentPane().setBackground(Color.WHITE);

        JLabel title = new JLabel(m.getTitle());
        title.setBounds(120, 20, 350, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        detail.add(title);

        detail.setVisible(true);
    }

    // ================= FOR YOU =================
    private List<Movie> getForYouMovies(List<Movie> movies) {

        List<Movie> result = new ArrayList<>();

        List<String> userGenres =
                userDB.getUserGenres(currentUser.getUserId());

        for (Movie m : movies) {

            for (String genre : userGenres) {

                if (genre.equalsIgnoreCase(m.getGenre())) {
                    result.add(m);
                    break;
                }
            }
        }

        return result;
    }

    // ================= TOP RATED =================
    private List<Movie> getTopRatedMovies(List<Movie> movies) {

        movies.sort(Comparator.comparingDouble(Movie::getRating).reversed());
        return movies;
    }

    

}