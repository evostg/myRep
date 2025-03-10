public class Rabbit extends Animals {

    private int rabbitAge = getAge();
    private int rabbitId =  getId();
    private double rabbitWeight = getWeight();
    private String rabbitName = getName();


    @Override
    public String toString() {
         return "Кролик - " +
                " Возраст: " + rabbitAge +
                " Номер кролика: " + rabbitId +
                " Вес кролика: " + rabbitWeight +
                " Имя кролика: " + rabbitName + "\n";
    }
}
