public class Dog extends Animals{

    private int dogAge = getAge();
    private int dogId =  getId();
    private double dogWeight = getWeight();
    private String dogName = getName();

    @Override
    public String toString() {
         return "Собака - " +
                " Возраст собаки: " + dogAge +
                " Номер собаки: " + dogId +
                " Вес собаки: " + dogWeight +
                " Имя собаки: " + dogName + "\n";
    }
}
