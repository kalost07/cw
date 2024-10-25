import java.util.Scanner;

public class GuessingGame {

    public static void main(String args[]) {
        Scanner read = new Scanner(System.in);
        int ans = (int)(Math.random() * 100) + 1;
        System.out.println("Welcome to guessing game.\n I have generated a random number between 1 and 100. You have to guess what it is.\n I will tell you whether it's lower or higher than the answer.\n You may quit by typing 'quit'.\n");

        int attempts = 0;
        while(true) {
            System.out.println("Enter your guess");
            if (read.hasNextInt()) {
                int guess = read.nextInt();
                if(guess == ans) {
                    System.out.println("You guessed correctly in " + ++attempts + " attempts!");
                    return;
                }
                else {
                    if(guess < ans) System.out.println("The answer is higher. You have made " + ++attempts + " attempts.");
                    else System.out.println("The answer is lower. You have made " + ++attempts + " attempts.");
                }
            }
            else {
                String input = read.nextLine();
                if (input.equals("quit")) {
                    System.out.println("You have quit after " + attempts + " attempts. The answer was " + ans);
                    return;
                }
                else {
                    System.out.println("Please enter an integer.");
                }
            }
        }
    }
}
