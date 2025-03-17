import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Shelter shelter = new Shelter();
        Scanner scanner = new Scanner(System.in);



        //TODO разделить методы через енам и сплит
        //TODO какая команда пришла - метод вызывается
        System.out.println("Command list: " +
                "\n\"Add animal\"" +
                "\n\"Pick up animal\"" +
                "\n\"Remove animal by ID\"" +
                "\n\"All animals\"" +
                "\n\"Clear\"");

        while (true) {
            System.out.println("Enter the command: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            switch (parts[0]) {
                case "add"  -> shelter.add(parts[1], Integer.valueOf(parts[2]));
                case "pick" -> shelter.removeAnimal(parts[2]);
                case "remove" -> shelter.removeById(parts[1], Integer.parseInt(parts[4]));
                case "all"  -> shelter.otherOptions(parts[1]);
                default -> System.out.println("Error.");
            }
            if (input.equalsIgnoreCase("Clear")) {
                System.out.println("Shelter now is empty");
            }
            if (input.trim().isEmpty()) {
                System.out.println("Вы ничего не ввели");
            }
        }
    }
}


