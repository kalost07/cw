import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        Car[] carArray = {
                new Car("Toyota", "Camry", 2020, 25000, false),
                new Car("Honda", "Civic", 2016, 15000, true),
                new Car("Ford", "Fusion", 2019, 20000, false)
        };
        int choice = 0;
        do{
            System.out.print("""
                    1. Display available cars
                    2. Display all cars
                    3. Display most expensive car
                    4. Display average price
                    5. Lease a car
                    0. Exit
                    """);
            System.out.print("Enter the option: ");
            choice = read.nextInt();
            switch(choice) {
                case 1:
                    displayAvailableCars(carArray);
                    break;
                case 2:
                    displayAll(carArray);
                    break;
                case 3:
                    mostExpensive(carArray);
                    break;
                case 4:
                    System.out.println("Price: " + averagePrice(carArray));
                    break;
                case 5:
                    System.out.print("Enter choice: ");
                    leaseCar(carArray, read.nextInt());
                    break;
                case 0:
                    return;
            }
        } while(choice != 0);
    }
    public static void displayAvailableCars(Car[] car) {
        for(int i = 0; i < car.length; i++) {
            if(!car[i].isLeased) {
                System.out.print("Car " + i + ": ");
                car[i].displayInfo();
            }
        }
    }
    public static void displayAll(Car[] car) {
        for(int i = 0; i < car.length; i++) {
            System.out.print("Car " + i + ": ");
            car[i].displayInfo();
        }
    }
    public static Car mostExpensive(Car[] car) {
        int index = 0;
        for(int i = 1; i < car.length; i++) {
            if(car[index].price < car[i].price) index = i;
        }
        System.out.print("Car " + index + ": ");
        car[index].displayInfo();
        return car[index];
    }
    public static double averagePrice(Car[] cars) {
        double sum = 0;
        for(Car car: cars) {
            sum += car.price;
        }
        return sum / cars.length;
    }
    public static void leaseCar (Car[] car, int leaseChoice) {
        if(car[leaseChoice].isLeased) System.out.println("Car is already leased");
        else System.out.println("Successfully leased car");
        car[leaseChoice].isLeased = true;
    }
}

class Car {
    String make;
    String model;
    int year;
    double price;
    boolean isLeased;

    public Car (String make, String model, int year, double price, boolean isLeased) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.isLeased = isLeased;
    }

    public void displayInfo() {
        System.out.printf("%s %s, %d, %.2f$, is leased: %b\n", make, model, year, price, isLeased);
    }
}
