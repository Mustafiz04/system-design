// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        Inventory inventory = new Inventory();
        inventory.addItem(new Product(101, "COCA COLA", 10), 10);
        inventory.addItem(new Product(102, "PEPSI", 15), 10);

        VendingMachine machine = new VendingMachine(inventory);

        machine.clickCoinButton();

    }
}