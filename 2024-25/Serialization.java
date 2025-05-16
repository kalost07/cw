import java.io.*;
import java.util.*;

public class Serialization {
    public static void main(String[] args) {
        Employee[] emps = {
                new Employee(64313, "Jack Jaeger", 65000),
                new Employee(24561, "Sue Springer", 70000),
                new Employee(62778, "Boris Braun", 72000),
        };

        String path = "D://emps.txt";
        for(int i = 0; i < emps.length; i++) {
            emps[i].write(path);
            emps[i] = Employee.read(path);
            emps[i].print();
        }
    }
}

class Employee implements Serializable {
    int employeeId;
    String name;
    int salary;

    Employee() {}
    Employee(int employeeID, String name, int salary) {
        this.employeeId = employeeID;
        this.name = name;
        this.salary = salary;
    }

    void print() {
        System.out.printf("ID: %d, name: %s, salary: %d\n", employeeId, name, salary);
    }

    static Employee read(String path) {
        Employee emp = new Employee();
        try (ObjectInputStream iS = new ObjectInputStream(new FileInputStream(path))) {
            try {
                emp = (Employee) iS.readObject();
            }catch (EOFException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return emp;
    }

    void write(String path) {
        try(ObjectOutputStream oS = new ObjectOutputStream(new FileOutputStream(path))) {
            oS.writeObject(this);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

