import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Select a category: ");
        System.out.println("1. Science");
        System.out.println("2. History");
        System.out.println("3. Sports");
        int category = reader.nextInt();

        String question;
        int ans;
        switch (category) {
            case 1:
                question = "How much does 1 mol of water weigh (in grams)?";
                ans = 18;
                break;
            case 2:
                question = "What year did World War 1 start?";
                ans = 1914;
                break;
            case 3:
                question = "How many players are on the field in a game of basketball?";
                ans = 10;
                break;
            default:
                System.out.println("Invalid category");
                return;
        }

        System.out.println(question);
        int guess = reader.nextInt();
        if (guess == ans) System.out.println("Correct!");
        else System.out.println("Incorrect. The correct answer is " + ans);
    }
}
