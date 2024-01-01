package behavioral.chainofresponsibility;

public class VicePresident implements Approver {
    private static final double MAX_LIMIT = 50000;
    private Approver nextApprover;

    public void setNextApprover(Approver approver) {
        this.nextApprover = approver;
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if( request.getAmount() <= MAX_LIMIT ) {
            System.out.println("Request have been approved by VicePresident");
        } else if( nextApprover != null ) {
            nextApprover.processRequest(request);
        } else {
            System.out.println("Request cannot be approved. No more Approvers in the chain.");
        }
    }
}
