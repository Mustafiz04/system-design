public class Product {
    private String name;
    private final int code;
    private final int price;

    public Product(int code, String name, int price) {
        this.name = name;
        this.code = code;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public int getPrice() {
        return price;
    }

}
