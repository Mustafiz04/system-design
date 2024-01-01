package behavioral.state;

public interface VendingMachineState {
    void insertCoin(VendingMachine vendingMachine);
    void selectProduct(VendingMachine vendingMachine);
    void despenseProduct(VendingMachine vendingMachine);
}
