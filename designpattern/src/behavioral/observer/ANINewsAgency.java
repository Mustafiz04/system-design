package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class ANINewsAgency implements NewsAgency {
    private List<NewsOutlet> observers = new ArrayList<>();
    private String latestNewsUpdate;

    @Override
    public void addObserver(NewsOutlet newsOutlet) {
        observers.add(newsOutlet);
    }

    @Override
    public void removeObserver(NewsOutlet newsOutlet) {
        observers.remove(newsOutlet);
    }

    @Override
    public void notifyObservers(String newsUpdate) {
        for(NewsOutlet outlet: observers) {
            outlet.update(newsUpdate);
        }
    }

    public void publishNews(String latestNewsUpdate) {
        System.out.println("ANI News Agency publishes: " + latestNewsUpdate);
        notifyObservers(latestNewsUpdate);
    }
}
