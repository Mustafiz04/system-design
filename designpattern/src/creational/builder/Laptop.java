package creational.builder;

public interface Laptop {
    void setProcessor(String processor);
    void setRAM(String ram);
    void setStorage(String storage);
    void setGraphicCard(String graphicCard);
    void printConfiguration();
}
