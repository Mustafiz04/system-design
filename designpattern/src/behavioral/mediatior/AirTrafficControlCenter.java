package behavioral.mediatior;

import java.util.ArrayList;
import java.util.List;

public class AirTrafficControlCenter implements AirTrafficControl {
    private List<Plane> planes;

    public AirTrafficControlCenter() {
        this.planes = new ArrayList<>();
    }

    @Override
    public void registrerPlan(Plane plane) {
        this.planes.add(plane);
    }

    @Override
    public void sendMessage(Plane sender, String message) {
        for(Plane plane: planes) {
            if(plane != sender) {
                plane.receiveMessage(message);
            }
        }
    }
}
