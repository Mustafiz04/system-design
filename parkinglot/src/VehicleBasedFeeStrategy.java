import java.util.*;

public class VehicleBasedFeeStrategy implements FeeStrategy {
    public HashMap<VehicleType, Double> feeRates = new HashMap<>();

    public VehicleBasedFeeStrategy() {
        feeRates.put(VehicleType.BIKE, 10.0);
        feeRates.put(VehicleType.TRUCK, 25.0);
        feeRates.put(VehicleType.CAR, 15.0);
    }

    @Override
    public double calculateFee(Ticket ticket) {
        long duration = ticket.getExitTime() - ticket.getIssueTime();
        long hour = (duration / (1000 * 60 * 60)) + 1;
        VehicleType type = ticket.getVehicle().getType();
        return hour * feeRates.get(type);
    }
}
