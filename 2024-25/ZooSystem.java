public class ZooSystem {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.addAnimal1("Julien", "Lemur", 12, "Rainforest", 36, 27);
        zoo.addAnimal2("Kowalski", "Penguin", 5, "Icy", 24, 16);
        zoo.addAnimal3("Dave", "Octopus", 14, "Underwater", 50, 23);
        zoo.addAnimal4("Eva", "Snow Owl", 6, "Forest", 40, 20);

        Habitat rainforest = new Habitat("Rainforest", 36, 27);
        Habitat ice = new Habitat("Icy", 24, 16);

        Staff s1 = new Staff("Alice", "Zookeeper", rainforest);
        s1.assignStaff(ice);
    }
}

class Habitat {
    private String type;
    private double size;
    private double temp;

    Habitat(String type, double size, double temp) {
        this.type = type;
        this.size = size;
        this.temp = temp;
    }

    String getType() {return type;}
}

class Animal {
    private String name;
    private String species;
    private int age;
    private Habitat habitat;    // composition

    Animal (String name, String species, int age, String type, double size, double temp) {
        this.name = name;
        this.species = species;
        this.age = age;
        habitat = new Habitat(type, size, temp);
    }
}

class Zoo {
    private Animal a1;
    private Animal a2;
    private Animal a3;
    private Animal a4;
    // composition

    void addAnimal1 (String name, String species, int age, String type, double size, double temp) {
        a1 = new Animal(name, species, age, type, size, temp);
    }
    void addAnimal2 (String name, String species, int age, String type, double size, double temp) {
        a2 = new Animal(name, species, age, type, size, temp);
    }
    void addAnimal3 (String name, String species, int age, String type, double size, double temp) {
        a3 = new Animal(name, species, age, type, size, temp);
    }
    void addAnimal4 (String name, String species, int age, String type, double size, double temp) {
        a4 = new Animal(name, species, age, type, size, temp);
    }
}

class Staff {
    private String name;
    private String role;
    private Habitat assignedHabitat;    // association

    Staff (String name, String role, Habitat assignedHabitat) {
        this.name = name;
        this.role = role;
        this.assignedHabitat = assignedHabitat;
    }

    void assignStaff(Habitat habitat) {
        assignedHabitat = habitat;
        System.out.println(name + " is assigned to " + assignedHabitat.getType());
    }
}
