import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<Product, Integer> inventory;

    public Inventory () {
        this.inventory = new HashMap<>();
    }

    public Map<Product, Integer> getInventory() {
        return this.inventory;
    }

    public void addItem(Product product, int quantity) {
        this.inventory.put(product, this.inventory.getOrDefault(product, 0) + quantity);
    }

    public void removeProduct(Product product) {
        this.inventory.remove(product);
    }

    public void updateQuantity(Product product, int quantity) {
        this.inventory.put(product, quantity);
    }

    public Product getProductById(int id) {
        for(Map.Entry<Product, Integer> e: inventory.entrySet()) {
            if( e.getKey().getCode() == id ) {
                return e.getKey();
            }
        }
        return null;
    }

    public boolean purchaseProduct(Product product, int quantity) {
        int availableQuantity = inventory.get(product);
        if( availableQuantity < quantity ) {
            System.out.println("Only " + availableQuantity + " is available now.");
            return false;
        }
        inventory.put(product, availableQuantity - quantity);
        return true;
    }
}
