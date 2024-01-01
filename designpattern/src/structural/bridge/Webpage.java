package structural.bridge;

abstract public class Webpage {
    protected Theme theme;
    Webpage (Theme theme) {
        this.theme = theme;
    }

    public abstract String getContent();
}
