import java.util.Scanner;

public class BookStore {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String[] titles = {"Lord of the Ring","Lord of Flies","Attack on Titan Volume 34","Advanced Physics 7th Edition"};
        double[] prices = {114.99, 29.99, 19.99, 29.99};
        int[] quantity = {8, 12, 3, 12};

        System.out.println("""
                1 {code}. Purchase Book
                2. Display Items
                3 {title}. Search by Title
                4. Exit""");

        int selection = -1;
        double balance = 0;
        while(true) {
            if(selection == -1) System.out.println("Selected: Nothing");
            else System.out.println("Selected: " + titles[selection]);
            System.out.printf("Balance: %.2f$\n", balance);
            switch(read.nextInt()) {
                case 1:
                    selection = read.nextInt();
                    if(selection < 0 || selection >= titles.length)
                        selection = -1;
                    System.out.print("Add funds: ");
                    double add = read.nextDouble();
                    if(add > 0) balance += add;
                    if(tryPurchase(selection, balance, prices, quantity)) {
                        System.out.printf("Bought %s for %.2f$\n", titles[selection], prices[selection]);
                        balance -= prices[selection];
                        quantity[selection]--;
                        selection = -1;
                    }
                    break;
                case 2:
                    display(titles, prices, quantity);
                    break;
                case 3:
                    search(read.nextLine().strip(), titles, prices, quantity);
                    break;
                case 4:
                    return;
            }
        }
    }
    static void display(String[] titles, double[] prices, int[] quantity) {
        for(int i = 0; i < titles.length; i++) {
            System.out.printf("%s, %.2f$, %d in stock, code: %d\n", titles[i], prices[i], quantity[i], i);
        }
    }
    static boolean tryPurchase(int selection, double money, double[] prices, int[] quantity) {
        if(selection == -1) return false;
        return money >= prices[selection] && quantity[selection] > 0;
    }
    static void search(String query, String[] titles, double[] prices, int[] quantity) {
        boolean match = false;
        for(int i = 0; i < titles.length; i++) {
            if(titles[i].toLowerCase().contains(query.toLowerCase())) {
                match = true;
                System.out.printf("%s, %.2f$, %d in stock, code: %d\n", titles[i], prices[i], quantity[i], i);
            }
        }
        if(!match) System.out.println("No matches found");
    }
}
