import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Machine machine = new Machine(500, 1000, 300, 200);
        machine.printMenu();
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter drink name from menu: ");
        String drinkName = scanner.nextLine();

        System.out.print("Choose sugar level (1-5): ");
        int sugarLevel = scanner.nextInt();

        System.out.print("Enter amount paid (format - 0.5, 1.5...): ");
        double amountPaid = scanner.nextDouble();

        System.out.println();
        machine.makeDrink(drinkName, amountPaid, sugarLevel);
        System.out.println();
        machine.CheckMachineStatus();

        scanner.close();
    }
}