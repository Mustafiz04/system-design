package creational.factorymethod;

public class DogFactory implements AnimalsFactory {
    @Override
    public Animals createAnimal() {
        return new Dog();
    }
}
