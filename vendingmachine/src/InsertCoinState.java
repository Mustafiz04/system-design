public class InsertCoinState implements VendingMachineState {

    public InsertCoinState() {
        System.out.println("Insert coin state");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Already click");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {

    }

    @Override
    public void clickOnSelectProductButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setState(new ChooseProductState());
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int code) throws Exception {

    }

    @Override
    public int cancelOrder(VendingMachine vendingMachine) throws Exception {
        return 0;
    }

    @Override
    public Product dispenseProduct(VendingMachine vendingMachine, int code) throws Exception {
        return null;
    }
}
