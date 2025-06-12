public class ReturnChangeState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine vendingMachine, Denomination denomination) {
        System.out.println("Cannot insert coin while returning change.");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, Product product, int quantity) {
        System.out.println("Cannot select product while returning change.");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        System.out.println("Cannot dispense product while returning change.");
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        vendingMachine.returnBalance();
        System.out.println("Returning to idle state.");
        vendingMachine.setState(new IdleState());
    }

    @Override
    public void cancelTransaction(VendingMachine vendingMachine) {
        System.out.println("Transaction cancelled. Returning to idle state.");
        vendingMachine.returnBalance();
        vendingMachine.setState(new IdleState());
    }
}
