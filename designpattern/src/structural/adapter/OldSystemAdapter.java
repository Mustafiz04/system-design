package structural.adapter;

public class OldSystemAdapter implements NewSystemInterface {
    private OldSystem oldSystem;

    public OldSystemAdapter(OldSystem oldSystem) {
        this.oldSystem = oldSystem;
    }

    @Override
    public void execute() {
        oldSystem.performOperation();
    }
}
