import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class GuessingGame3 {
    static int N = 100;
    static int ans;
    static int attempts;
    static boolean finished;
    public static void main(String args[]) {
        JFrame window = new JFrame("Guessing Game");
        window.setSize(500,500);
        window.setLayout(new GridLayout(3,1));

        JPanel inputPanel = new JPanel(new FlowLayout());
        JTextField inputField = new JTextField(10);
        inputPanel.add(inputField);
        window.add(inputPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton guessButton = new JButton("Guess");
        JButton resetButton = new JButton("Reset the game");
        buttonPanel.add(guessButton);
        buttonPanel.add(resetButton);
        window.add(buttonPanel);

        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel resultLabel = new JLabel("Guess a number");
        resultPanel.add(resultLabel);
        window.add(resultPanel);

        window.setVisible(true);

        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (finished) return;
                int guess = Integer.parseInt(inputField.getText());
                String resText;
                if (guess == ans) {
                    resText = "You guessed correctly in " + ++attempts + " attempts!";
                    finished = true;
                }
                else {
                    if (guess < ans) resText = "The answer is higher. You have made " + ++attempts + " attempts";
                    else resText = "The answer is lower. You have made " + ++attempts + " attempts";
                }
                resultLabel.setText(resText);
            }
        });
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText("Guess a number");
                inputField.setText("");
                attempts = 0;
                finished = false;
                ans = (int)(Math.random() * N) + 1;
            }
        });

        ans = (int)(Math.random() * N) + 1;
        attempts = 0;
        finished = false;
    }
}
