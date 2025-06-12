import java.util.*;

public class Inventory {
    private final HashMap<Product, Integer> productStocks = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        this.productStocks.put(product, quantity);
    }

    public void deductProduct(Product product, int quantity) {
        this.productStocks.put(product, this.productStocks.get(product) - quantity);
    }

    public boolean isAvailable(Product product) {
        return this.productStocks.containsKey(product) && this.productStocks.get(product) > 0;
    }

    public HashMap<Product, Integer> getProductStocks() {
        return this.productStocks;
    }
}
