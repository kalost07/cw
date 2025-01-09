import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        return name + ", " + price + "$, " + quantity + " in stock.\n";
    }
}

class Inventory {
    private static final int maxProducts = 3;
    private int numOfProducts = 0;
    Product[] products = new Product[maxProducts];

    public int addProduct(String name, double price, int quantity) {
        if(numOfProducts >= maxProducts) return -1;
        if(price < 0) return -2;
        if(quantity < 0) return -3;
        products[numOfProducts] = new Product(name, price, quantity);
        numOfProducts++;
        return numOfProducts;
    }

    public int updateProduct(String name, double price, int quantity) {
        if(price < 0) return -2;
        if(quantity < 0) return -3;
        for(int i = 0; i < numOfProducts; i++) {
            if(!name.equals(products[i].getName())) continue;

            products[i].setPrice(price);
            products[i].setQuantity(quantity);
            return 1;
        }
        return -1;
    }

    public String displayAllProducts() {
        String res = "";
        for(int i = 0; i < numOfProducts; i++) {
            res += products[i].displayDetails() + '\n';
        }
        return res;
    }
}

public class InventoryManagement {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        JFrame frame = new JFrame("Inventory Management System");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(3, 1));

        JPanel inputPanel = new JPanel(new FlowLayout());
        JTextField nameField = new JTextField(10);
        JTextField priceField = new JTextField(10);
        JTextField quantityField = new JTextField(10);
        inputPanel.add(nameField);
        inputPanel.add(priceField);
        inputPanel.add(quantityField);
        frame.add(inputPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Product");
        JButton updateButton = new JButton("Update Product");
        JButton displayButton = new JButton("Display Products");
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(displayButton);
        frame.add(buttonPanel);

        JPanel outputPanel = new JPanel(new FlowLayout());
        JTextArea outputArea = new JTextArea();
        outputPanel.add(outputArea);
        frame.add(outputPanel);

        frame.setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = inventory.addProduct(nameField.getText(), Double.parseDouble(priceField.getText()), Integer.parseInt(quantityField.getText()));
                switch(res) {
                    case -1: outputArea.append("Too many products\n"); break;
                    case -2: outputArea.append("Price cannot be negative\n"); break;
                    case -3: outputArea.append("Quantity cannot be negative\n"); break;
                    default: outputArea.append("Product added successfully\n"); break;
                }
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = inventory.updateProduct(nameField.getText(), Double.parseDouble(priceField.getText()), Integer.parseInt(quantityField.getText()));
                switch (res) {
                    case -1: outputArea.append("Product not found\n"); break;
                    case -2: outputArea.append("Price cannot be negative\n"); break;
                    case -3: outputArea.append("Quantity cannot be negative\n"); break;
                    default: outputArea.append("Product updated successfully\n"); break;
                }
            }
        });
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String res = inventory.displayAllProducts();
                outputArea.setText(res);
            }
        });
    }
}
