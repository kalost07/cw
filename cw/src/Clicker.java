import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clicker {

    public static void main(String[] args) {

       JFrame frame = new JFrame("clicker game");
       JLabel showCLicks = new JLabel("0");
       JButton clickButton = new JButton("click me");
       JButton noClickButton = new JButton("don't click me");
       JButton resetButton = new JButton("reset");


       frame.setLayout(new GridLayout(2,3));
       frame.setSize(300,300);
       frame.add(showCLicks);
       frame.add(resetButton);
       frame.add(clickButton);
       frame.add(noClickButton);

       frame.setVisible(true);

       clickButton.addActionListener(new ActionListener(){

           public void actionPerformed(ActionEvent e){
               int counter = Integer.parseInt(showCLicks.getText());
               counter++;
               showCLicks.setText(String.valueOf(counter));
           }
       });
       noClickButton.addActionListener(new ActionListener(){

           public void actionPerformed(ActionEvent e){
               int counter = Integer.parseInt(showCLicks.getText());
               counter--;
               showCLicks.setText(String.valueOf(counter));
           }
       });
        resetButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                showCLicks.setText("0");
            }
        });

/* TASK: Improve this game by adding another button to decrement the counter.
Your GUI should look like this:

------------
0
|+| |-|
------------

*/
    }
}
