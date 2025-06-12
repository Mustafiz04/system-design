public class ReadyState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine vendingMachine, Denomination denomination) {
        vendingMachine.addBalance(denomination.getValue());
        System.out.println("Inserted coin: " + denomination.name() + " (" + denomination.getValue() + ")");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, Product product, int quantity) {
        if(vendingMachine.isProductAvailable(product)) {
            if (vendingMachine.getBalance() >= product.getPrice() * quantity) {
                System.out.println("Product selected: " + product.getName());
                vendingMachine.selectSelectedProduct(product);
                vendingMachine.setQuantity(quantity);
                vendingMachine.setState(new DispensingState());
            } else {
                System.out.println("Insufficient balance for product: " + product.getName());
            }
        } else {
            System.out.println("Product not available: " + product.getName());
        }
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        System.out.println("No product selected. Please select a product after inserting coins.");
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        vendingMachine.returnBalance();
        vendingMachine.setState(new IdleState());
    }

    @Override
    public void cancelTransaction(VendingMachine vendingMachine) {
        System.out.println("Transaction cancelled. Returning to idle state.");
        vendingMachine.returnBalance();
        vendingMachine.setState(new IdleState());
    }
}
