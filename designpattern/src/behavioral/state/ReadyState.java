package behavioral.state;

public class ReadyState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine vendingMachine) {
        System.out.println("Coin inserted. Please select your product now.");
        vendingMachine.setCurrentState(new CoinInsertedState());
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine) {
        System.out.println("Please insert a coin first.");
    }

    @Override
    public void despenseProduct(VendingMachine vendingMachine) {
        System.out.println("Please select a product first.");
    }
}
