import java.util.ArrayList;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String displayDetails() {
        return "Name: " + name
            + "\nPrice: " + price
            + "\nQuantity: " + quantity + '\n';
    }
}

class Inventory {
    private static int maxProducts = 3;
    private int numOfProducts = 0;
    Product[] products = new Product[maxProducts];

    public int addProduct(String name, double price, int quantity) {
        if(numOfProducts >= maxProducts) return -1;
        products[numOfProducts] = new Product(name, price, quantity);
        numOfProducts++;
        return numOfProducts - 1;
    }

    public boolean updateProduct(String name, double price, int quantity) {
        for(int i = 0; i < numOfProducts; i++) {
            if(!name.equals(products[i].getName())) continue;
            
            products[i].setPrice(price);
            products[i].setQuantity(quantity);
            return true;
        }
        return false;
    }
    
    public String displayAllProducts() {
        String res = "";
        for(int i = 0; i < numOfProducts; i++) {
            res += products[i].displayDetails() + '\n';
        }
        return res;
    }
    
    public static void main(String[] args) {
        ;
    }
}

public class InventoryManagement {

}
