public class DispenseProductState implements VendingMachineState {

    public DispenseProductState(VendingMachine vendingMachine, int code) {
        dispenseProduct(vendingMachine, code);
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) {

    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {

    }

    @Override
    public void clickOnSelectProductButton(VendingMachine vendingMachine) {

    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int code) {

    }

    @Override
    public int cancelOrder(VendingMachine vendingMachine) {
        return 0;
    }

    @Override
    public Product dispenseProduct(VendingMachine vendingMachine, int code) {
        System.out.println("Product has been dispensed");
        Product product = vendingMachine.getInventory().getProductById(code);
        vendingMachine.getInventory().purchaseProduct(product, 1);
        vendingMachine.setState(new IdleState(vendingMachine));
        return product;
    }
}
