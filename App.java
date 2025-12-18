public class App {
    public static void main(String[] args) {
        Machine machine = new Machine(500, 1000, 300, 10, 10, 20, 50, 40, 100);
        machine.printMenu();
        System.out.println();
        machine.CheckMachineStatus();
        System.out.println();
        machine.makeDrink("Espresso", 60);
        System.out.println();
        machine.CheckMachineStatus();
    }
}
