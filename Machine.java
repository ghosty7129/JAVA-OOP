import java.util.ArrayList;

public class Machine {

    public int total_machine_milk;
    public int total_machine_water;
    public int total_machine_coffee;

    ArrayList<Drink> all_drinks = new ArrayList<>();

    public Machine(int total_machine_milk, int total_machine_water, int total_machine_coffee) {
        this.total_machine_milk = total_machine_milk;
        this.total_machine_water = total_machine_water;
        this.total_machine_coffee = total_machine_coffee;

        Drink espresso = new Drink("Espresso", 50, 0, 30, 18);
        Drink cappuccino = new Drink("Cappuccino", 80, 100, 50, 18);
        Drink milk = new Drink("Milk", 30, 150, 0, 0);
        Drink water = new Drink("Water", 10, 0, 200, 0);

        all_drinks.add(espresso);
        all_drinks.add(cappuccino);
        all_drinks.add(milk);
        all_drinks.add(water);
    }

    public void printMenu() {
        System.out.println("MENU:");
        for (Drink d : all_drinks) {
            System.out.println(d.getDrink_name() + " -> " + d.getPrice() + " cents");
        }
    }

    public void makeDrink(String entered_drink_name) {
        boolean drinkFound = false; 

        for (Drink d : all_drinks) {
            if (d.getDrink_name().equals(entered_drink_name)) {
                drinkFound = true;
                System.out.println("Preparing " + d.getDrink_name() + "...");

                if (total_machine_milk >= d.getMilk_needed() &&
                    total_machine_water >= d.getWater_needed() &&
                    total_machine_coffee >= d.getCoffee_needed()) {

                    total_machine_milk -= d.getMilk_needed();
                    total_machine_water -= d.getWater_needed();
                    total_machine_coffee -= d.getCoffee_needed();

                    System.out.println(d.getDrink_name() + " has been made!");
                } else {
                    System.out.println("Insufficient ingredients to make " + d.getDrink_name());
                }
            } else if(!drinkFound) {
            System.out.println("Drink not found in menu: " + entered_drink_name);
        }
        
    } 
    
}

    public void CheckMachineStatus() {
        System.out.println("Machine Status:");
        System.out.println("Milk: " + total_machine_milk + "ml");
        System.out.println("Water: " + total_machine_water + "ml");
        System.out.println("Coffee: " + total_machine_coffee + "g");
    }
}

