public class Dog extends Animals{

    private int dogAge = getAge();
    private int dogId =  getId();
    private double dogWeight = getWeight();
    private String dogName = getName();


    public int getDogId() {
        return dogId;
    }
    public int getDogAge() {
        return dogAge;
    }
    public double getDogWeight() {
        return dogWeight;
    }
    public String getDogName() {
        return dogName;
    }


    public void dogInfo () {
        System.out.println("\n" + "Кошка: " + dogName +
                "\n" + "Возраст: " + dogAge +
                "\n" + "Вес: " + dogWeight +
                "\n" + "Номер: " + dogId);
    }

    @Override
    public String toString() {
        return "Собака - " +
                " Возраст собаки: " + dogAge +
                " Номер собаки: " + dogId +
                " Вес собаки: " + dogWeight +
                " Имя собаки: " + dogName;
    }
}
