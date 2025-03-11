import java.util.ArrayList;

public class Shelter {

    private static int allSheltersSize = 0;
    private static int waitingRoomSize = 0;

    static ArrayList<Cat> catsShelter = new ArrayList<>();
    static ArrayList<Dog> dogsShelter = new ArrayList<>();
    static ArrayList<Rabbit> rabbitsShelter = new ArrayList<>();
    static ArrayList<Animals> waitingRoom = new ArrayList<>();

    public static void add (String input) {
        if (allSheltersSize >= 100) {
            Shelter.waiting(input);
        }
        if (input.contains("add Cat")) {
            catsShelter.add(new Cat());
            allSheltersSize++;
        }
        if (input.contains("add Dog")) {
            dogsShelter.add(new Dog());
            allSheltersSize++;
        }
        if (input.contains("add Rabbit")) {
            rabbitsShelter.add(new Rabbit());
            allSheltersSize++;
        }
    } // add

    public static void remove (String input) {
        if (input.contains("pick up Dog")) {
            dogsShelter.removeFirst();
        }
        if (input.contains("pick up Cat")) {
            catsShelter.removeFirst();
        }
        if (input.contains("pick up Rabbit")) {
            rabbitsShelter.removeFirst();
        }
    } //remove

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

    public static void otherOptions (String input) {
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

