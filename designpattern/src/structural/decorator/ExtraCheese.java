package structural.decorator;

public class ExtraCheese implements Pizza {
    Pizza basePizza;

    public ExtraCheese(Pizza pizza) {
        this.basePizza = pizza;
    }

    @Override
    public String  getDescription() {
        return basePizza.getDescription() + ", with extra cheese";
    }

    @Override
    public double getCost() {
        return basePizza.getCost() + 10;
    }
}
