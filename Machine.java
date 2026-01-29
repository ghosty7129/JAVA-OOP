import java.util.ArrayList;

public class Machine {

    public int total_machine_milk;
    public int total_machine_water;
    public int total_machine_coffee;
    public int total_machine_sugar;

    private Coin coins;

    ArrayList<Drink> all_drinks = new ArrayList<>();

    public Machine(int total_machine_milk, int total_machine_water, int total_machine_coffee, int total_machine_sugar) {
        this.total_machine_milk = total_machine_milk;
        this.total_machine_water = total_machine_water;
        this.total_machine_coffee = total_machine_coffee;
        this.total_machine_sugar = total_machine_sugar;
        this.coins = new Coin();

        Drink espresso = new Drink("Espresso", 0.50, 0, 30, 18);
        Drink cappuccino = new Drink("Cappuccino", 0.80, 100, 50, 18);
        Drink milk = new Drink("Milk", 0.30, 150, 0, 0);
        Drink water = new Drink("Water", 0.10, 0, 200, 0);

        all_drinks.add(espresso);
        all_drinks.add(cappuccino);
        all_drinks.add(milk);
        all_drinks.add(water);
    }

    public void printMenu() {
        System.out.println("MENU:");
        for (Drink d : all_drinks) {
            System.out.println(d.getDrink_name() + " -> " + String.format("%.2f", d.getPrice()) + " euros");
        }
    }

    public void makeDrink(String entered_drink_name, double amount_paid, int sugarLevel) {
        boolean drinkFound = false;

        for (Drink d : all_drinks) {
            if (d.getDrink_name().equals(entered_drink_name)) {
                drinkFound = true;
                System.out.println("Preparing " + d.getDrink_name() + "...");

                if (total_machine_milk >= d.getMilk_needed() &&
                        total_machine_water >= d.getWater_needed() &&
                        total_machine_coffee >= d.getCoffee_needed()) {

                    if (amount_paid < d.getPrice()) {
                        System.out.println(
                                "Not enough money! You need " + String.format("%.2f", (d.getPrice() - amount_paid))
                                        + " more euros.");
                    } else {
                        int sugarAdded = chooseSugar(sugarLevel);
                        if (sugarAdded == 0) {
                            return;
                        }

                        total_machine_milk -= d.getMilk_needed();
                        total_machine_water -= d.getWater_needed();
                        total_machine_coffee -= d.getCoffee_needed();

                        System.out.println(d.getDrink_name() + " has been made!");

                        double change = amount_paid - d.getPrice();
                        change = Math.round(change * 100.0) / 100.0;

                        if (change < 0.01) {
                            System.out.println("Exact amount paid!");
                        } else {
                            System.out.println("Your change is: " + String.format("%.2f", change) + " euros");
                            System.out.println("Coins:");

                            coins.returnChange(change);

                        }
                    }
                }

                else {
                    System.out.println("Insufficient ingredients to make " + d.getDrink_name());
                }
            }
        }

        if (!drinkFound) {
            System.out.println("Drink not found in menu: " + entered_drink_name);
        }
    }

    public int chooseSugar(int level) {
        if (level < 1 || level > 5) {
            System.out.println("Invalid sugar level. Choose between 1 and 5.");
            return 0;
        }

        int grams = level * 5;

        if (total_machine_sugar < grams) {
            System.out.println("Not enough sugar in the machine.");
            return 0;
        }

        total_machine_sugar -= grams;
        System.out.println("Sugar added: " + grams + "g");
        return grams;
    }

    public void CheckMachineStatus() {
        System.out.println("Machine Status:");
        System.out.println("Milk: " + total_machine_milk + "ml");
        System.out.println("Water: " + total_machine_water + "ml");
        System.out.println("Coffee: " + total_machine_coffee + "g");
        System.out.println("Sugar: " + total_machine_sugar + "g");
        coins.printCoinsStatus();
    }
}
