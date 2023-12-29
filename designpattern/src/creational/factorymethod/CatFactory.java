package creational.factorymethod;

public class CatFactory implements AnimalsFactory{
    @Override
    public Animals createAnimal(){
        return new Cat();
    }
}
