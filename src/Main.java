import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Shelter shelter = new Shelter();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Скажите, кого привезли (Не вводите F): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("F")) {
                System.out.println("Ты всех убил. Животное.");
                break;
            }
            shelter.add(input);
            shelter.otherOptions(input);
        }
    }
}


