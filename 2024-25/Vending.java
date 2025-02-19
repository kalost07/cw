import java.util.Scanner;

public class Vending {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String[] names = {"Water","Coke","Monster","Chips","Chocolate","Croissant"};
        double[] prices = {0.80, 1.70, 2.00, 3.60, 3.00, 2.00};
        int[] quantity = {15, 10, 10, 8, 8, 8};

        System.out.println("""
                1 x. Select item x
                2 x. Insert x money
                3. Display Items
                4. Exit""");

        int selection = -1;
        double money = 0;
        while(true) {
            if(selection == -1) System.out.println("Selected: Nothing");
            else System.out.println("Selected: " + names[selection]);
            System.out.printf("Money: %.2f$\n", money);
            switch(read.nextInt()) {
                case 1:
                    selection = read.nextInt();
                    if(selection < 0 || selection >= names.length)
                        selection = -1;
                    if(tryPurchase(selection, money, prices)) {
                        System.out.printf("Bought a %s for %.2f$\n", names[selection], prices[selection]);
                        System.out.printf("Returned %.2f$ in change\n", money - prices[selection]);
                        money = 0;
                        selection = -1;
                    }
                    break;
                case 2:
                    double add = read.nextDouble();
                    if(add > 0) money += add;
                    if(tryPurchase(selection, money, prices)) {
                        System.out.printf("Bought a %s for %.2f$\n", names[selection], prices[selection]);
                        System.out.printf("Returned %.2f$ in change\n", money - prices[selection]);
                        money = 0;
                        selection = -1;
                    }
                    break;
                case 3:
                    display(names, prices, quantity);
                    break;
                case 4:
                    return;
            }
        }
    }
    static void display(String[] names, double[] prices, int[] quantity) {
        for(int i = 0; i < names.length; i++) {
            System.out.printf("%s, %.2f$, %d in stock, code: %d\n", names[i], prices[i], quantity[i], i);
        }
    }
    static boolean tryPurchase(int selection, double money, double[] prices) {
        if(selection == -1) return false;
        return money >= prices[selection];
    }
}
