package creational.prototype;

public class Computer implements Prototype {
    private String brand;
    private String model;

    public Computer(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public Prototype clone() {
        return new Computer(this.brand, this.model);
    }

    @Override
    public String toString() {
        return "Computer{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + '}';
    }
}
