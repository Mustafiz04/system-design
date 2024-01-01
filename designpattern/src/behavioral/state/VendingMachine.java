package behavioral.state;

public class VendingMachine {
    private VendingMachineState currentState;

    public VendingMachine() {
        this.currentState = new ReadyState();
    }

    public void setCurrentState(VendingMachineState state) {
        this.currentState = state;
    }

    public void insertCoin() {
        currentState.insertCoin(this);
    }

    public void selectProduct() {
        currentState.selectProduct(this);
    }

    public void dispenseProduct() {
        currentState.despenseProduct(this);
    }
}
