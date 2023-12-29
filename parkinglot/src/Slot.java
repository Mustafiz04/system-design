public class Slot {
    private int slotId;
    private boolean isAvailable;
    private Vehicle vehicle;

    public Slot(int slotId) {
        this.slotId = slotId;
        this.isAvailable = true;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void occupySlot(Vehicle parkVehicle) {
        this.vehicle = parkVehicle;
        this.isAvailable = false;
    }

    public void vacateSlot() {
        this.vehicle = null;
        this.isAvailable = true;
    }
}
