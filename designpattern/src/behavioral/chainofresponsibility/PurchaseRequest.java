package behavioral.chainofresponsibility;

public class PurchaseRequest {
    private double amount;

    public PurchaseRequest(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }
}
