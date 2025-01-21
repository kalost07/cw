import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

class Date{
    private int year;
    private int month;
    private int day;

    Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {return year;}
    public void setYear(int year) {this.year = year;}
    public int getMonth() {return month;}
    public void setMonth(int month) {this.month = month;}
    public int getDay() {return day;}
    public void setDay(int day) {this.day = day;}

    public String displayDelta() {
        String res = "";
        switch(year) {
            case 0: break;
            case 1: res += "1 year"; break;
            default: res += year + " years";
        }
        if(year != 0 && month != 0) { // only add punctuation between year and month
            if(day == 0) res += " and ";
            else res += ", ";
        }
        switch(month) {
            case 0: break;
            case 1: res += "1 month"; break;
            default: res += month + " months";
        }
        if((year != 0 || month != 0) && day !=0) res += " and "; // only add and cuz its the last item
        switch(day) {
            case 0: break;
            case 1: res += "1 day"; break;
            default: res += day + " days";
        }
        if(res.isEmpty()) return "0 days";
        return res;
    }

    static boolean isLeapYear(int year) {
        if(year % 4 != 0) return false;
        if(year % 100 == 0 && year % 400 != 0) return false;
        return true;
    }
    static int daysInMonth(int month, int year) {
        switch(month) {
            case 0, 2, 4, 6, 7, 9, 11, -1: return 31; // -1 is basically December
            case 3, 5, 8, 10: return 30;
            case 1: if(isLeapYear(year)) return 29;
            else return 28;
            default: return 0;
        }
    }
    public static Date timeDelta(Date a, Date b) {
        // Do b-a
        // Borrowing logic
        while (b.day < a.day) {
            b.month--;
            b.day += daysInMonth(b.month, b.year);
        }
        if(b.month < a.month) {
            b.year--;
            b.month += 12;
        }
        // Subtract
        int years = b.year - a.year;
        int months = b.month - a.month;
        int days = b.day - a.day;
        return new Date(years, months, days);
    }
}

public class AgeCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Age Calculator");
        frame.setSize(400,400);
        frame.setLayout(new GridLayout(3, 1));

        JPanel inputPanel = new JPanel(new FlowLayout());
        JPanel inputPanel2 = new JPanel(new GridLayout(2, 3));
        JLabel dayLabel = new JLabel("Day");
        JLabel monthLabel = new JLabel("Month");
        JLabel yearLabel = new JLabel("Year");
        JTextField dayInput = new JTextField(10);
        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        JComboBox<String> monthInput = new JComboBox<String>(months);
        JTextField yearInput = new JTextField(10);
        inputPanel2.add(dayLabel);
        inputPanel2.add(monthLabel);
        inputPanel2.add(yearLabel);
        inputPanel2.add(dayInput);
        inputPanel2.add(monthInput);
        inputPanel2.add(yearInput);
        inputPanel.add(inputPanel2);
        frame.add(inputPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton calcButton = new JButton("Calculate Age");
        calcButton.setBackground(new Color(0x1AC45F));
        calcButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        calcButton.setForeground(Color.WHITE);
        buttonPanel.add(calcButton);
        frame.add(buttonPanel);

        JPanel outputPanel = new JPanel(new FlowLayout());
        JLabel outputLabel = new JLabel();
        outputPanel.add(outputLabel);
        frame.add(outputPanel);

        frame.setVisible(true);

        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if input is numeric
                if(!dayInput.getText().matches("\\d+") || !yearInput.getText().matches("\\d+")) {
                    outputLabel.setText("Input positive integers only");
                    return;
                }
                // Get Data
                int day = Integer.parseInt(dayInput.getText());
                int month = monthInput.getSelectedIndex();
                int year = Integer.parseInt(yearInput.getText());
                // Check if day is valid
                if(day > Date.daysInMonth(month, year) || day <= 0) {
                    outputLabel.setText("Invalid day");
                    return;
                }
                // Create Dates
                LocalDate ltoday = LocalDate.now();
                Date today = new Date(ltoday.getYear(), ltoday.getMonth().getValue() - 1, ltoday.getDayOfMonth());
                Date bday = new Date(year, month, day);
                // Mathing
                Date delta = Date.timeDelta(bday, today);
                if(delta.getYear() < 0) outputLabel.setText("Input a date in the past");
                else outputLabel.setText("You are " + delta.displayDelta() + " old.");
            }
        });
    }
}
