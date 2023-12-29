package creational.abstractfactory;

import creational.simplefactory.Animal;
import creational.simplefactory.Dog;

public class DogPetFactory implements PetFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }

    @Override
    public Food createFood() {
        return new DogFood();
    }
}
