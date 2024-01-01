package behavioral.mediatior;

public class AirbusA380 implements Plane {
    private AirTrafficControl airTrafficControl;

    public AirbusA380(AirTrafficControl airTrafficControl) {
        this.airTrafficControl = airTrafficControl;
        this.airTrafficControl.registrerPlan(this);
    }

    @Override
    public void sendMessage(String message) {
        this.airTrafficControl.sendMessage(this, message);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Airbus A380 receives message : " + message);
    }
}
