package parking;

import vehicle.Vehicle;

public abstract class Slot {
    private String slotId;
    private boolean isAvailable;
    private Vehicle vehicle;
    private SlotType slotType;

    public Slot(String slotId, Vehicle vehicle, SlotType slotType) {
        this.slotId = slotId;
        this.isAvailable = true;
        this.slotType = slotType;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isAvailable = false;
    }

    public void freeSpot() {
        this.isAvailable = true;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
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

    public SlotType getSlotType() {
        return slotType;
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
    }
}
