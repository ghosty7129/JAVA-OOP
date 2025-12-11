public class App {
    public static void main(String[] args) {
        Machine machine = new Machine(500, 1000, 300);
        machine.printMenu();
        System.out.println();
        machine.CheckMachineStatus();
        System.out.println();
        machine.makeDrink("Espresso");
        System.out.println();
        machine.CheckMachineStatus();
    }
}
