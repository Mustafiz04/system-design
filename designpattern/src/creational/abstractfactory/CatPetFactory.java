package creational.abstractfactory;

import creational.simplefactory.Animal;
import creational.simplefactory.Cat;

public class CatPetFactory implements PetFactory{
    @Override
    public Animal createAnimal() {
        return new Cat();
    }

    @Override
    public Food createFood() {
        return new CatFood();
    }
}
