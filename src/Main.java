import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Shelter shelter = new Shelter();
        Scanner scanner = new Scanner(System.in);



        //TODO разделить методы через енам и сплит
        //TODO какая команда пришла - метод вызывается

        while (true) {
            System.out.println("Скажите, кого привезли: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            switch (parts[0]) {
                case "add"  -> shelter.add(parts[1],Integer.valueOf(parts[2]));
                case "pick" -> shelter.pick(parts[2]);
                case "all"  -> shelter.otherOptions(parts[1]);
                default -> System.out.println("Error.");
            }
            if (input.equalsIgnoreCase("Clear")) {
                System.out.println("Shelter now is empty");
                break;
            }
            if (input.trim().isEmpty()) {
                System.out.println("Вы ничего не ввели");
            }
            shelter.processInput(input);
        }
    }
}


