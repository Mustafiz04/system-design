package structural.adapter;

public class NewSystemClient {
    public void useNewSystem(NewSystemInterface newSystem) {
        newSystem.execute();
    }
}
