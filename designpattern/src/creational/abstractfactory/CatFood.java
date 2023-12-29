package creational.abstractfactory;

public class CatFood implements Food{
    @Override
    public void consume() {
        System.out.println("This is cat's food");
    }
}
