package behavioral.observer;

public class TvNewsOutlet implements NewsOutlet {
    String name;

    public TvNewsOutlet(String name) {
        this.name = name;
    }

    @Override
    public void update(String newsUpdate) {
        System.out.println("Television News Outlet " + name + " receives update: " + newsUpdate);
    }
}
