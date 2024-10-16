import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the time of day (peak/off-peak):");
        String time = reader.nextLine();
        System.out.println("Enter the distance traveled in kilometers:");
        // reader.next();
        int km = reader.nextInt();

        double fare;
        if(km <= 5) fare = 2.0;
        else fare = 2.5;
        if(time.equals("peak")) fare += 1.0;
        System.out.println("Total fare: $" + fare);
    }
}
