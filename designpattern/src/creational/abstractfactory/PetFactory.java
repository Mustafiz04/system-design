package creational.abstractfactory;

import creational.simplefactory.Animal;

public interface PetFactory {
    Animal createAnimal();
    Food createFood();
}
