package behavioral.observer;

public interface NewsAgency {
    void addObserver(NewsOutlet newsOutlet);
    void removeObserver(NewsOutlet newsOutlet);
    void notifyObservers(String newsUpdate);
}
