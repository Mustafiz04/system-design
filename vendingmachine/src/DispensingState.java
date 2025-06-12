public class DispensingState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine vendingMachine, Denomination denomination) {
        System.out.println("Cannot insert coin while dispensing product.");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, Product product, int quantity) {
        System.out.println("Cannot select product while dispensing another product.");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        Product selectedProduct = vendingMachine.getSelectedProduct();
        if( selectedProduct == null ) {
            System.out.println("No product selected. Please select a product after inserting coins.");
            return;
        }
        int quantity = vendingMachine.getQuantity();
        vendingMachine.getInventory().deductProduct(selectedProduct, quantity);
        vendingMachine.deductBalance(selectedProduct.getPrice() * quantity);
        System.out.println("Dispensing product: " + selectedProduct.getName());
        vendingMachine.setState(new ReturnChangeState());
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        vendingMachine.returnBalance();
        System.out.println("Returning to idle state after dispensing product.");
        vendingMachine.setState(new IdleState());
    }

    @Override
    public void cancelTransaction(VendingMachine vendingMachine) {
        System.out.println("Transaction cancelled. Returning to idle state.");
        vendingMachine.returnBalance();
        vendingMachine.setState(new IdleState());
    }
}
