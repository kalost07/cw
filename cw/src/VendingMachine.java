import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter a code: ");
        String code = reader.nextLine();

        switch (code) {
            case "A1":
                System.out.println("Product \"Soda\" - Price: $1.50");
                break;
           case "B2":
                System.out.println("Product \"Chips\" - Price: $1.25");
                break;
           case "C3":
                System.out.println("Product \"Candy\" - Price: $0.75");
                break;
           case "D4":
                System.out.println("Product \"Water\" - Price: $1.00");
                break;
           default:
                System.out.println("Code does not exist");
                break;
        }
    }
}
