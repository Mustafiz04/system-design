package behavioral.observer;

public class OnlineNewsOutlet implements NewsOutlet {
    String name;

    public OnlineNewsOutlet(String name) {
        this.name = name;
    }

    @Override
    public void update(String newsUpdate) {
        System.out.println("Online News Outlet " + name + " receives update: " + newsUpdate);
    }
}
