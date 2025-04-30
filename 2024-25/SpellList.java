import java.util.*;

public class SpellList {
    public static void main(String[] args) {
        ArrayList<Spell> spells = new ArrayList<>();
        spells.add(new Fireball());
        spells.add(new Lightning_Bolt());
        spells.add(new Invisibility());

        for(Spell spell: spells) spell.printDetails();
        for(Spell spell: spells) spell.castSpell(spell.level);
    }
}

class Spell {
    static String getOrdinal(int number) {
        if (number >= 11 && number <= 13) {
            return number + "th";  // Special case for 11th, 12th, 13th
        }
        return switch (number % 10) {
            case 1 -> number + "st";
            case 2 -> number + "nd";
            case 3 -> number + "rd";
            default -> number + "th";
        };
    }
    static Random rand = new Random();
    String name;
    int level;
    String school;
    String[] spellLists;

    Spell(String name, int level, String school, String[] spellLists) {
        this.name = name;
        this.level = level;
        this.school = school;
        this.spellLists = Arrays.copyOf(spellLists, spellLists.length);
    }
    void effect() {
        System.out.println("Nothing happens...");
    };
    void castSpell(int spellSlot) {
        if(spellSlot != level) {
            if(level == 0) System.out.printf("You do not need a spell slot to cast %s.\n", name);
            else System.out.printf("You need a %s level spell slot to cast %s.\n", getOrdinal(level), name);
            return;
        }
        System.out.printf("I CAST %s\n", name.toUpperCase());
        effect();
        System.out.println();
    }
    String description() {
        return "It doesn't appear to do anything...";
    }
    void printDetails() {
        System.out.println("___________________");
        System.out.println(name);
        if(level == 0) System.out.println(school + "cantrip");
        else System.out.println(getOrdinal(level) + " level " + school + " spell");
        System.out.println(description());
        System.out.print("Learnable by: ");
        for(int i = 0; i < spellLists.length; i++) {
            System.out.print(spellLists[i]);
            if(i < spellLists.length - 1) System.out.print(", ");
            else System.out.print(".");
        }
        System.out.print("\n\n");
    }
}

class Fireball extends Spell {
    Fireball() {
        super("Fireball", 3, "Evocation",
                new String[]{"Sorcerer", "Spellblade", "Wizard"});
    }

    @Override
    void effect() {
        int dmg = 0;
        for(int i = 0; i < 8; i++) {
            dmg += rand.nextInt(6) + 1;
        }
        System.out.println("Dealt " + dmg + " fire damage to all creatures in radius. Watch out!");
    }
    @Override
    String description() {
        return "A tiny spark flashes from your finger to a point you can see. It explodes in a roaring flame. Deal 8d6 fire damage to all creatures in a 20ft radius.";
    }
}

class Invisibility extends Spell {
    Invisibility() {
        super("Invisibility", 2, "Illusion",
                new String[]{"Artificer", "Bard", "Occultist", "Sorcerer", "Spellblade", "Warlock", "Wizard"});
    }

    @Override
    void effect() {
        System.out.println("You've become invisible!");
    }
    @Override
    String description() {
        return "You become invisible until you make an attack or cast a spell. You have advantage on attack rolls and enemies have disadvantage on attack rolls against you while invisible.";
    }
}

class Lightning_Bolt extends Spell {
    Lightning_Bolt() {
        super("Lightning Bolt", 3, "Evocation",
                new String[]{"Sorcerer", "Spellblade", "Wizard"});
    }

    @Override
    void effect() {
        int dmg = 0;
        for(int i = 0; i < 8; i++) {
            dmg += rand.nextInt(6) + 1;
        }
        System.out.println("Dealt " + dmg + " lightning damage to all creatures in the line. Shocking!");
    }
    @Override
    String description() {
        return "A lightning blasts out from your finger in a straight line. It is a 100 ft long and 5 ft wide. Deal 8d6 lightning damage to all creatures in the line.";
    }
}
