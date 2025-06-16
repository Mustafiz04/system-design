package airlinemanagementsystem.payment;

public class Payment {
    private final String paymentId;
    private final String paymentMethod; // Default payment method can make it payment strategy
    private final double amount;
    private PaymentStatus status;

    public Payment(String paymentId, String paymentMethod, double amount, PaymentStatus status) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.status = status;
    }

    public void pay() {
        if (status == PaymentStatus.PENDING) {
            // Simulate payment processing
            System.out.println("Processing payment of " + amount + " using " + paymentMethod);
            status = PaymentStatus.COMPLETED; // Update status to completed
            System.out.println("Payment completed successfully.");
        } else {
            System.out.println("Payment cannot be processed. Current status: " + status);
        }
    }
}
