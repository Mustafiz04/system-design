package behavioral.chainofresponsibility;

public class Manager implements Approver {
    private static final double MAX_LIMIT = 10000;
    private Approver nextApprover;

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if( request.getAmount() <= MAX_LIMIT ) {
            System.out.println("Request have been approved by Manager");
        } else if( nextApprover != null ) {
            nextApprover.processRequest(request);
        } else {
            System.out.println("Request cannot be approved. No more Approvers in the chain.");
        }
    }
}
