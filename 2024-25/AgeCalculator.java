import javax.swing.*;
import java.awt.*;

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

    static boolean isLeapYear(int year) {
        if(year % 4 != 0) return false;
        if(year % 100 == 0 && year % 400 != 0) return false;
        return true;
    }
    static int daysInMonth(int month, int year) {
        switch(month) {
            case 0, 2, 4, 6, 7, 9, 11: return 31;
            case 3, 5, 8, 10: return 30;
            case 1: if(isLeapYear(year)) return 29;
                    else return 28;
            default: return 0;
        }
    }
    static Date timeDelta(Date a, Date b) {
        // Do b-a
        // Borrowing logic
        while (b.day < a.day) {
            b.month--;
            b.day += b.day + daysInMonth(b.month, b.year);
        }
        if(b.month < a.month) {
            b.year--;
            b.month += 12;
        }
        // Substract
        int years = b.year - a.year;
        int months = b.month - a.month;
        int days = b.day - a.day;
        return new Date(years, months, days);
    }
}

public class AgeCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Age Calculator");
        frame.setLayout(new GridLayout(3, 1));

        JPanel inputPanel = new JPanel(new FlowLayout());
        JPanel inputPanel2 = new JPanel(new GridLayout(1, 3));
        JTextField dayInput = new JTextField(5);
    }
}
