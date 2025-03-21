public class Cat extends Animals {

    private int catAge = getAge();
    private int catId = getId();
    private double catWeight = getWeight();
    private String catName = getName();

    @Override
    public String toString() {
         return "Кошка - " +
                " Возраст кошки: " + catAge +
                " Номер кошки: " + catId +
                " Вес кошки: " + catWeight +
                " Имя кошки: " + catName + "\n";
    }
}
