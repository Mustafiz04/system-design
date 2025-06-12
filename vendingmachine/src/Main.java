public class Main {
    public static void main(String[] args) throws Exception {
        Inventory inventory = new Inventory();
        Product cola = new Product("Cola", 15);
        Product chips = new Product("Chips", 5);
        Product candy = new Product("Candy", 1);

        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.getInventory().addProduct(cola, 10);
        vendingMachine.getInventory().addProduct(chips, 10);
        vendingMachine.getInventory().addProduct(candy, 10);

        vendingMachine.addCoin(Denomination.FIVE);
        vendingMachine.selectProduct(cola, 2);
        vendingMachine.cancelTransaction();

        System.out.println("-------------------------");

        vendingMachine.addCoin(Denomination.TEN);
        vendingMachine.addCoin(Denomination.FIVE);
        vendingMachine.selectProduct(chips, 2);
        vendingMachine.dispenseProduct();
        vendingMachine.returnChange();

        System.out.println("-------------------------");

        vendingMachine.cancelTransaction();
    }
}