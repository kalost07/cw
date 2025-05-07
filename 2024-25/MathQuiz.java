import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class MathQuiz {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter user name: ");
        String path = "D:\\" + in.nextLine() + "-answers.txt";
        try(PrintWriter out = new PrintWriter(new FileWriter(path))) {
            Random rand = new Random();
            for (int i = 0; i < 5; i++) {
                int num1 = rand.nextInt(100) + 1;
                int num2 = rand.nextInt(100) + 1;
                int ans = 0;
                String question = "";
                switch(rand.nextInt(3)) {
                    case 0:
                        ans = num1 + num2;
                        question = num1 + " + " + num2 + " = ";
                        break;
                    case 1:
                        ans = num1 - num2;
                        question = num1 + " - " + num2 + " = ";
                        break;
                    case 2:
                        num1 = (num1 - 1) / 10 + 1;
                        num2 = (num2 - 1) / 10 + 1;
                        ans = num1 * num2;
                        question = num1 + " * " + num2 + " = ";
                        break;
                }
                System.out.print(question);
                int userAns = in.nextInt();
                if(userAns == ans) {
                    System.out.println("Correct!");
                    out.println(question + userAns + " Correct");
                }
                else {
                    System.out.println("Wrong! The answer is " + ans + ".");
                    out.println(question + userAns + " Incorrect");
                }
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
