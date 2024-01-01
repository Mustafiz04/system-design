package creational.builder;

public class SimpleLaptop implements Laptop {
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

    public static class SimpleLaptopBuilder {
        SimpleLaptop simpleLaptop;
        public SimpleLaptopBuilder() {
            this.simpleLaptop = new SimpleLaptop();
        }

        public SimpleLaptopBuilder setProcessor(String processor) {
            simpleLaptop.setProcessor(processor);
            return this;
        }

        public SimpleLaptopBuilder setRAM(String ram) {
            simpleLaptop.setRAM(ram);
            return this;
        }

        public SimpleLaptopBuilder setStorage(String storage) {
            simpleLaptop.setStorage(storage);
            return this;
        }

        public SimpleLaptopBuilder setGraphicCard(String graphicCard) {
            simpleLaptop.setGraphicCard(graphicCard);
            return this;
        }

        public SimpleLaptop build() {
            return simpleLaptop;
        }
    }
}
