package structural.decorator;

public class ChickenPizza implements Pizza {
    Pizza pizza;
    public ChickenPizza(Pizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + ", with chicken ";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 50;
    }
}
