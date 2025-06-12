public class IdleState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine vendingMachine, Denomination denomination) {
        vendingMachine.addBalance(denomination.getValue());
        System.out.println("Inserted coin: " + denomination.name() + " (" + denomination.getValue() + ")");
        vendingMachine.setState(new ReadyState());
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, Product product, int quantity) {
        System.out.println("Please insert coins before selecting a product.");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        System.out.println("No product selected. Please insert coins and select a product.");
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        System.out.println("No change to return. The machine is idle.");
    }

    @Override
    public void cancelTransaction(VendingMachine vendingMachine) {
        System.out.println("No transaction to cancel. The machine is idle.");
    }
}
