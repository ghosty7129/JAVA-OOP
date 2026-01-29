public class Drink {

    private String drink_name;
    private double price;
    private int milk_needed;
    private int water_needed;
    private int coffee_needed;

    public Drink(String drink_name, double price, int milk_needed, int water_needed, int coffee_needed) {
        this.drink_name = drink_name;
        this.price = price;
        this.milk_needed = milk_needed;
        this.water_needed = water_needed;
        this.coffee_needed = coffee_needed;
    }

    public String getDrink_name() {
        return drink_name;
    }

    public double getPrice() {
        return price;
    }

    public int getMilk_needed() {
        return milk_needed;
    }

    public int getWater_needed() {
        return water_needed;
    }

    public int getCoffee_needed() {
        return coffee_needed;
    }
}