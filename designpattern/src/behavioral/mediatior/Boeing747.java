package behavioral.mediatior;

public class Boeing747 implements Plane {
    private AirTrafficControl airTrafficControl;

    public Boeing747(AirTrafficControl airTrafficControl) {
        this.airTrafficControl = airTrafficControl;
        this.airTrafficControl.registrerPlan(this);
    }


    @Override
    public void sendMessage(String message) {
        this.airTrafficControl.sendMessage(this, message);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Boeing 747 receives message : "+ message);
    }
}
