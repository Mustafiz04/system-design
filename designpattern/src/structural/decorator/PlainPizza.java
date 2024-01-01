package structural.decorator;

public class PlainPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Simple pizza";
    }

    @Override
    public double getCost() {
        return 50.00;
    }
}
