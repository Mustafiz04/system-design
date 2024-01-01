package behavioral.mediatior;

public interface AirTrafficControl {
    void registrerPlan(Plane plane);
    void sendMessage(Plane sender, String message);
}
