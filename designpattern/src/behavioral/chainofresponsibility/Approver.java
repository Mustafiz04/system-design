package behavioral.chainofresponsibility;

public interface Approver {
    void processRequest(PurchaseRequest request);
}
