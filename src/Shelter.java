import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Shelter {


//    private final int SHELTER_MIN = 0;
//    private final int SHELTER_MAX = 100;

    static Set<Animals> shelter = new HashSet<>();
    static Set<Cat> catsShelter = new HashSet<>();
    static Set<Dog> dogsShelter = new HashSet<>();
    static Set<Rabbit> rabbitsShelter = new HashSet<>();

    public void add (String input) {
        if (input.contains("Cat")) {
            catsShelter.add(new Cat());
        }
        if (input.contains("Dog")) {
            dogsShelter.add(new Dog());
        }
        if (input.contains("Rabbit")) {
            rabbitsShelter.add(new Rabbit());
        }

    }
    public void otherOptions (String input) {
        if (input.contains("All Cats")) {
            System.out.println(catsShelter.toString());
        }
        if (input.contains("All Dogs")) {
            System.out.println(dogsShelter.toString());
        }
        if (input.contains("All Rabbits")) {
            System.out.println(rabbitsShelter.toString());
        }
        if (input.contains("All Animals")) {
            System.out.println(catsShelter.toString() + dogsShelter.toString() +
                    rabbitsShelter.toString());
        }
        if (input.contains("F")) {
            shelter.clear();
        }
    }
 }

