import java.util.ArrayList;

public class Shelter {


    private final int SHELTER_MIN = 0;
    private final int SHELTER_MAX = 100;

    static ArrayList<Animals> shelter = new ArrayList<>();

    public void add (String input) {
        if (input.contains("addCat")) {
            shelter.add(new Cat());
        }
        if (input.contains("addDog")) {
            shelter.add(new Dog());
        }
        if (input.contains("addRabbit")) {
            shelter.add(new Rabbit());
        }
        if (input.contains("info")) {
            System.out.println(shelter.toString());
        }
        if (input.contains("F")) {
            shelter.clear();
        }
    }

 }

