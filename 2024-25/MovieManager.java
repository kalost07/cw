import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int numMovies = 0;
    public static void main(String[] args) {
        Movie[] movies = new Movie[10];


        JFrame frame = new JFrame("Movie Collection Manager");
        frame.setSize(400,400);
        frame.setLayout(new GridLayout(3,1));

        JTextField searchBar = new JTextField(20);
        searchBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // search func
                Movie[] filteredMovies = new Movie[10];
                int n = 0;
                if(searchBar.getText().isEmpty()) filteredMovies = Arrays.copyOf(movies, movies.length);
                else {
                    for(int i = 0; i < numMovies; i++) {
                        if(movies[i].getTitle().toLowerCase().contains(searchBar.getText().toLowerCase())) {
                            filteredMovies[n] = new Movie(movies[i]);
                            n++;
                        }
                    }
                }
                updateTable(filteredMovies, table, n);
            }
        });
        frame.add(searchBar);

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

        frame.add(table);

        JButton addMovieButton = new JButton("Add movie");
        frame.add(addMovieButton);

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
                    updateTable(movies, table, numMovies);
                    return;
                }
            }
        });

        frame.setVisible(true);
    }
    static void updateTable(Movie[] movies, JTable table, int n) {
        for(int i = 0; i < n; i++) {
            table.setValueAt(movies[i].getTitle(), i + 1, 0);
            table.setValueAt(movies[i].getGenre(), i + 1, 1);
        }
    }
    static void sortMovies(Movie[] movies, boolean genre) {
        Comparator<Movie> compTitle = new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        };
        Comparator<Movie> compGenre = new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getGenre().compareTo(o2.getGenre());
            }
        };
        if(!genre) Arrays.sort(movies, 0, numMovies, compTitle);
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
