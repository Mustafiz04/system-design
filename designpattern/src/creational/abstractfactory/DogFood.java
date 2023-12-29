package creational.abstractfactory;

public class DogFood implements Food {
    @Override
    public void consume() {
        System.out.println("This is dog food.");
    }
}
