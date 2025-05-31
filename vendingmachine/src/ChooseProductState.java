public class ChooseProductState implements VendingMachineState {
    public ChooseProductState() {
        System.out.println("Choose product state");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {

    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {

    }

    @Override
    public void clickOnSelectProductButton(VendingMachine vendingMachine) throws Exception {

    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int code) throws Exception {
        Product product = vendingMachine.getInventory().getProductById(code);
        int amountPaidByUser = 0;
        for(Coin coin : vendingMachine.getCoins()) {
            amountPaidByUser += coin.getValue();
        }
        if(amountPaidByUser < product.getPrice()) {
            refund(product.getPrice() - amountPaidByUser);
            vendingMachine.setState(new IdleState(vendingMachine));
            System.out.println("Insufficient Amount, Product you selected is for price: " + product.getPrice() + " and you paid: " + amountPaidByUser);
        } else {
            if(amountPaidByUser > product.getPrice()) {
                refund(amountPaidByUser - product.getPrice());
            }
            vendingMachine.setState(new DispenseProductState(vendingMachine, code));
        }
    }

    private void refund(int amount) {
        System.out.println("Returned the change in the Coin Dispense Tray: " + amount);
    }

    @Override
    public int cancelOrder(VendingMachine vendingMachine) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        vendingMachine.setState(new IdleState(vendingMachine));
        int amountPaidByUser = 0;
        for(Coin coin : vendingMachine.getCoins()) {
            amountPaidByUser += coin.getValue();
        }
        return amountPaidByUser;
    }

    @Override
    public Product dispenseProduct(VendingMachine vendingMachine, int code) throws Exception {
        return null;
    }
}
