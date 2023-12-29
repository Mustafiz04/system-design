import java.util.Date;

public class Ticket {
    private int slotId;
    private String vehicleNumber;
    private Date date;
    private VehicleType vehicleType;

    public Ticket(int slotId, String vehicleNumber, VehicleType vehicleType, Date date) {
        this.slotId = slotId;
        this.vehicleNumber = vehicleNumber;
        this.date = date;
        this.vehicleType = vehicleType;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
