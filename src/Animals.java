import java.util.Random;

public class Animals {

    private int age;
    private int id;
    private double weight;
    private String name;

    private static Random random = new Random();

    private static int minAge = 1;
    private static int maxAge = 10;
    private static double minWeight = 1.0;
    private static double maxWeight = 15.0;

    public Animals() {
        this.age = generateRandomAge();
        this.id = generateRandomId();
        this.weight = Math.round(generateRandomWeight() * 10) / 10.0;
        this.name = generateRandomName();
    }


    private int generateRandomAge() {
        return random.nextInt(maxAge - minAge + 1) + minAge;
    }
    private int generateRandomId() {
        return random.nextInt(1000);
    }
    private double generateRandomWeight() {
        return minWeight + (maxWeight - minWeight) * random.nextDouble();
    }
    private String generateRandomName() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder nameBuilder = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            nameBuilder.append(randomChar);
        }
        return nameBuilder.toString();
    }

    public int getAge() {
        return age;
    }
    public int getId() {
        return id;
    }
    public double getWeight() {
        return weight;
    }
    public String getName() {
        return name;
    }
}