package creational.factorymethod;

public class Dog implements Animals {
    @Override
    public void makeSound() {
        System.out.println("Woof Woof !!");
    }
}
