import creational.abstractfactory.CatPetFactory;
import creational.abstractfactory.DogPetFactory;
import creational.abstractfactory.Food;
import creational.abstractfactory.PetFactory;
import creational.factorymethod.Animals;
import creational.factorymethod.AnimalsFactory;
import creational.factorymethod.CatFactory;
import creational.factorymethod.DogFactory;
import creational.simplefactory.Animal;
import creational.simplefactory.AnimalFactory;
import creational.singleton.President;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        Singleton
        President president = President.getInstance();
        president.setName("John Doe");
        president.setPartyName("Unity Party");
        System.out.println(president.getName());
        president.setName("John");
        president.setPartyName("Part Party");

        System.out.println(president.getName());

        System.out.println("-------------------------------------");
//        Simple Factory
//        Animal dog = AnimalFactory.createAnimal("DOG");
//        dog.makeSound();
//        Animal cat = AnimalFactory.createAnimal("CAT");
//        cat.makeSound();

        System.out.println("-------------------------------------");

//        Factory Method
//        AnimalsFactory dogFactory = new DogFactory();
//        AnimalsFactory catFactory = new CatFactory();
//
//        Animals dog = dogFactory.createAnimal();
//        Animals cat = catFactory.createAnimal();
//
//        dog.makeSound();
//        cat.makeSound();

        System.out.println("-------------------------------------");

//        AbstractFactory
        PetFactory dogPet = new DogPetFactory();
        Animal dog = dogPet.createAnimal();
        Food dogFood = dogPet.createFood();
        dog.makeSound();
        dogFood.consume();

        PetFactory catPet = new CatPetFactory();
        Animal cat = catPet.createAnimal();
        Food catFood = catPet.createFood();
        cat.makeSound();
        catFood.consume();

        System.out.println("-------------------------------------");
    }
}