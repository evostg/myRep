import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Shelter {

    private static int allSheltersSize = 0;
    private static int waitingRoomSize = 0;

    static Set<Cat> catsShelter = new HashSet<>();
    static Set<Dog> dogsShelter = new HashSet<>();
    static Set<Rabbit> rabbitsShelter = new HashSet<>();
    static Set<Animals> waitingRoom = new HashSet<>();

    public void add (String input) {
        if (allSheltersSize >= 100) {
            Shelter.waiting(input);
        }
        if (input.contains("Cat")) {
            catsShelter.add(new Cat());
            allSheltersSize++;
        }
        if (input.contains("Dog")) {
            dogsShelter.add(new Dog());
            allSheltersSize++;
        }
        if (input.contains("Rabbit")) {
            rabbitsShelter.add(new Rabbit());
            allSheltersSize++;
        }

    } // add

    public static void waiting(String input) {
        if (input.contains("Cat")) {
            waitingRoom.add(new Cat());
            waitingRoomSize++;
        }
        if (input.contains("Dog")) {
            waitingRoom.add(new Dog());
            waitingRoomSize++;
        }
        if (input.contains("Rabbit")) {
            waitingRoom.add(new Rabbit());
            waitingRoomSize++;
        }
    } // waiting

    public void otherOptions (String input) {
        if (input.contains("All Cats")) {
            System.out.println(catsShelter.toString());
            System.out.println("Количество кошек: " + catsShelter.size());
        }
        if (input.contains("All Dogs")) {
            System.out.println(dogsShelter.toString());
            System.out.println("Количество собак: " + dogsShelter.size());
        }
        if (input.contains("All Rabbits")) {
            System.out.println(rabbitsShelter.toString());
            System.out.println("Количество кроликов: " + rabbitsShelter.size());
        }
        if (input.contains("All Animals")) {
            System.out.println(catsShelter.toString() + dogsShelter.toString() +
                    rabbitsShelter.toString());
            System.out.println(allSheltersSize);
        }
        if (input.contains("F")) {
            dogsShelter.clear();
            catsShelter.clear();
            rabbitsShelter.clear();
            allSheltersSize = 0;
            waitingRoomSize = 0;
        }
    } // other options
 } // shelter

