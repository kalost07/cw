import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main {
    static int numMovies = 0;
    static boolean sortByGenre = false;
    public static void main(String[] args) {
        Movie[] movies = new Movie[10];


        JFrame frame = new JFrame("Movie Collection Manager");
        frame.setSize(400,400);
        frame.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JTextField searchBar = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        northPanel.add(searchBar, gbc);

        JComboBox<String> sortOption = new JComboBox<>(new String[]{"Title", "Genre"});
        gbc.gridy = 1;
        northPanel.add(sortOption, gbc);

        frame.add(northPanel, BorderLayout.NORTH);


        JTable table = new JTable(new DefaultTableModel(11, 2) {
            // Override isCellEditable to disable user editing
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Disable editing for users
            }
        });
        table.getColumnModel().getColumn(0).setPreferredWidth(250);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.setValueAt("Title", 0, 0);
        table.setValueAt("Genre", 0, 1);
        frame.add(table, BorderLayout.CENTER);

        JButton addMovieButton = new JButton("Add movie");
        frame.add(addMovieButton, BorderLayout.SOUTH);

        addMovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String title = (String)JOptionPane.showInputDialog(
                        frame,
                        "Enter the title of the movie",
                        "Add Movie",
                        JOptionPane.PLAIN_MESSAGE);

                if ((title != null) && (!title.isEmpty())) {
                    Object[] genres = {"Action", "Comedy", "Thriller", "Fantasy", "Sci-Fi", "Horror"};
                    String genre = (String)JOptionPane.showInputDialog(
                            frame,
                            "Choose the genre of " + title,
                            "Add Movie",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            genres,
                            genres[0]
                    );
                    if(numMovies < movies.length) {
                        movies[numMovies] = new Movie(title, genre);
                        numMovies++;
                    }
                    sortMovies(movies);
                    updateTable(movies, table, numMovies);
                    return;
                }
            }
        });
        searchBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // search func
                Movie[] filteredMovies = new Movie[10];
                int n = numMovies;
                if(searchBar.getText().isEmpty()) filteredMovies = Arrays.copyOf(movies, movies.length);
                else {
                    n = 0;
                    for(int i = 0; i < numMovies; i++) {
                        if(movies[i].getTitle().toLowerCase().contains(searchBar.getText().toLowerCase().strip())) {
                            System.out.println("match " + movies[i].getTitle());
                            filteredMovies[n] = new Movie(movies[i]);
                            n++;
                        }
                    }
                }
                updateTable(filteredMovies, table, n);
            }
        });
        sortOption.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // Check if the selected item has changed
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Get the selected item
                    boolean selectedGenre = ((String) e.getItem()).equals("Genre");
                    if(sortByGenre != selectedGenre) {
                        sortByGenre = selectedGenre;
                        sortMovies(movies);
                        updateTable(movies, table, numMovies);
                    }
                }
            }
        });

        frame.setVisible(true);
    }
    static void updateTable(Movie[] movies, JTable table, int n) {
        for(int i = 0; i < movies.length; i++) {
            table.setValueAt("", i + 1, 0);
            table.setValueAt("", i + 1, 1);
        }
        for(int i = 0; i < n; i++) {
            table.setValueAt(movies[i].getTitle(), i + 1, 0);
            table.setValueAt(movies[i].getGenre(), i + 1, 1);
        }
        System.out.println("update");
    }
    static void sortMovies(Movie[] movies) {
        Comparator<Movie> compTitle = new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        };
        Comparator<Movie> compGenre = new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                int res = o1.getGenre().compareTo(o2.getGenre());
                if(res != 0) return res;
                return o1.getTitle().compareTo(o2.getTitle());
            }
        };
        if(!sortByGenre) Arrays.sort(movies, 0, numMovies, compTitle);
        else Arrays.sort(movies, 0, numMovies, compGenre);
    }

}

class Movie {
    private String title;
    private String genre;

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }
    public Movie(Movie movie) {
        this.title = movie.title;
        this.genre = movie.genre;
    }


    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }
}
