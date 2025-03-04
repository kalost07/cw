import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
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
            }
        });
        frame.add(searchBar);

        JTable table = new JTable(11, 2);
        table.getColumnModel().getColumn(0).setPreferredWidth(250);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
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
                    Object[] genres = {"ham", "spam", "yam"};
                    String genre = (String)JOptionPane.showInputDialog(
                            frame,
                            "Choose the genre of " + title,
                            "Add Movie",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            genres,
                            genres[0]
                    );
                    return;
                }
            }
        });

        frame.setVisible(true);
    }
    static void updateTable(Movie[] movies) {

    }
}

class Movie {
    private String title;
    private String genre;

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }
}
