import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
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

        JTable table = new JTable(10, 3);
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(250);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        frame.add(table);

        frame.setVisible(true);
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
