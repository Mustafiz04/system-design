public interface VendingMachineState {
    void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception;
    void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception;
    void clickOnSelectProductButton(VendingMachine vendingMachine) throws Exception;
    void selectProduct(VendingMachine vendingMachine, int code) throws Exception;
    int cancelOrder(VendingMachine vendingMachine) throws Exception;
    Product dispenseProduct(VendingMachine vendingMachine, int code) throws Exception;
}