public class Main {
    public static void AddressbookExtended(String[] args) {
        // Task 6: Create more objects and test the methods
        Person p1 = new Person("Eda", "eda@gmail.com", "123-456-7890", "ul. Iskar 32");
        p1.print();
        Person p2 = new Person("Hannah", "hannah@gmail.com", "404-899-9955", "Floyd Black 4");
        p2.print();
        Person p3 = new Person("Kaidou", "kaidou@prmail.com", "678-681-7688", "Onigashima, Wano");
        p3.print();
        Person p4 = new Person("Zuko", "zuko@fmail.com", "626-732-3838", "Royal Palace, Capital, Fire Nation");
        p4.print();

        // Task 8: Test the updateEmail method
        p3.updateEmail("kaidou@beast.com");
        p3.print();
    }
}

// Define the Person class here
class Person {
    // Instance variables
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    // Task 1: Add a new attribute (e.g., age)

    // Constructor: Initialize Person data
    public Person(String initName, String initEmail, String initPhone, String initAddress) { // Task 2: modify method signature to include your new attribute.
        name = initName;
        email = initEmail;
        phoneNumber = initPhone;
        address = initAddress;
        // Task 3: Assign a default value to the new attribute here.
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        // Task 4: Print the new attribute here
    }

    // Task 5: Add getter methods to access and return each attribute individually. Here's an example:
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getAddress() {
        return address;
    }

    // Task 7: Add a method to update the email
    public void updateName(String newName) {
        name = newName;
    }
    public void updateEmail(String newEmail) {
        email = newEmail;
    }
    public void updatePhoneNumber(String newPhoneNumber) {
        phoneNumber = newPhoneNumber;
    }
    public void updateAddress(String newAddress) {
        address = newAddress;
    }
}
