import java.util.ArrayList;

public class Shelter {

    private static int allSheltersSize = 0;
    private static int waitingRoomSize = 0;

    private static String adding = "Животное в убежище!";
    private static String removing = "Добрые люди забрали животное!";

    private static final int MAX_SHELTER_SIZE = 100;


    static ArrayList<Animals> dogsShelter = new ArrayList<>();
    static ArrayList<Animals> catsShelter = new ArrayList<>();
    static ArrayList<Animals> rabbitsShelter = new ArrayList<>();
    static ArrayList<Animals> waitingRoom = new ArrayList<>();

//                       ДОБАВЛЕНИЕ ЖИВОТНЫХ В ХРАНИЛИЩЕ

    public static void add (String input) {
        if (allSheltersSize >= MAX_SHELTER_SIZE) {
           waiting(input);
           return;
        }
        switch (input.toLowerCase()) {
            case "add dog" -> addDog();
            case "add cat" -> addCat();
            case "add rabbit" -> addRabbit();
        }
    } //add

    public static void addDog () {
        dogsShelter.add(new Dog());
        allSheltersSize++;
        System.out.println(adding);
    }
    public static void addCat () {
        catsShelter.add(new Cat());
        allSheltersSize++;
        System.out.println(adding);
    }
    public static void addRabbit () {
        rabbitsShelter.add(new Rabbit());
        allSheltersSize++;
        System.out.println(adding);
    }

    //                      ЗАБОР ЖИВОТНЫХ ИЗ ХРАНИЛИЩА

    public static void remove (String input) {
        switch (input.toLowerCase()) {
            case "pick up dog" -> pickUpDog();
            case "pick up cat" -> pickUpCat();
            case "pick up rabbit" -> pickUpRabbit();
        } if (allSheltersSize == 99) toShelter();
    } //remove


    public static void pickUpDog () {
        if (!dogsShelter.isEmpty()) {
            dogsShelter.removeFirst();
            allSheltersSize--;
            System.out.println(removing);
        } else {
            System.out.println("Собак нет в наличии.");
        }
    }
    public static void pickUpCat () {
        if (!catsShelter.isEmpty()) {
            catsShelter.removeFirst();
            allSheltersSize--;
            System.out.println(removing);
        } else {
            System.out.println("Кошек нет в наличии.");
        }
    }
    public static void pickUpRabbit () {
        if (!rabbitsShelter.isEmpty()) {
            rabbitsShelter.removeFirst();
            allSheltersSize--;
            System.out.println(removing);
        } else {
            System.out.println("Кроликов нет в наличии.");
        }
    }

    //                                ЗАБОР ПО ID

    public static void processInput(String input) {
        String[] parts = input.split(" ");
        if (parts.length < 5 || !parts[0].equalsIgnoreCase("pick")
                || !parts[1].equalsIgnoreCase("up")
                || !parts[3].equalsIgnoreCase("by")
                || !parts[4].equalsIgnoreCase("id")) {
            return;
        }
        String animalType = parts[2].toLowerCase();
        int id;
        try {
            id = Integer.parseInt(parts[5]);
        } catch (NumberFormatException e) {
            System.out.println("Неверный ID.");
            return;
        }
        switch (animalType) {
            case "dog" -> pickUpDogById(id);
            case "cat" -> pickUpCatById(id);
            case "rabbit" -> pickUpRabbitById(id);
        }
    }

    public static void pickUpDogById(int id) {
        Animals animalToRemove = null;
        for (Animals animal : dogsShelter) {
            if (animal.getId() == id) {
                animalToRemove = animal;
                break;
            }
        }
        if (animalToRemove != null) {
            dogsShelter.remove(animalToRemove);
            System.out.println("Вы забрали собаку: " + animalToRemove.getName());
        } else {
            System.out.println("Собаки с ID " + id + " нет.");
        }
        allSheltersSize--;
    }
    public static void pickUpCatById(int id) {
        Animals animalToRemove = null;
        for (Animals animal : catsShelter) {
            if (animal.getId() == id) {
                animalToRemove = animal;
                break;
            }
        }
        if (animalToRemove != null) {
            catsShelter.remove(animalToRemove);
            System.out.println("Вы забрали кошку: " + animalToRemove.getName());
        } else {
            System.out.println("Кошки с ID " + id + " нет.");
        }
        allSheltersSize--;
    }
    public static void pickUpRabbitById(int id) {
        Animals animalToRemove = null;
        for (Animals animal : rabbitsShelter) {
            if (animal.getId() == id) {
                animalToRemove = animal;
                break;
            }
        }
        if (animalToRemove != null) {
            rabbitsShelter.remove(animalToRemove);
            System.out.println("Вы забрали кролика: " + animalToRemove.getName());
        } else {
            System.out.println("Кролика с ID " + id + " нет.");
        }
        allSheltersSize--;
    }

    //                                 ОЖИДАНИЕ И ПЕРЕМЕЩЕНИЕ

    public static void waiting(String input) {
        if (input.toLowerCase().contains("add dog")) {
            waitingRoom.add(new Dog());
            waitingRoomSize++;
            System.out.println("Собака ждет своей очереди...");
        }
        if (input.toLowerCase().contains("add cat")) {
            waitingRoom.add(new Cat());
            waitingRoomSize++;
            System.out.println("Кошка ждет своей очереди...");
        }
        if (input.toLowerCase().contains("add rabbit")) {
            waitingRoom.add(new Rabbit());
            waitingRoomSize++;
            System.out.println("Кролик ждет своей очереди...");
        }
    }

    public static void toShelter () {
        if (!waitingRoom.isEmpty()) {
            Animals animal = waitingRoom.removeFirst();
            if (animal instanceof Dog) {
                dogsShelter.add(animal);
                allSheltersSize++;
            }
            if (animal instanceof Cat) {
                catsShelter.add(animal);
                allSheltersSize++;
            }
            if (animal instanceof Rabbit) {
                rabbitsShelter.add(animal);
                allSheltersSize++;
            }
        }
    }

    public static void otherOptions (String input) {
        if (input.toLowerCase().contains("all cogs")) {
            System.out.println(dogsShelter.toString());
            System.out.println("Количество собак: " + dogsShelter.size());
        }
        if (input.toLowerCase().contains("all cats")) {
            System.out.println(catsShelter.toString());
            System.out.println("Количество кошек: " + catsShelter.size());
        }
        if (input.toLowerCase().contains("all rabbits")) {
            System.out.println(rabbitsShelter.toString());
            System.out.println("Количество кроликов: " + rabbitsShelter.size());
        }
        if (input.toLowerCase().contains("all animals")) {
            System.out.println(catsShelter.toString() + dogsShelter.toString() +
                    rabbitsShelter.toString());
            System.out.println("");
            System.out.println("Животных в убежище: " + allSheltersSize);
            System.out.println(waitingRoom.toString());
        }
        if (input.contains("F")) {
            dogsShelter.clear();
            catsShelter.clear();
            rabbitsShelter.clear();
            allSheltersSize = 0;
            waitingRoomSize = 0;
        }
    }
 }

