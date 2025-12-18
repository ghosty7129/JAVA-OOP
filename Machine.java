import java.util.ArrayList;

public class Machine {

    public int total_machine_milk;
    public int total_machine_water;
    public int total_machine_coffee;

    public int total_machine_dollars;
    public int total_machine_half_dollars;
    public int total_machine_quarters;
    public int total_machine_dimes;
    public int total_machine_nickels;
    public int total_machine_pennies;

    ArrayList<Drink> all_drinks = new ArrayList<>();

    public Machine(int total_machine_milk, int total_machine_water, int total_machine_coffee,
            int total_machine_dollars, int total_machine_half_dollars, int total_machine_quarters,
            int total_machine_dimes, int total_machine_nickels, int total_machine_pennies) {
        this.total_machine_milk = total_machine_milk;
        this.total_machine_water = total_machine_water;
        this.total_machine_coffee = total_machine_coffee;
        this.total_machine_dollars = total_machine_dollars;
        this.total_machine_half_dollars = total_machine_half_dollars;
        this.total_machine_quarters = total_machine_quarters;
        this.total_machine_dimes = total_machine_dimes;
        this.total_machine_nickels = total_machine_nickels;
        this.total_machine_pennies = total_machine_pennies;

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

    public void makeDrink(String entered_drink_name, int amount_paid) {
        boolean drinkFound = false;

        for (Drink d : all_drinks) {
            if (d.getDrink_name().equals(entered_drink_name)) {
                drinkFound = true;
                System.out.println("Preparing " + d.getDrink_name() + "...");

                if (total_machine_milk >= d.getMilk_needed() &&
                        total_machine_water >= d.getWater_needed() &&
                        total_machine_coffee >= d.getCoffee_needed()) {

                    if (amount_paid < d.getPrice()) {
                        System.out
                                .println("Not enough money! You need " + (d.getPrice() - amount_paid) + " more cents.");
                    } else {
                        total_machine_milk -= d.getMilk_needed();
                        total_machine_water -= d.getWater_needed();
                        total_machine_coffee -= d.getCoffee_needed();

                        System.out.println(d.getDrink_name() + " has been made!");

                        int change = amount_paid - d.getPrice();

                        if (change == 0) {
                            System.out.println("Exact amount paid!");
                        } else {
                            System.out.println("Your change is: " + change + " cents");
                            System.out.println("Coins given:");

                            int totalCoins = 0;

                            while (change >= 100 && total_machine_dollars > 0) {
                                change -= 100;
                                total_machine_dollars--;
                                totalCoins++;
                                System.out.println("1 dollar");
                            }

                            while (change >= 50 && total_machine_half_dollars > 0) {
                                change -= 50;
                                total_machine_half_dollars--;
                                totalCoins++;
                                System.out.println("1 half-dollar");
                            }

                            while (change >= 25 && total_machine_quarters > 0) {
                                change -= 25;
                                total_machine_quarters--;
                                totalCoins++;
                                System.out.println("1 quarter");
                            }

                            while (change >= 10 && total_machine_dimes > 0) {
                                change -= 10;
                                total_machine_dimes--;
                                totalCoins++;
                                System.out.println("1 dime");
                            }

                            while (change >= 5 && total_machine_nickels > 0) {
                                change -= 5;
                                total_machine_nickels--;
                                totalCoins++;
                                System.out.println("1 nickel");
                            }

                            while (change >= 1 && total_machine_pennies > 0) {
                                change -= 1;
                                total_machine_pennies--;
                                totalCoins++;
                                System.out.println("1 penny");
                            }
                            
                            System.out.println("Total coins given: " + totalCoins);
            
                        }
                    }
                } else {
                    System.out.println("Insufficient ingredients to make " + d.getDrink_name());
                }
            }
        }

        if (!drinkFound) {
            System.out.println("Drink not found in menu: " + entered_drink_name);
        }
    }

    public void CheckMachineStatus() {
        System.out.println("Machine Status:");
        System.out.println("Milk: " + total_machine_milk + "ml");
        System.out.println("Water: " + total_machine_water + "ml");
        System.out.println("Coffee: " + total_machine_coffee + "g");
        System.out.println("Dollars: " + total_machine_dollars);
        System.out.println("Half-dollars: " + total_machine_half_dollars);
        System.out.println("Quarters: " + total_machine_quarters);
        System.out.println("Dimes: " + total_machine_dimes);
        System.out.println("Nickels: " + total_machine_nickels);
        System.out.println("Pennies: " + total_machine_pennies);
    }
}
