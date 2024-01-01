package creational.builder;

public class GamingLaptop implements Laptop {
    private String processor;
    private String ram;
    private String storage;
    private String graphicCard;

    @Override
    public void setProcessor(String processor) {
        this.processor = processor;
    }

    @Override
    public void setRAM(String ram) {
        this.ram = ram;
    }

    @Override
    public void setStorage(String storage) {
        this.storage = storage;
    }

    @Override
    public void setGraphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
    }

    @Override
    public void printConfiguration() {
        System.out.println(this.processor);
        System.out.println(this.ram);
        System.out.println(this.storage);
        System.out.println(this.graphicCard);
    }

    public static class GamingLaptopBuilder {
        GamingLaptop gamingLaptop;
        public GamingLaptopBuilder() {
            this.gamingLaptop = new GamingLaptop();
        }

        public GamingLaptopBuilder setProcessor(String processor) {
            gamingLaptop.setProcessor(processor);
            return this;
        }

        public GamingLaptopBuilder setRAM(String ram) {
            gamingLaptop.setRAM(ram);
            return this;
        }

        public GamingLaptopBuilder setStorage(String storage) {
            gamingLaptop.setStorage(storage);
            return this;
        }

        public GamingLaptopBuilder setGraphicCard(String graphicCard) {
            gamingLaptop.setGraphicCard(graphicCard);
            return this;
        }

        public GamingLaptop build() {
            return gamingLaptop;
        }
    }
}
