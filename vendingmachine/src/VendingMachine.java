import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private VendingMachineState vendingMachineState;
    private Inventory inventory;
    private List<Coin> coins;

    public VendingMachine(Inventory inventory) {
        this.vendingMachineState = new IdleState();
        this.inventory = inventory;
        this.coins = new ArrayList<>();
    }

    public void clickCoinButton() throws Exception {
        vendingMachineState.clickOnInsertCoinButton(this);
    }

    public void resetCoinTray() {
        this.coins = new ArrayList<>();
    }

    public void setState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public List<Coin> getCoins() {
        return coins;
    }
}
