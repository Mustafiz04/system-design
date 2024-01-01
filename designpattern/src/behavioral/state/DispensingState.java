package behavioral.state;

public class DispensingState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine vendingMachine) {
        System.out.println("Coin already inserted. Dispensing in progress.");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine) {
        System.out.println("Product already selected. Dispensing in progress.");
    }

    @Override
    public void despenseProduct(VendingMachine vendingMachine) {
        System.out.println("Product dispensed. Returning to ready state.");
        vendingMachine.setCurrentState(new ReadyState());
    }
}
