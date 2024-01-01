package behavioral.state;

public class CoinInsertedState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine vendingMachine) {
        System.out.println("Coin already inserted. Product not selected.");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine) {
        System.out.println("Product selected. Dispensing product.");
        vendingMachine.setCurrentState(new DispensingState());
    }

    @Override
    public void despenseProduct(VendingMachine vendingMachine) {
        System.out.println("Please select a product first.");
    }
}
