import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String path = "D:\\" + in.nextLine();
        try(PrintWriter out = new PrintWriter(new FileWriter(path))) {
            System.out.println("Enter shopping list. Finish with \"done\".");
            String item = in.nextLine();
            while(!item.equals("done")) {
                out.println(item);
                item = in.nextLine();
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

