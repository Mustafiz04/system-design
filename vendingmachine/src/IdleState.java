public class IdleState implements VendingMachineState {

    public IdleState() {
        System.out.println("In IDLE STATE");
    }
    public IdleState(VendingMachine vendingMachine) {
        vendingMachine.resetCoinTray();
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) {
        vendingMachine.setState(new InsertCoinState());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("Can't insert coin in IDLE state");
    }

    @Override
    public void clickOnSelectProductButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Click on insert coin button first");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int code) throws Exception {
        throw new Exception("Can't select product in IDLE state");
    }

    @Override
    public int cancelOrder(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Can't cancel in IDLE state");
    }

    @Override
    public Product dispenseProduct(VendingMachine vendingMachine, int code) throws Exception {
        throw new Exception("Can't dispense product in IDLE state");
    }
}
