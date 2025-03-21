import java.util.ArrayList;

public class Shelter {

    private int allSheltersSize = 0;
    private int waitingRoomSize = 0;

    ArrayList<Animal> animals = new ArrayList<>();
    ArrayList<Animal> waitingRoom = new ArrayList<>();


    public void add(String type, Integer count) {
        for (int i = 0; i < count; i++) {
            int MAX_SHELTER_SIZE = 100;
            if (allSheltersSize == MAX_SHELTER_SIZE) {
                switch (type) {
                    case "dog" -> waitingRoom.add(new Dog());
                    case "cat" -> waitingRoom.add(new Cat());
                    case "rabbit" -> waitingRoom.add(new Rabbit());
                    default -> {
                        System.out.println("Wrong animal type...");
                        return;
                    }
                }
                waitingRoomSize++;
            } else {
                switch (type) {
                    case "dog" -> animals.add(new Dog());
                    case "cat" -> animals.add(new Cat());
                    case "rabbit" -> animals.add(new Rabbit());
                    default -> {
                        System.out.println("Wrong animal type to add");
                        return;
                    }
                }
                allSheltersSize++;
            }
        }
        System.out.println("You brought " + count + " " + type + "s");
    }

    public void removeAnimal (String type) {
        if (!animals.isEmpty()) {
            boolean wasRemoved = false;
            switch (type.toLowerCase()) {
                case "dog" -> {
                    for (Animal animal : animals) {
                        if (animal instanceof Dog) {
                            animals.remove(animal);
                            wasRemoved = true;
                            break;
                        }
                    }
                }
                case "cat" -> {
                    for (Animal animal : animals) {
                        if (animal instanceof Cat) {
                            animals.remove(animal);
                            wasRemoved = true;
                            break;
                        }
                    }
                }
                case "rabbit" -> {
                    for (Animal animal : animals) {
                        if (animal instanceof Rabbit) {
                            animals.remove(animal);
                            wasRemoved = true;
                            break;
                        }
                    }
                }
            }
            if (wasRemoved) {
                allSheltersSize--;
                System.out.println( type + " has been removed.");
                boolean animalIsWaiting = (allSheltersSize == 99) && !waitingRoom.isEmpty();
                if (animalIsWaiting) {
                        Animal animal = waitingRoom.removeFirst();
                        animals.add(animal);
                        allSheltersSize++;
                }
            }
        }

    }

    public void removeById (String type, int id) {
        if (!animals.isEmpty()) {
            boolean wasRemovedById = false;
            switch (type) {
                case "dog" -> {
                    for (Animal animal : animals) {
                        if (animal instanceof Dog && (animal.getId() == id)) {
                            animals.remove(animal);
                            wasRemovedById = true;
                            break;
                        }
                    }
                }
                case "cat" -> {
                    for (Animal animal : animals) {
                        if (animal instanceof Cat && (animal.getId() == id)) {
                            animals.remove(animal);
                            wasRemovedById = true;
                            break;
                        }
                    }
                }
                case "rabbit" -> {
                    for (Animal animal : animals) {
                        if (animal instanceof Rabbit && (animal.getId() == id)) {
                            animals.remove(animal);
                            wasRemovedById = true;
                            break;
                        }
                    }
                }
                default -> System.out.println("Animal is not found!");
            }
            if (wasRemovedById) {
                allSheltersSize--;
                System.out.println( type + " has been removed.");
                boolean animalIsWaiting = (allSheltersSize == 99) && !waitingRoom.isEmpty();
                if (animalIsWaiting) {
                    Animal animal = waitingRoom.removeFirst();
                    animals.add(animal);
                    allSheltersSize++;
                }
            }
        }
    }

    public void otherOptions (String type) {
        switch (type) {
            case "dogs" -> {
                System.out.println("All dogs: ");
                int dogsCount = 0;
                for (Animal animal : animals) {
                    if (animal instanceof Dog) {
                        System.out.println(animal);
                        dogsCount++;
                    }
                }
                System.out.println("Dogs count = " + dogsCount);
            }
            case "cats" -> {
                System.out.println("All cats: ");
                int catsCount = 0;
                for (Animal animal : animals) {
                    if (animal instanceof Cat) {
                        System.out.println(animal);
                        catsCount++;
                    }
                }
                System.out.println("Cats count = " + catsCount);
            }
            case "rabbits" -> {
                System.out.println("All rabbits: ");
                int rabbitsCount = 0;
                for (Animal animal : animals) {
                    if (animal instanceof Rabbit) {
                        System.out.println(animal);
                        rabbitsCount++;
                    }
                }
                System.out.println("Rabbits count = " + rabbitsCount);
            }
            case "animals" -> {
                System.out.println(animals.toString() + "\nAnimals count = " + allSheltersSize);
                System.out.println(waitingRoom.toString() + "\nAnimals is waiting = " + waitingRoomSize);
            }
            default -> System.out.println("Wrong animal type!");
        }

    }
 }

