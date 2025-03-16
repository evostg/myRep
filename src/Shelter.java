import java.util.ArrayList;

public class Shelter {

    private int allSheltersSize = 0;
    private  int waitingRoomSize = 0;

    private final String adding = "Животное в убежище!";
    private final String removing = "Добрые люди забрали животное!";

    private final int MAX_SHELTER_SIZE = 100;


    ArrayList<Animal> animals = new ArrayList<>();
    ArrayList<Animal> waitingRoom = new ArrayList<>();

//                       ДОБАВЛЕНИЕ ЖИВОТНЫХ В ХРАНИЛИЩЕ

    //TODO Через type, %S, %D

    public void add(String type, Integer count) {
        if (allSheltersSize >= MAX_SHELTER_SIZE) {
            //TODO Очередь
            return;
        }
        for (int i = 0; i < count; i++) {
            switch (type.toLowerCase()) {
                case "dog" -> animals.add(new Dog());
                case "cat" -> animals.add(new Cat());
                case "rabbit" -> animals.add(new Rabbit());
                default -> System.out.println("Не верный тип животного");
            }
            allSheltersSize++;
        }
        System.out.println("You brought " + count + " " + type + "s");
    }

    //                      ЗАБОР ЖИВОТНЫХ ИЗ ХРАНИЛИЩА

    public void pick (String type) {
        if (!animals.isEmpty()) {
            switch (type.toLowerCase()) {
                case "dog" -> pickUpDog();
                case "cat" -> pickUpCat();
                case "rabbit" -> pickUpRabbit();
            }
            if (allSheltersSize == 99) toShelter();
        } else {
            System.out.println("The animal is not available!");
        }
    }


    public void pickUpDog () {
            animals.removeFirst();
            allSheltersSize--;
            System.out.println(removing);
        }
    public void pickUpCat () {
            animals.removeFirst();
            allSheltersSize--;
            System.out.println(removing);
    }
    public void pickUpRabbit () {
            animals.removeFirst();
            allSheltersSize--;
            System.out.println(removing);
    }

    //                                ЗАБОР ПО ID

    public void processInput(String input) {
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
            System.out.println("Wrong ID.");
            return;
        }
        switch (animalType) {
            case "dog" -> pickUpDogById(id);
            case "cat" -> pickUpCatById(id);
            case "rabbit" -> pickUpRabbitById(id);
        }
    }

    public void pickUpDogById(int id) {
        Animal animalToRemove = null;
        for (Animal animal : animals) {
            if (animal.getId() == id) {
                animalToRemove = animal;
                break;
            }
        }
        if (animalToRemove != null) {
            animals.remove(animalToRemove);
            System.out.println("Вы забрали собаку: " + animalToRemove.getName());
        } else {
            System.out.println("Собаки с ID " + id + " нет.");
        }
        allSheltersSize--;
    }
    public void pickUpCatById(int id) {
        Animal animalToRemove = null;
        for (Animal animal : animals) {
            if (animal.getId() == id) {
                animalToRemove = animal;
                break;
            }
        }
        if (animalToRemove != null) {
            animals.remove(animalToRemove);
            System.out.println("Вы забрали кошку: " + animalToRemove.getName());
        } else {
            System.out.println("Кошки с ID " + id + " нет.");
        }
        allSheltersSize--;
    }
    public void pickUpRabbitById(int id) {
        Animal animalToRemove = null;
        for (Animal animal : animals) {
            if (animal.getId() == id) {
                animalToRemove = animal;
                break;
            }
        }
        if (animalToRemove != null) {
            animals.remove(animalToRemove);
            System.out.println("Вы забрали кролика: " + animalToRemove.getName());
        } else {
            System.out.println("Кролика с ID " + id + " нет.");
        }
        allSheltersSize--;
    }

    //                                 ОЖИДАНИЕ И ПЕРЕМЕЩЕНИЕ

    public void waiting(String input) {
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

    public void toShelter () {
        if (!waitingRoom.isEmpty()) {
            Animal animal = waitingRoom.removeFirst();
            if (animal instanceof Dog) {
                animals.add(animal);
                allSheltersSize++;
            }
            if (animal instanceof Cat) {
                animals.add(animal);
                allSheltersSize++;
            }
            if (animal instanceof Rabbit) {
                animals.add(animal);
                allSheltersSize++;
            }
        }
    }

    public void otherOptions (String type) {
        switch (type) {
            case "dogs" -> {
                System.out.println("All dogs: ");
                for (Animal animal : animals) {
                    if (animal instanceof Dog) {
                        System.out.println(animal);
                    }
                }
            }
            case "cats" -> {
                System.out.println("All cats: ");
                for (Animal animal : animals) {
                    if (animal instanceof Cat) {
                        System.out.println(animal);
                    }
                }
            }
            case "rabbits" -> {
                System.out.println("All rabbits: ");
                for (Animal animal : animals) {
                    if (animal instanceof Rabbit) {
                        System.out.println(animal);
                    }
                }
            }
            case "animals" -> System.out.println(animals.toString());
            default -> System.out.println("Wrong animal type!");
        }
    }
 }

