import java.util.Scanner;

public class GuessingGame {
    static int ans = 5;

    static boolean guess(int attempt) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int guess = reader.nextInt();
        if(guess == ans) {
            System.out.println("Congratulations!");
            return true;
        }
        else {
            if(guess < ans) System.out.println("Incorrect. Your guess is smaller than the answer");
            else System.out.println("Incorrect. Your guess is greater than the answer");
            System.out.println("You have " + attempt + " guesses left.\n");
        }
        return false;
    }
    public static void main(String[] args) {
        if (guess(2)) return;
        if (guess(1)) return;
        if (guess(0)) return;

        System.out.println("You are out of guesses");
    }
}
