public class VendingMachine {
    private final Inventory inventory;
    private VendingMachineState state;
    private int balance;
    private Product selectedProduct;
    private int quantity;

    VendingMachine() {
        this.inventory = new Inventory();
        this.state = new IdleState(); // Initial state
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void addCoin(Denomination denomination) {
        this.state.insertCoin(this, denomination);
    }

    public void selectProduct(Product product, int quantity) {
        this.state.selectProduct(this, product, quantity);
    }

    public void dispenseProduct() {
        this.state.dispenseProduct(this);
    }

    public void returnChange() {
        this.state.returnChange(this);
    }

    public void cancelTransaction() {
        this.state.cancelTransaction(this);
    }


    // internal Method
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void addBalance(int amount) {
        this.balance += amount;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deductBalance(int amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Deducted balance: " + amount + ". Remaining balance: " + this.balance);
        } else {
            System.out.println("Insufficient balance to deduct: " + amount);
        }
    }

    public boolean isProductAvailable(Product product) {
        return this.inventory.isAvailable(product);
    }

    public void selectSelectedProduct(Product product) {
        this.selectedProduct = product;
    }

    public Product getSelectedProduct() {
        return this.selectedProduct;
    }

    public void returnBalance() {
        int change = getBalance();
        if (change > 0) {
            System.out.println("Returning change: " + change);
            this.balance = 0; // Reset balance after returning change
        } else {
            System.out.println("No change to return.");
        }
    }
}
