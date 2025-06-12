public interface VendingMachineState {
    void insertCoin(VendingMachine vendingMachine, Denomination denomination);
    void selectProduct(VendingMachine vendingMachine, Product product, int quantity);
    void dispenseProduct(VendingMachine vendingMachine);
    void returnChange(VendingMachine vendingMachine);
    void cancelTransaction(VendingMachine vendingMachine);
}
